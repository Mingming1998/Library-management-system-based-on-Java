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
 * �˵��Ͱ�ť��Action����
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; // �Ӵ��弯��
	
	public static BookModiAction BOOK_MODIFY; // ͼ����Ϣ�޸Ĵ��嶯��
	public static BookAddAction BOOK_ADD; // ͼ����Ϣ��Ӵ��嶯��
	
	public static BookTypeAddAction TYPE_ADD;//ͼ�������Ӵ��嶯��
	public static BookTypeModifyAction TYPE_MODIFY;//ͼ������޸Ĵ��嶯��
	
	public static ReaderAddAction READER_ADD;//������Ϣ��Ӵ��嶯��
	public static ReaderModifyAction READER_MODIFY;//������Ϣ�޸Ĵ��嶯��
	
	public static BorrowBookAction BORROW_BOOK;//ͼ����Ĵ��嶯��
	public static BackBookAction BACK_BOOK;//ͼ��黹���嶯��

    public static ExitAction EXIT; // ϵͳ�˳�����

	static {
		frames = new HashMap<String, JInternalFrame>();
		//ͼ������޸�
		BOOK_MODIFY = new BookModiAction();
		BOOK_ADD = new BookAddAction();
		
		//ͼ���������޸�
		TYPE_ADD = new BookTypeAddAction();
		TYPE_MODIFY = new BookTypeModifyAction();
		
		//������Ϣ����޸�
		READER_ADD = new ReaderAddAction();
		READER_MODIFY = new ReaderModifyAction();
		
		//ͼ����Ĺ黹
		BORROW_BOOK = new BorrowBookAction();
		BACK_BOOK = new BackBookAction();
		EXIT = new ExitAction();
	}
	
	//ͼ���޸���ɾ��
	private static class BookModiAction extends AbstractAction {
		BookModiAction() {
			super("ͼ����Ϣ�޸�", null);
			putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ��ͼ����Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "ͼ����Ϣ�޸�");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ����Ϣ�޸�")||frames.get("ͼ����Ϣ�޸�").isClosed()) {
				BookModiAndDelIFrame iframe=new BookModiAndDelIFrame();
				frames.put("ͼ����Ϣ�޸�", iframe);
				Library.addIFame(frames.get("ͼ����Ϣ�޸�"));
			}
		}
	}
	private static class BookAddAction extends AbstractAction {				// ͼ����Ϣ��ӣ������Ѿ�ʵ�֣������
		BookAddAction() {

			super("ͼ����Ϣ���", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µ�ͼ����Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "ͼ����Ϣ���");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ����Ϣ���")||frames.get("ͼ����Ϣ���").isClosed()) {
				BookAddIFrame iframe = new BookAddIFrame();
				frames.put("ͼ����Ϣ���", iframe);
				Library.addIFame(frames.get("ͼ����Ϣ���"));
			}
		}
	}
	
	//ͼ�����������޸�
	private static class BookTypeAddAction extends AbstractAction {
		BookTypeAddAction() {
			super("ͼ��������", null);
			putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µ�ͼ�������Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "ͼ��������");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ��������")||frames.get("ͼ��������").isClosed()) {
				BookTypeAddIFrame iframe=new BookTypeAddIFrame();
				frames.put("ͼ��������", iframe);
				Library.addIFame(frames.get("ͼ��������"));//���ַ�����ƥ��
			}
		}
	}
	private static class BookTypeModifyAction extends AbstractAction {				
		BookTypeModifyAction() {

			super("ͼ������޸�", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ��ͼ�����");
			putValue(Action.SHORT_DESCRIPTION, "ͼ������޸�");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ������޸�")||frames.get("ͼ������޸�").isClosed()) {
				BookTypeModiAndDelIFrame iframe = new BookTypeModiAndDelIFrame();
				frames.put("ͼ������޸�", iframe);
				Library.addIFame(frames.get("ͼ������޸�"));
			}
		}
	}
	
	
	//������Ϣ������޸�
	private static class ReaderAddAction extends AbstractAction{
		ReaderAddAction() {
			super("������Ϣ���", null);
			putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µĶ�����Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "������Ϣ���");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("������Ϣ���")||frames.get("������Ϣ���").isClosed()) {
				ReaderAddIFrame iframe=new ReaderAddIFrame();
				frames.put("������Ϣ���", iframe);
				Library.addIFame(frames.get("������Ϣ���"));//���ַ�����ƥ��
			}
		}
	}
	
	private static class ReaderModifyAction extends AbstractAction {				
		ReaderModifyAction() {

			super("������Ϣ�޸�", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ��������Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "������Ϣ�޸�");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("������Ϣ�޸�")||frames.get("������Ϣ�޸�").isClosed()) {
				ReaderModiAndDelIFrame iframe = new ReaderModiAndDelIFrame();
				frames.put("������Ϣ�޸�", iframe);
				Library.addIFame(frames.get("������Ϣ�޸�"));
			}
		}
	}
	
	
	//ͼ�������黹
		private static class BorrowBookAction extends AbstractAction{
			BorrowBookAction() {
				super("ͼ�����", null);
				putValue(Action.LONG_DESCRIPTION, "��ͼ��ݽ���ͼ��");
				putValue(Action.SHORT_DESCRIPTION, "ͼ�����");
			}
			public void actionPerformed(ActionEvent e) {
				if (!frames.containsKey("ͼ�����")||frames.get("ͼ�����").isClosed()) {
					BookBorrowIFrame iframe=new BookBorrowIFrame();
					frames.put("ͼ�����", iframe);
					Library.addIFame(frames.get("ͼ�����"));//���ַ�����ƥ��
				}
			}
		}
		
		private static class BackBookAction extends AbstractAction {				
			BackBookAction() {

				super("ͼ��黹", null);
				//super();
				putValue(Action.LONG_DESCRIPTION, "�黹��ͼ���ͼ��");
				putValue(Action.SHORT_DESCRIPTION, "ͼ��黹");
			}
			public void actionPerformed(ActionEvent e) {
				if (!frames.containsKey("ͼ��黹")||frames.get("ͼ��黹").isClosed()) {
					BookBackIFrame iframe = new BookBackIFrame();
					frames.put("ͼ��黹", iframe);
					Library.addIFame(frames.get("ͼ��黹"));
				}
			}
		}
	
	
	//�˳�ϵͳ
	private static class ExitAction extends AbstractAction { // �˳�ϵͳ����
		public ExitAction() {
			super("�˳�ϵͳ", null);
			putValue(Action.LONG_DESCRIPTION, "�˳�ͼ��ݹ���ϵͳ");
			putValue(Action.SHORT_DESCRIPTION, "�˳�ϵͳ");
		}
		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}

}
