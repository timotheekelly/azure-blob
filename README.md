# azure-blob
 Java Spring Boot API to store media in Azure Storage and media metadata in MongoDB

 Requirements:
 - [Java 11](https://www.java.com/en/download/manual.jsp) or higher.
 - [Maven](https://maven.apache.org/) or Gradle, but this tutorial will reference Maven.
 - Your own [MongoDB Atlas](https://www.mongodb.com/) account.
 - An [Azure Account](https://azure.microsoft.com/en-us/free/) with an active subscription.
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
