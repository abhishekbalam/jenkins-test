node {
	checkout scm
	docker.image('mariadb:10.3').withRun('-e "MYSQL_ROOT_PASSWORD=root"') { c ->
		docker.image('mariadb:10.3').inside("--link ${c.id}:db") {
			sh 'echo "here1"'
			sh 'while ! mysqladmin ping -h0.0.0.0 --silent; do sleep 1; done'
			sh 'echo "here2"'
			
			//sh 'mysql -uroot -proot -h0.0.0.0 -e "SET GLOBAL character_set_server = \'utf8mb4\'"';
			//sh 'mysql -uroot -proot -h0.0.0.0 -e "SET GLOBAL collation_server = \'utf8mb4_unicode_ci\'"';
		}
		docker.image('abhishekbalam/test1:latest').inside('--user frappe --link ${c.id}:db -w /home/frappe') {
			sh 'bench init frappe-bench --skip-assets --python $(which python3)'
			sh 'ls'

			sh 'mkdir ~/frappe-bench/sites/test_site'

			sh 'cp ~/site_configs/consumer_db/mariadb.json ~/frappe-bench/sites/test_site/site_config.json'
			sh 'mkdir ~/frappe-bench/sites/test_site_producer'
			sh 'cp ~/site_configs/producer_db/mariadb.json ~/frappe-bench/sites/test_site_producer/site_config.json'

			sh 'mysql -uroot -proot -hdb -e "CREATE DATABASE test_frappe_consumer"';
		}
	}
}