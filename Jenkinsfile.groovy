pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'     
        jdk 'JAVA_HOME'           
    }

    environment {
        BROWSER = 'chrome'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/rameshhub/ProjectSelenium.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project'
                sh 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                echo "Running Selenium tests on ${BROWSER}"
                sh "mvn test -Dbrowser=${BROWSER}"
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                publishHTML(target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'Selenium Test Report'
                ])
            }
        }
    }

    post {
        success {
            echo 'Selenium tests passed'
        }
        failure {
            echo 'Selenium tests failed'
        }
        always {
            cleanWs()
        }
    }
}
