package chap11;

public interface Human extends Creature {
	void talk();
	void watch();
	void hear();
	// さらに、親インタフェースからrun()を継承する
}
