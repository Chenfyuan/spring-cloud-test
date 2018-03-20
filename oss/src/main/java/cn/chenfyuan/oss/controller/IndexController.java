package cn.chenfyuan.oss.controller;

import cn.chenfyuan.oss.po.SysFunction;
import cn.chenfyuan.oss.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ISysFunctionService sysFunctionService;

    /***
     * index页面
     * @author linweijian
     * @Date 2018/3/1 15:19
     * @param model
     * @return java.lang.String
     * @throws
     **/
    @GetMapping("/")
    public String index(Model model) {
        List<SysFunction> list = sysFunctionService.findAll();
        model.addAttribute("menuList", list);
        return "/index";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("msg", "Hello World");
        return "/welcome";
    }

    @RequestMapping("/memberDel")
    public String memberDel(Model model) {
        model.addAttribute("msg", "Hello World");
        return "/member-del";
    }
    @RequestMapping("/403")
    public String error(Model model) {
        return "/error/403";
    }
}
