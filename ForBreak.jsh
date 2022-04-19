{
    int[] data = {5, 3, 7, -1, 4, 2, 9};

    for (int i = 0; i < data.length; i++) {
        if (data[i] < 0) {
            break;
        }
        System.out.println(data[i]);
    }
}