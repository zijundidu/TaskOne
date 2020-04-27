/**
 * 
 */
package com.GroupName.bank.TestDemo.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.GroupName.bank.TestDemo.Dao.Impl.JDBCUtils;
import com.GroupName.bank.TestDemo.Dao.Impl.PeopleDao;
import com.GroupName.bank.TestDemo.Domin.People;

/**
 * TODO
 * @author Prince
 * @date 2020年4月27日  
 */
public class TestOne {
	PeopleDao peopleDao = new PeopleDao();
	
	@Test
	public void fun1() {
		People people = new People();
		people.setId(1002);
		people.setName("da");
		people.setQq(123456789);
		people.setJob("java开发工程师");
		
		Date now = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		people.setTime(ft.format(now));
		
		people.setUniversity("北京大学");
		people.setNumber(9527);
		people.setSrc("www.zijun.com");
		people.setTarget("多吃不胖");
		people.setSenior("大师兄");
		people.setUnderstand("everywhere");
		
		peopleDao.add(people);
	}
	
	@Test
	public void fun2() {
		peopleDao.query("da");
	}
	
	@Test
	public void fun3() {
		People people = new People();
		people.setName("da");
		people.setQq(123467899);
		people.setJob("java开发");
		
		Date now = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		people.setTime(ft.format(now));
		
		people.setUniversity("北大");
		people.setNumber(9537);
		people.setSrc("www.zijun.cn");
		people.setTarget("不胖");
		people.setSenior("大师");
		people.setUnderstand("every");
		
		peopleDao.update(people);
	}
	
	@Test
	public void fun4() {
		peopleDao.delete("da");
	}
	
	@Test
	public void fun5() {
		try {
			Connection con = JDBCUtils.getConnection();
			String sql = "insert into people values(?,?,?,?,?,?,?,?,?,?,?,now(),now())";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			long temp = 0;
			for(int x = 0; x < 10; x ++) {
				JDBCUtils.beginTransaction(); //执行后con已经赋值
				
				//添加数据，大量的添加
				for(int i = 0; i < 3000000; i ++) {
					pstmt.setInt(1, (i + 1) + ((x + 1) * 3000000) );
					pstmt.setString(2, "stu_" + i);
					pstmt.setDouble(3, (new Random(300000).nextDouble())*(new Random(300000).nextDouble()) );
					pstmt.setString(4, i % 2 == 0 ? "java开发" : "python开发");
					
					Date now = new Date();
					SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
					pstmt.setString(5, ft.format(now));
					
					pstmt.setString(6, i % 2 == 0 ? "清华" : "北大");
					pstmt.setInt(7, new Random(i + 7000).nextInt());
					pstmt.setString(8, "www.zijun" + (i + i % 2 == 0 ? ".com" : ".cn"));
					pstmt.setString(9, "多吃不胖");
					pstmt.setString(10, "周自辉");
					pstmt.setString(11, "everywhere");
					pstmt.addBatch(); //添加批，这一组参数就保存在集合中了
				}
				long start = System.currentTimeMillis(); //开始时间
				pstmt.executeBatch(); //执行批
				long end = System.currentTimeMillis(); //结束时间
				
				temp = (end - start) + temp;
				JDBCUtils.commitTransaction(); //提交事务后con被归还给连接池，已被关闭，但并不为null
			}
			
			System.out.println("插入三千万条语句时间为：" + temp);
		}catch(Exception e) {
			try {
				JDBCUtils.rollbackTransaction();
			} catch (SQLException e1) {
			}
		}
	}
}
