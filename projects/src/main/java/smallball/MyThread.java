package smallball;
import java.awt.Color;

import javax.swing.JOptionPane;
/**
 * 线程类
 * 
 * @author Administrator
 * 
 */
public class MyThread extends Thread {
	private int width = 20, height = 20;
	private int x, y;
	private  java.awt.Graphics g;
	private GameUI UI;
	private boolean isexist = true;
	private MyListener listener;
	private int speed;
	private int x1 = 12, y1 = 12;
	private long start, end;
	private long last_time;
	private int response;
	private boolean isFinish = true;
	private boolean isPause = true;
	private java.util.ArrayList<MyThread> list;
	private float value = 320;
	private java.awt.Color color = java.awt.Color.blue;
 
	/*
	 * 重写构造器
	 */
	public MyThread(java.awt.Graphics g, MyListener listener, GameUI UI, int x,
			int y, int speed) {
		this.g = g;
		this.UI = UI;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.listener = listener;
	}
 
	/*
	 * (non-Javadoc)重写run的方法
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		drawOval();
	}
 
	/**
	 * 创建线程的方法
	 */
	public void drawOval() {
		
		
		start = System.currentTimeMillis();
		while (isFinish) {
			while (isPause) {
				synchronized(this.g){
				// 画一个圆
				g.setColor(java.awt.Color.black);
				g.fillOval(x, y, width, height);
				x += x1;
				y += y1;
 
				getColors();
				g.setColor(color);
				g.fillOval(x, y, width, height);
				}
				int x2 = listener.getX();
				if (x > 580) {
					x1 = -12;
				}
				if (x < 10) {
					x1 = 12;
				}
				if (y < 90) {
					y1 = 12;
				}
				if (y > 595 && x > x2 && x < x2 + 100) {
					y1 = -12;
				}
				if (y > 630) {
					if (isexist) {
						isAgain();
					}
					stopThread();
				}
				try {
					Thread.sleep(speed);
					value -= 0.1;
				} catch (Exception ef) {
					ef.printStackTrace();
				}
				// 将前一次画的清除掉
				end = System.currentTimeMillis();
				last_time = 100 - (end - start) / 1000;
				UI.text_field.setText(last_time + "s");
				UI.pBar.setValue((int) value);
				if (last_time == 0) {
					list = UI.list;
					for (int j = 0; j < list.size(); j++) {
						// 停在线程，并且去掉最后一个圆
						list.get(j).stopThread();
						list.get(j).fadeOval();
 
					}
					stopThread();
					showDialog();
				}
			}
 
		}
 
	}
 
	/**
	 * 线程结束时消去最后一个圆的方法
	 */
	public void fadeOval() {
		g.setColor(java.awt.Color.black);
		g.fillOval(x, y, width, height);
	}
 
	/**
	 * 重来对话框的处理方法
	 */
	public void isAgain() {
		isexist = false;
		list = UI.list;
		System.out.println(list.size());
 
		for (int j = 0; j < list.size(); j++) {
			// 停在线程，并且去掉最后一个圆
			list.get(j).stopThread();
			list.get(j).fadeOval();
 
		}
		Object[] options = { "是", "否" };
		String command = UI.getCommand();
		response = JOptionPane.showOptionDialog(null,
				"哈哈，你输了！不要灰心\n坚持就是胜利，是否再来一次？", null, JOptionPane.YES_OPTION,
				JOptionPane.NO_OPTION, null, options, null);
 
		System.out.println(response);
		if (response == 0) {
			if (command.equals("简单") || command.equals("开始")) {
				AgainThread();
				if (list.size() != 0) {
					// 现将原来的对象从队列中移除
					list.removeAll(list);
					UI.creatBall(20, 1);
				}
 
			}
			if (command.equals("中等")) {
				AgainThread();
				if (list.size() != 0) {
					list.removeAll(list);
					UI.creatBall(20, 2);
				}
 
			}
 
			if (command.equals("困难")) {
				AgainThread();
				if (list.size() != 0) {
					list.removeAll(list);
					UI.creatBall(50, 3);
				}
			}
		}
 
		// 如果点击关闭，则将线程对象从队列中移除
		if (response == -1 || response == 1) {
			list.removeAll(list);
		}
 
	}
 
	/**
	 * 停止线程的方法
	 */
	public void stopThread() {
		isFinish = false;
		isPause = false;
 
	}
 
	/**
	 * 暂停线程的方法
	 */
	public void PauseThread() {
		isPause = false;
 
	}
 
	/**
	 * 继续线程的方法
	 */
	public void ContinueThread() {
 
		isPause = true;
 
	}
 
	/**
	 * 是否重来的方法
	 */
	public void AgainThread() {
		isFinish = true;
		isPause = true;
 
	}
 
	public void getColors() {
 
		if (x % 2 == 0 && y % 2 == 0) {
			color = java.awt.Color.green;
		}
		if (x % 2 == 0 && y % 2 != 0) {
			color = java.awt.Color.red;
		}
		if (x % 2 != 0 && y % 2 != 0) {
 
			color = java.awt.Color.orange;
 
		}
		if (x % 2 != 0 && y % 2 != 0) {
			color = java.awt.Color.yellow;
		}
	}
 
	public void showDialog() {
 
		javax.swing.JOptionPane
				.showInputDialog("好样的，你是真的高手，\n恭喜你坚持了100s\n请输入您的大名");
	}
 
}