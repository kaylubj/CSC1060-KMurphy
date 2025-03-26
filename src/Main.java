/*
Rational Numbers
Kaylub Murphy
03/24/2025
Purpose: Create a rational class
 */
public class Main {

    public static void main(String[] args) {
        Rational no_Params = new Rational();
        Rational params = new Rational(17, 32);
        Rational common = new Rational(35, 10);
        Rational seventeen = new Rational(17, 51);
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println(no_Params.toString());
        System.out.println(params.toString());
        System.out.println(no_Params.invert());
        System.out.println(params.invert());
        System.out.println(no_Params.toString());
        System.out.println(params.toString());
        System.out.println(no_Params.toDouble());
        System.out.println(params.toDouble());
        System.out.println(no_Params.gcd());
        System.out.println(params.gcd());
        System.out.println(common.gcd());
        System.out.println(seventeen.gcd());
    }
}