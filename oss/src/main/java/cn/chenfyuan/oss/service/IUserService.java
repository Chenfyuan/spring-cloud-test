package cn.chenfyuan.oss.service;

import cn.chenfyuan.oss.common.vo.Pager;
import cn.chenfyuan.oss.po.SysUser;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    void saveUser(SysUser user);

    /***
     * @Description: 查找用户信息
     * @author linweijian
     * @Date 2018/2/28 17:11
     * @param
     * @return java.util.List
     * @throws
     **/
    List listUser(int startIndex, int pageSize, String hql);

    /***
     * 分页获取用户信息
     * @author linweijian
     * @Date 2018/3/1 16:57
     * @param pageable
     * @return org.springframework.data.domain.Page<cn.chenfyuan.oss.po.SysUser>
     * @throws
     **/
  Pager pagUser(Pageable pageable);

    void deleteUserById(Long id);
}
