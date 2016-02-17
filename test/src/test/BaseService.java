package test;

public abstract class BaseService<T> {
	// 业务方法
	public abstract T service();
	
	// 处理业务的方法_模板方法
	public T doService() {
		try {
			// 1. 获取数据库连接
			System.out.println("获取数据库连接");
			
			// 2. 处理业务
			return service();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 3.关闭数据库连接
			System.out.println("关闭数据库连接");
		}
		
		return null;
	}
}
