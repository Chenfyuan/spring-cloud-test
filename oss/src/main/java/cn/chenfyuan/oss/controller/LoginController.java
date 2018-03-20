package cn.chenfyuan.oss.controller;

import cn.chenfyuan.oss.common.vo.Feedback;
import cn.chenfyuan.oss.common.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author linweijian
 * @version V1.0
 * @Description:登录页面的controller
 * @Package cn.chenfyuan.oss.controller
 * @date 2018/3/4
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @PostMapping("/login")
    public Feedback login(@RequestBody UserVo userVo, HttpSession session) {
//      JSONObject jsObject= com.alibaba.fastjson.JSON.parseObject(jsonString);
//      String jsonString1 =(String)jsObject.get("test");
//      SysUser u=jsObject.get("user");
        return Feedback.success();
    }
    @PostMapping("/login-error")
    public Feedback loginError(@RequestBody UserVo userVo, HttpSession session) {
//      JSONObject jsObject= com.alibaba.fastjson.JSON.parseObject(jsonString);
//      String jsonString1 =(String)jsObject.get("test");
//      SysUser u=jsObject.get("user");
        return Feedback.error();
    }
}
