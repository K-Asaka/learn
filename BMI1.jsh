{
    double height, weight, weightAve, fat;

    height = 1.75;
    weight = 85.5;

    weightAve = 22 * Math.pow(height, 2);
    fat = (weight - weightAve) / weightAve * 100;

    System.out.print("‚ ‚È‚½‚Ì”ì–—¦‚Í");
    System.out.print(fat);
    System.out.println("%‚Å‚·B");
    if (fat >= 20) {
        System.out.println("‚ ‚È‚½‚Í‘¾‚è‚·‚¬‚Å‚·B");
    }
}