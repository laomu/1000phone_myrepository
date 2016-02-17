package test;

public class DateTest {
	public static void main(String[] args) {
		// java.util.Date --> java.sql.Date java.sql.Timestamp
		java.util.Date date = new java.util.Date();
		
		long time = date.getTime();
		
		
		java.sql.Date sqlDate = new java.sql.Date(time);
		java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
		
		// java.sql.Date --> java.util.Date / java.sql.Timestamp
		java.sql.Date sDate = new java.sql.Date(System.currentTimeMillis());
		
		time = sDate.getTime();
		
		java.util.Date uDate = new java.util.Date(time);
		java.sql.Timestamp tt = new java.sql.Timestamp(time);
		
		// java.sql.Timestamp --> java.sql.Date / java.util.Date
		java.sql.Timestamp sqlT = new java.sql.Timestamp(System.currentTimeMillis());
		
		time = sqlT.getTime();
		
		java.sql.Date sqlD = new java.sql.Date(time);
		java.util.Date utilD = new java.util.Date(time);
	
	}
}
