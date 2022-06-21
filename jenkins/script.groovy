def CheckoutSCM(){
    echo "Checkout SCM ..."
    // bat "docker run -p 3000:3000 dikabrenda/cypress_project:v3 ."
}

def AtBranch() {
    BRANCH_NAME == 'dev' && CODE_CHANGES = true
}

def PopulateEnv(){
    bat "cp env/sample.env .env"
}

def TestApps(){
    bat 'mvn --batch-mode --update-snapshots verify'
}

def InitialSession(){
    bat "docker compose up"
}

def RemoveSession(){
    bat "docker compose down"
}

def PublishReport(){
    bat "cucumber buildStatus: 'null', 
    customCssFiles: '', 
    customJsFiles: '', 
    failedFeaturesNumber: -1, 
    failedScenariosNumber: -1, 
    failedStepsNumber: -1, 
    fileIncludePattern: '**/*.json', 
    pendingStepsNumber: -1, 
    skippedStepsNumber: -1, 
    sortingMethod: 'ALPHABETICAL', 
    undefinedStepsNumber: -1"
}

def CucumberReport(){
    cucumber buildStatus: "UNSTABLE"
    fileIncludePattern: '**/cucumber.json'
}

def SendToTelegram(){
    echo "send to telegram.."
}

return this;