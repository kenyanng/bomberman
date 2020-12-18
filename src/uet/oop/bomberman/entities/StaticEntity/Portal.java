package uet.oop.bomberman.entities.StaticEntity;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.AnimatedEntity.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.Sound;

public class Portal extends Tile {

    protected Board _board;

	public Portal(int x, int y, Sprite sprite, Board board) {
		super(x, y, sprite);
		_board = board;
	}
	
	@Override
	public boolean collide(Entity e) {
		// TODO: Xử lý va chạm với bomber
		if(e instanceof Bomber ) {
			if(_board.detectNoEnemies() == false) {
				return false; // nếu chưa hết enemy thì ko cho qua
			}

			// xử lý va chạm cho qua màn
			if(e.getXTile() == getX() && e.getYTile() == getY()) {
				if(_board.detectNoEnemies()) {
					Sound.getInstance().getAudio(Sound.win).play();
					_board.nextLevel();
				}
			}
			return true;
		}
		
		return false;
	}
}