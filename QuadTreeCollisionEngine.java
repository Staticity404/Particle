import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
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
				if (neighbor != e ) {
					double ecx = e.bounds.x + e.bounds.width / 2;
					double ecy = e.bounds.y + e.bounds.height / 2;
					double ecr = e.bounds.width / 2;

					double ncx = neighbor.bounds.x + neighbor.bounds.width / 2;
					double ncy = neighbor.bounds.y + neighbor.bounds.height / 2;
					double ncr = neighbor.bounds.width / 2;

					double dx = ecx - ncx;
					double dy = ecy - ncy;
					double sr = ecr + ncr;

					if (dx * dx + dy * dy <= sr * sr) {
						double angle = Math.atan2(dx, dy);
						
						double vx1 = e.vx;
						double vy1 = e.vy;
						double d1 = Math.atan2(vx1, vy1);

						double vx2 = neighbor.vx;
						double vy2 = neighbor.vy;
						double d2 = Math.atan2(vx2, vy2);

						double nvx1 = vx1 * Math.cos(d1 - angle);
						double nvy1 = vy2 * Math.sin(d1 - angle);
						double nvx2 = vy1 * Math.cos(d2 - angle);
						double nvy2 = vy2 * Math.sin(d2 - angle);

						double fx1 = (nvx1 * (ecr - ncr) + 2 * ncr * vx2) / (ecr + ncr);
						double fy1 = (nvy1 * (ecr - ncr) + 2 * ncr * vy2) / (ecr + ncr);
						double fx2 = (nvx2 * (ecr - ncr) + 2 * ncr * vx1) / (ecr + ncr);
						double fy2 = (nvy2 * (ecr - ncr) + 2 * ncr * vy1) / (ecr + ncr);

						e.vx = fx1;
						e.vy = fy1;
						neighbor.vx = fx2;
						neighbor.vy = fy2;

						e.update();
						neighbor.update();
					}
				}
			}
		}
	}

	public void draw(Graphics g) {
		tree.draw(g);
	}
}