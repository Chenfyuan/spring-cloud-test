package cn.chenfyuan.oss.exception;

/**
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.exception
 * @date 2018/3/18
 */
public class DaoException extends RuntimeException {
    private String msg = "数据库操作异常";

    public DaoException(String message) {
        super(message);
    }

    public DaoException() {
        super();
    }

    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }
}
