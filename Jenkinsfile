pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'ls'
                sh 'pwd'
                sh 'whoami'
                sh 'docker run -d ubuntu:trusty -u root /bin/bash'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}