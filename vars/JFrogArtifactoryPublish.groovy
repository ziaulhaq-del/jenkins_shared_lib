def publishToArtifactory(artifactoryCredentialsId) {
    def mavenBuildInfo

    // Set the path to your Maven project or artifact
    def projectPath = "/path/to/your/project"
    
    // Set the path to the target repository in Artifactory
    def targetRepository = "libs-release-local"
    
    // Set the version of your Maven project
    def projectVersion = "1.0.0"

    // JFrog CLI command to publish artifacts to Artifactory
    def cliCommand = """
        jfrog rt mvn "target/*.jar" "${targetRepository}/${projectPath}/${projectVersion}/" --build-name=my-build --build-number=1
    """

    // Execute the JFrog CLI command
    def result = sh(script: cliCommand, returnStatus: true)

    // Check if the JFrog CLI command was successful
    if (result == 0) {
        // Retrieve Maven build information for additional actions or reporting
        mavenBuildInfo = sh(script: 'jfrog rt bce my-build 1', returnStdout: true).trim()
    } else {
        error "Failed to publish artifacts to Artifactory"
    }

    return mavenBuildInfo
}

// Example usage
def artifactoryCredentialsId = 'artifactory-credentials'
def mavenBuildInfo = publishToArtifactory(artifactoryCredentialsId)
println "Maven Build Info: ${mavenBuildInfo}"
