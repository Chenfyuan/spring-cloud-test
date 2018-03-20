package cn.chenfyuan.oss.service.impl;

import cn.chenfyuan.oss.common.vo.Pager;
import cn.chenfyuan.oss.dao.UserDao;
import cn.chenfyuan.oss.po.SysUser;
import cn.chenfyuan.oss.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements IUserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao dao;

    @CachePut(key = "#user.id")
    @Override
    public void saveUser(SysUser user) {
        dao.store(user);
    }

    @Cacheable
    @Override
    public List listUser(int startIndex, int pageSize, String hql) {

        return dao.pageByHql(SysUser.class, hql, null, startIndex, pageSize);
    }

    @Override
    public Pager pagUser(Pageable pageable) {
        Pager pager = new Pager();
        Page<SysUser> userPage = dao.findAll(pageable);
        long count = userPage.getTotalElements();
        pager.setCount(count);
        pager.setData(userPage.getContent());
        pager.setCode(0);
        pager.setMsg("success");
        return pager;
    }

    @CacheEvict(key = "#id")
    @Override
    public void deleteUserById(Long id) {
        dao.delete(id);
    }

}
