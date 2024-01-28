pipeline {
    agent none
    stages {
        stage('Back-end') {
            agent {
                docker { 
                    image 'maven:3.9.6-adoptopenjdk-11' 
                }
            }
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Checkout') {
            agent {
                docker {
                    image 'maven:3.9.6-adoptopenjdk-11'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                git 'https://github.com/OPQjuly23/Train-Ticket-Reservation-System.git'
            }
        }
        stage('Front-end') {
            agent {
                docker { 
                    image 'node:16-alpine' 
                }
            }
            steps {
                sh 'npm install'
            }
        }
    }
}
