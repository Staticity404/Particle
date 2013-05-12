import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.util.List;

public abstract class CollisionEngine {

	public Rectangle2D.Double bounds;
	public List<Entity> ents;

	public CollisionEngine(Rectangle2D.Double bounds, List<Entity> ents) {
		this.bounds = bounds;
		this.ents = ents;
	}

	public abstract void update();
	public abstract void clear();
	public abstract void draw(Graphics g);
}