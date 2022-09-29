pipeline {
    agent any

       stages {
        stage('Compile') {
            steps {
              withMaven(maven: 'maven_3.8.6'){
                echo 'in compile stage'
                sh 'mvn clean compile package'
             }
            }
        }
        
       stage('Test') {
           steps{
             withMaven(maven: 'maven_3.8.6'){
               echo 'in Test stage'
               sh 'mvn test'
              }
           }
       }
       
       stage('containerize') {
           steps{
             script{
               sh 'docker build -t bitcoinservice'   
             }
           }
       }
       

    }
}
