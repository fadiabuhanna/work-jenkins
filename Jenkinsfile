pipeline {
  agent any
  parameters{
    string(name: 'folderName', defaultValue: '', description: 'folder to print')
 }
  stages {
    stage("build") {
      steps {
        pwd
        bat "java Try.java ${params.folderName}"
      }
    } 
  } 
} 
