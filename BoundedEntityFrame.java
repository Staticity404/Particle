import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class BoundedEntityFrame extends BoundableEntityFrame {

	public BoundedEntityFrame(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public BoundedEntityFrame(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	public BoundedEntityFrame(Rectangle2D.Double bounds) {
		super(bounds);
	}

	public BoundedEntityFrame(Rectangle2D.Double bounds, Color color) {
		super(bounds, color);
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