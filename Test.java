import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.lang.Exception;
import java.lang.Thread;


public class Test extends JFrame implements MouseListener {

	public BoundableEntityFrame[] frames;

	public Test(int width, int height) {
		super("Test..");

		frames = new BoundableEntityFrame[1];
		frames[0] = new QuadTreeCollisionFrame(0, 0, width, height);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height + 22);
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
				Thread.sleep(1000 / 100);
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
		double x1 = e.getX() - 5;
		double y1 = e.getY() - 22;
		double rvx = (int)(Math.random() * 6) - 3;
		double rvy = (int)(Math.random() * 6) - 3;

		int rrad = 5;

		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);

		frames[0].add(new Particle(x1, y1, rvx, rvy, rrad, new Color(r, g, b)));
		repaint();
	}

	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < frames.length; i++) {
			// frames[i].clear();
		}
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public static void main(String args[]) {
		Test t = new Test(750, 750);
		t.run();
	}
}