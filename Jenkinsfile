node {
    // checkout scm
    docker.image('mysql:5').withRun('-e "MYSQL_ROOT_PASSWORD=my-secret-pw"') { c ->
        docker.image('mysql:5').inside("--link ${c.id}:db") {
            /* Wait until mysql service is up */
            sh 'while ! mysqladmin ping -hdb --silent; do sleep 1; done'
            sh 'mysql -h 127.0.0.1 -P 3306 -u root -pmy-secret-pw'
        }
        docker.image('ubuntu:trusty').inside("--link ${c.id}:db") {
            /*
             * Run some tests which require MySQL, and assume that it is
             * available on the host name `db`
             */
            sh 'echo "hello"'
            sh 'apt install mysql-server'
            sh 'mysql'
        }
    }
}