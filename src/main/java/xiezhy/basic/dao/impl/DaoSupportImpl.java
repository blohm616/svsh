package xiezhy.basic.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import xiezhy.basic.dao.DaoSupport;
import xiezhy.basic.entity.Pager;
import xiezhy.basic.entity.Pagination;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * version:
 * --------------------
 * date:2016/4/21
 * author:binbin
 */
public class DaoSupportImpl<T> implements DaoSupport<T> {

    @Resource
    private SessionFactory sessionFactory;

    private Class clazz;

    public DaoSupportImpl() {
        //获取当前new对象泛型的类型
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(Object entity) {
        return (Long) getSession().save(entity);
    }

    @Override
    public void update(Object entity) {
        getSession().update(entity);
    }

    @Override
    public void deleteById(Long id) {
        Object obj = getById(id);
        if(obj != null)
            getSession().delete(obj);
    }

    @Override
    public List<T> getLists() {

        return getSession().createQuery(//
                "FROM " + clazz.getSimpleName()) //
                .list();
    }

    @Override
    public T getById(Long id) {
        return (T) getSession().get(clazz,id);
    }

    /**
     * hql: FROM User WHERE userName = :userName
     *      map.put("userName","abc");
     */
    @Override
    public List<T> getByHql(String hql, Map<String, Object> map) {
        Query query = getSession().createQuery(hql);
        if(map != null && !map.isEmpty()) {
            for (String name : query.getNamedParameters()) {
                query.setParameter(name, map.get(name));
            }
        }
        return query.list();
    }

    /**
     * sql: SELECT * FROM user WHERE user_name = :name
     *      map.put("userName","abc");
     */
    @Override
    public List<T> getBySql(String sql, Map<String, Object> map) {
        Query query = getSession().createSQLQuery(sql);
        if(map != null && !map.isEmpty()) {
            for(String name : query.getNamedParameters()) {
                query.setParameter(name , map.get(name));
            }
        }
        return query.list();
    }

    /**
     *  pageNo = 1   	pageSize = 3
        start = (pageNo - 1) * pageSize
        end = pageNo * pageSize
     */

    @Override
    public List<T> getByHql(String hql, int start, int pageSize, Map<String, Object> map) {

        Query query = getSession().createQuery(hql);
        if(map != null && !map.isEmpty()) {
            for(String name : query.getNamedParameters()) {
                query.setParameter(name , map.get(name));
            }
        }

        return query.setFirstResult(start).setMaxResults(pageSize).list();
    }

    @Override
    public List<T> getBySql(String sql, int start, int pageSize, Map<String, Object> map) {

        Query query = getSession().createSQLQuery(sql);
        if(map != null && !map.isEmpty()) {
            for(String name : query.getNamedParameters()) {
                query.setParameter(name , map.get(name));
            }
        }

        return query.setFirstResult(start).setMaxResults(pageSize).list();
    }

    @Override
    public int getCountByHql(String hql,Map<String,Object> map) {
        Query query = getSession().createQuery(hql);
        if(map != null && !map.isEmpty()) {
            for(String name : query.getNamedParameters()) {
                query.setParameter(name , map.get(name));
            }
        }
        return (int) query.uniqueResult();
    }

    @Override
    public int getCountBySql(String sql,Map<String,Object> map) {
        Query query = getSession().createSQLQuery(sql);
        if(map != null && !map.isEmpty()) {
            for(String name : query.getNamedParameters()) {
                query.setParameter(name , map.get(name));
            }
        }
        return (int) query.uniqueResult();
    }


}
