package cn.chenfyuan.oss.controller;

import cn.chenfyuan.oss.common.vo.Pager;

import cn.chenfyuan.oss.common.vo.UserVo;
import cn.chenfyuan.oss.po.SysUser;
import cn.chenfyuan.oss.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.controller
 * @date 2018/3/1
 */
@RestController
@Api(value = "会员信息控制类", description = "对会员信息进行增删改查的操作")
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private IUserService userService;
    private static final ThreadLocal<SysUser> local = new ThreadLocal<SysUser>();

    @ApiOperation(value = "会员列表", notes = "会员列表")
    @GetMapping("/members")
    public Pager memberList(Pager pager) {
        Pageable p = new PageRequest(pager.getPage() - 1, pager.getLimit());
        return userService.pagUser(p);
    }

    @ApiOperation(value = "删除会员信息", notes = "删除会员信息")
    @ApiImplicitParam(value = "会员id", name = "id", required = true)
    @DeleteMapping("/{id}")
    public String delMember(@PathVariable Long id) {
        String result = "删除成功";
        userService.deleteUserById(99L);
        return result;
    }

}
