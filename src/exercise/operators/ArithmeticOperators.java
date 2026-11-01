package exercise.operators;

public class ArithmeticOperators {
    public static void main(String[] args) {
        double number1 = 8.4, number2 = 4.2, result = 0.0;
        result=number1+number2;
        System.out.println("number1 + number2 = "+result);
        result=number1-number2;
        System.out.println("number1 - number2 = "+result);
        result=number1/number2;
        System.out.println("number1 / number2 = "+result);
        result=number1*number2;
        System.out.println("number1 * number2 = "+result);
        result=number1%number2;
        System.out.println("number1 % number2 = "+result);

        String str1="Java",str2="Programming",str3=str1+str2;
        System.out.println(str3);
    }
}
