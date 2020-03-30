pipeline {
  agent {
    docker {
      image 'ubuntu:trusty'
    }

  }
  stages {
    stage('Test') {
      
      parallel {
        stage('Py') {
          agent {
            docker {
              image 'ubuntu:trusty'
            }

          }
          steps {
            sh 'echo "py3"'
            ping googe.com -c 2
          }
        }

        stage('Py3 Postgres') {
          agent {
            docker {
              image 'ubuntu:trusty'
            }

          }
          steps {
            sh 'echo "test"'
          }
        }

        stage('Py2 maria') {
          agent {
            docker {
              image 'ubuntu:trusty'
            }

          }
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
