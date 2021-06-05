// 飛行機クラス(スーパークラス)
class airplane {
    public void display() {
        System.out.println("飛行機オブジェクトを作成しました");
    }
}
// ジャンボジェット機クラス(サブクラス)
class jumbojet extends airplane {
    public void display() {
        System.out.print("ジャンボジェット機オブジェクトを");
        System.out.println("作成しました");
    }
}

public class Sample110 {
    public static void main(String[] args) {
        airplane plane = new airplane();
        plane.display();
        jumbojet jumbo = new jumbojet();
        jumbo.display();

        // planeオブジェクトがjumbojetクラスかどうか調べる
        if (plane instanceof jumbojet) {
            System.out.print("planeオブジェクトのクラスは");
            System.out.println("jumbojetです");
        } else {
            System.out.print("planeオブジェクトのクラスは");
            System.out.println("jumbojetではありません");
        }

        // jumboオブジェクトがjumbojetクラスかどうか調べる
        if (jumbo instanceof jumbojet) {
            System.out.print("jumboオブジェクトのクラスは");
            System.out.println("jumbojetです");
        } else {
            System.out.print("jumboオブジェクトのクラスは");
            System.out.println("jumbojetではありません");
        }
    }
}
