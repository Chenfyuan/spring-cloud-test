package cn.chenfyuan.oss.po;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author linweijian
 * @version V1.0
 * @Description:用户实体
 * @Package cn.chenfyuan.oss.po
 * @date 2018/3/5
 */
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, length = 20)
    private Long id;
    @Column(name = "user_name")
    private String username;
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<SysRole> roles;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.PASSWORD
     *
     * @mbg.generated
     */
    @Column(name = "password")
    @Length(min = 6,message = "密码必须大于6位")
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.SEX
     *
     * @mbg.generated
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.EMAIL
     *
     * @mbg.generated
     */
    @Column(name = "email")
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ADDRESS
     *
     * @mbg.generated
     */
    @Column(name = "address")
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.JOIN_TIME
     *
     * @mbg.generated
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "join_time")
    private Date joinTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.STATUS
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ID
     *
     * @return the value of user.ID
     * @mbg.generated
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ID
     *
     * @param id the value for user.ID
     *
     * @mbg.generated
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.USER_NAME
     *
     * @return the value of user.USER_NAME
     * @mbg.generated
     */
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.USER_NAME
     *
     * @param username the value for user.USER_NAME
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<SysRole> roles = this.getRoles();
        for (SysRole role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.PASSWORD
     *
     * @return the value of user.PASSWORD
     * @mbg.generated
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.PASSWORD
     *
     * @param password the value for user.PASSWORD
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.SEX
     *
     * @return the value of user.SEX
     * @mbg.generated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.SEX
     *
     * @param sex the value for user.SEX
     * @mbg.generated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.EMAIL
     *
     * @return the value of user.EMAIL
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.EMAIL
     *
     * @param email the value for user.EMAIL
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ADDRESS
     *
     * @return the value of user.ADDRESS
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ADDRESS
     *
     * @param address the value for user.ADDRESS
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.JOIN_TIME
     *
     * @return the value of user.JOIN_TIME
     * @mbg.generated
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.JOIN_TIME
     *
     * @param joinTime the value for user.JOIN_TIME
     * @mbg.generated
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.STATUS
     *
     * @return the value of user.STATUS
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.STATUS
     *
     * @param status the value for user.STATUS
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser [userName=" + username + ", email=" + email + ", address="
                + address + "]";
    }

}