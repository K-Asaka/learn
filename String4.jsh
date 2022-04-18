{
    String s = "Hello.";
    char c = s.charAt(1);

    System.out.println(s + "‚Ì2•¶š–Ú‚Í" + c + "‚Å‚·B");

    String s2 = s.toLowerCase();
    System.out.println(s + "‚ğ¬•¶š‚É‚·‚é‚Æ" + s2 + "‚Å‚·B");

    String s3 = s.toUpperCase();
    System.out.println(s + "‚ğ‘å•¶š‚É‚·‚é‚Æ" + s3 + "‚Å‚·B");

    System.out.println("s2‚ÆHello.‚Í“™‚µ‚¢:" + s2.equals("Hello."));
    System.out.println("s2‚ÆHello.‚Í“™‚µ‚¢:" + s2.equalsIgnoreCase("Hello."));
}