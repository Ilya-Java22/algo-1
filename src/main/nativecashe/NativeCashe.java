package main.nativecashe;

import java.lang.reflect.Array;

class NativeCashe<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;

    public NativeCashe(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[size];
    }

    public int hashFun(String key)
    {
        int sumBytes = 0;
        for (char c : key.toCharArray()) {
            sumBytes += c;
        }
        return sumBytes % size;
    }

    public int findIndMinAr(int[] arr) {
        int indexOfMin = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] < arr[indexOfMin])
            {
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    public T get(String key)
    {
        int index = hashFun(key);
        if (key.equals(slots[index])) {
            hits[index]++;
            return values[index];
        }
        for (String slot : slots) {
            if (key.equals(slot)) {
                hits[index]++;
                return values[index];
            }
        }
        return null;
    }

    public int seekSlot(String key)
    {
        int slot = hashFun(key);
        if (slots[slot] == null || key.equals(slots[slot])) {
            return slot;
        }
        int count = 0;
        while (count < 2) {
            slot += 1;
            if (slot > size - 1) {
                slot -= size;
                count++;
            }
            if (slots[slot] == null || key.equals(slots[slot])) {
                return slot;
            }
        }
        return -1;
    }

    public void put(String key, T value)
    {
        int factSlot = seekSlot(key);
        if (factSlot == -1) {
            factSlot = findIndMinAr(hits);
            hits[factSlot] = 0;
        }
        slots[factSlot] = key;
        values[factSlot] = value;
    }
}
