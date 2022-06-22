pipeline {
    agent any
    options {
        ansiColor('xterm')
    }

    stages {
        stage("SCM") {
            steps {
                echo "Checkout SCM ..."
            }
        }
        stage("Populate ENV") {
            steps {
                bat "copy env\\env.sample .env"
            }
        }
        stage("Test") {
            steps {
                bat 'mvn --batch-mode --update-snapshots verify'
            }
        }
    }
    post {
        always {
            cucumber buildStatus: 'null', 
            customCssFiles: '', 
            customJsFiles: '', 
            failedFeaturesNumber: -1, 
            failedScenariosNumber: -1, 
            failedStepsNumber: -1, 
            fileIncludePattern: 'target/cucumber.json', 
            pendingStepsNumber: -1, 
            skippedStepsNumber: -1, 
            sortingMethod: 'ALPHABETICAL', 
            undefinedStepsNumber: -1
        }
    }
}