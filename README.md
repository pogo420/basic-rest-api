# basic-rest-api
Implementing a basic rest API in spring boot


### Execution steps
- Getting jwt token with user validation:

    POST /movie/info/authenticate HTTP/1.1
    
    Host: localhost:8080
    
    Content-Type: application/json
    
    cache-control: no-cache
    
    body:
    {
    "username": "arnab",
    "password": "passwd1"
    }

- Using jwt token for requests:

    GET /movie/info/all HTTP/1.1
    
    Host: localhost:8080
    
    Content-Type: application/json
    
    Authorization: Bearer <jwt_token>
    
    cache-control: no-cache
    

### Using docker containers

- Create MySql image
`docker build -t project/mysql ./MysqlInfra/Dockerfile`
- Create Spring App image
`docker build -t project/basic-rest-api .`
- Run Mysql image
`docker run --name mysqldb -d -p 3307:3307 -e MYSQL_ROOT_PASSWORD=Mysql123 -e MYSQL_DATABASE=movie_rest_service -e MYSQL_USER=user1 -e MYSQL_PASSWORD=Mysql123 project/mysql`
- Run Spring App image
`docker run -t --link mysqldb:mysql -p 8080:8080 project/basic-rest-api`
