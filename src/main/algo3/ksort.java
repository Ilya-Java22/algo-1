package main.algo3;

public class ksort {
    public String[] items;

    public ksort() {
        items = new String[800];
    }

    public int index(String s) {
        if (s.matches("^[a-h]\\d{2}$")) {
            return (s.charAt(0) - 97) * 100 + Integer.parseInt(s, 1, 3, 10);
        }
        return -1;
    }

    public boolean add(String s) {
        int index = index(s);
        boolean indexIsFound = index != -1;
        if (indexIsFound) {
            items[index] = s;
        }
        return indexIsFound;
    }
}
