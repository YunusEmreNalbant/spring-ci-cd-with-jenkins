pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t yunusemrenalbant/spring-ci-cd-with-jenkins .'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t yunusemrenalbant/spring-ci-cd-with-jenkins:0.0.2 .'
                }
            }
        }

        stage('Push image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u yunusemrenalbant -p ${dockerhubpwd}'

                        sh 'docker push yunusemrenalbant/spring-ci-cd-with-jenkins:0.0.1'
                    }
                }
            }
        }
    }
}