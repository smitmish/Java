package exercise.operators;

public class BitwiseBitshiftOperator {
    public static void main(String[] args) {
        System.out.println("-----------Bitwise AND (&) Operator----------------------");

        //Bitwise AND(&)
        int num1=8; //1000
        int num2=9; //1001
                    //1000 = 8 in decimal
        System.out.println("num1 in binary: "+Integer.toBinaryString(num1));
        System.out.println("num2 in binary: "+Integer.toBinaryString(num2));
        System.out.println("num1 & num2 in binary: "+Integer.toBinaryString(num1 & num2));
        System.out.println("num1 & num2 in decimal: "+(num1 & num2));

        System.out.println("-----------Bitwise Inclusive OR (|) Operator----------------------");

        //Bitwise OR(|)
        int num3=8; //1000
        int num4=9; //1001
                    //1001 = 9 in decimal
        System.out.println("num3 in binary: "+Integer.toBinaryString(num3));
        System.out.println("num4 in binary: "+Integer.toBinaryString(num4));
        System.out.println("num3 | num4 in binary: "+Integer.toBinaryString(num3 | num4));
        System.out.println("num3 | num4 in decimal: "+(num3 | num4));

        System.out.println("-----------Bitwise Exclusive OR (^) Operator----------------------");

        //Bitwise Exclusive OR(^)
        int num5=8; //1000
        int num6=9; //1001
                    //0001 = 1 in decimal
        System.out.println("num5 in binary: "+Integer.toBinaryString(num5));
        System.out.println("num6 in binary: "+Integer.toBinaryString(num6));
        System.out.println("num5 ^ num6 in binary: "+Integer.toBinaryString(num5 ^ num6));
        System.out.println("num5 ^ num6 in decimal: "+(num5 ^ num6));

        System.out.println("-----------Signed Left-shift (<<) Operator----------------------");

        //Signed Left-shift (<<)
        int num7=8; //1000 << 2 = 100000 = 32 in decimal
                    //or you can say 8 * (2 power 2) (number of digit to shift i.e. <<2) = 8 * (4) = 32.

        System.out.println("num7 in binary: "+Integer.toBinaryString(num7));
        System.out.println("num7 << 2 in binary: "+Integer.toBinaryString(num7 << 2));
        System.out.println("num7 << 2 in decimal: "+(num7 << 2));

        int num8=2_147_483_647;

        System.out.println("num8 in binary: "+Integer.toBinaryString(num8));
        System.out.println("num8 << 1 in binary: "+Integer.toBinaryString(num8 << 1));
        System.out.println("num8 << 1 in decimal: "+(num8 << 1));
        System.out.println("num8 + num 8 or num8 << 1 or num8 * 2 in binary: "+Integer.toBinaryString(num8 +num8));
        System.out.println("num8 + num 8 or num 8 << 1 or num8 * 2 in decimal: "+(num8 + num8));
        System.out.println("num8 + 1 in binary: "+Integer.toBinaryString(num8 + 1));
        System.out.println("num8 + 1 in decimal: "+(num8 + 1));

        System.out.println("-----------Signed Right-shift (>>) Operator----------------------");

        //Signed Right-shift (<<)
        int num9=8; //1000 >> 2 = 000010 = 2 in decimal
                    //or you can say 8 / (2 power 2) = 8 / 4 = 2
        System.out.println("num9 in binary: "+Integer.toBinaryString(num9));
        System.out.println("num9 >> 2 in binary: "+Integer.toBinaryString(num9 >> 2));
        System.out.println("num9 >> 2 in decimal: "+(num9 >> 2));

        System.out.println("-----------Unary Bitwise Complement (~) Operator----------------------");

        //Unary Bitwise Complement (~) Operator
        int num10=8;
        //Mathematically, ~8 = -(8+1) = -9
        //How machine interprets it:
        //Step 1 : 8 in 32-bit nonary representation.
        //0000 0000 0000 0000 0000 0000 0000 1000
        //Step 2: Negate the number. ~8 invert all 1 to 0 and 0 to 1
        //1111 1111 1111 1111 1111 1111 1111 0111
        //Strep 3 : Now, looking to MSB, its clear it's a negative number,
        //but what is magnitude for that we need to reverse the 2 compliment process.
        //a) invert all the bits back.
        //0000 0000 0000 0000 0000 0000 0000 1000 =8
        //b) Add 1.
        //0000 0000 0000 0000 0000 0000 0000 1001 = 9
        //since after negating the number we know MSB was 1 so it's a negative number.
        //So you need to put minus = -9. So sign we understood from step 2 and magnitude we
        //get from reverse 2's comp process.
        System.out.println("num10 in binary: "+Integer.toBinaryString(num10));
        System.out.println("num10 in binary: "+Integer.toBinaryString(~num10));
        System.out.println("num10 in decimal: "+(~num10));

        //Example 2
        int num11=33;
        //0010 0001 = 33
        //1111 1111 1111 1111 1111 1111 1101 1110 ==> MSB 1
        //0000 0000 0000 0000 0000 0000 0010 0001 = 33
        //+1 = 34 = -34
        //Add 1 to binary string.
        //0000 0000 0000 0000 0000 0000 0010 0010 = 34
        System.out.println("num11 in binary: "+Integer.toBinaryString(num11));
        System.out.println("num11 in binary: "+Integer.toBinaryString(~num11));
        System.out.println("num11 in decimal: "+(~num11));
    }
}
