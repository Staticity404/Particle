import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class EntityFrame {

	public static final Color DEFAULT_COLOR = Color.WHITE;

	public Rectangle2D.Double bounds;
	public Color color;
	public List<Entity> ents;

	public EntityFrame(int x, int y, int width, int height) {
		this(x, y, width, height, DEFAULT_COLOR);
	}

	public EntityFrame(int x, int y, int width, int height, Color color) {
		this(new Rectangle2D.Double(x, y, width, height), color);
	}

	public EntityFrame(Rectangle2D.Double bounds) {
		this(bounds, DEFAULT_COLOR);
	}

	public EntityFrame(Rectangle2D.Double bounds, Color color) {
		this.bounds= bounds;
		this.color = color;
		this.ents = new ArrayList<Entity>();
	}

	public void add(Entity e) {
		ents.add(e);
	}

	public void clear() {
		ents.clear();
	}

	public void update() {
		for (int i = ents.size() - 1; i >= 0; i--) {
			ents.get(i).update();
		}
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int)bounds.x, (int)bounds.y, (int)bounds.width, (int)bounds.height);
		for (int i = ents.size() - 1; i >= 0; i--) {
			ents.get(i).draw(g, bounds.x, bounds.y);
		}
		g.setColor(Color.BLACK);
		g.drawRect((int)bounds.x, (int)bounds.y, (int)bounds.width, (int)bounds.height);
	}
}