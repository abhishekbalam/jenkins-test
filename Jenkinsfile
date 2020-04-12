pipeline {
  agent {
    docker.image('ubuntu:trusty').inside{
      apt update
      apt upgrade
    }
  }
  stages {
    stage('Test') {
      parallel {
        stage('Py') {
          steps {
            sh 'echo "py3"'
            ping googe.com -c 2
          }
        }

        stage('Py3 Postgres') {
          steps {
            sh 'echo "test"'
          }
        }

        stage('Py2 maria') {
          steps {
            sh 'echo "yeah"'
          }
        }

      }
    }

  }
  post {
    always {
      echo 'Always!'
    }

    success {
      echo 'Success!'
    }

    failure {
      echo 'Failure!'
    }

    changed {
      echo 'Changed!'
    }

  }
}
