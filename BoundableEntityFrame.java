import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class BoundableEntityFrame extends EntityFrame {

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	public boolean[] bounded = {false, false, false, false};

	public BoundableEntityFrame(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public BoundableEntityFrame(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	public BoundableEntityFrame(Rectangle2D.Double bounds) {
		super(bounds);
	}

	public BoundableEntityFrame(Rectangle2D.Double bounds, Color color) {
		super(bounds, color);
	}

	public boolean boundedNorth() {
		return bounded[NORTH];
	}

	public boolean boundedSouth() {
		return bounded[SOUTH];
	}

	public boolean boundedEast() {
		return bounded[EAST];
	}

	public boolean boundedWest() {
		return bounded[WEST];
	}

	public void update() {
		super.update();
		regulateBounds();
	}

	protected final void regulateBounds() {
		if(boundedNorth()) {
			for (int i = ents.size() - 1; i >= 0; i--) {
				Entity e = ents.get(i);
				if (e.bounds.y <= 0) {
					e.bounds.y = 0;
					e.vy = -e.vy;
				}
			}
		}
		if (boundedSouth()) {
			for (int i = ents.size() - 1; i >= 0; i--) {
				Entity e = ents.get(i);
				if (e.bounds.y + e.bounds.height >= bounds.height) {
					e.bounds.y = bounds.height - e.bounds.height;
					e.vy = -e.vy;
				}
			}
		}
		if (boundedEast()) {
			for (int i = ents.size() - 1; i >= 0; i--) {
				Entity e = ents.get(i);
				if (e.bounds.x + e.bounds.width >= bounds.width) {
					e.bounds.x = bounds.width - e.bounds.width;
					e.vx = -e.vx;
				}
			}
		}
		if (boundedWest()) {
			for (int i = ents.size() - 1; i >= 0; i--) {
				Entity e = ents.get(i);
				if (e.bounds.x <= 0) {
					e.bounds.x = 0;
					e.vx = -e.vx;
				}
			}
		}
	}
}