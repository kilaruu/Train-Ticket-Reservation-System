node {
     stage ('git clone'){
      git 'https://github.com/kilaruu/Train-Ticket-Reservation-System.git'
    }
    stage('maven build'){
            sh 'mvn clean install'
    }
    
  stage ('deploy') {
              withCredentials([usernamePassword(credentialsId: 'tomcatcred', passwordVariable: 'TOMCAT_PASSWORD', usernameVariable: 'TOMCAT_USERNAME')]) {
            sh 'cp target/*.war /opt/tomcat/apache-tomcat-9.0.68/webapps/'
} 
           }
}

