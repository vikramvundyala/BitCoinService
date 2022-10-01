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
       
       stage('run container') {
           steps{
             withMaven(maven: 'maven_3.8.6'){
               echo 'in run container'  
               sh 'echo "test" | sudo -S docker stop bitcoin_service || exit 0'
               sh 'echo "test" | sudo -S docker rm bitcoin_service || exit 0'
               sh 'echo "test" | sudo -S docker rmi vikramvundyala/bitcoinservice || exit 0'
               sh 'echo "test" | sudo -S docker run -d -p 9095:9095 --name bitcoin_service vikramvundyala/bitcoinservice'
             }
           }
       }
    }
}
