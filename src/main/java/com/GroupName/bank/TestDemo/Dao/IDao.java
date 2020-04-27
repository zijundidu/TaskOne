/**
 * 
 */
package com.GroupName.bank.TestDemo.Dao;

import com.GroupName.bank.TestDemo.Domin.People;

/**
 * TODO
 * @author Prince
 * @date 2020年4月27日  
 */
public interface IDao {
	public void add(People people); //增
	public void delete(String name); //删
	public void update(People people); //改
	public void query(String name); //查
}
