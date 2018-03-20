package cn.chenfyuan.oss;

import cn.chenfyuan.oss.dao.SysFunctionDao;
import cn.chenfyuan.oss.dao.UserDao;
import cn.chenfyuan.oss.po.SysFunction;
import cn.chenfyuan.oss.po.SysUser;
import cn.chenfyuan.oss.service.ISysFunctionService;
import cn.chenfyuan.oss.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OssApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private IUserService userService;
    @Autowired
    private SysFunctionDao sysFunctionDao;
    @Autowired
    private ISysFunctionService sysFunctionService;

    @Test
    public void contextLoads() {
    }

    @Test

    public void testAdd() {
       for(int i=0;i<99;i++){
           SysUser user = new SysUser();
           user.setAddress("广州市"+i);
           user.setEmail("1034023223@qq.com");
           user.setSex(1);
           user.setStatus(1);
           user.setUsername("linweijian"+i);
           user.setJoinTime(new Date());
           userDao.store(user);
       }
    }

    @Test
    public void testFindHql() {
        String hql = "from SysUser";
        List<SysUser> list = userDao.pageByHql(SysUser.class, hql, null, 0, 10);
        for (SysUser u : list) {
            System.out.println(u.toString());
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testFindSql() {
        String sql = " select * from user";
        List<SysUser> list = userDao.pageBySQL(SysUser.class, sql, null, 0, 10);
        for (SysUser u : list) {
            System.out.println(u.toString());
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testFindSqlCondition() {
        String sql = " select * from user where id=?";
        List<SysUser> list = userDao.pageBySQL(SysUser.class, sql, new Object[]{1}, 0, 10);
        for (SysUser u : list) {
            System.out.println(u.toString());
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testFindHqlCondition() {
        String sql = " from SysUser where id=?";
        List<SysUser> list = userDao.pageByHql(SysUser.class, sql, new Object[]{1l}, 0, 10);
        for (SysUser u : list) {
            System.out.println(u.toString());
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Transactional
    @Test
    public void testDelete() {

        //userDao.delete(16l);
        userService.deleteUserById(16l);
    }


    @Test
    public void testUpdate() {
        SysUser user = new SysUser();
        user.setAddress("广州市");
        user.setEmail("1034023223@qq.com");
        user.setSex(1);
        user.setStatus(1);
        user.setUsername("linweijian");
        user.setJoinTime(new Date());
        Long id = userDao.store(user);//添加后返回主键
        System.out.println(id);
    }



    @Test
    public void testAddFunction() {
        Set<SysFunction> childrenList = new HashSet<>();
        SysFunction sysFunction = new SysFunction();
        sysFunction.setFuncName("会员列表");
        sysFunction.setParentId("aaecb750ed314b269715d6b763ed56c1");
        sysFunction.setIsstop(0);
        sysFunction.setMenuSort(1);
        sysFunction.setMenuSort(1);
        SysFunction sysFunction1 = new SysFunction();
        sysFunction1.setFuncName("会员删除");
        sysFunction1.setMenuSort(2);
        sysFunction1.setParentId("aaecb750ed314b269715d6b763ed56c1");
        sysFunction1.setIsstop(0);
        sysFunction1.setMenuSort(1);
        SysFunction sysFunction2 = new SysFunction();
        sysFunction2.setFuncName("会员管理");
        sysFunction2.setIsstop(0);
        sysFunction2.setMenuSort(1);
        sysFunction2.setMenuSort(3);
        sysFunction2.setParentId("aaecb750ed314b269715d6b763ed56c1");
        sysFunctionDao.store(sysFunction, sysFunction1, sysFunction2);
    }

    @Test
    public void testGetfuncList() {
        List<SysFunction> functions = sysFunctionService.findAll();
        Assert.assertNotNull(functions);
    }
}
