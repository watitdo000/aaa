pipeline {
    agent any

    stage('Build') {
            steps {
                // Set up Maven environment
                def mvnHome = tool 'Maven'
                env.PATH = "${mvnHome}/bin:${env.PATH}"

                // Build the Maven project
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Add your test steps here
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the project...'
                // Add your deployment steps here
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully!'
            // Add any post-success actions here
        }
        failure {
            echo 'Pipeline failed :('
            // Add any post-failure actions here
        }
    }
}
