/**
 * 
 */
package com.GroupName.bank.TestDemo.Dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.GroupName.bank.TestDemo.Dao.IDao;
import com.GroupName.bank.TestDemo.Domin.People;

/**
 * TODO
 * @author Prince
 * @date 2020年4月27日  
 */
public class PeopleDao implements IDao {
	QueryRunner qr = new TxQueryRunner();
	@Override
	public void add(People people) {
		try {
			String sql = "insert into people values(?,?,?,?,?,?,?,?,?,?,?,now(),now())";
			Object[] params = {people.getId(), people.getName(),
					people.getQq(), people.getJob(),people.getTime(),
					people.getUniversity(), people.getNumber(),
					people.getSrc(), people.getTarget(),
					people.getSenior(), people.getUnderstand()};
			qr.update(sql, params);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void delete(String name) {
		try {
			String sql = "delete from people where name=?";
			Object[] params = {name};
			qr.update(sql, params);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void update(People people) {
		try {
			String sql = "update people set qq=?,job=?,time=?,"
					+ "university=?,number=?,src=?,target=?,"
					+ "senior=?,understand=?,update_at=now() where name=?";
			Object[] params = {people.getQq(), people.getJob(),
					people.getTime(),people.getUniversity(), 
					people.getNumber(),people.getSrc(), 
					people.getTarget(),people.getSenior(), 
					people.getUnderstand(),people.getName()};
			qr.update(sql, params);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void query(String name) {
		try {
			String sql = "select * from people where name=?";
			Object[] params = {name};
			People people = qr.query(sql, new BeanHandler<>(People.class), params);
			System.out.println(people.toString());
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
