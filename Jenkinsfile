pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'tests', url: 'https://github.com/gleb1alekseev/monkkee.git'

                // Run Maven on a Unix agent.
//                 sh "mvn -Dtest=LoginTest test"

                // To run Maven on a Windows agent, use
                bat "mvn clean -Dtest=LoginTest test"
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    allure([
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}