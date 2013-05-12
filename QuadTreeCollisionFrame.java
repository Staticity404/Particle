import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class QuadTreeCollisionFrame extends CollisionFrame {

	public QuadTreeCollisionFrame(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.engine = new QuadTreeCollisionEngine(bounds, ents);
	}

	public QuadTreeCollisionFrame(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		this.engine = new QuadTreeCollisionEngine(bounds, ents);
	}

	public QuadTreeCollisionFrame(Rectangle2D.Double bounds) {
		super(bounds);
		this.engine = new QuadTreeCollisionEngine(bounds, ents);
	}

	public QuadTreeCollisionFrame(Rectangle2D.Double bounds, Color color) {
		super(bounds, color);
		this.engine = new QuadTreeCollisionEngine(bounds, ents);
	}

	public void update() {
		engine.clear();
		super.update();
	}

	public void clear() {
		super.clear();
		engine.clear();
	}

	public boolean boundedNorth() {
		return true;
	}

	public boolean boundedSouth() {
		return true;
	}
	
	public boolean boundedEast() {
		return true;
	}

	public boolean boundedWest() {
		return true;
	}
}