// node {
// 	checkout scm
// 	docker.image('mariadb:10.3').withRun('-e "MYSQL_ROOT_PASSWORD=root"') { c ->
// 		docker.image('mariadb:10.3').inside("--link ${c.id}:db --user root") {
// 			sh 'echo "here1"'
// 			sh 'pwd;ls'
// 			sh 'whoami'
// 			sh 'while ! mysqladmin ping -h0.0.0.0 --silent; do sleep 1; done'
// 			sh 'echo "here2"'
			
// 			//sh 'mysql -uroot -proot -h0.0.0.0 -e "SET GLOBAL character_set_server = \'utf8mb4\'"';
// 			//sh 'mysql -uroot -proot -h0.0.0.0 -e "SET GLOBAL collation_server = \'utf8mb4_unicode_ci\'"';
// 		}
// 		docker.image('abhishekbalam/test1:latest').inside('--user frappe --link ${c.id}:db -w /home/frappe') {
// 			sh 'bench init frappe-bench --skip-assets --python $(which python3)'
// 			sh 'ls'

// 			sh 'mkdir ~/frappe-bench/sites/test_site'

// 			sh 'cp ~/site_configs/consumer_db/mariadb.json ~/frappe-bench/sites/test_site/site_config.json'
// 			sh 'mkdir ~/frappe-bench/sites/test_site_producer'
// 			sh 'cp ~/site_configs/producer_db/mariadb.json ~/frappe-bench/sites/test_site_producer/site_config.json'

// 			sh 'mysql -uroot -proot -hdb -e "CREATE DATABASE test_frappe_consumer"';
// 		}
// 	}
// }

node {
    checkout scm
    docker.image('mariadb:10.3').withRun('-e "MYSQL_ROOT_PASSWORD=root"') { c ->
        docker.image('mariadb:10.3').inside("--link ${c.id}:db --user root") {
            /* Wait until mysql service is up */
            sh 'while ! mysqladmin ping -hdb --silent; do sleep 1; done'
        }
        docker.image('ubuntu:trusty').inside("--link ${c.id}:db --user root") {
            /*
             * Run some tests which require MySQL, and assume that it is
             * available on the host name `db`
             */
            sh 'apt update;apt -y install mysql-client'
            sh 'apt mysql -uroot -proot -hdb -e "SHOW DATABASES;"'
        }
    }
}