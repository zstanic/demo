# demo

Simple demo application for CRU operations on Redis server.

Minimul requirements :

- Redis server
- Java 11
- Maven

Running application :

1. Make sure redis server is on port 6379
2. Make sure Java 11 is installed
3. Run application :
	java -jar demo-0.0.1-SNAPSHOT.war
	
Download docker images :

1. docker network create demoRedis
2. docker pull redis
3. docker pull ymmij/demo_web
	
Running as docker :

1. First run this command to crated redis container : docker run -p 6379:6379 --name locRedis --network demoRedis redis
2. Run this command to create app container : docker run -p 8080:8080 --name demoApp --network demoRedis ymmij/demo_web