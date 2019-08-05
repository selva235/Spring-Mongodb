node{
stage('clone repository'){
        github {
            scanCredentialsId('selvagithubcred')
            repoOwner('selva235')
            repository('Spring-Mongodb')
//hai
        }
    }

stage('gradle build'){
	gradle('clean build')
   }   
}
