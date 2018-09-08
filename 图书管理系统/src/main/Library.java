package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import iframe.BookLoginIFrame;
import util.CreatecdIcon;



/**
 * ������
 * 
 */
public class Library extends JFrame {
	private static final JDesktopPane 
				DESKTOP_PANE = new JDesktopPane();//���洰��
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager
				.getSystemLookAndFeelClassName());//����ϵͳ�������
			new BookLoginIFrame();//��¼����
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void addIFame(JInternalFrame iframe) { // ����Ӵ���ķ���
		DESKTOP_PANE.add(iframe);	//�����Ӵ���
	}
	public Library() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);////���ùرհ�ť�����¼�
		Toolkit tool = Toolkit.getDefaultToolkit();				//���Ĭ�ϵĹ�����
		Dimension screenSize = tool.getScreenSize();			//�����Ļ�Ĵ�С
		setSize(800, 600);										//���ô����С
		setLocation((screenSize.width - getWidth()) / 2,
				(screenSize.height - getHeight()) / 2);			//���ô���λ��
		setTitle("ͼ��ݹ���ϵͳ");								//���ô������
		JMenuBar menuBar = createMenu(); 	//���ô����˵����ķ���
		setJMenuBar(menuBar);				//���ò˵���
		JToolBar toolBar = createToolBar(); // ���ô����������ķ���
		getContentPane().add(toolBar, BorderLayout.NORTH);//���ù�����
		final JLabel label = new JLabel();	//����һ����ǩ��������ʾͼƬ
		label.setBounds(0, 0, 0, 0);		//���ô���Ĵ�С��λ��
		label.setIcon(null); // ���屳��
		DESKTOP_PANE.addComponentListener(new ComponentAdapter() {
			public void componentResized(final ComponentEvent e) {
				Dimension size = e.getComponent().getSize();//��������С
				label.setSize(e.getComponent().getSize());//���ñ�ǩ��С
				label.setText("<html><img width=" + size.width + " height="
						+ size.height + " src='"
						+ this.getClass().getResource("/backImg.jpg")
						+ "'></html>");//���ñ�ǩ�ı�
			}
		});
		DESKTOP_PANE.add(label,new Integer(Integer.MIN_VALUE));//����ǩ��ӵ����洰��
		getContentPane().add(DESKTOP_PANE);//�����洰����ӵ���������
	}
	/**
	 * ����������
	 * 
	 * @return JToolBar
	 */
	private JToolBar createToolBar() { // �����������ķ���
		JToolBar toolBar = new JToolBar();		//��ʼ��������
		toolBar.setFloatable(false);			//�����Ƿ�����ƶ�������
		toolBar.setBorder(new BevelBorder(BevelBorder.RAISED));//���ñ߿�
		
		
		JButton bookAddButton=new JButton(MenuActions.BOOK_ADD);//ͼ����Ϣ��Ӱ�ť
		ImageIcon icon=new ImageIcon(Library.class.getResource("/bookAddtb.jpg"));//��Ӳ˵���ͼ��	
		bookAddButton.setIcon(icon);//���ð�ťͼ��
		bookAddButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(bookAddButton);//��ӵ���������
		
		
		JButton bookModiAndDelButton=new JButton(MenuActions.BOOK_MODIFY);//ͼ����Ϣ�޸İ�ť
		ImageIcon bookmodiicon=CreatecdIcon.add("bookModiAndDeltb.jpg");//����ͼ�귽��
		bookModiAndDelButton.setIcon(bookmodiicon);//���ð�ťͼ��
		bookModiAndDelButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(bookModiAndDelButton);//��ӵ���������
		
		

		
		
		JButton ExitButton=new JButton(MenuActions.EXIT);//�˳�ϵͳ��ť
		ImageIcon Exiticon=CreatecdIcon.add("exittb.jpg");//����ͼ�귽��
		ExitButton.setIcon(Exiticon);//���ð�ťͼ��
		ExitButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(ExitButton);//��ӵ���������
		return toolBar;
	}
	/**
	 * �����˵���
	 */
	private JMenuBar createMenu() { // �����˵����ķ���
		JMenuBar menuBar = new JMenuBar();//����������
		JMenu baseMenu = new JMenu();// ��ʼ����������ά���˵�
		baseMenu.setIcon(CreatecdIcon.add("jcsjcd.jpg"));//���ò˵�ͼ��
		
		
		JMenu menu = new JMenu("ͼ����Ϣ����");//����ͼ����Ϣ�����Ӳ˵�
		menu.add(MenuActions.BOOK_ADD);//���ͼ����Ϣ��Ӳ˵���
		menu.add(MenuActions.BOOK_MODIFY);//���ͼ����Ϣ�޸Ĳ˵���	
		baseMenu.add(menu);				//���ͼ����Ϣ�����Ӳ˵�
		
		JMenu bookTypeManageMItem = new JMenu("ͼ��������");//����ͼ���������Ӳ˵�
		bookTypeManageMItem.add(MenuActions.TYPE_ADD);//ͼ�������Ӳ˵���
		bookTypeManageMItem.add(MenuActions.TYPE_MODIFY);//ͼ������޸Ĳ˵���
		baseMenu.add(bookTypeManageMItem);//���ͼ���������Ӳ˵�
		
		JMenu readerManagerMItem = new JMenu("������Ϣ����");//����������Ϣ�����Ӳ˵�
		readerManagerMItem.add(MenuActions.READER_ADD);//������Ϣ��Ӳ˵���
		readerManagerMItem.add(MenuActions.READER_MODIFY);//������Ϣ�޸Ĳ˵���
		baseMenu.add(readerManagerMItem);//��Ӷ�����Ϣ�����Ӳ˵�
		
		JMenu borrowManagerMItem = new JMenu("ͼ����Ĺ���");//����ͼ����Ĺ����Ӳ˵�
		borrowManagerMItem.add(MenuActions.BORROW_BOOK);//ͼ����Ĳ˵���
		borrowManagerMItem.add(MenuActions.BACK_BOOK);//ͼ��黹�˵���
		baseMenu.add(borrowManagerMItem);//������鶩�������Ӳ˵�
		
		
		baseMenu.addSeparator();		//��ӷָ���
		baseMenu.add(MenuActions.EXIT);//����˳�ϵͳ�˵���
		menuBar.add(baseMenu); // ��ӻ�������ά���˵����˵���
		
		return menuBar;
	}
}
