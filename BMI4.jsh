{
    double height, weight, weightAve, fat;

    height = 1.75;
    weight = 71.5;

    weightAve = 22 * Math.pow(height, 2);
    fat = (weight - weightAve) / weightAve * 100;

    System.out.print("あなたの肥満率は");
    System.out.printf("%2.1f", fat);
    System.out.println("%です。");

    System.out.print("あなたは太りすぎで");
    System.out.print(fat >= 20 ? "す。" : "はありません。");
}