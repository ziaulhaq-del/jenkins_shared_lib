script {
    def artifactoryCredentialsId = 'artifactory-credentials'
    def mavenBuildInfo = publishToArtifactory(artifactoryCredentialsId)
}
