pipeline {
    agent any
    ansiColor('xterm') {
        stages {
            stage("SCM") {
                steps {
                    git branch: 'qa-dikabrenda',
                    credentialsId: '0105c6c0-ed90-4433-8ddd-3728c87f861d', 
                    url: 'https://github.com/paquesid/paques-website-automation.git'
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
}