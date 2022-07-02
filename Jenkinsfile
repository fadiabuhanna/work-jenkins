pipeline {
  agent any
  parameters{
    string(name: 'UserName', defaultValue: 'fadi', description: 'user name')
    string(name: 'HostIp', defaultValue: '127.0.0.1', description: 'host ip address')
    string(name: 'Port', defaultValue: '2222', description: 'port')
    string(name: 'password', defaultValue: '123123123', description: 'password')
    string(name: 'root', defaultValue: '-R', description: 'root')
  }
  stages {
    stage("build") {
      steps {
        bat "java -classpath jsch-0.1.55.jar Try.java"
      }
    } 
  } 
} 
