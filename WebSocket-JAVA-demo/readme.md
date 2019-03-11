## 环境要求
jdk 1.8

## 运行  

1.先修改application.properties中的accessKey，secretKey

cd 项目路径

mvn clean package -Dmaven.test.skip=true

cd target/

java -jar WebSocket-JAVA-demo-1.jar  




# application.properties参数说明
| 名称| 说明|
|----|----|
|accessKey |用户accessKey,需要填写|
|    secretKey | 用户secretKey,需要填写|
|   uri.host      | websocket地址,不需要修改|
|   uri.protocol  | 协议,不需要修改|
|    uri.ao.path     |  账户及订单请求路径,不需要修改|
|    uri.market.path     |  账户及订单请求路径,不需要修改|
|    uri.port     |  端口号,不需要修改|


# 相关说明
```
项目中
WebSocketAccountsAndOrders用于请求订单及账户信息
WebSocketMarket用于请求market信息
```






