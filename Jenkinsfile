node {
    // checkout scm
    docker.image('mariadb').withRun('-e "MARIADB_ROOT_PASSWORD=my-secret-pw" --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --character-set-client-handshake=FALSE default-character-set=utf8mb4') { c ->
        docker.image('mariadb').inside("--link ${c.id}:db") {
            /* Wait until mysql service is up */
        	sh 'while ! mysqladmin ping -h0.0.0.0 --silent; do sleep 1; done'
        }
        docker.image('abhishekbalam/test1:latest').inside("--link ${c.id}:db") {
        	sh 'bench init frappe-bench --skip-assets --python $(which python3)'
        	sh 'mkdir ~/frappe-bench/sites/test_site'

        	sh 'cp ~/site_configs/consumer_db/mariadb.json ~/frappe-bench/sites/test_site/site_config.json'
        	sh 'mkdir ~/frappe-bench/sites/test_site_producer'
        	sh 'cp ~/site_configs/producer_db/mariadb.json ~/frappe-bench/sites/test_site_producer/site_config.json'

        	sh 'mysql -uroot -proot -h db -e "SET GLOBAL character_set_server = 'utf8mb4'";'
        }
    }
}