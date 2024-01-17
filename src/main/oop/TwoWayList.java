package main.oop;

public abstract class TwoWayList<T> extends ParentList<T> {

    //статусы выполнения методов
    public static final int LEFT_NIL = 0; // left() ещё не вызывалась
    public static final int LEFT_OK = 1; // последняя left() отработала нормально
    public static final int LEFT_OVERBOUNDING = 3; // узлы слева отсутствуют
    public static final int LEFT_ERR = 2; // список пуст

    //команда
    // предусловие: список не пустой
    // предусловие: курсор не установлен на первый узел в списке
    // постусловие: курсор сдвинут на один узел влево
    public abstract void left();

    // дополнительные запросы (возвращение статусов выполнения методов):
    public abstract int get_left_status();
}
