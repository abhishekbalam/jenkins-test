pipeline {
  agent {
    docker.image('ubuntu:trusty').inside{
      apt update
      apt upgrade
    }
  }
  stages {
    stage('Test') {
      steps {
        sh 'echo "py3"'
        ping googe.com -c 2
      }
    }
  }
}