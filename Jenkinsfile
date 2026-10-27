pipeline {
    agent any
    tools{
      jdk 'java21'
    }

    stage('Check Java Version') {
    steps {
        sh 'echo "JAVA_HOME=$JAVA_HOME"'
        sh 'java -version'
        sh './mvnw -version'
    }
}
    
    stages{
      stage('Checkout') {
              steps {
                  checkout scm
              }
          }
      stage('Build and Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean verify'
            }
        }
    
    }
}
