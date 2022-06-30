pipeline {
  agent any
  parameters{
    string(name: 'folderName', defaultValue: '', description: 'folder to print')
  }
  stages {
    stage("build") {
      steps {
        bat "java -classpath jsch-0.1.55.jar Try.java "fadi" "127.0.0.1" "2222" "
      }
    } 
  } 
} 
