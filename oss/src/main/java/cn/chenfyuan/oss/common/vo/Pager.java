package cn.chenfyuan.oss.common.vo;


import java.util.Collection;

/**  layui数据表格
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.common
 * @date 2018/3/1
 */
public class Pager {
    private Integer code;
    private Long count;
    private String msg;
    private Collection data;
    private Integer page=1;//第几页
    private Integer limit=50;//选择数据行的数量
    public Pager(Long count, String msg, Collection data) {
        this.count = count;
        this.msg = msg;
        this.data = data;
    }
    public Pager() { }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Collection getData() {
        return data;
    }

    public void setData(Collection data) {
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
