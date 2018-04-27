@2018-04-28
Swagger2集成
------
Nginx测试接口，Nginx的配置可参考reference/nginx.conf

第一步，修改Nginx配置文件
++
upstream springboot_server{
	server localhost:8080 weight=20;
	server localhost:8081 weight=40;
	server localhost:8082 weight=60;
}

server {
	location / {
		proxy_pass http://springboot_server;
		root   html;
		index  index.html index.htm;
	}

...
}
++

第二步，启动三个服务实例
++
../kjoy>mvn install -Dmaven.test.skip=true
../kjoy>java -jar target/kjoy-0.0.1-SNAPSHOT.jar --server.port=8080
../kjoy>java -jar target/kjoy-0.0.1-SNAPSHOT.jar --server.port=8081
../kjoy>java -jar target/kjoy-0.0.1-SNAPSHOT.jar --server.port=8082
++

第三步，打开浏览器测试
http://localhost/nginx/whereami

不断刷新以上地址结果如下（但出现的几率不一样）：
You are on port 8082.
You are on port 8081.
You are on port 8080.
------