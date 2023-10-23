public class Program {
    public static void caculate(double num1, double num2, String oper) {
        double result = 0;
        if (oper.equals("+")) {
            result = num1 + num2;
        } else if (oper.equals("-")) {
            result = num1 - num2;
        } else if (oper.equals("x")) {
            result = num1 * num2;
        } else if (oper.equals("/")) {
            result = num1 / num2;
        } else if (oper.equals("^")) {
            result = Math.pow(num1, num2);
        } else {
            System.out.println("Unsupported operator");
            return;
        }
        System.out.println(result);
    }
    public static void main(String args[]){
        if (args.length != 3){
            System.out.println("Invalid expression");
        }
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[2]);
        caculate(num1, num2, args[1]);
    }
}