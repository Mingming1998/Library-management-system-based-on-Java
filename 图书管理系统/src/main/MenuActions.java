package main;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;

import iframe.BookBackIFrame;
import iframe.BookAddIFrame;
import iframe.BookBorrowIFrame;
import iframe.BookModiAndDelIFrame;

import iframe.BookTypeAddIFrame;
import iframe.BookTypeModiAndDelIFrame;
import iframe.ReaderAddIFrame;
import iframe.ReaderModiAndDelIFrame;

/**
 * 菜单和按钮的Action对象
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; // 子窗体集合
	
	public static BookModiAction BOOK_MODIFY; // 图书信息修改窗体动作
	public static BookAddAction BOOK_ADD; // 图书信息添加窗体动作
	
	public static BookTypeAddAction TYPE_ADD;//图书类别添加窗体动作
	public static BookTypeModifyAction TYPE_MODIFY;//图书类别修改窗体动作
	
	public static ReaderAddAction READER_ADD;//读者信息添加窗体动作
	public static ReaderModifyAction READER_MODIFY;//读者信息修改窗体动作
	
	public static BorrowBookAction BORROW_BOOK;//图书借阅窗体动作
	public static BackBookAction BACK_BOOK;//图书归还窗体动作

    public static ExitAction EXIT; // 系统退出动作

	static {
		frames = new HashMap<String, JInternalFrame>();
		//图书添加修改
		BOOK_MODIFY = new BookModiAction();
		BOOK_ADD = new BookAddAction();
		
		//图书类别添加修改
		TYPE_ADD = new BookTypeAddAction();
		TYPE_MODIFY = new BookTypeModifyAction();
		
		//读者信息添加修改
		READER_ADD = new ReaderAddAction();
		READER_MODIFY = new ReaderModifyAction();
		
		//图书借阅归还
		BORROW_BOOK = new BorrowBookAction();
		BACK_BOOK = new BackBookAction();
		EXIT = new ExitAction();
	}
	
	//图书修改与删除
	private static class BookModiAction extends AbstractAction {
		BookModiAction() {
			super("图书信息修改", null);
			putValue(Action.LONG_DESCRIPTION, "修改和删除图书信息");
			putValue(Action.SHORT_DESCRIPTION, "图书信息修改");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书信息修改")||frames.get("图书信息修改").isClosed()) {
				BookModiAndDelIFrame iframe=new BookModiAndDelIFrame();
				frames.put("图书信息修改", iframe);
				Library.addIFame(frames.get("图书信息修改"));
			}
		}
	}
	private static class BookAddAction extends AbstractAction {				// 图书信息添加－－－已经实现，请参照
		BookAddAction() {

			super("图书信息添加", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的图书信息");
			putValue(Action.SHORT_DESCRIPTION, "图书信息添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书信息添加")||frames.get("图书信息添加").isClosed()) {
				BookAddIFrame iframe = new BookAddIFrame();
				frames.put("图书信息添加", iframe);
				Library.addIFame(frames.get("图书信息添加"));
			}
		}
	}
	
	//图书类别添加与修改
	private static class BookTypeAddAction extends AbstractAction {
		BookTypeAddAction() {
			super("图书类别添加", null);
			putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的图书类别信息");
			putValue(Action.SHORT_DESCRIPTION, "图书类别添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书类别添加")||frames.get("图书类别添加").isClosed()) {
				BookTypeAddIFrame iframe=new BookTypeAddIFrame();
				frames.put("图书类别添加", iframe);
				Library.addIFame(frames.get("图书类别添加"));//让字符进行匹配
			}
		}
	}
	private static class BookTypeModifyAction extends AbstractAction {				
		BookTypeModifyAction() {

			super("图书类别修改", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "修改和删除图书类别");
			putValue(Action.SHORT_DESCRIPTION, "图书类别修改");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书类别修改")||frames.get("图书类别修改").isClosed()) {
				BookTypeModiAndDelIFrame iframe = new BookTypeModiAndDelIFrame();
				frames.put("图书类别修改", iframe);
				Library.addIFame(frames.get("图书类别修改"));
			}
		}
	}
	
	
	//读者信息添加与修改
	private static class ReaderAddAction extends AbstractAction{
		ReaderAddAction() {
			super("读者信息添加", null);
			putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的读者信息");
			putValue(Action.SHORT_DESCRIPTION, "读者信息添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("读者信息添加")||frames.get("读者信息添加").isClosed()) {
				ReaderAddIFrame iframe=new ReaderAddIFrame();
				frames.put("读者信息添加", iframe);
				Library.addIFame(frames.get("读者信息添加"));//让字符进行匹配
			}
		}
	}
	
	private static class ReaderModifyAction extends AbstractAction {				
		ReaderModifyAction() {

			super("读者信息修改", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "修改和删除读者信息");
			putValue(Action.SHORT_DESCRIPTION, "读者信息修改");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("读者信息修改")||frames.get("读者信息修改").isClosed()) {
				ReaderModiAndDelIFrame iframe = new ReaderModiAndDelIFrame();
				frames.put("读者信息修改", iframe);
				Library.addIFame(frames.get("读者信息修改"));
			}
		}
	}
	
	
	//图书借阅与归还
		private static class BorrowBookAction extends AbstractAction{
			BorrowBookAction() {
				super("图书借阅", null);
				putValue(Action.LONG_DESCRIPTION, "从图书馆借阅图书");
				putValue(Action.SHORT_DESCRIPTION, "图书借阅");
			}
			public void actionPerformed(ActionEvent e) {
				if (!frames.containsKey("图书借阅")||frames.get("图书借阅").isClosed()) {
					BookBorrowIFrame iframe=new BookBorrowIFrame();
					frames.put("图书借阅", iframe);
					Library.addIFame(frames.get("图书借阅"));//让字符进行匹配
				}
			}
		}
		
		private static class BackBookAction extends AbstractAction {				
			BackBookAction() {

				super("图书归还", null);
				//super();
				putValue(Action.LONG_DESCRIPTION, "归还给图书馆图书");
				putValue(Action.SHORT_DESCRIPTION, "图书归还");
			}
			public void actionPerformed(ActionEvent e) {
				if (!frames.containsKey("图书归还")||frames.get("图书归还").isClosed()) {
					BookBackIFrame iframe = new BookBackIFrame();
					frames.put("图书归还", iframe);
					Library.addIFame(frames.get("图书归还"));
				}
			}
		}
	
	
	//退出系统
	private static class ExitAction extends AbstractAction { // 退出系统动作
		public ExitAction() {
			super("退出系统", null);
			putValue(Action.LONG_DESCRIPTION, "退出图书馆管理系统");
			putValue(Action.SHORT_DESCRIPTION, "退出系统");
		}
		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}

}
