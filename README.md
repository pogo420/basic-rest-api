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
`docker build -t mysql_image_name ./MysqlInfra/Dockerfile`
- Create Spring App image
`docker build -t spring_app_image_name .`
- Run Mysql image
`docker run --name mysql_container_name -d -p 3307:3307 -e MYSQL_ROOT_PASSWORD=some_password -e MYSQL_DATABASE=some_db -e MYSQL_USER=some_user -e MYSQL_PASSWORD=some_password mysql_image_name`
- Run Spring App image
`docker run -d --name spring_container_name -t --link mysql_container_name:mysql -p 8080:8080 -e MYSQL_HOST=host_ip_string -e MYSQL_USER=some_user -e MYSQL_PASSWORD=some_password spring_app_image_name`

### Using kubernetes

- For learning, lets use minikube, single node version of kubernetes perfect for testing and learning. Follow this 
[document](https://kubernetes.io/docs/tasks/tools/install-minikube/) for installation. 
- Assuming minikube is installed.
- Start minikube `minikube start`
- Creating Secret `kubectl apply -f ./kubernetes/app-secret.yaml`
- Creating Mysql deployment and service(internal) `kubectl apply -f ./kubernetes/mysql-config.yaml`
- Check internal ip of mysql service by `kubectl get service`
- Update the ip in `mysql-host` of `./kubernetes/global-config.yaml` 
- Creating ConfigMap `kubectl apply -f ./kubernetes/global-config.yaml`
- Creating Spring App deployment and service(external) `kubectl apply -f ./kubernetes/app-config.yaml`
- Check pod status by `kubectl get pods`
- We can check logs by `kubectl logs pod_name`
- Generate external by `minikube service spring_service_name` and use the ip for rest calls.