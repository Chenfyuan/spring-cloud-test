package cn.chenfyuan.oss.dao;

import cn.chenfyuan.oss.common.jpa.JpaRepositoryPlus;
import cn.chenfyuan.oss.po.SysFunction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.dao
 * @date 2018/3/1
 */
@Repository
public interface SysFunctionDao extends JpaRepositoryPlus<SysFunction,String> {
    /***
    * 查找功能菜单
    * @author linweijian
    * @Date 2018/3/1 15:01
    * @param
    * @return java.util.List<cn.chenfyuan.oss.po.SysFunction>
    * @throws
    **/
    List<SysFunction> findSysFunctionByParentIdIsNullOrderByMenuSort();
}
