pipeline {
  agent {
    node {
      docker.image('ubuntu:trusty').inside{ c->
        apt update
        apt upgrade
      }
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