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
               println(pwd())
               sh 'mvn test'
              }
           }
       }
       
       stage('run container') {
           steps{
             sh 'sudo docker run -p 9095:9095 vikramvundyala/bitcoinservice'
           }
       }
       

    }
}
