pipeline {
  agent any
  //{
  //   node {
  //     docker.image('ubuntu:trusty').inside{ c->
  //       apt update
  //       apt upgrade
  //     }
  //   }
  // }
  stages {
    stage('Test') {
      steps {
        docker.image('ubuntu:trusty').inside{ c->
          apt update
          apt upgrade
        }
      }
    }
  }
}