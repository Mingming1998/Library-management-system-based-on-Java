package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.BookInfo;
import model.Reader;
import util.JDBC;

public class ReaderDao {

	public static int InsertReader(String name, String sex, String age, String identityCard, Date date, String maxNum,
			String tel, Double keepMoney, String zj, String zy, Date bztime, String ISBN) {
		int i=0;
		try{
			String sql="insert into tb_reader(name,sex,age,identityCard,date,maxNum,tel,keepMoney,zj,zy,bztime,ISBN)"
					+ "values('"+name+"','"+sex+"','"+age+"','"+identityCard+"','"+date+"','"+maxNum
					+"','"+tel+"',"+keepMoney+",'"+zj+"','"+zy+"','"+bztime+"','"+ISBN+"')";
			i=JDBC.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		JDBC.close();
		return i;
	}

	
	public static List selectReader() {
		List list=new ArrayList();
		String sql="select * from tb_reader";
		ResultSet rs= JDBC.executeQuery(sql);
		try{
			while(rs.next()){
				Reader reader=new Reader();
				reader.setName(rs.getString("name"));
				reader.setSex(rs.getString("sex"));
				reader.setAge(rs.getString("age"));
				reader.setIdentityCard(rs.getString("identityCard"));
				reader.setDate(rs.getDate("date"));
				reader.setMaxNum(rs.getString("maxNum"));
				reader.setTel(rs.getString("tel"));
				reader.setKeepMoney(rs.getDouble("keepMoney"));
				reader.setZj(rs.getInt("zj"));
				reader.setZy(rs.getString("zy"));
				reader.setBztime(rs.getDate("bztime"));
				reader.setISBN(rs.getString("ISBN"));
				list.add(reader);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static int DelReader(String ISBN) {
		int i=0;
		try{
			String sql="delete from tb_reader where ISBN='"+ISBN+"'";//delete语句不用加*
			i = JDBC.executeUpdate(sql);
			if(i==1){
				return 1;
			}else{
				return 0;
			}
		}catch(Exception e){
			System.out.println(e);
			return 0;
		}
	}

	public static int UpdateReader(String name, String sex, String age, String identityCard, Date date,
			String maxNum, String tel, Double keepMoney, String zj, String zy, Date bztime, String ISBN) {
		int i=0; //更新记录数
		try{
			String sql="update tb_reader set ISBN='"+ISBN+"',name='"+name+"',sex='"+sex+"',age='"+age+"',"
					+ "identityCard='"+identityCard+"',date='"+date+"',maxNum='"+maxNum+"',tel='"+tel+"',"
							+ "keepMoney="+keepMoney+",zj='"+zj+"',zy='"+zy+"',bztime='"+bztime+"' where ISBN='"+ISBN+"'";
			i=JDBC.executeUpdate(sql); //影响的行数，执行更新
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();
		return i;
	}

}
