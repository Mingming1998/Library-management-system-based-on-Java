package dao;

import java.sql.ResultSet;

import model.Operater;
import util.JDBC;

public class LoginDao {
    public static Operater check(String name,String password){
    	Operater operater=new Operater();
    	String sql="select * from tb_operator where name='"+name+"' and password='"+password+"'and admin=1"; //查询字符串
    	ResultSet rs=JDBC.executeQuery(sql); //执行查询
    	try{
    		while(rs.next()){  //如果查询到了记录
    			operater.setId(rs.getString("id")); //设置操作员编号
    			operater.setName(rs.getString("name")); //设置操作员用户名
    			operater.setGrade(rs.getString("admin")); //设置操作员等级
    			operater.setPassword(rs.getString("password")); //设置管理员密码
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	JDBC.close(); //关闭连接对象
    	return operater; //返回操作员信息对象
    }
}
