/**
 *
 */
package cn.chenfyuan.oss.config;

import cn.chenfyuan.oss.common.jpa.CustomRepositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * @author linweijian
 * @date 2018年1月30日
 */
@Configuration
@EnableJpaRepositories(basePackages = "cn.chenfyuan.oss", repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
@EnableSpringDataWebSupport
public class JpaDataConfig {

}
