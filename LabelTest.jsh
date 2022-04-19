{
    outer_loop:
    for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 10; j++) {
            System.out.print(i * j);
            System.out.print(" ");
            if (i >= 5 && j >= 6) {
                break outer_loop;
            }
        }
        System.out.println();
    }
}