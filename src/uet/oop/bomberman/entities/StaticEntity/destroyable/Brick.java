package uet.oop.bomberman.entities.StaticEntity.destroyable;

import uet.oop.bomberman.entities.AnimatedEntity.character.enemy.Minvo;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.AnimatedEntity.bomb.Flame;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.level.Coordinates;
import uet.oop.bomberman.sound.Sound;

public class Brick extends DestroyableTile {
	
	public Brick(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	@Override
	public void render(Screen screen) {
		int x = Coordinates.tileToPixel(_x);
		int y = Coordinates.tileToPixel(_y);
		
		if(_destroyed) {
			_sprite = movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2);
			screen.renderEntityWithBelowSprite(x, y, this, _belowSprite);
		}
		else screen.renderEntity( x, y, this);
	}

	@Override
	public boolean collide(Entity e) {
		if(e instanceof Flame) {
			destroy();
			Sound.getInstance().getAudio(Sound.destroy).play();
		}
		if (e instanceof Minvo) {
			return true;
		}
		return false;
	}
}