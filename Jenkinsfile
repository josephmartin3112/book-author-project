pipeline {
    agent any

    tools {
        maven 'maven-3.9.8'
        jdk 'jdk-21'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        git url: 'https://github.com/josephmartin3112/book-author-project.git', branch: 'main'
                    }
                }
            }
        }

        stage('Pre-Build') {
            steps {
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        bat 'docker-compose down || true'
                        
                        def services = ['gateway-service', 'eureka-service', 'security-service', 'authors-service', 'books-service']
                        
                        for (service in services) {
                            bat 'docker rmi -f ${service}:latest || true'
                            
                        }
                    }
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    def services = ['gateway-service', 'eureka-service', 'security-service', 'authors-service', 'books-service']

                    for (service in services) {
                        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                            dir(service) {
                                bat 'mvn clean package -DskipTests'
                            }
                        }
                    }
                }
            }
        }

        stage('Run Docker Compose Up') {
            steps {
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        bat 'docker-compose up -d'
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed!'
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline had errors, but execution continued.'
        }
    }
}

def getPort(service) {
    switch (service) {
        case 'gateway-service':
            return '8080'
        case 'eureka-service':
            return '8761'
        case 'security-service':
            return '8083'
        case 'authors-service':
            return '8082'
        case 'books-service':
            return '8081' 
        default:
            return '8080' 
    }
}