package chap04;

public class Code04_16 {
	public static void main(String[] args) {
		boolean judge = true;
		if (judge == true) {
			int[] array = { 1, 2, 3 };
		}
		// arrayの参照情報はブロックを抜けて消えるが
		// newで確保された要素はブロックを抜けても消えない
		// ガベージコレクションはこのようなメモリ上のゴミを
		// 自動的に探し出して片付けてくれる
	}
}
