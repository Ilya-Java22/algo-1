package main.oop;

public abstract class Queue<T> {

    //статусы выполнения методов
    public static final int REMOVE_NIL = 0; // remove() ещё не вызывалась
    public static final int REMOVE_OK = 1; // последняя remove() отработала нормально
    public static final int REMOVE_ERR = 2; // очередь была пуста

    public static final int PEEK_NIL = 0; // peek() ещё не вызывалась
    public static final int PEEK_OK = 1; // последняя peek() отработала нормально
    public static final int PEEK_ERR = 2; // очередь была пуста

    // конструктор
    // постусловие: создана новая очередь
    public abstract Queue<T> Queue();

    // команды:

    // постусловие: в конец очереди добавлен новый элемент
    public abstract void add(T t);

    // предусловие: очередь не пуста
    // постусловие: из очереди удален головной элемент
    public abstract void remove();

    // запросы:

    public abstract int size();

    // предусловие: очередь не пуста
    public abstract T peek();


    // дополнительные запросы (возвращение статусов выполнения методов):
    public abstract int get_remove_status();

    public abstract int get_peek_status();
}
