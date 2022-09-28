pipeline {
    agent any

       stages {
        stage('Compile') {
            steps {
              withMaven(maven: 'maven_3.8.6'){
                echo 'in compile stage'
                sh 'mvn clean compile'
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
       
         stage('Deploy') {
           steps{
             withMaven(maven: 'maven_3.8.6'){
               echo 'in Deploy stage'
               sh 'mvn deploy'
              }
           }
       }

    }
}
