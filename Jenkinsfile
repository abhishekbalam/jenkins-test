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
        stage('Test') {
          steps {
            sh 'python --version'
            echo 'In Test Stage'
          }
        }

        stage('Py3 Maria') {
          agent {
            docker {
              image 'ubuntu:trusty'
            }

          }
          environment {
            DB = 'mariadb'
            PYTHON = '3'
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
          environment {
            DB = 'postgres'
            PYTHON = '3'
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
          environment {
            DB = 'mariadb'
            PYTHON = '2'
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