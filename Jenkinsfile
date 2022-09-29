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
               sh 'sudo docker build -t bitcoinservice .'   
             }
           }
       }
       
       stage('run container') {
           steps{
             script{
               sh 'sudo docker run -p 9095:9095 -d bitcoinservice'   
             }
           }
       }
       

    }
}
