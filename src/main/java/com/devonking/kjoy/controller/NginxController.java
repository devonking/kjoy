package com.devonking.kjoy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 此类的目的是测试Nginx的功能
 * <p>
 * 实验步骤：
 *      1. 启动三个不同端口号的服务实例（8080 8081 8082）
 *      2. 配置Nginx的upstream，并将所有请求路由到upstream
 *      3. 浏览器中访问接口http://localhost/nginx/whereami
 *
 * @author Devon King
 * @date 2018/4/27
 */
@Api(value = "Nginx", description = "Testing Nginx")
@Controller
@RequestMapping("/nginx")
public class NginxController {

    /**
     * 每次请求客户端都将看到当前Web实例的端口号
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "Load Balance", notes = "Testing Load Balance functionality")
    @RequestMapping(value = "/whereami", method = RequestMethod.GET)
    public @ResponseBody String loadBalance(HttpServletRequest request) {
        int port = request.getLocalPort();
        return "You are on port " + port + ".";
    }
}
