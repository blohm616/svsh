package xiezhy.basic.dao;

import xiezhy.basic.entity.Pager;
import xiezhy.basic.entity.Pagination;

import java.util.List;
import java.util.Map;

/**
 * version:
 * --------------------
 * date:2016/4/21
 * author:binbin
 */
public interface DaoSupport<T> {
    /**
     * 保存
     */
    Long save(T entity);

    /**
     * 修改
     */
    void update(T entity);

    /**
     * 删除
     */
    void deleteById(Long id);

    /**
     * 查询所有
     */
    List<T> getLists();

    /**
     * 通过Id查询
     */
    T getById(Long id);

    /**
     * 查询
     */
    List<T> getByHql(String hql,Map<String,Object> map);
    List<T> getBySql(String sql,Map<String,Object> map);
    List<T> getByHql(String hql,int start,int pageSize,Map<String,Object> map);
    List<T> getBySql(String sql,int start,int pageSize,Map<String,Object> map);



    /**
     * count查询
     */
    int getCountByHql(String hql,Map<String,Object> map);
    int getCountBySql(String sql,Map<String,Object> map);


}
