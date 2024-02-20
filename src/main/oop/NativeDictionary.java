package main.oop;

public abstract class NativeDictionary<T> {
    // конструктор
    // постусловие: создан новый словарь размером size
    public abstract NativeDictionary<T> NativeDictionary(int size);

    // команды:

    // предусловие: для данного ключа найдено свободное место или найден слот с данным ключом
    // постусловие: в словарь добавлена новая пара или изменено значение в найденном слоте с данным ключом
    public abstract void put(String key, T t);

    // предусловие: в словаре есть пара с данным ключом
    // постусловие: из словаря удалена пара с данным ключом
    public abstract void remove(String key);

    // запросы:

    public abstract int size();

    // проверка, есть ли пара с данным ключом в словаре
    public abstract boolean contain(String key);

    //получение значения по данному ключу
    //предусловие: в словаре есть пара с данным ключом
    public abstract T get(String key);


    // дополнительные запросы (возвращение статусов выполнения методов):
    public abstract int get_put_status();
    public abstract int get_remove_status();
    public abstract int get_get_status();
}
