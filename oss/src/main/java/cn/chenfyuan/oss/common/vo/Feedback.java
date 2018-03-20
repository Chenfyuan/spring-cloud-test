package cn.chenfyuan.oss.common.vo;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.jdbc.StringUtils;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 *
 * @author linweijian
 * @Date 2018/3/4 12:33
 * feedback
 **/
public class Feedback {
    private static final String SUCCESS_MESSAGE = "操作成功";
    private static final String ERROR_MESSAGE = "操作失败";
    private boolean success = true;

    private String msg;

    public Feedback(String msg) {
        this.msg = msg;
    }

    public Feedback(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static Feedback success(String msg) {
        String feedbackStr = Feedback.SUCCESS_MESSAGE;
        if (StrUtil.isNotEmpty(msg)) {
            feedbackStr = msg;
        }
        return new Feedback(true, feedbackStr);
    }

    public static Feedback success() {
        String feedbackStr = Feedback.SUCCESS_MESSAGE;
        return new Feedback(true, feedbackStr);
    }

    public static Feedback error(String msg) {
        String feedbackStr = Feedback.ERROR_MESSAGE;
        if (StrUtil.isNotEmpty(msg)) {
            feedbackStr = msg;
        }
        return new Feedback(false, feedbackStr);
    }

    public static Feedback error() {
        String feedbackStr = Feedback.ERROR_MESSAGE;
        return new Feedback(false, feedbackStr);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
