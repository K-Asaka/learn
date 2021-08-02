package chap11;

public class Matango {
	int hp = 50;
		
	public void attack(Hero h) {
		System.out.println("キノコの攻撃");
		System.out.println("10のダメージ");
		h.hp -= 10;
	}
}
