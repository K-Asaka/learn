{
    String s = "Hello.";
    char c = s.charAt(1);

    System.out.println(s + "��2�����ڂ�" + c + "�ł��B");

    String s2 = s.toLowerCase();
    System.out.println(s + "���������ɂ����" + s2 + "�ł��B");

    String s3 = s.toUpperCase();
    System.out.println(s + "��啶���ɂ����" + s3 + "�ł��B");

    System.out.println("s2��Hello.�͓�����:" + s2.equals("Hello."));
    System.out.println("s2��Hello.�͓�����:" + s2.equalsIgnoreCase("Hello."));
}