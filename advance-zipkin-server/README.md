# Spring Cloud Sleuth进阶实战

##项目说明
1、包含了eureka-server工程，作为服务注册中心.eureka-server的创建过程这里不重复；
2、advance-zipkin-server作为链路追踪服务中心，负责存储链路数据；
3、advance-gateway-service作为服务网关工程，负责请求的转发,同时它也作为链路追踪客户端，负责产生数据，并上传给advance-zipkin-service；
4、advance-user-service为一个应用服务，对外暴露API接口，同时它也作为链路追踪客户端，负责产生数据。

##项目演示
1、完整的项目搭建完毕，依次启动eureka-server、zipkin-server、user-service、gateway-service。
2、在浏览器上访问http://localhost:5000/user-api/user/hi
3、访问http://localhost:9411，即访问Zipkin的展示界面。这个界面主要用来查找服务的调用情况

##怎么在链路数据中添加自定义数据
现在需要实现这样一个功能，需要在链路数据中加上操作人。这需要在gateway-service上实现。建一个ZuulFilter过滤器，它的类型为“post”，order为900，
开启拦截。在拦截逻辑方法里，通过Tracer的addTag方法加上自定义的数据，比如本案例中加入了链路的操作人。另外也可以在这个过滤器中获取当前链路的
traceId信息,traceId作为链路数据的唯一标识，可以存储在log日志中，方便后续查找。

@Component
public class LoggerFilter extends ZuulFilter {

    @Autowired
    Tracer tracer;
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        tracer.addTag("operator","forezp");
        System.out.print(tracer.getCurrentSpan().traceIdString());
        return null;
    }
}

###使用spring-cloud-starter-stream-rabbit进行链路通讯
代码已经体现，增加rabbit配置，和修改pom。

###将链路数据存储在Mysql数据库
1、Zipkin支持Mysql、Elasticsearch、Cassandra存储
2、数据库sql文件：\document\mysql.sql
3、在pom和yml配置中加数据库相关信息。