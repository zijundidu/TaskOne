/**
 * 
 */
package com.GroupName.bank.TestDemo.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * TODO
 * @author Prince
 * @date 2020年3月29日  
 */

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	//使用配置文件
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	//这个con是Service专用连接对象
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
//	private static Connection con = null;
	
	/**
	 * 使用连接池返回一个连接对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		
		Connection con = tl.get();
		
		//当con不等于null，说明已经调用过beginTransaction方法，表示开启了事务
		if(con != null) {
			return con;
		}
		return dataSource.getConnection();
	}
	/**
	 * 返回一个 连接池 对象
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 开启事务
	 * 1.获取一个Connection，设置它的setAutoCommit(false)
	 * 还要保证Dao中使用的连接是beginTransaction创建的
	 * @throws SQLException 
	 */
	public static void beginTransaction() throws SQLException {
		
		Connection con = tl.get();
		
		if(con != null) {
			throw new SQLException("已经开启事务，不能重复开启");
		}
		/*
		 * 给con赋值
		 * 给con设置手动提交setAutoCommit(false)
		 */
		con = getConnection(); //给con赋值，表示事务已经开始
		con.setAutoCommit(false);
		
		tl.set(con); //将当前线程的来连接保存起来
	}
	/**
	 * 提交事务
	 * 1.获取beginTransaction提供的Connection，调用commit()方法
	 * @throws SQLException 
	 */
	public static void commitTransaction() throws SQLException {
		
		Connection con = tl.get();
		
		if(con == null) {
			throw new SQLException("未开启事务，不能提交");
		}
		/*
		 * 直接使用con.commit()
		 */
		con.commit();
		con.close();
//		con = null; //将其设置为null，表示事务已经结束了
		tl.remove(); //从tl中移除连接
	}
	/**
	 * 回滚事务
	 * 1.获取beginTransaction提供的Connection，调用rollback()方法
	 * @throws SQLException 
	 */
	public static void rollbackTransaction() throws SQLException {
		
		Connection con = tl.get();
		
		if(con == null) {
			throw new SQLException("未开启事务，不能提交");
		}
		/*
		 * 直接使用con.rollback()
		 */
		con.rollback();
		con.close();
		tl.remove();
	}
	
	/**
	 * 释放连接
	 * @param connection
	 * @throws SQLException 
	 */
	public static void releaseConnection(Connection connection) throws SQLException {
		
		Connection con = tl.get();
		
		/*
		 * 判断connection是否为事务专用连接
		 * 如果是，不用关闭，事务结束时会自动关闭
		 * 如果不是，就要关闭
		 */
		if(con == null) { //没有事务
			//没有事务时connection一定不是事务连接
			connection.close(); //直接关闭
		}
		
		//有事务
		if(con != connection) { //但事务连接和connection不是同一个连接
			connection.close(); //直接关闭
		}
		
	}
}
