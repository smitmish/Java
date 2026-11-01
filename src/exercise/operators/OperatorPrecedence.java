package exercise.operators;

public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 5 + 2 * 4; //2*4 = 8 -> 5+8 = 13
        System.out.println("result = "+result);

        result = (5 + 2) * 4; //5 + 2 = 7 -> 7 * 4 = 28
        System.out.println("result = "+result);

        result += 80 /20 % 8 * 3 + -5;
        //80 /20 = 4
        //4 % 8 = 2
        //2 * 3 =6
        //6 + -5 = 1
        //result = result + 1 => result = 28 + 1;
        System.out.println("result = "+result);

        int x = 8, y = 4, z = 2, sum =0;
/*        sum = x + --y + --z;
        // 8 + 3 + 1 = 12
        System.out.println("sum = "+sum);*/

/*        sum = x + y-- + --z;
        // 8 + 4 + 1 = 13
        System.out.println("sum = "+sum);*/

/*        sum = x + y-- + --z + y;
        // 8 + 4 + 1 + 3 = 16
        System.out.println("sum = "+sum);*/

        sum = x + y-- + --z * y;
        //x=8, y=4, z=1, y(new value) = 3
        // 8 + 4 + (1 * 3) = 8 + 4 + 3 = 15
        System.out.println("sum = "+sum);
    }
}
