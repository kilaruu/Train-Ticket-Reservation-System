node {
 
    stage ('git clone'){
      git credentialsId: 'jenkins cred', url: 'https://github.com/OPQjuly23/Train-Ticket-Reservation-System.git'
    }
    stage('maven build'){
            sh 'mvn clean install'
    }
    
    stage('SonarQube Analysis') {
 withSonarQubeEnv(credentialsId: 'SonarQube-token') {
    // some block
                 sh'mvn  sonar:sonar'
            }
        }
  stage ('deploy') {
              sshagent(['tomcat-1cred']) {
             // some block
            sh 'scp -o strictHostkeyChecking=no target/*.war ubuntu@3.108.218.245:/opt/tomcat/apache-tomcat-9.0.68/webapps/'
} 
           }
}


