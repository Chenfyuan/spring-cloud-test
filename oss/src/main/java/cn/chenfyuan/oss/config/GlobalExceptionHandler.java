package cn.chenfyuan.oss.config;

import cn.chenfyuan.oss.exception.DaoException;
import cn.chenfyuan.oss.exception.ExceptionCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author linweijian
 * @version V1.0
 * @Description:全局异常处理类
 * @Package cn.chenfyuan.oss.config
 * @date 2018/3/18
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DaoException.class)
    @ResponseBody
    public ExceptionCode DaoException(DaoException e) {

        return new ExceptionCode("数据库操作失败" + e.getMessage(),"error");
    }
}
