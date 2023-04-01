package main.hashtable;

public class HashTable {
        public int size;
        public int step;
        public String [] slots;

    public HashTable(int sz, int stp)
        {
            size = sz;
            step = stp;
            slots = new String[size];
            for(int i=0; i<size; i++) slots[i] = null;
        }

        public int hashFun(String value)
        {
            int sumBytes = 0;
            for (char c : value.toCharArray()) {
                sumBytes += c;
            }
            return sumBytes % size;
        }

        public int seekSlot(String value)
        {
            int slot = hashFun(value);
            if (slots[slot] == null) {
                return slot;
            }
            int count = 0;
            while (count < 2) {
                slot += step;
                if (slot > size - 1) {
                    slot -= size;
                    count++;
                }
                if (slots[slot] == null) {
                    return slot;
                }
            }
            return -1;
        }

        public int put(String value)
        {
            int factSlot = seekSlot(value);
            if (factSlot != -1) {
                slots[factSlot] = value;
            }
            return factSlot;
        }

        public int find(String value)
        {
            for (int i = 0; i < slots.length; i++) {
                if (value.equals(slots[i])) {
                    return i;
                }
            }
            return -1;
        }
}
