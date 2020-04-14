node {
    // checkout scm
    docker.image('mariadb').withRun('-e "MARIADB_ROOT_PASSWORD=my-secret-pw"') { c ->
        docker.image('mariadb').inside("--link ${c.id}:db") {
            /* Wait until mysql service is up */
            sh 'while ! mysqladmin ping -hdb --silent; do sleep 1; done'
            sh 'mysql -hdb -P 3306 -u root -pmy-secret-pw'
            sh 'echo "yolo"'
            sh 'lsrelease'
            sh 'apt update'
        }
        // docker.image('ubuntu:trusty').inside("--link ${c.id}:db") {
        //     sh 'echo "hello"'
        //     sh 'whoami'
        //     sh 'mysql -hdb'
        // }
    }
}