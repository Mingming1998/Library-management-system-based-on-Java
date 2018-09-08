package dao;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Back;
import model.BookInfo;
import model.BookType;
import model.Reader;
import util.JDBC;

public class BookBorrowBackDao {

	//Borrow
	public static List selectBookCategory(String typeNames) {
		List list=new ArrayList();
		String sql="select * from tb_bookType where typeName='"+typeNames+"'";
		//��Ҫ��������������ݿ����Ѱ����֮��ƥ���Ԫ�飨�ж�������Ƿ������ݿ���У�
		ResultSet rs=JDBC.executeQuery(sql);
		try{
			while(rs.next()){
				BookType booktype=new BookType();
				booktype.setId(rs.getString("id"));
				booktype.setTypeName(rs.getString("typename"));
				booktype.setDays(rs.getString("days"));
				booktype.setFk(rs.getString("fk"));
				list.add(booktype); //����ú���ӽ����б���
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static List selectBookInfo(String bookISBNs) {
		List list=new ArrayList();
		String sql="select * from tb_bookInfo where ISBN='"+bookISBNs+"'";
		//��Ҫ�����鼮��������ݿ����Ѱ����֮��ƥ���Ԫ�飨�ж��鼮����Ƿ������ݿ���У�
		ResultSet rs= JDBC.executeQuery(sql);
		try{
			while(rs.next()){
				BookInfo bookinfo=new BookInfo();
				bookinfo.setISBN(rs.getString("ISBN"));
				bookinfo.setTypeId(rs.getString("typeid"));
				bookinfo.setBookName(rs.getString("bookname"));
				bookinfo.setWriter(rs.getString("writer"));
				bookinfo.setTranslator(rs.getString("translator"));
				bookinfo.setPublisher(rs.getString("publisher"));
				bookinfo.setDate(rs.getDate("date"));
				bookinfo.setPrice(rs.getDouble("price"));
				list.add(bookinfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static List selectReader(String readerISBNs) {
		List list=new ArrayList();
		String sql="select * from tb_reader where ISBN='"+readerISBNs+"'";  //�������ԺͲ����Լ����ֲ�ͬ��������������ǲ�ͬ��
		//��Ҫ���Ŷ��߱�������ݿ����Ѱ����֮��ƥ���Ԫ�飨�ж϶��߱���Ƿ������ݿ���У�
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

	public static int InsertBookBorrow(String bookISBNs, String readerISBNs, String operatorId, Timestamp borrowDate,Timestamp backDate) {
		int i=0;
		try{
			String sql="insert into tb_borrow(bookISBN,readerISBN,operatorId,borrowDate,backDate)values"
					+ "('"+bookISBNs+"','"+readerISBNs+"','"+operatorId+"','"+borrowDate+"','"+backDate+"')";
			i=JDBC.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		JDBC.close();
		return i;
	}

	
	//Back
	public static List selectBookBack(String readerISBNs) {
		List list=new ArrayList();
		String sql="select * from tb_Borrow,tb_BookInfo,tb_Reader "
				+ "where tb_Borrow.bookISBN=tb_BookInfo.ISBN and "
				+ "tb_Borrow.readerISBN=tb_Reader.ISBN and readerISBN='"+readerISBNs+"'";
		//���ö�������ҵ����е�����ֵ
		ResultSet rs= JDBC.executeQuery(sql);
		try{
			while(rs.next()){
				Back back=new Back();
				back.setBookISBN(rs.getString("bookISBN"));
				back.setBookname(rs.getString("bookname"));    //tb_BookInfo
				back.setOperatorId(rs.getString("operatorId"));
				back.setBorrowDate(rs.getString("borrowDate"));
				back.setBackDate(rs.getString("backDate"));
				back.setReaderName(rs.getString("name"));      //tb_Reader
				back.setReaderISBN(rs.getString("readerISBN"));
				back.setTypeId(rs.getInt("typeId"));           //tb_BookInfo
				back.setId(rs.getInt("id"));//������ж���id���ԣ����Ҫָ��������
				list.add(back);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static List selectBookTypeFk(String typeNames) {
		List list=new ArrayList();
		String sql="select * from tb_bookType where typeName='"+typeNames+"'";
		ResultSet rs=JDBC.executeQuery(sql);
		try{
			while(rs.next()){
				BookType booktype=new BookType();
				booktype.setId(rs.getString("id"));
				booktype.setTypeName(rs.getString("typename"));
				booktype.setDays(rs.getString("days"));
				booktype.setFk(rs.getString("fk"));
				list.add(booktype); //����ú���ӽ����б���
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static int UpdateBookBack(String bookISBNs, String readerISBNs, int id) {
		int i=0; //���¼�¼��
		try{
			String sql="update tb_Borrow set bookISBN='"+bookISBNs+"',readerISBN='"
					+readerISBNs+"' where id='"+id+"'";//Ҫ����������������ֵ��id�ֶ�����
			i=JDBC.executeUpdate(sql); //Ӱ���������ִ�и���
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();
		return i;
		
	}

}
