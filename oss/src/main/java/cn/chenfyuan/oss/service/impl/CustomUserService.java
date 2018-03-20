package cn.chenfyuan.oss.service.impl;

import cn.chenfyuan.oss.dao.UserDao;
import cn.chenfyuan.oss.po.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/***
 *
 * @author linweijian
 * @Date 2018/3/5 15:04
 * */
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
