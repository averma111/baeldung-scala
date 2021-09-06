pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Test') {
            steps {
                sh './mvnw clean test'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw -DskipTests=true package'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts '**/target/*-1.0-SNAPSHOT.jar'
        }
    }
}

