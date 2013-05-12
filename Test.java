import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.lang.Exception;
import java.lang.Thread;


public class Test extends JFrame implements MouseListener {

	public BoundedEntityFrame[] frames;

	public Test(int width, int height) {
		super("Test..");

		frames = new BoundedEntityFrame[4];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				frames[i * 2 + j] = new BoundedEntityFrame((width / 2) * i, (height / 2) * j, width / 2, height / 2);
			}
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setVisible(true);
		setResizable(true);

		addMouseListener(this);
	}

	public void run() {
		while (true) {
			for (int i = 0; i < frames.length; i++) {
				frames[i].update();
			}
			repaint();
			try {
				Thread.sleep(1000 / 30);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g) {
		for (int i = 0; i < frames.length; i++) {
			frames[i].draw(getContentPane().getGraphics());	
		}
	}

	public void mouseClicked(MouseEvent e) {
		int row = e.getY() / (getWidth() / 2);
		int col = e.getX() / (getHeight() / 2);
		int cell = 2 * col + row;

		double x1 = e.getX() - frames[cell].bounds.x;
		double y1 = e.getY() - frames[cell].bounds.y;

		double rvx = Math.random() * 4 - 2;
		double rvy = Math.random() * 4 - 2;

		int rrad = 5 + (int)(Math.random() * 10);

		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);

		frames[cell].add(new Particle(x1, y1, rvx, rvy, rrad, new Color(r, g, b)));
		repaint();
	}

	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < frames.length; i++) {
			frames[i].clear();
		}
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public static void main(String args[]) {
		Test t = new Test(1000, 1000);
		t.run();
	}
}