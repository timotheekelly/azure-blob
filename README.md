# azure-blob
 Java Spring Boot API to store media in Azure Storage and media metadata in MongoDB

 Requirements:
 - Java Verion 11 or above
 - Azure Storage Container
 - MongoDB cluster

In the application.properties file, copy below and add in your connection details:
```
spring.data.mongodb.uri=
spring.data.mongodb.database=
server.port=8080
azure.blob-storage.connection-string=
SharedAccessSignature=
spring.cloud.azure.storage.blob.container-name=
