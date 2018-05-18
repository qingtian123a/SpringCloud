# 断路器聚合监控

##演示说明
###1、http://localhost:8769/turbine.stream
###2、依次请求turbine监视的服务。如：http://localhost:8765/test/hi?name=forezp1，http://localhost:8775/test/hi?name=kay1
###3、打开:http://localhost:8765/hystrix,输入监控流http://localhost:8769/turbine.stream
###4、点击monitor stream 进入页面