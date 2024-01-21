package main.oop;

public abstract class DynArray<T> {

    //статусы выполнения методов
    public static final int INSERT_NIL = 0; // insert() ещё не вызывалась
    public static final int INSERT_OK = 1; // последняя insert() отработала нормально
    public static final int INSERT_ERR = 2; // некорректный индекс

    public static final int REMOVE_NIL = 0; // remove() ещё не вызывалась
    public static final int REMOVE_OK = 1; // последняя remove() отработала нормально
    public static final int REMOVE_ERR = 2; // некорректный индекс

    public static final int GET_NIL = 0; // remove ещё не вызывалась
    public static final int GET_OK = 1; // последняя remove отработала нормально
    public static final int GET_ERR = 2; // некорректный индекс

    // конструктор
    // постусловие: создан новый динамический массив
    public abstract DynArray<T> DynArray();

    // команды:

    // постусловие: в конец массива добавлен новый элемент
    public abstract void append(T t);

    // предусловие: передаваемый в качестве аргумента индекс положителен и меньше размера массива
    // постусловие: в массив вставлен элемент на указанное место
    public abstract void insert(T t, int index);

    // предусловие: передаваемый в качестве аргумента индекс положителен и меньше размера массива
    // постусловие: из массива удален элемент на указанном месте
    public abstract void remove(int index);

    // запросы:

    // предусловие: передаваемый в качестве аргумента индекс положителен и меньше размера массива
    public abstract T get(int index);


    // дополнительные запросы (возвращение статусов выполнения методов):
    public abstract int get_insert_status();

    public abstract int get_remove_status();

    public abstract int get_get_status();
   }
