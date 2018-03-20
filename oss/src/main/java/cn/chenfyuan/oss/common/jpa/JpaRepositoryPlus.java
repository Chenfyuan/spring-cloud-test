package cn.chenfyuan.oss.common.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface JpaRepositoryPlus<T, ID extends Serializable> extends JpaRepository<T, ID>,JpaSpecificationExecutor<T> {
    /**
     * 保存对象<br/>
     * 注意：如果对象id是字符串，并且没有赋值，该方法将自动设置为uuid值
     *
     * @param item 持久对象，或者对象集合
     * @throws Exception
     */
    public void store(Object... item);

    /***
     * 添加后返回主键
     * @author linweijian
     * @Date 2018/2/28 17:36
     * @param item
     * @return ID
     * @throws
     **/
    public ID store(Object item);

    /**
     * 更新对象数据
     *
     * @param item 持久对象，或者对象集合
     * @throws Exception
     */
    public void update(Object... item);

    /**
     * 执行ql语句
     *
     * @param hqlString 基于jpa标准的ql语句
     * @param values    ql中的?参数值,单个参数值或者多个参数值
     * @return 返回执行后受影响的数据个数
     */
    public int executeUpdate(String hqlString, Object... values);

    /**
     * 执行ql语句
     *
     * @param hqlString 基于jpa标准的ql语句
     * @param params    key表示ql中参数变量名，value表示该参数变量值
     * @return 返回执行后受影响的数据个数
     */
    public int executeUpdate(String hqlString, Map<String, Object> params);

    /**
     * 执行ql语句，可以是更新或者删除操作
     *
     * @param hqlString 基于jpa标准的ql语句
     * @param values    hql中的?参数值
     * @return 返回执行后受影响的数据个数
     * @throws Exception
     */
    public int executeUpdate(String hqlString, List<Object> values);

    /**
     * sql分页查询，查询结果为指定的泛型T对象
     *
     * @param clazz
     * @param sql
     * @param params
     * @param startIndex
     * @param pageSize
     * @return
     * @author linweijian
     * @date 2018年1月30日
     */
    public <T> List<T> pageBySQL(Class<T> clazz, final String sql, final Object[] params,
                                 final int startIndex, final int pageSize);

    /***
     * @Description: 根据hql分页查询
     * @author linweijian
     * @Date 2018/2/28 17:04
     * @param [clazz, hql, params, startIndex, pageSize]
     * @return java.util.List<T>
     * @throws
     **/
    public <T> List<T> pageByHql(Class<T> clazz, final String hql, final Object[] params,
                                 final int startIndex, final int pageSize);
}
