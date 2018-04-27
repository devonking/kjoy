package com.devonking.kjoy.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Devon King
 * @date 2018-04-27
 */
@Api(value = "主页", description = "主页")
@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * 简单测试Swagger是否工作
     *
     * 在浏览器输入http://localhost:8080/v2/api-docs即可查看
     * 此项目的JSON格式的API文档
     *
     * @param visitor
     * @return
     */
    @ApiOperation(value = "敲门", notes = "完成敲门和身份确认的动作")
    @RequestMapping(value = "/knock", method = RequestMethod.GET)
    public @ResponseBody String knockKnock(@ApiParam @RequestParam String visitor) {
        return "Host: Who is there? Visitor: I am " + visitor;
    }
}
