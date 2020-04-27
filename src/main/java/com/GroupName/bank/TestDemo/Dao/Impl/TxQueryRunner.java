/**
 * 
 */
package com.GroupName.bank.TestDemo.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * TODO 这个类中的方法自己处理连接的问题，无需外界的传递
 * 使用JDBCUtils.getConnection()获取连接对象
 * 获取到的有可能是事务连接，也可能是普通连接
 * 再通过JDBCUtils.releaseConnection()来关闭普通连接
 * @author Prince
 * @date 2020年4月18日  
 */
public class TxQueryRunner extends QueryRunner{

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		int[] result = super.batch(con, sql, params);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		T result = super.query(con, sql, param, rsh);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		T result = super.query(con, sql, params, rsh);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		T result = super.query(con, sql, rsh, params);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		T result = super.query(con, sql, rsh);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		int result = super.update(con, sql);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		int result = super.update(con, sql, param);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		
		Connection con = JDBCUtils.getConnection();
		int result = super.update(con, sql, params);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		T result = super.insert(con, sql, rsh);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		T result = super.insert(con, sql, rsh, params);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		T result = super.insertBatch(con, sql, rsh, params);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int execute(String sql, Object... params) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		int result = super.execute(con, sql, params);
		JDBCUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> List<T> execute(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
		/*
		 * 得到连接
		 * 执行父类方法,传递连接对象
		 * 释放连接
		 * 返回值
		 */
		Connection con = JDBCUtils.getConnection();
		List<T> result = super.execute(con, sql, rsh, params);
		JDBCUtils.releaseConnection(con);
		return result;
	}
	
}
