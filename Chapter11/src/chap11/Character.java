package chap11;

public class Character {
	String name;
	int hp;
	// 逃げる
	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}
	// 戦う
	public abstract void attack(Matango m);
}
