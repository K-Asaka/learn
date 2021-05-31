class intData {
    public int num1;
    public int num2;
    public int num3;

    intData(int n1, int n2, int n3) {
        num1 = n1;
        num2 = n2;
        num3 = n3;
    }
}

class compute {
    public void add(intData i) {
        // オブジェクトのメンバであるフィールドにアクセスしている
        System.out.print("計算結果は");
        System.out.println((i.num1 + i.num2 + i.num3) + "です");
    }
}

public class Sample097 {
    public static void main(String[] args) {
        intData data = new intData(1, 2, 3);
        compute comp = new compute();

        // オブジェクトを渡している
        comp.add(data);
    }
}
