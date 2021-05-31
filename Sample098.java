class ObjectClass {
    public DataClass getObject() {
        return new DataClass();
    }
}

// class DataClass {
//     public int num1 = 1;
//     public int num2 = 2;
//     public int num3 = 3;
// }

class Sample098 {
    public static void main(String[] args) {
        ObjectClass obj = new ObjectClass();
        // メソッドからオブジェクトが返されている
        DataClass data = obj.getObject();
        System.out.print("計算結果は");
        System.out.print((data.num1 + data.num2 + data.num3));
        System.out.println("です");
    }
}