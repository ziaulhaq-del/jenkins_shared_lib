def call() {
    echo '----------executing jfrog'
    sh """ curl -X PUT -u admin:Admin123 -T /var/lib/jenkins/workspace/JfrogArtf/target/kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar http://3.82.162.232:8082
}
