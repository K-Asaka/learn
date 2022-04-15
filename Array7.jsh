{
    int[] a = {0, 1, 2, 3, 4};
    int[] b;

    b = a;

    b[1] = b[2] = b[3] = 5;
    System.out.print(a[0]);
    System.out.print(a[1]);
    System.out.print(a[2]);
    System.out.print(a[3]);
    System.out.print(a[4]);
}