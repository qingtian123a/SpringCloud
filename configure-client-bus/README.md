# configure-client-bus

##说明
1、需要多引入spring-cloud-starter-bus-amqp包，增加对消息总线的支持
2、这时我们去代码仓库将foo的值改为“foo version 4”，即改变配置文件foo的值。如果是传统的做法，需要重启服务，才能达到配置文件的更新。此时，我们只需要发送post请求：http://localhost:8881/bus/refresh，你会发现config-client会重新读取配置文件
3、/bus/refresh接口可以指定服务，即使用”destination”参数，比如 “/bus/refresh?destination=customers:**” 即刷新服务名为customers的所有服务，不管ip。

## 框架图
### 获取框架图
![获取框架图](image/SpringCloud-config-bus-框架图.png)