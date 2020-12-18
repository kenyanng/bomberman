package uet.oop.bomberman.entities.StaticEntity.destroyable;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.AnimatedEntity.bomb.Flame;
import uet.oop.bomberman.entities.StaticEntity.Tile;
import uet.oop.bomberman.graphics.Sprite;

public class DestroyableTile extends Tile {

	private final int MAX_ANIMATE = 7500; // lưu trạng thái hoạt ảnh và đừng để điều này quá lớn
	private int _animate = 0;
	protected boolean _destroyed = false;	// bị phá hủy hay không
	protected int _timeToDisapear = 20;		// thời gian biến mất của một ô gạch
	protected Sprite _belowSprite = Sprite.grass; // spite ẩn trong gạch
	
	public DestroyableTile(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public void update() {
		if(_destroyed) {	// nếu bị phá hủy
			if(_animate < MAX_ANIMATE) _animate++; else _animate = 0; // thay đổi ảnh khi mà bom nổ
			if(_timeToDisapear > 0) _timeToDisapear--;
			else remove();
		}
	}

	// Hàm phá ô gạch
	public void destroy() {
		_destroyed = true;
	}
	
	@Override
	public boolean collide(Entity e) {
		if(e instanceof Flame) destroy();	// Nếu gặp flame thì bị phá hủy
		return false;
	}
	
	public void addBelowSprite(Sprite sprite) {
		_belowSprite = sprite;
	}
	
	protected Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2) {
		int calc = _animate % 30;
		
		if(calc < 10) return normal;
		if(calc < 20) return x1;

		return x2;
	}
}
