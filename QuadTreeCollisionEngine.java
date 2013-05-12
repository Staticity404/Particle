import java.awt.geom.Rectangle2D;
import java.util.List;

public class QuadTreeCollisionEngine extends CollisionEngine {

	public QuadTree tree;

	public QuadTreeCollisionEngine(Rectangle2D.Double bounds, List<Entity> ents) {
		super(bounds, ents);
		tree = new QuadTree(bounds);
	}

	public void clear() {
		tree.clear();
	}

	public void update() {
		// TODO: Improve this
		tree.insert(ents);
		for (int i = 0; i < ents.size(); i++) {
			Entity e = ents.get(i);
			List<Entity> relative = tree.retrieveNeighbors(e);

			for (int j = 0; j < relative.size(); j++) {
				Entity neighbor = relative.get(j);
				if (neighbor != e) {
					if (neighbor.bounds.intersects(e.bounds)) {
						neighbor.vx = 0;
						neighbor.vy = 0;
						e.vx = 0;
						e.vy = 0;
					}
				}
			}
		}
	}
}