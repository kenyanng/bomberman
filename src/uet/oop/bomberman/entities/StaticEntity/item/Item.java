package uet.oop.bomberman.entities.StaticEntity.item;

import uet.oop.bomberman.entities.StaticEntity.Tile;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Item extends Tile {

	protected boolean _active = false;
	protected int _level;
	
	public Item(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	// cập nhật lại item của bomber
	public abstract void setValues();
	
	public int getLevel() {
		return _level;
	}

	// kiểm tra có hoạt động không
	public boolean isActive() {
		return _active;
	}
}
