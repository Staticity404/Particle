import java.awt.Color;

public abstract class BoundableEntityFrame extends EntityFrame {

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

	public abstract boolean boundedNorth();
	public abstract boolean boundedSouth();
	public abstract boolean boundedEast();
	public abstract boolean boundedWest();

	public void update() {
		super.update();
		regulateBounds();
	}

	protected final void regulateBounds() {
		if(boundedNorth()) {
			for (int i = ents.size() - 1; i >= 0; i--) {
				Entity e = ents.get(i);
				if (e.y <= y) {
					e.y = y;
					e.vy = -e.vy;
				}
			}
		}
		if (boundedSouth()) {
			for (int i = ents.size() - 1; i >= 0; i--) {
				Entity e = ents.get(i);
				if (e.y + e.height >= y + height) {
					e.y = y + height - e.height;
					e.vy = -e.vy;
				}
			}
		}
		if (boundedEast()) {
			for (int i = ents.size() - 1; i >= 0; i--) {
				Entity e = ents.get(i);
				if (e.x + e.width >= x + width) {
					e.x = x + width - e.width;
					e.vx = -e.vx;
				}
			}
		}
		if (boundedWest()) {
			for (int i = ents.size() - 1; i >= 0; i--) {
				Entity e = ents.get(i);
				if (e.x <= x) {
					e.x = x;
					e.vx = -e.vx;
				}
			}
		}
	}
}