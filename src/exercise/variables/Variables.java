package exercise.variables;

public class Variables {
    public static void main(String[] args) {
        int a=10, b=20, c=a+b;
        System.out.printf("c: {%d}\n",c);
        System.out.printf("c: ",a+b);
        System.out.printf("c: {%d}",(a+b));

        int age; //valid
        int _age;//valid
        int $age;//valid
        int age3;//valid

        /* cannot contain space and start with number.
        int a ge;//invalid
        int 3age;//invalid

         */

        /* cannot used keywords and reserved words.
        int break; //invalid
        int const; //invalid
        int do; //invalid
        int public; //invalid

         */


    }
}
