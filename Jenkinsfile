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
                git branch: 'master', url: 'https://github.com/gleb1alekseev/monkkee.git'

                // Run Maven on a Unix agent.
//                 sh "mvn -Dtest=LoginTest test"

                // To run Maven on a Windows agent, use
//                 bat "mvn clean -Dtest=LoginTest test"
            bat "tree /F src/test/java"

            // 2. Запуск с явным указанием пути
            bat """
                mvn clean test \\
                -Dtest=tests.LoginTest \\
                -Dsurefire.failIfNoTests=false \\
                -Dmaven.test.failure.ignore=true
            """

            // 3. Резервный вариант - все тесты
            bat "mvn test -DsuiteXmlFile=src/test/resources/testng.xml"
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