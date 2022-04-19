{
    double height, weight, weightAve, fat;

    height = 1.75;
    weight = 70.0;

    weightAve = 22 * Math.pow(height, 2);
    fat = (weight - weightAve) / weightAve * 100;

    System.out.print("‚ ‚È‚½‚Ì”ì–—¦‚Í");
    System.out.printf("%2.1f", fat);
    System.out.println("%‚Å‚·B");

    if ((fat > -10)  && (fat < 20)) {
        System.out.println("‚ ‚È‚½‚Í•’Ê‚Å‚·B");
    }
}