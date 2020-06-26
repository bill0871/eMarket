pipeline {
   agent any

   stages {
      stage('pull') {
         steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/develop']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'f784fdfb-01ed-4da3-adac-0ade1bbac95c', url: 'git@github.com:bill0871/eMart.git']]])
         }
      }
      stage('build') {
         steps {
            sh label: '', script: '''cd emart-back-end
            mvn clean install -Dmaven.test.skip=true'''
         }
      }
      stage('deploy') {
         steps {
            echo 'deploy application'
         }
      }
   }
}
