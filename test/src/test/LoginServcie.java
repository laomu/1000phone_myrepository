package test;

import java.util.List;

public class LoginServcie {
	
	public boolean login() {
		return new BaseService<Boolean>(){

			@Override
			public Boolean service() {
				// �жϷ���true/false
				return false;
			}
		}.doService();
	}
	
	public List<User> findAll() {
		return  new BaseService<List<User>>() {

			@Override
			public List<User> service() {

				return null;
			}
		}.doService();
	}
	
}
