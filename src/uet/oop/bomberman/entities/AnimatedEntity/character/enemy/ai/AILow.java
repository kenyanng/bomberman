package uet.oop.bomberman.entities.AnimatedEntity.character.enemy.ai;

public class AILow extends AI {

	@Override
	public int calDirection() {
		// TODO: cài đặt thuật toán tìm đường đi
		return random.nextInt(4);
	}
}
