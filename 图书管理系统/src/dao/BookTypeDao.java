package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.BookType;
import util.JDBC;

public class BookTypeDao {

	public static int InsertBookType(String typeName, String days, double fk) {
		int i=0;
		try{
			String sql="insert into tb_bookType(typeName,days,fk)values('"+typeName+"','"+days+"',"+fk+")";
			i=JDBC.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		JDBC.close();
		return i;
	}

	public static List selectBookCategory() {
		List list=new ArrayList();
		String sql="select * from tb_bookType";
		ResultSet rs=JDBC.executeQuery(sql);
		try{
			while(rs.next()){
				BookType booktype=new BookType();
				booktype.setId(rs.getString("id"));
				booktype.setTypeName(rs.getString("typename"));
				booktype.setDays(rs.getString("days"));
				booktype.setFk(rs.getString("fk"));
				list.add(booktype); //保存好后添加进入列表中
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static int UpdatebookType(String id, String typeName, String days, String fk) {
		int i=0; //更新记录数
		try{
			String sql="update tb_bookType set id='"+id+"',typeName='"+typeName+"',days='"
					+days+"',fk='"+fk+"' where id='"+id+"'";//要根据主键来进行找值、id字段自增
			i=JDBC.executeUpdate(sql); //影响的行数，执行更新
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();
		return i;
		
	}

}
