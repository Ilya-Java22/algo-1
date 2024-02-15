package main.oop;

public abstract class HashTable<T> {
    // конструктор
    // постусловие: создана новая хэш-таблица размером size
    public abstract HashTable<T> HashTable(int size);

    // команды:

    // предусловие: для данного элемента найдено свободное место
    // постусловие: в хэш-таблицу добавлен новый элемент
    public abstract void add(T t);

    // предусловие: хэш-таблица не пуста
    // постусловие: из хэш-таблицы удален элемент
    public abstract void remove(T t);

    // запросы:

    public abstract int size();

    // проверка, есть ли данный элемент в хэш-таблице
    // предусловие: хэш-таблица не пуста
    public abstract boolean contain(T t);


    // дополнительные запросы (возвращение статусов выполнения методов):
    public abstract int get_remove_status();
    public abstract int get_add_status();
    public abstract int get_contain_status();
}
