package cn.chenfyuan.oss.exception;

/**
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.exception
 * @date 2018/3/18
 */
public class ExceptionCode {
    private String msg;
    private String code;

    public ExceptionCode(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public ExceptionCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
