pipeline {
    agent any
    tools {
        maven "maven3.8.3"
        jdk "jdk17-nuevo"
    }
    stages {
        stage("Env Variables") {
            steps {
                sh "printenv"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Site') {
            steps {
                sh 'mvn site'
            }
        }
        stage('Sonar'){
            steps {
                 sh 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=m5-spring-jenkins -Dsonar.login=c5f73456fdc62705650e6c57648ffa62ca6f5737 -Dsonar.host.url=https://sonarcloud.io -Dsonar.organization=jorgeaparicio'
            }
        }
    }
}