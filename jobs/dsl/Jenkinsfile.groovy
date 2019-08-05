node{
   stage('gradle build'){
	steps {
gradle('clean build')
		}
	}   
}
