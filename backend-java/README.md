# backend-java

Build the application with: 

````
mvn package
````

Then run the app with: 

````
export OTEL_SERVICE_NAME=backend-svc
export OTEL_RESOURCE_ATTRIBUTES='deployment.environment=derek-test'
export SPLUNK_TRACE_RESPONSE_HEADER_ENABLED=true
java -javaagent:./splunk-otel-javaagent.jar -Dserver.port=8090 -Dotel.exporter.oltp.endpoint='http://localhost:4318' -Dsplunk.metrics.endpoint='http://localhost:4318' -Dsplunk.metrics.enabled=true -jar ./target/myproject-0.0.1-SNAPSHOT.jar
````

Test it with: 

````
curl http://localhost:8090/ping
````