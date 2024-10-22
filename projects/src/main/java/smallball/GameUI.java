package smallball;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 游戏界面类
 * 
 * @author Administrator
 * 
 */
public class GameUI extends javax.swing.JFrame {
	private static GameUI UI;
	private java.awt.Graphics g;
	private MyListener ml;
	public javax.swing.JLabel text_field;
	public javax.swing.JProgressBar pBar;
	private String command;
	public java.util.ArrayList<MyThread> list = new java.util.ArrayList<>();
	private javax.swing.JToggleButton button;
 
	public static void main(String args[]) {
		UI = new GameUI();
		UI.initUI();
	}
 
	/**
	 * 初始化窗体的方法
	 */
	public void initUI() {
		// 设置标题
		this.setTitle("是高手就坚持100s");
		// 设置大小
		this.setSize(610, 635);
		// 设置关闭是退出程序
		this.setDefaultCloseOperation(3);
		// 设置打开窗体时在屏幕中间显示
		this.setLocationRelativeTo(null);
		// 设置窗体的流式布局管理器
		this.setLayout(new java.awt.FlowLayout());
		// 设置窗体背景颜色
		this.getContentPane().setBackground(Color.black);
		// 创建文本标签对象
		text_field = new javax.swing.JLabel();
		javax.swing.JLabel lable = new javax.swing.JLabel("时  间  ：");
		// 设置文本标签前景颜色
		lable.setForeground(java.awt.Color.red);
		text_field.setForeground(java.awt.Color.red);
 
		
 
		// 创建进度条对象
		pBar = new javax.swing.JProgressBar(0, 330);
		// 创建按钮对象
		button = new javax.swing.JToggleButton();
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setIcon(new javax.swing.ImageIcon("images/Pause.gif"));
		button.setActionCommand("暂停");
		// 通过匿名内部类来创建动作监听器
		java.awt.event.ActionListener button_listener = new java.awt.event.ActionListener() {
 
			public void actionPerformed(ActionEvent e) {
				String com = e.getActionCommand();
 
				if (com.equals("暂停")) {
					button.setMargin(new Insets(0, 0, 0, 0));
					button.setIcon(new javax.swing.ImageIcon(
									"images/start.gif"));
					button.setActionCommand("继续");
					for (int i = 0; i < list.size(); i++) {
						list.get(i).PauseThread();
 
					}
 
				}
				if (com.equals("继续")) {
 
					button.setMargin(new Insets(0, 0, 0, 0));
					button.setIcon(new javax.swing.ImageIcon(
									"images/Pause.gif"));
					button.setActionCommand("暂停");
 
					for (int i = 0; i < list.size(); i++) {
						list.get(i).ContinueThread();
					}
 
				}
 
			}
 
		};
		button.addActionListener(button_listener);
 
		this.add(button);
		this.add(lable);
		this.add(pBar);
		this.add(text_field);
		// 的到菜单条
		javax.swing.JMenuBar bar = creatMenuBar();
		// 为窗体设置菜单条
		this.setJMenuBar(bar);
		// 设置窗体的可见性
		this.setVisible(true);
	}
 
	/**
	 * 创建菜单条的方法
	 * 
	 * @return
	 */
	public javax.swing.JMenuBar creatMenuBar() {
		// 创建菜单条对象
		javax.swing.JMenuBar bar = new javax.swing.JMenuBar();
		// 创建菜单对象
		javax.swing.JMenu menu_menu = new javax.swing.JMenu("菜单");
		javax.swing.JMenu difficulty_menu = new javax.swing.JMenu("难度");
		javax.swing.JMenu help_menu = new javax.swing.JMenu("帮助");
		// 创建菜单选项对象
		javax.swing.JMenuItem star_item = new javax.swing.JMenuItem("开始");
		javax.swing.JMenuItem exit_item = new javax.swing.JMenuItem("退出");
		javax.swing.JMenuItem help_item = new javax.swing.JMenuItem("游戏说明");
		javax.swing.JMenuItem about_item = new javax.swing.JMenuItem("关于");
		// 创建单选选项
		javax.swing.JRadioButtonMenuItem easy_item = new javax.swing.JRadioButtonMenuItem(
				"简单");
		javax.swing.JRadioButtonMenuItem middle_item = new javax.swing.JRadioButtonMenuItem(
				"中等");
		javax.swing.JRadioButtonMenuItem hard_item = new javax.swing.JRadioButtonMenuItem(
				"困难");
		// 创建一个按钮组
		javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();
		// 将单选按钮添加到按钮组中
		group.add(easy_item);
		group.add(middle_item);
		group.add(hard_item);
		// 将单选按钮添加到菜单中
		difficulty_menu.add(easy_item);
		difficulty_menu.add(middle_item);
		difficulty_menu.add(hard_item);
		// 通过匿名内部类来创建动作监听器
		ActionListener listener = new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				command = e.getActionCommand();
				// 如果选择开始，则创建线程对象
				if (command.equals("开始") && list.size() == 0) {
					creatBall(20, 1);
 
				}
				// 如果选择退出按钮，则退出程序
				if (command.equals("退出")) {
					System.exit(0);
				}
 
				// 如果选择简单按钮
				if (command.equals("简单") && list.size() == 0) {
 
					creatBall(20, 1);
				}
 
				// 如果选择中等按钮
				if (command.equals("中等") && list.size() == 0) {
					creatBall(50, 2);
 
				}
				if (command.equals("困难") && list.size() == 0) {
					creatBall(40, 2);
				}
				if (command.equals("游戏说明")) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"移动鼠标，用挡板接球，如果接不住，就算输了……\n游戏可以选择难度，包括简单、中等、困难");
				}
				if (command.equals("关于")) {
					javax.swing.JOptionPane
							.showMessageDialog(null,
									"这是一个用Java编写的小游戏……\n制作人：沈冠军\n时间：2010年8月\n版权所有,翻版必究！");
				}
			}
		};
		// 添加动作监听器
		star_item.addActionListener(listener);
		exit_item.addActionListener(listener);
		easy_item.addActionListener(listener);
		middle_item.addActionListener(listener);
		hard_item.addActionListener(listener);
		help_item.addActionListener(listener);
		about_item.addActionListener(listener);
 
		// 将菜单选项对象添加到菜单对象上
		menu_menu.add(star_item);
		menu_menu.add(exit_item);
		help_menu.add(help_item);
		help_menu.add(about_item);
		// 将菜单对象添加到菜单条上
		bar.add(menu_menu);
		bar.add(difficulty_menu);
		bar.add(help_menu);
		// 返回菜单条对象
		return bar;
	}
 
	/**
	 * 创建线程对象的方法
	 * 
	 * @param speed
	 *            ：速度
	 * 
	 */
	public void creatBall(int speed, int num) {
		java.util.Random ran = new java.util.Random();
 
		if (ml == null) {
			g = UI.getGraphics();
			ml = new MyListener(g);
			UI.addMouseListener(ml);
			UI.addMouseMotionListener(ml);
 
		}
		for (int i = 0; i < num; i++) {
			int x = ran.nextInt(600) + 10;
			int y = ran.nextInt(300) + 100;
			MyThread th = new MyThread(g, ml, UI, x, y, speed);
			list.add(th);
			th.start();
		}
 
	}
 
	/**
	 * 得到命令的方法
	 */
	public String getCommand() {
		return command;
	}
 
}