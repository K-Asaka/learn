{
    double height, weight, weightAve, fat;

    height = 1.75;
    weight = 71.5;

    weightAve = 22 * Math.pow(height, 2);
    fat = (weight - weightAve) / weightAve * 100;

    System.out.print("���Ȃ��̔얞����");
    System.out.printf("%2.1f", fat);
    System.out.println("%�ł��B");

    System.out.print("���Ȃ��͑��肷����");
    System.out.print(fat >= 20 ? "���B" : "�͂���܂���B");
}