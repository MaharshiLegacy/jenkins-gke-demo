pipeline {
    agent any
    tools{
      jdk 'java21'
    }

  
    
    stages{
         stage('Check Java Version') {
    steps {
        sh 'chmod +x mvnw'
        sh 'echo "JAVA_HOME=$JAVA_HOME"'
        sh 'java -version'
        sh './mvnw -version'
    }
}
      stage('Checkout') {
              steps {
                  checkout scm
              }
          }

        stage('Check Java Compiler') {
    steps {
        sh 'echo "JAVA_HOME=$JAVA_HOME"'
        sh 'which java'
        sh 'java -version'
        sh 'which javac'
        sh 'javac -version'
        sh 'javac --help | grep -A 2 -- "--release"'
    }
}
        
    stage('Build and Test') {
    steps {
        sh 'chmod +x mvnw'
        sh './mvnw clean verify'
    }
}

        
stage('Build Docker Image') {
    steps {
        sh '''
            set -eu

            PROJECT_ID="project-f45bd8e2-3bd4-49b8-a29"
            REGION="asia-south1"
            REPOSITORY="jenkins-gke-demo"
            IMAGE_NAME="gke-demo"

            IMAGE_URI="${REGION}-docker.pkg.dev/${PROJECT_ID}/${REPOSITORY}/${IMAGE_NAME}"

            echo "Building Docker image: ${IMAGE_URI}:${BUILD_NUMBER}"

            docker build \
                -t "${IMAGE_URI}:${BUILD_NUMBER}" \
                -t "${IMAGE_URI}:latest" .
        '''
    }
}

stage('Push Image to Artifact Registry') {
    steps {
        sh '''
            set -eu

            PROJECT_ID="project-f45bd8e2-3bd4-49b8-a29"
            REGION="asia-south1"
            REPOSITORY="jenkins-gke-demo"
            IMAGE_NAME="gke-demo"

            IMAGE_URI="${REGION}-docker.pkg.dev/${PROJECT_ID}/${REPOSITORY}/${IMAGE_NAME}"

            gcloud auth configure-docker \
                "${REGION}-docker.pkg.dev" --quiet

            docker push "${IMAGE_URI}:${BUILD_NUMBER}"
            docker push "${IMAGE_URI}:latest"

            echo "Image pushed successfully."
            echo "${IMAGE_URI}:${BUILD_NUMBER}"
        '''
    }
}

        
    
    }
}
