import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity {

	public static final Color DEFAULT_COLOR = Color.BLACK;

	public double x, y, vx, vy;
	public Color color;

	public Entity() {
		this(0, 0, DEFAULT_COLOR);
	}

	public Entity(double x, double y) {
		this(x, y, DEFAULT_COLOR);
	}

	public Entity(double x, double y, Color color) {
		this(x, y, 0, 0);
	}

	public Entity(double x, double y, double vx, double vy) {
		this(x, y, vx, vy, DEFAULT_COLOR);
	}

	public Entity(double x, double y, double vx, double vy, Color color) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.color = color;
	}

	public void update();

	public void draw(Graphics g, int x, int y);

}