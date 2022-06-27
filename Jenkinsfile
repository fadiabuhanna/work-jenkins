pipeline {
  agent any
  parameters{
    string(name: 'folderName', defaultValue: '', description: 'folder to print')
    choice(name:"VERION", choises:["1.1","1.2"])
 }
  stages {
    stage("build") {
      steps {
        bat "java Try.java ${params.folderName}"
      }
    } 
  } 
} 
