{
    double height, weight, weightAve, fat;

    height = 1.75;
    weight = 70.0;

    weightAve = 22 * Math.pow(height, 2);
    fat = (weight - weightAve) / weightAve * 100;

    System.out.print("���Ȃ��̔얞����");
    System.out.printf("%2.1f", fat);
    System.out.println("%�ł��B");

    if ((fat > -10)  && (fat < 20)) {
        System.out.println("���Ȃ��͕��ʂł��B");
    }
}