node {
    checkout scm
    docker.image('mariadb:10.3').withRun('-e "MARIADB_ROOT_PASSWORD=root"') { c ->
        docker.image('mariadb:10.3').inside("--link ${c.id}:db") {
            /* Wait until mysql service is up */
            sh 'while ! mysqladmin ping -hdb --silent; do sleep 1; done'
        }
        docker.image('ubuntu:trusty').inside("--link ${c.id}:db --user root") {
            /*
             * Run some tests which require MySQL, and assume that it is
             * available on the host name `db`
             */
            sh 'ls'
            sh 'mysql -uroot -proot -hdb -e "SHOW DATABASES"'
        }
    }
}