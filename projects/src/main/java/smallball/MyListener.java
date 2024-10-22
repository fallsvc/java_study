package smallball;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
 
import javax.swing.JFrame;
 
/**
 * 鼠标监听器的类
 * 
 * @author Administrator
 * 
 */
public class MyListener extends java.awt.event.MouseAdapter {
	private java.awt.Graphics g;
	private int x = 5, y = 620;
	private int width = 100, height = 10;
 
	public MyListener(java.awt.Graphics g) {
		this.g = g;
	}
 
	public void mouseMoved(MouseEvent e) {
		// 设置画布对象颜色
		synchronized (this.g) {
			g.setColor(java.awt.Color.black);
			g.fillRect(x, y, width, height);
			x = e.getX();
			g.setColor(java.awt.Color.green);
			g.fillRect(x, y, width, height);
		}
	}
 
	/**
	 * 得到x的方法
	 * 
	 * @return：x
	 */
	public int getX() {
		return x;
	}
 
}
 