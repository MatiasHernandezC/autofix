pipeline{
    agent any
    tools{
        maven "maven"
    }
    stages{
        stage("Build JAR File"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MatiasHernandezC/autofix.git']])
                dir("autofix"){
                    sh "mvn clean install"
                }
            }
        }
        stage("Test"){
            steps{
                dir("autofix"){
                    sh "mvn test"
                }
            }
        }
        stage("Build Docker Image"){
            steps{
                dir("autofix"){
                    sh "docker build -t motihc/proyecto_autofix:latest ."
                }
            }
        }
        stage("Push Docker Image"){
            steps{
                dir("autofix"){
                    withCredentials([string(credentialsId: 'dckrhubpassword', variable: 'dckpass')]) {
                        sh "docker login -u motihc -p ${dckpass}"
                    }
                    sh "docker push motihc/proyecto_autofix:latest"
                }
                
            }
        }
    }
    post{
        always{
            dir("autofix"){
                sh "docker logout"
            }
        }
    }
}
