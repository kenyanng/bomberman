package uet.oop.bomberman.entities.AnimatedEntity.character.enemy.ai;
import uet.oop.bomberman.entities.AnimatedEntity.character.Bomber;
import uet.oop.bomberman.entities.AnimatedEntity.character.enemy.Enemy;

public class AIMedium extends AI {
	Bomber _bomber;
	Enemy _e;
	
	public AIMedium(Bomber bomber, Enemy e) {
		_bomber = bomber;
		_e = e;
	}

    protected int calCol() {
        if(_bomber.getYTile() < _e.getYTile()) return 0;
        else if(_bomber.getYTile() > _e.getYTile()) return 2;
        return -1;
    }

    protected int calRow(){
        if(_bomber.getXTile() < _e.getXTile()) return 3;
        else if(_bomber.getXTile() > _e.getXTile()) return 1;
        return -1;
    }

	@Override
	public int calDirection() {
		// Cài đặt thuật toán tìm đường đi
		if(_bomber == null) return random.nextInt(4);
        int vertical = random.nextInt(2);
        if(vertical == 1){
            if(calRow() != -1){
                return calRow();
            }
            else return calCol();
        }
        else {
            if(calCol() != 1){
                return calCol();
            }
            else return calRow();
        }
	}
}
