package cn.chenfyuan.oss.config;

import cn.chenfyuan.oss.service.impl.CustomUserService;
import cn.chenfyuan.oss.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.config
 * @date 2018/3/5
 */
@Configuration
//允许进入页面方法前检验
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("yiibai").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面

//        http
//                //http.authorizeRequests()方法有多个子节点，每个macher按照他们的声明顺序执行
//                .authorizeRequests()
//
//                //我们指定任何用户都可以访问多个URL的模式。
//                //任何用户都可以访问以"/resources/","/signup", 或者 "/about"开头的URL。
//                .antMatchers("/css/**").permitAll()
//                .antMatchers("/fonts/**").permitAll()
//                .antMatchers("/images/**").permitAll()
//                .antMatchers("/js/**").permitAll()
//                .antMatchers("/lib/**").permitAll()
////                //以 "/admin/" 开头的URL只能让拥有 "ROLE_ADMIN"角色的用户访问。
////                //请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀。
////                .antMatchers("/admin/**").hasRole("ADMIN")
////
////                //任何以"/db/" 开头的URL需要同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"权限的用户才可以访问。
////                //和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。
////                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
////
////                //任何以"/db/" 开头的URL只需要拥有 "ROLE_ADMIN" 和 "ROLE_DBA"其中一个权限的用户才可以访问。
////                //和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。
////                .antMatchers("/db/**").hasAnyRole("ADMIN", "DBA")
//
//                //尚未匹配的任何URL都要求用户进行身份验证
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll();
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/lib/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().permitAll().and().csrf().disable();

    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }

}
