{
    double height, weight, weightAve, fat;

    height = 1.75;
    weight = 71.5;

    weightAve = 22 * Math.pow(height, 2);
    fat = (weight - weightAve) / weightAve * 100;

    System.out.print("Ç†Ç»ÇΩÇÃîÏñûó¶ÇÕ");
    System.out.printf("%2.1f", fat);
    System.out.println("%Ç≈Ç∑ÅB");

    System.out.print("Ç†Ç»ÇΩÇÕëæÇËÇ∑Ç¨Ç≈");
    System.out.print(fat >= 20 ? "Ç∑ÅB" : "ÇÕÇ†ÇËÇ‹ÇπÇÒÅB");
}