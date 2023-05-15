# A simple train ticket machine API

- This application will support a touch user interface of a ticketing
  machine.
- The user will search for a station and the system will return all the available options
- Next available characters to be updated in the machine as well
- White space is considered a useful character

# Stack

- Spring / Spring Boot 3.0
- Maven
- Java 17
- JUnit5 and Mockito

## Startup application

```java
mvn clean package
```

```java
mvn spring-boot:run
```
or

```java
docker build -t train-ticket-machine:v1 .
```

```java
docker run -d -p 8081:8081 --name train-ticket-machine train-ticket-machine:v1
```

## Context Path

`http://localhost:8081/api`

## Default Station List

    Abrantes
    Porto Campanha
    Porto São Bento
    Braga
    Coimbra
    Coimbra B
    Aveiro
    Vila das Aves
    Lordelo
    Faro
    Santa Margarida
    Santarem
    Santana Cartaxo
    Lisboa Santa Apolonia 
    Santo Amaro de Oeiras
    Barreiro
    Carregado  
    Lisboa Oriente  
    Azambuja 
    Obidos

## Station Resource Endpoint

### Request

```curl 
GET http://localhost:8081/api/v1/station
```

```curl 
curl -i -H 'Accept: application/json' http://localhost:8081/api/v1/station
```

### Response

```java

    HTTP/1.1 200 OK
    Date: Date: Mon, 15 May 2023 21:43:52 GMT
    Status: 200 OK
    
    {
    	"stations": [
    		{
    			"name": "Aveiro",
    			"isAvailable": true
    		},
    		{
    			"name": "Lisboa Santa Apolonia",
    			"isAvailable": true
    		},
    		{
    			"name": "Lisboa Oriente",
    			"isAvailable": true
    		},
    		...
    		{
    			"name": "Santo Amaro de Oeiras",
    			"isAvailable": true
    		}
    	],
    	"nextAvailableChars": [
    		"P",
    		...
    		"F",
    		"L",
    		"O"
    	]
    }
````

### Request (with search param)

```curl 
GET http://localhost:8081/api/v1/station
```

```curl 
curl -i -H 'Accept: application/json' http://localhost:8081/api/v1/station?search=Santa
```

### Response

```java
    HTTP/1.1 200 OK
    Date: Date: Mon, 15 May 2023 21:43:52 GMT
    Status: 200 OK
    
    {
    	"stations": [
    		{
    			"name": "Santana Cartaxo",
    			"isAvailable": true
    		},
    		{
    			"name": "Santa Margarida",
    			"isAvailable": true
    		},
    		{
    			"name": "Santarem",
    			"isAvailable": true
    		}
    	],
    	"nextAvailableChars": [
    		" ",
    		"r",
    		"n"
    	]
    }

```

## Tests Coverage

Unit tests are included in the project

- Service Layer (verify **getAllStations** and **getNextAvailableChar** methods)
- Controller layer (`http://localhost:8081/api/v1/station` and `http://localhost:8081/api/v1/station?search=Santa`)
- DAO layer (**getAllStations** method)