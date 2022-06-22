def gv

pipeline{
    agent any
    options {
        ansiColor('xterm')
    }

    stages {
        stage("Initial") {
            steps {
                script {
                    gv = load 'jenkins/script.groovy'
                }
            }
        }
        stage("SCM") {
            steps {
                script {
                    gv.CheckoutSCM()
                }
            }
        }
        stage("Populate ENV") {
            steps {
                script {
                    gv.PopulateEnv()
                }
            }
        }
        stage("Test") {
            steps {
                script {
                    gv.TestApps()
                }
            }
        }
    }
    post{
        always{
            script {
                gv.PublishReport()
            }
        }
    }
}