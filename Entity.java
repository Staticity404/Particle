import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public abstract class Entity {

	public static final Color DEFAULT_COLOR = Color.BLACK;

	public Rectangle2D.Double bounds;
	public double vx, vy;
	public Color color;

	public Entity() {
		this(0, 0, DEFAULT_COLOR);
	}

	public Entity(double x, double y) {
		this(x, y, DEFAULT_COLOR);
	}

	public Entity(double x, double y, Color color) {
		this(x, y, 0, 0, color);
	}

	public Entity(double x, double y, double vx, double vy) {
		this(x, y, vx, vy, DEFAULT_COLOR);
	}

	public Entity(double x, double y, double vx, double vy, Color color) {
		this(x, y, vx, vy, 0, 0, color);
	}

	public Entity(double x, double y, double width, double height, double vx, double vy) {
		this(x, y, vx, vy, width, height, DEFAULT_COLOR);
	}

	public Entity(double x, double y, double width, double height, double vx, double vy, Color color) {
		this(new Rectangle2D.Double(x, y, width, height), vx, vy, color);
	}

	public Entity(Rectangle2D.Double bounds) {
		this(bounds, DEFAULT_COLOR);
	}

	public Entity(Rectangle2D.Double bounds, Color color) {
		this(bounds, 0, 0, color);
	}

	public Entity(Rectangle2D.Double bounds, double vx, double vy) {
		this(bounds, vx, vy, DEFAULT_COLOR);
	}

	public Entity(Rectangle2D.Double bounds, double vx, double vy, Color color) {
		this.bounds = bounds;
		this.vx = vx;
		this.vy = vy;
		this.color = color;
	}

	public abstract void update();

	public abstract void draw(Graphics g, double x, double y);

}