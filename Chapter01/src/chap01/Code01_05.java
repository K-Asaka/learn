package chap01;

public class Code01_05 {
	public static void main(String[] args) {
		final double PI = 3.14;
		int pie = 5;
		System.out.println("半径" + pie + "cmのパイの面積は、");
		System.out.println(pie * pie * PI);
		System.out.println("パイの半径を倍にします");
		pie = 10;
		System.out.println("半径" + pie + "cmのパイの面積は、");
		System.out.println(pie * pie * PI);
	}
}
