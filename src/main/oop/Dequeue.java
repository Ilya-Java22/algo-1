package main.oop;

public abstract class Dequeue<T> extends ParentQueue<T> {
    // конструктор
    // постусловие: создана новая двусторонняя очередь
    public abstract Queue<T> Queue();

    // команды:

    // постусловие: в начало очереди добавлен новый элемент
    public abstract void addHead(T t);

    // предусловие: очередь не пуста
    // постусловие: из очереди удален хвостовой элемент
    public abstract void removeTail();

    // запросы:

    public abstract int size();

    // предусловие: очередь не пуста
    public abstract T peekTail();


    // дополнительные запросы (возвращение статусов выполнения методов):
    public abstract int get_removeTail_status();

    public abstract int get_peekTail_status();
}
