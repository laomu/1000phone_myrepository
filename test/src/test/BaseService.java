package test;

public abstract class BaseService<T> {
	// ҵ�񷽷�
	public abstract T service();
	
	// ����ҵ��ķ���_ģ�巽��
	public T doService() {
		try {
			// 1. ��ȡ���ݿ�����
			System.out.println("��ȡ���ݿ�����");
			
			// 2. ����ҵ��
			return service();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 3.�ر����ݿ�����
			System.out.println("�ر����ݿ�����");
		}
		
		return null;
	}
}
