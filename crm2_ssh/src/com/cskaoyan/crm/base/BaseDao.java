package com.cskaoyan.crm.base;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 添加
	 * @param t
	 */
	public void save(T t );
	/**
	 * 更新
	 * @param t
	 */
	public void update(T t );
	
	/**
	 * 保存或更新
	 * * 代理主键：如果没有OID将执行save，如果有OID将执行update
	 * @param t
	 */
	public void saveOrUpdate(T t);
	
	/**
	 * 删除
	 * @param t
	 */
	public void delete(T t );
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public T findById(java.io.Serializable id);
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> findAll();
	/**
	 * 带有条件查询所有
	 * @param condition 条件语句 （where之后的语句）
	 * * 格式： and 属性 关键字 ? 
	 * * 例如：and name like ?
	 * @param params 条件
	 * @return
	 */
	public List<T> findAll(String condition, Object ... params);
	
	/**
	 * 查询分页数据
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAllWithPage(int startIndex,int pageSize);
	/**
	 * 查询总记录数
	 * @return
	 */
	public int getTotalRecord();
	
}
