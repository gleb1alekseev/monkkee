pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "M3"
   }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
                string(name: 'user', defaultValue: 'defaultUser')
                string(name: 'password', defaultValue: 'defaultPassword')
    }

   stages {
      stage('Testing') {
         steps {
            // Get some code from a GitHub repository
            git branch: "${params.BRANCH}", url: 'https://github.com/gleb1alekseev/monkkee.git'

            // Run Maven on a Unix agent.
//             sh "mvn clean test"

            // To run Maven on a Windows agent, use
            bat "mvn clean -Duser=${params.user} -Dpassword=${params.password} test"
         }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
            }
         }
      }
      stage('Reporting') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
      }
   }
}