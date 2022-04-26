# spring-boot-neo4j-example

Java 17 LTS / spring-boot 2.6.6 / bootstrap 4.6.1 / jquery 3.6.0 / single module version ...

## Docker Neo4j Container

### Run/prepare docker image and container

``docker run --publish 7474:7474 --publish 7687:7687 --env=NEO4J_AUTH=none --name spring-neo4j -d neo4j:4.4.6``

### Neo4j Web Interface

Open browser connection to ``localhost:7474`` that presents the web interface.

### Stop docker container

``docker stop spring-neo4j``

## Spring-Boot-Application
- Start application with maven target sequence ``clean`` then ``package`` or ``install`` and ``spring-boot:start`` or ``spring-boot:run``

- Open web-app inside a browser on localhost and port ``8080``

- Stop application when needed with maven target ``spring-boot:stop``