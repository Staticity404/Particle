import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.lang.Exception;
import java.lang.Thread;


public class Test extends JFrame implements MouseListener {

	public BoundedEntityFrame frame;

	public Test(int width, int height) {
		super("Test..");
		frame = new BoundedEntityFrame(0, 0, width, height);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setVisible(true);
		setResizable(true);

		addMouseListener(this);
	}

	public void run() {
		while (true) {
			frame.update();
			repaint();
			try {
				Thread.sleep(1000 / 200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g) {
		frame.draw(g);
	}

	public void mouseClicked(MouseEvent e) {
		int x1 = e.getX();
		int y1 = e.getY();

		double rvx = Math.random() * 4 - 2;
		double rvy = Math.random() * 4 - 2;

		int rrad = 5 + (int)(Math.random() * 10);

		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);

		frame.add(new Particle(x1, y1, rvx, rvy, rrad, new Color(r, g, b)));

		repaint();
	}

	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {
		frame.clear();
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public static void main(String args[]) {
		Test t = new Test(600, 600);
		t.run();
	}
}