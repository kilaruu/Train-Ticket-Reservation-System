node {
     stage ('git clone'){
      git 'https://github.com/OPQjuly23/Train-Ticket-Reservation-System.git'
    }
    stage('maven build'){
            sh 'mvn clean install'
    }
    
    stage('SonarQube Analysis') {
 withSonarQubeEnv(credentialsId: 'sonarqube-Token') {
    // some block
                 sh'mvn  sonar:sonar'
            }
        }
  stage ('deploy') {
              sshagent(['tomcatcred']) {
    // some block
            sh 'scp -o strictHostkeyChecking=no target/*.war ubuntu@13.232.191.194:/opt/tomcat/apache-tomcat-9.0.68/webapps/'
} 
           }
}

