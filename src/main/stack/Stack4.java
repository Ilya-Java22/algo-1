package main.stack;

public class Stack4 {
    public static boolean testBalance(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')' && stack.size() == 0) {
                return false;
            }
            if (ch == ')') {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        return stack.size() == 0;
    }
}
