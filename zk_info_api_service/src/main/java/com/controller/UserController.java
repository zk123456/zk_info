package com.controller;

import com.domain.Student;
import com.domain.User;
import com.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Zhangk
 * @Date 11:52 2019/2/22
 * @Description
 */
@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Map<Long, User> map = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    /**
     * ModelAttribute绑定请求参数到命令对象
     * 直接放置参数key也可
     */
    /**
     * GET、POST方式提时， 根据request header Content-Type的值来判断:
     application/x-www-form-urlencoded， 可选（即非必须，因为这种情况的数据@RequestParam, @ModelAttribute也可以处理，当然@RequestBody也能处理）
     */
    /**
     * 使用@RequestBody遇到如下错误:
     * {
     "timestamp": "2019-02-22T07:13:01.855+0000",
     "status": 415,
     "error": "Unsupported Media Type",
     "message": "Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported",
     "path": "/add"
     }
     可去掉注解或者使用 ModelAttribute
     也可以使用@RequestParam
     */
    public String addUser(User user) {
        map.put(user.getId(), user);
        return "success";
    }

    @RequestMapping("/list")
    public List<User> getUserList() {
        return Lists.newArrayList(map.values());
    }

    @ApiOperation(value = "通过用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    })
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    public User getUserById(Long id) {
        return map.get(id);
    }

    /**
     * produces：它的作用是指定返回值类型，不但可以设置返回值类型还可以设定返回值的字符编码；
     consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html
     * @return
     */
    @PostMapping(value = "/student", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Student getStudent() {
        Student s = new Student();
        s.setAge(1);
        s.setName("1");
        return s;
    }

    @RequestMapping("/create")
    public String createUser(Integer age, String name) {
        userService.create(name, age);
        return "success";
    }
}
