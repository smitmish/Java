package exercise.operators;

public class AssignmentOperator {
    public static void main(String[] args) {
        int x=20, y=15, z=0;
        z=x+y;
        System.out.println("z=x+y->"+z);
        z+=x;
        System.out.println("z+="+z);
        z-=x;
        System.out.println("z-="+z);
        z*=x;
        System.out.println("z*="+z);
        z/=x;
        System.out.println("z/="+z);
        z%=x;
        System.out.println("z%="+z);
    }
}
