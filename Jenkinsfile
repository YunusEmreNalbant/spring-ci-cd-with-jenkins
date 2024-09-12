pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t yunusemrenalbant/spring-ci-cd-with-jenkins:0.0.7 .'
                }
            }
        }

        stage('Push image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u yunusemrenalbant -p ${dockerhubpwd}'

                        sh 'docker push yunusemrenalbant/spring-ci-cd-with-jenkins:0.0.7'
                    }
                }
            }
        }
    }
}