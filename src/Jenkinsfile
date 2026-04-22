pipeline {
    agent any

    parameters {
        string(
            name: 'SCENARIO_ID',
            defaultValue: 'C001',
            description: 'Cucumber scenario tag without @'
        )
    }

    stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Start backend') {
                steps {
                    bat 'docker rm -f nbank || exit /b 0'
                    bat 'docker pull --platform linux/arm64 nobugsme/nbank:with_validation_fix'
                    bat 'docker run -d --name nbank -p 127.0.0.1:5000:4111 nobugsme/nbank:with_validation_fix'
                }
            }

            stage('Run Cucumber') {
                steps {
                    bat "mvn clean test -Pcucumber -Dcucumber.filter.tags=@${params.SCENARIO_ID}"
                }
            }
        }

    post {
        always {
            allure([
                results: [[path: 'target/allure-results']]
            ])
        }
    }
}