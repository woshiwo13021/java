package com.cn.comm;

public class GetDriver {
	
	private GetDriver(){}
	/**
	 * 静态内部类，用于生产GetDriver的唯一实例
	 * @author Administrator
	 *
	 */
	public static class DriverBuilder{
		private static final GetDriver INSTANCE = new GetDriver();
	}
	/**
	 * 公共静态方法用于返回GetDriver的唯一实例
	 * @return
	 */
	public static final GetDriver getInstance(){
		return DriverBuilder.INSTANCE;
	}
	/**
	 * 加载数据库驱动
	 */
	public void getDriver(){
		try {
			//加载数据库驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
