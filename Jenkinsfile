pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Unit Test') {
            steps {
                sh 'make test'
            }
        }

        stage('Build Jar') {
            steps {
                sh 'make build'
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

