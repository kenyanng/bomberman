package uet.oop.bomberman.entities.StaticEntity.item;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.AnimatedEntity.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.Sound;

public class LiveItem extends Item {
    protected Board _board;

    public LiveItem(int x, int y, Board board, Sprite sprite) {
        super(x, y, sprite);
        _board = board;
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
        _board.addLives(1);
    }
}
