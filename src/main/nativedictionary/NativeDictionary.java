package main.nativedictionary;

import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        int sumBytes = 0;
        for (char c : key.toCharArray()) {
            sumBytes += c;
        }
        return sumBytes % size;
    }

    public boolean isKey(String key)
    {
        int index = hashFun(key);
        if (key.equals(slots[index])) {
            return true;
        }
        for (String s : slots) {
            if (key.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value)
    {
        int index = hashFun(key);
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key)
    {
        int index = hashFun(key);
        if (key.equals(slots[index])) {
            return values[index];
        }
        return null;
    }
}
