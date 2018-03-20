package cn.chenfyuan.oss.po;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.po
 * @date 2018/3/1
 */
@Entity
@Table(name = "sys_function")
public class SysFunction {
    private String id;
    private String funcName;
    private String linkPage;
    private Integer menuSort;
    private String menuIcon;
    private String description;
    private String parentId;
    private Integer isstop;
    private Set<SysFunction> children;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "func_name")
    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    @Basic
    @Column(name = "link_page")
    public String getLinkPage() {
        return linkPage;
    }

    public void setLinkPage(String linkPage) {
        this.linkPage = linkPage;
    }

    @Basic
    @Column(name = "menu_sort")
    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    @Basic
    @Column(name = "menu_icon")
    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "parent_id")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "isstop")
    public Integer getIsstop() {
        return isstop;
    }

    public void setIsstop(Integer isstop) {
        this.isstop = isstop;
    }

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "parent_id")
    @OrderBy("menu_sort")
    public Set<SysFunction> getChildren() {
        return children;
    }

    public void setChildren(Set<SysFunction> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysFunction that = (SysFunction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(funcName, that.funcName) &&
                Objects.equals(linkPage, that.linkPage) &&
                Objects.equals(menuSort, that.menuSort) &&
                Objects.equals(menuIcon, that.menuIcon) &&
                Objects.equals(description, that.description) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(isstop, that.isstop);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, funcName, linkPage, menuSort, menuIcon, description, parentId, isstop);
    }
}
