package uet.oop.bomberman.entities.StaticEntity;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Grass extends Tile {

	public Grass(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	/**
	 * Cho bất kì đối tượng khác đi qua
	 */
	@Override
	public boolean collide(Entity e) {
		return true;
	}
}
