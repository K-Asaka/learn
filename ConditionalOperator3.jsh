{
    char c = 'C';

    int a = c >= 'A' && c <= 'Z' ? c - 'A' + 'a' :
        c >= 'a' && c <= 'z' ? c - 'a' + 'A' : c;
    System.out.println("c = " + c + " a = " + (char)a);
}