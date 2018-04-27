@2018-04-28
Swagger2集成
------
Nginx测试接口，Nginx的配置可参考reference/nginx.conf
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
------