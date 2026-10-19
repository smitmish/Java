package exercise.numbers;

public class JavaNumbers {
    public static void main(String[] args) {
        System.out.println("-----Octal Numbers-----");
        //Octal 0-7
        int octalNumber1 = 015; //this will be stored as 13 in decimal.
        int octalNumber2 = 0104;//this will be stored as 68 in decimal.
        int sumOctalNumbers = octalNumber1+octalNumber2; //81 in decimal

        System.out.println("octalNumber1 in decimal: "+octalNumber1);
        System.out.println("hexNumber2 in decimal: "+octalNumber2);
        System.out.println("result in decimal: "+sumOctalNumbers);
        System.out.println("result in octal: "+Integer.toOctalString(sumOctalNumbers));

        System.out.println("-----Hexadecimal Numbers-----");
        int hexNumber1 = 0x1B0; //432 in decimal
        int hexNumber2 = 0x2F;//47 in decimal
        int sumHexNumbers = hexNumber1 + hexNumber2; //479 in decimal

        System.out.println("hexNumber1 in decimal: "+ hexNumber1);
        System.out.println("hexNumber2 in decimal: "+ hexNumber2);
        System.out.println("result in decimal: "+sumHexNumbers);
        System.out.println("result in hexadecimal: "+Integer.toHexString(sumHexNumbers));

        System.out.println("-----Binary Numbers-----");
        int binaryNumber1 = 0b1001; //432 in decimal
        int binaryNumber2 = 0B1011;//47 in decimal
        int sumBinaryNumbers = binaryNumber1 + binaryNumber2; //479 in decimal

        System.out.println("octalNumber1 in decimal: "+ binaryNumber1);
        System.out.println("hexNumber2 in decimal: "+ binaryNumber2);
        System.out.println("result in decimal: "+sumBinaryNumbers);
        System.out.println("result in octal: "+Integer.toBinaryString(sumBinaryNumbers));
    }
}
