## Environment Requiremen
jdk 1.8

## Run  

1.Firstly, change the accessKey and secretKey under directory application.properties

cd path

mvn clean package -Dmaven.test.skip=true

cd target/

java -jar WebSocket-JAVA-demo-1.jar  




# application.properties Parameters Specifications
| Name| Specification|
|----|----|
|accessKey |Users need to put in accessKey|
|    secretKey | Users need to put in secretKey|
|   uri.host      | websocket address, no need of modification|
|   uri.protocol  | agreement, no need of modification|
|    uri.ao.path     |  account and order request path, no need of modification|
|    uri.market.path     |  account and order request path, no need of modification|
|    uri.port     |  port number, no need of modification|


# Supplements
```
Project related:
WebSocketAccountsAndOrders is used to request order and account information
```






