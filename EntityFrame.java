import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

public class EntityFrame {

	public int x, y, width, height;
	public Color color;
	public List<Entity> ents;

	public EntityFrame(int x, int y, int width, int height) {
		this(x, y, width, height, Color.WHITE);
	}

	public EntityFrame(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.ents = new ArrayList<Entity>();
	}

	public void upate() {
		for (int i = ents.size() - 1; i >= 0; i--) {
			ents.get(i).update();
		}
	}

	public void draw(Graphics g) {
		g.fillRect(x, y, width, height);
		for (int i = ents.size() - 1; i >= 0; i--) {
			ents.get(i).draw(g, x, y);
		}
	}
}