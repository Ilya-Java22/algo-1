package main.deque;

public class Deque2 {
    public static boolean checkPlndrm(String s) {
        if (s.length() < 2) {
            throw new IllegalArgumentException("string must be more than one character long");
        }
        boolean rsl = true;
        Deque<Character> deque = new Deque<>();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                deque.addTail(ch);
            }
        }
        while (deque.size() > 1) {
            if (!deque.removeFront().equals(deque.removeTail())) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
