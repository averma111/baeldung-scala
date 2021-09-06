pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Test') {
            sh './mvnw clean test'
        }

        stage('Build') {
            sh './mvnw -DskipTests=true clean package'
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts '**/target/*-1.0-SNAPSHOT.jar'
        }
    }
}

