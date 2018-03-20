package cn.chenfyuan.oss.service.impl;

import cn.chenfyuan.oss.dao.SysFunctionDao;
import cn.chenfyuan.oss.po.SysFunction;
import cn.chenfyuan.oss.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author linweijian
 * @version V1.0
 * @Description:
 * @Package cn.chenfyuan.oss.service.impl
 * @date 2018/3/1
 */
@Service
@CacheConfig(cacheNames = "sysfunction")
public class SysFunctionServiceImpl implements ISysFunctionService {
    @Autowired
    private SysFunctionDao dao;

    @Cacheable
    @Override
    public List<SysFunction> findAll() {
//        Specification<SysFunction> sysFunctionSpecification =
//                (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isNull(root.get("parentId"));
//        Sort sort = new Sort(Sort.Direction.ASC, "menuSort");
//        return dao.findAll(sysFunctionSpecification, sort);
        return dao.findSysFunctionByParentIdIsNullOrderByMenuSort();
    }
}
