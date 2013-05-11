import java.awt.Color;
import java.awt.Graphics;

public class Particle extends Circle {

	public Particle(double x, double y, double radius, Color color) {
		this(x, y, 0, 0, radius, color);
	}

	public Particle(double x, double y, double vx, double vy, double radius, Color color) {
		super(x, y, radius, color);
		this.vx = vx;
		this.vy = vy;
	}

	public void update() {
		this.x += this.vx;
		this.y += this.vy;
	}
}