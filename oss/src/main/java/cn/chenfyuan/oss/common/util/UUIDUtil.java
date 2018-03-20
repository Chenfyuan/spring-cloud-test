package cn.chenfyuan.oss.common.util;

import java.util.UUID;

/**
 * UUID工具类
 * @author linweijian
 * @date 2018年2月28日
 * @ version 1.0
 */
public class UUIDUtil {
    /**
     * 获取生成的uuid
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
