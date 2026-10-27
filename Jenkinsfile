pipeline {
    agent any
    tools{
      jdk 'java21'
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
