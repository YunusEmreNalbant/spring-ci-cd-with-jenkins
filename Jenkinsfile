pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {

        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/YunusEmreNalbant/spring-ci-cd-with-jenkins']])
                sh 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t yunusemrenalbant/spring-ci-cd-with-jenkins:0.0.9 .'
                }
            }
        }

        stage('Push image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u yunusemrenalbant -p ${dockerhubpwd}'
                    }
                    sh 'docker push yunusemrenalbant/spring-ci-cd-with-jenkins:0.0.9'
                }
            }
        }
    }
}