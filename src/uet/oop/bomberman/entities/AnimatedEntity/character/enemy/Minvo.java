package uet.oop.bomberman.entities.AnimatedEntity.character.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.AnimatedEntity.character.enemy.ai.AIMedium;
import uet.oop.bomberman.entities.AnimatedEntity.character.enemy.ai.AIPass;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.StaticEntity.destroyable.Brick;
import uet.oop.bomberman.graphics.Sprite;

public class Minvo extends Enemy {
	
	
	public Minvo(int x, int y, Board board) {
		super(x, y, board, Sprite.minvo_dead, Game.getBomberSpeed(), 800);

		_sprite = Sprite.minvo_right1;
		_ai = new AIPass(_board.getBomber(), this);
		_direction = _ai.calDirection();
	}

	@Override
	protected void chooseSprite() {
		switch(_direction) {
			case 0:
			case 1:
				if(_moving)
					_sprite = Sprite.movingSprite(Sprite.minvo_right1, Sprite.minvo_right2, Sprite.minvo_right3, _animate, 60);
				else
					_sprite = Sprite.minvo_left1;
				break;
			case 2:
			case 3:
				if(_moving)
					_sprite = Sprite.movingSprite(Sprite.minvo_left1, Sprite.minvo_left2, Sprite.minvo_left3, _animate, 60);
				else
					_sprite = Sprite.minvo_left1;
				break;
		}
	}
}
