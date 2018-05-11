# configure-server
配置服务器

##启动程序：访问http://localhost:8888/foo/dev
有个文件config-client-dev.properties文件中有一个属性。

foo = foo version 3

## http请求地址和资源文件映射如下

   /{application}/{profile}[/{label}]
   /{application}-{profile}.yml
   /{label}/{application}-{profile}.yml
   /{application}-{profile}.properties
   /{label}/{application}-{profile}.properties
  