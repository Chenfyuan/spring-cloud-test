package cn.chenfyuan.oss.dao;

import cn.chenfyuan.oss.common.jpa.JpaRepositoryPlus;
import cn.chenfyuan.oss.po.SysUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao extends JpaRepositoryPlus<SysUser, Long> {
    SysUser findByUsername(String username);

    @Query(value = "select * from SYSTEM_USER", nativeQuery = true)
    List<SysUser> getUserList();
}
