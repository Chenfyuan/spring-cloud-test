package cn.chenfyuan.oss.common.jpa;

import cn.chenfyuan.oss.common.util.ReflectHelper;
import cn.chenfyuan.oss.common.util.UUIDUtil;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/***
 * @Description: 扩展JpaRepository
 * @author linweijian
 * @Date 2018/2/28 16:57
 **/
public class JpaRepositoryPlusImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements JpaRepositoryPlus<T, ID> {
    private final EntityManager entityManager;

    public JpaRepositoryPlusImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void store(Object... item) {
        if (null != item) {
            for (Object entity : item) {
                innerSave(entity);
            }
        }
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ID store(Object item) {
        Serializable s = innerSave(item);
        return (ID) s;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Object... item) {
        if (null != item) {
            for (Object entity : item) {
                entityManager.merge(entity);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int executeUpdate(String hqlString, Object... values) {
        Query query = entityManager.createQuery(hqlString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
        }
        return query.executeUpdate();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int executeUpdate(String hqlString, Map<String, Object> params) {
        Query query = entityManager.createQuery(hqlString);
        for (String name : params.keySet()) {
            query.setParameter(name, params.get(name));
        }
        return query.executeUpdate();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int executeUpdate(String hqlString, List<Object> values) {
        Query query = entityManager.createQuery(hqlString);
        for (int i = 0; i < values.size(); i++) {
            query.setParameter(i + 1, values.get(i));
        }
        return query.executeUpdate();
    }

    @Override
    public <T1> List<T1> pageBySQL(Class<T1> clazz, String sql, Object[] params, int startIndex, int pageSize) {
        Query query = entityManager.createNativeQuery(sql, clazz);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] != null) {
                    query.setParameter(i + 1, params[i]);
                }
            }
        }
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public <T1> List<T1> pageByHql(Class<T1> clazz, String hql, Object[] params, int startIndex, int pageSize) {
        Query query = entityManager.createQuery(hql, clazz);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] != null) {
                    query.setParameter(i + 1, params[i]);
                }
            }
        }
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    private Serializable innerSave(Object item) {
        try {
            if (item == null) {
                return null;
            }
            Class<?> clazz = item.getClass();
            Field idField = ReflectHelper.getIdField(clazz);
            Method getMethod = null;
            if (idField != null) {
                Class<?> type = idField.getType();
                Object val = idField.get(item);
                if (type == String.class && (val == null || "".equals(val))) {
                    idField.set(item, UUIDUtil.uuid());
                }
            } else {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    Id id = method.getAnnotation(Id.class);
                    if (id != null) {
                        Object val = method.invoke(item);
                        if (val == null || "".equals(val)) {
                            String methodName = "s" + method.getName().substring(1);
                            Method setMethod = clazz.getDeclaredMethod(methodName, method.getReturnType());
                            if (setMethod != null) {
                                setMethod.invoke(item, UUIDUtil.uuid());
                            }
                        }
                        getMethod = method;
                        break;
                    }
                }
            }
            entityManager.persist(item);
            entityManager.flush();
            if (idField != null) {
                return (Serializable) idField.get(item);
            }
            if (getMethod != null) {
                return (Serializable) getMethod.invoke(item);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
