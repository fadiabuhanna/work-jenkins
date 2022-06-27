pipeline {
  agent any
  parameters{
    string(name: 'folderName', defaultValue: '', description: 'folder to print')
    choise(name:"testNum", choises:['1','2','3'])

  }
  stages {
    stage("build") {
      steps {
        bat "java Try.java ${params.folderName}"
      }
    } 
  } 
} 
