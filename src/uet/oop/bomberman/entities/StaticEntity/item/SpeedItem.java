package uet.oop.bomberman.entities.StaticEntity.item;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.AnimatedEntity.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.Sound;

public class SpeedItem extends Item {

	public SpeedItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn Item
		if(e instanceof Bomber) {
			((Bomber) e).addItem(this);
			remove();
			Sound.getInstance().getAudio(Sound.item).play();
			return true;
		}
		return false;
	}

        @Override
	public void setValues() {
		_active = true;
		Game.addBomberSpeed(0.3);// tăng tốc độ chạy
	}
}
