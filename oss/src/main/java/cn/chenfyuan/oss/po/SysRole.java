package cn.chenfyuan.oss.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author linweijian
 * @version V1.0
 * @Description:角色实体
 * @Package cn.chenfyuan.oss.po
 * @date 2018/3/5
 */
@Entity
@Table(name="sys_role")
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
