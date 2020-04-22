node {
    checkout scm
    docker.image('mariadb:10.3').withRun('-e "MYSQL_ROOT_PASSWORD=root"') { c ->
        docker.image('mariadb:10.3').inside("--link ${c.id}:db --user root") {
            /* Wait until mysql service is up */
            sh 'while ! mysqladmin ping -hdb --silent; do sleep 1; done'
        }
        docker.image('abhishekbalam/test1:latest').inside("--link ${c.id}:db --user frappe") {
			sh 'ls'
			sh 'pwd'
			sh 'bench init frappe-bench --skip-assets --python $(which python3)'
			sh 'mkdir $WORKSPACE/frappe-bench/sites/test_site'
			// sh 'cp ${WORKSPACE}/site_configs/consumer_db/mariadb.json ${WORKSPACE}/frappe-bench/sites/test_site/site_config.json'
			sh 'mkdir frappe-bench/sites/test_site_producer'
			// sh 'cp ${WORKSPACE}/site_configs/producer_db/mariadb.json ${WORKSPACE}/frappe-bench/sites/test_site_producer/site_config.json'

			sh 'mysql -uroot -proot -hdb -e "CREATE DATABASE test_frappe_consumer"';
        }
    }
}