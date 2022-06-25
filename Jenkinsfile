pipeline {
  agent any
  parameters{
    string(name: 'folderName', defaultValue: '', description: 'folder to print')
 }
  stages {
    stage("build") {
      steps {
        bat "java Try.java oinn"
      }
    } 
  } 
} 
