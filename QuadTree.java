import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuadTree {

	public static final int MAX_ENTITIES = 10;
	public static final int MAX_LEVELS = 5;

	public static final int SELF = -1;
	public static final int TOP_LEFT = 0;
	public static final int TOP_RIGHT = 1;
	public static final int BOT_LEFT = 2;
	public static final int BOT_RIGHT = 3;

	public List<Entity> ents;
	public QuadTree[] nodes;
	public Rectangle2D.Double bounds;
	private int level;

	public QuadTree(Rectangle2D.Double bounds) {
		this(bounds, 0);
	}

	private QuadTree(Rectangle2D.Double bounds, int level) {
		this.ents = new ArrayList<Entity>();
		this.nodes = new QuadTree[4];
		this.bounds= bounds;
		this.level = level;
	}

	public void clear() {
		ents.clear();
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null) {
				nodes[i].clear();
				nodes[i] = null;
			}
		}
	}

	private void split() {
		double x = bounds.x;
		double y = bounds.y;
		double hWidth = bounds.width / 2;
		double hHeight = bounds.height / 2;

		nodes[TOP_LEFT] = new QuadTree(new Rectangle2D.Double(x, y, hWidth, hHeight), level + 1);
		nodes[TOP_RIGHT] = new QuadTree(new Rectangle2D.Double(x + hWidth, y, hWidth, hHeight), level + 1);
		nodes[BOT_LEFT] = new QuadTree(new Rectangle2D.Double(x, y + hHeight, hWidth, hHeight), level + 1);
		nodes[BOT_RIGHT] = new QuadTree(new Rectangle2D.Double(x + hWidth, y + hHeight, hWidth, hHeight), level + 1);
	}

	public void insert(Collection<Entity> ents) {
		for (Entity e : ents) {
			insert(e);
		}
	}

	public void insert(Entity e) {
		if (nodes[0] != null) {
			int index = getIndex(e);
			if (index != SELF) {
				nodes[index].insert(e);
				return;
			}
		}

		ents.add(e);

		if (ents.size() > MAX_ENTITIES && level < MAX_LEVELS) {
			if (nodes[0] == null) {
				split();
			}

			for (int i = ents.size() - 1; i >= 0; i--) {
				int index = getIndex(ents.get(i));

				if (index != SELF) {
					nodes[index].insert(ents.remove(i));
				}
			}
		}

	}

	private int getIndex(Entity e) {
		double mX = bounds.width / 2;
		double mH = bounds.height / 2;
		
		double x = e.bounds.x;
		double y = e.bounds.y;
		double w = e.bounds.width;
		double h = e.bounds.height;

		boolean top = (y > mH) && (y + h > mH);
		boolean bot = (y < mH) && (y + h < mH);
		boolean left = (x < mX) && (x + h < mX);
		boolean right = (x > mX) && (x + h > mX);

		if (top) {
			if (left) {
				return TOP_LEFT;
			} else {
				return TOP_RIGHT;
			}
		} else if (bot) {
			if (left) {
				return BOT_LEFT;
			} else {
				return BOT_RIGHT;
			}
		} else {
			return SELF;
		} 
	}

	public List<Entity> retrieveNeighbors(Entity e) {
		return retrieveNeighbors(e, new ArrayList<Entity>());
	}

	private List<Entity> retrieveNeighbors(Entity e, List<Entity> collection) {
		collection.addAll(ents);
		
		if (nodes[0] == null) {
			return collection;
		}

		int index = getIndex(e);

		if (index == SELF) {
			return collection;
		} else {
			nodes[index].retrieveNeighbors(e, collection);
		}

		return collection;
	}

}