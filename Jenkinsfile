pipeline {
  agent none
  stages {
    stage('Back-end') {
      agent {
        docker { image 'maven:3.9.6-adoptopenjdk-11' }
      }
      steps {
        sh 'mvn clean install'
      }
    }
     stage('Checkout') {
      agent docker {
          steps{
                git 'https://github.com/OPQjuly23/Train-Ticket-Reservation-System.git'
              }
                  }
      }
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Front-end') {
      agent {
        docker { image 'node:16-alpine' }
      }
      steps {
        sh 'npm install'
      }
    }
  }

