package main.oop;

public abstract class LinkedList<T> {

    //статусы выполнения методов
    public static final int IS_HEAD_NIL = 0; // is_head() ещё не вызывалась
    public static final int IS_HEAD_OK = 1; // последняя is_head() отработала нормально
    public static final int IS_HEAD_ERR = 2; // список пуст

    public static final int IS_TAIL_NIL = 0; // is_tail() ещё не вызывалась
    public static final int IS_TAIL_OK = 1; // последняя is_tail() отработала нормально
    public static final int IS_TAIL_ERR = 2; // список пуст

    public static final int GET_NIL = 0; // get() ещё не вызывалась
    public static final int GET_OK = 1; // последняя get() отработала нормально
    public static final int GET_ERR = 2; // список пуст

    public static final int FIND_NIL = 0; // find() ещё не вызывалась
    public static final int FIND_OK = 1; // последняя find() отработала нормально, искомое значение найдено, курсор на соответстующем узле
    public static final int FIND_NOT_FOUND = 3; // последняя find() отработала нормально, искомое значение не найдено, курсор на хвосте
    public static final int FIND_ERR = 2; // список пуст

    public static final int REPLACE_NIL = 0; // replace() ещё не вызывалась
    public static final int REPLACE_OK = 1; // последняя replace() отработала нормально
    public static final int REPLACE_ERR = 2; // список пуст

    public static final int REMOVE_NIL = 0; // remove() ещё не вызывалась
    public static final int REMOVE_OK = 1; // последняя remove() отработала нормально
    public static final int REMOVE_ERR = 2; // список пуст

    public static final int PUT_RIGHT_NIL = 0; // put_right() ещё не вызывалась
    public static final int PUT_RIGHT_OK = 1; // последняя put_right() отработала нормально
    public static final int PUT_RIGHT_ERR = 2; // список пуст

    public static final int PUT_LEFT_NIL = 0; // put_left() ещё не вызывалась
    public static final int PUT_LEFT_OK = 1; // последняя put_left() отработала нормально
    public static final int PUT_LEFT_ERR = 2; // список пуст

    public static final int HEAD_NIL = 0; // head() ещё не вызывалась
    public static final int HEAD_OK = 1; // последняя head() отработала нормально
    public static final int HEAD_ERR = 2; // список пуст

    public static final int TAIL_NIL = 0; // tail() ещё не вызывалась
    public static final int TAIL_OK = 1; // последняя tail() отработала нормально
    public static final int TAIL_ERR = 2; // список пуст

    public static final int RIGHT_NIL = 0; // right() ещё не вызывалась
    public static final int RIGHT_OK = 1; // последняя right() отработала нормально
    public static final int RIGHT_OVERBOUNDING = 3; // узлы справа отсутствуют
    public static final int RIGHT_ERR = 2; // список пуст

    // конструктор
    public abstract LinkedList<T> LinkedList(); // постусловие: создан новый связный список

    // команды:

    // предусловие: список не пустой
    // постусловие: курсор установлен на первый узел в списке
    public abstract void head();

    // предусловие: список не пустой
    // постусловие: курсор установлен на последний узел в списке
    public abstract void tail();

    // предусловие: список не пустой
    // предусловие: курсор не установлен на последний узел в списке
    // постусловие: курсор сдвинут на один узел вправо
    public  abstract void right();

    // предусловие: список не пустой
    // постусловие: за текущим узлом вставлен новый узел с заданным значением
    public  abstract void put_right(T t);

    // предусловие: список не пустой
    // постусловие: перед текущим узлом вставлен новый узел с заданным значением
    public  abstract void put_left(T t);

    // предусловие: список не пустой;
    // постусловие: текущий узел удален, курсор смещается к правому соседу, если он есть, в противном случае
    //                  курсор смещается к левому соседу, если он есть
    public abstract void remove();

    // постусловие: из списка удалятся все узлы
    public abstract void clear();

    // постусловие: в хвост списка добавлен новый узел
    public abstract void add_tail(T t);

    // предусловие: список не пустой;
    // постусловие: значение текущего узла заменено на заданное
    public abstract void replace(T t);

    // предусловие: список не пустой;
    // постусловие: курсор установлен на следующий узел
    //                  с искомым значением (по отношению к текущему узлу), если он есть,
    //                  либо на последний узел в списке
    public abstract void find(T t);

    // постусловие: в списке отсутствуют все узлы с заданным значением
    public abstract void remove_all(T t);

    // запросы:

    // предусловие: список не пустой
    public abstract T get();

    public abstract int size();

    // предусловие: список не пустой
    public abstract boolean is_tail();

    // предусловие: список не пустой
    public abstract boolean is_head();

    public abstract boolean is_value();


    // дополнительные запросы (возвращение статусов выполнения методов):
    public abstract int get_is_head_status();
    public abstract int get_is_tail_status();
    public abstract int get_get_status();
    public abstract int get_find_status();
    public abstract int get_replace_status();
    public abstract int get_remove_status();
    public abstract int get_put_right_status();
    public abstract int get_put_left_status();
    public abstract int get_right_status();
    public abstract int get_head_status();
    public abstract int get_tail_status();
}
