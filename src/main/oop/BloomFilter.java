package main.oop;

public abstract class BloomFilter<T> {
    // конструктор
    // постусловие: создан новый фильтр Блюма размером size
    public abstract BloomFilter<T> BloomFilter(int size);

    // команда:

    // предусловие: для данного элемента найден хотя бы один нулевой бит в фильтре
    // постусловие: в фильтр Блюма добавлена информация о новом элементе
    public abstract void add(T t);

    // запрос:
    public abstract boolean isValue(T t);

    // дополнительные запросы (возвращение статусов выполнения методов):
    public abstract int get_add_status();
}
