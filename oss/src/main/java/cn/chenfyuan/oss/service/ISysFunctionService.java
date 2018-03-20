package cn.chenfyuan.oss.service;

import cn.chenfyuan.oss.po.SysFunction;

import java.util.List;

/**
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.service
 * @date 2018/3/1
 */
public interface ISysFunctionService {
    /**
    * @Description: 查找功能菜单
    * @author linweijian
    * @Date 2018/3/1 14:43
    * @param
    * @return java.util.List<cn.chenfyuan.oss.po.SysFunction>
    * @throws
    **/
    List<SysFunction> findAll();
}
