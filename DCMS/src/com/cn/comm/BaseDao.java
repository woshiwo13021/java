package com.cn.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
	//此接口用于连接数据库
	public Connection conn = null;
	//此接口用于执行预编译sql语句
	public PreparedStatement pst = null;
	//数据库结果集，通常由执行sql查询语句产生
	public ResultSet rls = null;
	/**
	 * 数据库连接
	 * @return
	 */
	public Connection getConn(){
		//加载数据库驱动
		GetDriver.getInstance().getDriver();
		try {
			//通过DriverManager的getConnection方法获得Connection对象
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭数据库连接
	 */
	public void closeAll(){
		if(rls!=null){
			try {
				rls.close();
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 对数据库进行增删改操作
	 * @param sql 要执行的sql语句
	 * @param list 给sql语句中的?赋值的集合
	 * @return 返回执行结果
	 */
	public int alter(String sql,List<Object> list){
		int r = 0;
		//获取conn对象
		conn = this.getConn();
		//预编译sql语句
		try {
			pst = conn.prepareStatement(sql);
			if(list!=null){
				for (int i = 0; i < list.size(); i++) {
					pst.setObject(i + 1, list.get(i));
				}
			}
			//执行sql
			r = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			this.closeAll();
		}
		return r;
	}
	//查询公共方法
	public ResultSet select(String sql,List<Object> list){
		conn = this.getConn();
		try {
			pst = conn.prepareStatement(sql);
			if(list!=null){
				for (int i = 0; i < list.size(); i++) {
					pst.setObject(i + 1, list.get(i));
				}
			}
			rls = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rls;
	}
}
