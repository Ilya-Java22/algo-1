package main.oop;

public abstract class PowerSet<T> extends HashTable<T> {
    // конструктор
    // постусловие: создано новое множество размером size
    public abstract PowerSet<T> PowerSet(int size);

    // запросы:

    public abstract int size();

    public abstract PowerSet<T> intersection(PowerSet<T> set2);

    public abstract PowerSet<T> union(PowerSet<T> set2);

    public abstract PowerSet<T> difference(PowerSet<T> set2);

    public abstract PowerSet<T> isSubset(PowerSet<T> set2);

}
