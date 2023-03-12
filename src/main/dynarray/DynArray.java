package main.dynarray;

import java.lang.reflect.Array;
import java.util.*;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        capacity = new_capacity;
        array = array == null ? (T[]) Array.newInstance(this.clazz, new_capacity) : Arrays.copyOf(array, new_capacity);
    }

    public T getItem(int index)
    {
        Objects.checkIndex(index, count);
        return array[index];
    }

    public void append(T itm)
    {
        if (count == capacity) {
            makeArray(count * 2);
        }
        array[count++] = itm;

    }

    public void insert(T itm, int index)
    {
        Objects.checkIndex(index, count + 1);
        if (count == capacity) {
            makeArray(count * 2);
        }
        if (index != count) {
            System.arraycopy(array, index, array, index + 1, count - index);
        }
        array[index] = itm;
        count++;
    }

    public void remove(int index)
    {
        Objects.checkIndex(index, count);
        if (index != count - 1) {
            System.arraycopy(array, index + 1, array, index, count - index - 1);
        }
        array[count - 1] = null;
        count--;
        if ((count < capacity / 2) && (int) (capacity / 1.5) > 16) {
            makeArray((int) (capacity / 1.5));
        }
    }
}
