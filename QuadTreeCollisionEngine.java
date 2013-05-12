import java.util.List;

public class QuadTreeCollisionEngine extends CollisionEngine {

	public QuadTree tree;

	public QuadTreeCollisionEngine(List<Entity> ents) {
		super(ents);
		tree = new QuadTree(bounds);
	}

	public void update() {

	}
}