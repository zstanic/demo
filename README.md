# demo

Simple demo application for CRU operations on Redis server.

Minimul requirements :

- Redis server
- Java 11
- Maven

Running application :

1. Make sure redis server is on localhost:6379
2. Make sure Java 11 is installed
3. Run application :
	java -jar demo-0.0.1-SNAPSHOT.war
	
Running as docker :

1. docker-compose build
2. docker run -p 8080:8080 --name demoApp demo_web