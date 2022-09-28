pipeline {
    agent any

       stages {
        stage('Compile') {
            steps {
                echo 'in compile stage'
                sh "mvn clean compile"

            }
        }
        
       stage('Test') {
           steps{
               echo 'in Test stage'
               sh "mvn test"
           }
       }
       
         stage('Deploy') {
           steps{
               echo 'in Deploy stage'
               sh "mvn deploy"
           }
       }

    }
}
