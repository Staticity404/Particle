import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity {

	public static final Color DEFAULT_COLOR = Color.BLACK;

	public double x, y, vx, vy, width, height;
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
		this(x, y, vx, vy, 0, 0, color);
	}

	public Entity(double x, double y, double vx, double vy, double width, double height) {
		this(x, y, vx, vy, width, height, DEFAULT_COLOR);
	}

	public Entity(double x, double y, double vx, double vy, double width, double height, Color color) {
		this.x = x;
		this.y = y;
		this.vy = vy;
		this.vx = vx;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public abstract void update();

	public abstract void draw(Graphics g, int x, int y);

}