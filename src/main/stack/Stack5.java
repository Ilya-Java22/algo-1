package main.stack;

import java.util.function.BinaryOperator;

public class Stack5 {
    public static Double calc(String s) {
        String[] strings = s.split(" ");
        Stack<String> stack1 = new Stack<>();
        Stack<Double> stack2 = new Stack<>();
        for (int i = 1; i <= strings.length; i++) {
            stack1.push(strings[strings.length - i]);
        }
        String t;
        while (!("=").equals(t = stack1.pop())) {
            stack2.push(subcalc(stack2, t));
        }
        return stack2.pop();
    }

    public static Double subcalc(Stack<Double> stack, String s) {
        if (Character.isDigit(s.charAt(0))) {
            return Double.parseDouble(s);
        }
        BinaryOperator<Double> bo = switch (s) {
            case "*" -> (x,y) -> x * y;
            case "/" -> (x,y) -> y / x;
            case "-" -> (x,y) -> y - x;
            default -> (x,y) -> x + y;
        };
        Double a = stack.pop();
        Double b = stack.pop();
        return bo.apply(a, b);
    }

    public static void main(String[] args) {
        System.out.println(calc("8 2 + 5 * 9 + ="));
    }
}
