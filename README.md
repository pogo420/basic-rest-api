# basic-rest-api
Implementing a basic rest API in spring boot



- Getting jwt token with user validation:

    POST /movie/info/authenticate HTTP/1.1
    
    Host: localhost:8080
    
    Content-Type: application/json
    
    cache-control: no-cache
    
    Postman-Token: 9bd0efa0-678d-451b-a849-ebe03d63eb85
    
    {
    "username": "arnab",
    "password": "passwd1"
    }------WebKitFormBoundary7MA4YWxkTrZu0gW--

- Using jwt token for requests:

    GET /movie/info/all HTTP/1.1
    
    Host: localhost:8080
    
    Content-Type: application/json
    
    Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhcm5hYiIsImV4cCI6MTU5ODgzNTc1OCwiaWF0IjoxNTk4Nzk5NzU4fQ.da5istNdKuJKskccK3Dc7HuX1oEMWcVjDETPOmupFoU
    
    cache-control: no-cache
    
    Postman-Token: ff0954c3-93cf-4fcf-b851-5493e34b55f3
