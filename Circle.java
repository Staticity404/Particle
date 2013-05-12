import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Entity {

	public double radius;

	public Circle(double x, double y, double radius) {
		this(x, y, radius, Entity.DEFAULT_COLOR);
	}

	public Circle(double x, double y, double radius, Color color) {
		super(x, y, radius * 2, radius * 2, 0, 0, color);
		this.radius = radius;
	}

	public void update() {}

	public void draw(Graphics g, double x, double y) {
		int x1 = (int)(this.bounds.x + x);
		int y1 = (int)(this.bounds.y + y);
		int d = (int)(radius * 2);

		g.setColor(color);
		g.fillOval(x1, y1, d, d);

		g.setColor(Color.BLACK);
		g.drawOval(x1, y1, d, d);
	}
}