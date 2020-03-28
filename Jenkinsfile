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
            steps {
                sh 'python --version'
                echo 'In Test Stage'
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
