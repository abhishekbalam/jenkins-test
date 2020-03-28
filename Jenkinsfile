pipeline {
  agent {
    docker {
      image 'python:3.5.1'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'python --version'
        echo 'In Build Stage'
      }
    }

    stage('Test') {
      parallel {
        stage('Py3 Maria') {
          agent {
            docker {
              image 'ubuntu:trusty'
            }

          }
          steps {
            sh 'echo "py3"'
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

    stage('Deploy') {
      steps {
        sh 'python --version'
        echo 'In Deploy Stage'
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