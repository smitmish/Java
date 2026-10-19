package exercise.inputoutput;

import java.util.Scanner;

public class BasicInputOutput {
    public static void main(String[] args) {
        System.out.println("Java Programming is fun.");
        System.out.printf("Introduced in year {%d}",1995);
        Scanner input = new Scanner(System.in);
        System.out.println("Plese enter a number: ");
        System.out.println(input.nextLine());

        //Single line comment
        //Print Hello Java Developers
        System.out.println("Hello Java Developers:");
        /*
        This is the multiline comment.
         */
        System.out.println(doMultiplication(3,2));
        input.close();
    }
    /**
     * This method is the multiplication method
     */
    public static int doMultiplication(int x, int y){
        return x*y;
    }
}
