class WrapperClassTest {
    public static void main(String[] args) {
        byte b = 1;
        short s = 234;
        int i = 56789;
        long l = 1234567890L;
        float f = 1.23F;
        double d = 0.000456;
        char c = 'A';
        boolean bool = true;

        Byte wrappedByte = new Byte(b);
        Short wrappedShort = new Short(s);
        Integer wrappedInt = new Integer(i);
        Long wrappedLong = new Long(l);
        Float wrappedFloat = new Float(f);
        Double wrappedDouble = new Double(d);
        Character wrappedChar = new Character(c);
        Boolean wrappedBoolean = new Boolean(bool);

        System.out.println(wrappedByte.byteValue());
        System.out.println(wrappedShort.shortValue());
        System.out.println(wrappedInt.intValue());
        System.out.println(wrappedLong.longValue());
        System.out.println(wrappedFloat.floatValue());
        System.out.println(wrappedDouble.doubleValue());
        System.out.println(wrappedChar.charValue());
        System.out.println(wrappedBoolean.toString());

        System.out.println(wrappedInt.equals(wrappedByte));
    }
}
