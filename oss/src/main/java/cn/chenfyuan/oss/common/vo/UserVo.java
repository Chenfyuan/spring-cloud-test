package cn.chenfyuan.oss.common.vo;

import cn.chenfyuan.oss.po.SysUser;

import java.util.List;

/**
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.common.vo
 * @date 2018/3/4
 */
public class UserVo {

    private String test;
    private List<SysUser> userList;

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
