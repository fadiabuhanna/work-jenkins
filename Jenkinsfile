pipeline {
  agent any
  parameters{
    string(name: 'userName', defaultValue: 'fadi', description: 'user name')
    string(name: 'hostip', defaultValue: '127.0.0.1', description: 'host ip address')
    string(name: 'port', defaultValue: '2222', description: 'port')
  }
  stages {
    stage("build") {
      steps {
        bat "java -classpath jsch-0.1.55.jar Try.java fadi 127.0.0.1 2222"
      }
    } 
  } 
} 
