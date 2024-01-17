package main.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class ParentList<T> {

    // скрытые поля
    private List<T> list; // основное хранилище
    private int cursorPosition; // расположение курсора
    // статусы запросов
    private int is_head_status;
    private int is_tail_status;
    private int get_status;
    private int find_status;
    private int replace_status;
    private int remove_status;
    private int put_right_status;
    private int put_left_status;
    private int head_status;
    private int tail_status;
    private int right_status;

    // начальные статусы для методов с предусловиями
    {
        is_head_status = IS_HEAD_NIL;
        is_tail_status = IS_TAIL_NIL;
        get_status = GET_NIL;
        find_status = FIND_NIL;
        replace_status = REPLACE_NIL;
        remove_status = REMOVE_NIL;
        put_right_status = PUT_RIGHT_NIL;
        put_left_status = PUT_LEFT_NIL;
        head_status = HEAD_NIL;
        tail_status = TAIL_NIL;
        right_status = RIGHT_NIL;
    }

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
    // постусловие: создан новый связный список
    public ParentList() {
        clear();
    };

    // команды:

    // предусловие: список не пустой
    // постусловие: курсор установлен на первый узел в списке
    public void head() {
        if (size() > 0) {
            cursorPosition = 0;
            head_status = HEAD_OK;
        } else {
            head_status = HEAD_ERR;
        }
    };

    // предусловие: список не пустой
    // постусловие: курсор установлен на последний узел в списке
    public void tail() {
        int listSize = size();
        if (listSize > 0) {
            cursorPosition = listSize - 1;
            tail_status = TAIL_OK;
        } else {
            tail_status = TAIL_ERR;
        }
    };

    // предусловие: список не пустой
    // предусловие: курсор не установлен на последний узел в списке
    // постусловие: курсор сдвинут на один узел вправо
    public  void right() {
        int listSize = size();
        if (listSize == 0) {
            right_status = RIGHT_ERR;
            return;
        }
        if (cursorPosition == listSize - 1) {
            right_status = RIGHT_OVERBOUNDING;
            return;
        }
        cursorPosition++;
        right_status = RIGHT_OK;
    };

    // предусловие: список не пустой
    // постусловие: за текущим узлом вставлен новый узел с заданным значением
    public  void put_right(T t) {
        if (size() > 0) {
            list.add(++cursorPosition, t);
            put_right_status = PUT_RIGHT_OK;
        } else {
            put_right_status = PUT_RIGHT_ERR;
        }
    };

    // предусловие: список не пустой
    // постусловие: перед текущим узлом вставлен новый узел с заданным значением
    public  void put_left(T t) {
        if (cursorPosition != 0) {
            --cursorPosition;
        }
        if (size() > 0) {
            list.add(cursorPosition, t);
            put_left_status = PUT_LEFT_OK;
        } else {
            put_left_status = PUT_LEFT_ERR;
        }
    };

    // предусловие: список не пустой;
    // постусловие: текущий узел удален, курсор смещается к правому соседу, если он есть, в противном случае
    //                  курсор смещается к левому соседу, если он есть
    public void remove() {
        if (size() == 0) {
            remove_status = REMOVE_ERR;
            return;
        }
        list.remove(cursorPosition);
        if (size() == 0) {
            cursorPosition = -1;
        } else if (cursorPosition == size()) {
            --cursorPosition;
        }
        remove_status = REMOVE_OK;
    };

    // постусловие: из списка удалятся все узлы
    public void clear() {
        list = new ArrayList<>();
        cursorPosition = -1;
    };

    // постусловие: в хвост списка добавлен новый узел
    public void add_tail(T t) {
        tail();
        put_right(t);
    };

    // предусловие: список не пустой;
    // постусловие: значение текущего узла заменено на заданное
    public void replace(T t) {
        if (size() > 0) {
            put_left(t);
            right();
            remove();
            replace_status = REPLACE_OK;
        } else {
            replace_status = REPLACE_ERR;
        }
    };

    // предусловие: список не пустой;
    // постусловие: курсор установлен на следующий узел
    //                  с искомым значением (по отношению к текущему узлу), если он есть,
    //                  либо на последний узел в списке
    public void find(T t) {
        if (list.size() == 0) {
            find_status = FIND_ERR;
            return;
        }
        for (int i = cursorPosition; i < size(); i++) {
            if (get() == t) {
                find_status = FIND_OK;
                return;
            }
        }
        find_status = FIND_NOT_FOUND;
    };

    // постусловие: в списке отсутствуют все узлы с заданным значением
    public void remove_all(T t) {
        while (cursorPosition < size()) {
            if (get() == t) {
                remove();
                continue;
            }
            cursorPosition++;
        }
    };

    // запросы:

    // предусловие: список не пустой
    public T get() {
        if (size() > 0) {
            get_status = GET_OK;
            return list.get(cursorPosition);
        } else {
            get_status = GET_ERR;
            return null;
        }
    };

    public int size() {
        return list.size();
    };

    // предусловие: список не пустой
    public boolean is_tail() {
        if (size() > 0 && cursorPosition == size() - 1) {
            is_tail_status = TAIL_OK;
            return true;
        } else {
            is_tail_status = TAIL_ERR;
            return false;
        }
    };

    // предусловие: список не пустой
    public boolean is_head() {
        if (size() > 0 && cursorPosition == 0) {
            is_head_status = HEAD_OK;
            return true;
        } else {
            is_head_status = HEAD_ERR;
            return false;
        }
    };

    public boolean is_value() {
        return cursorPosition != -1;
    };


    // дополнительные запросы (возвращение статусов выполнения методов):
    public int get_is_head_status() {
        return is_head_status;
    };

    public int get_is_tail_status() {
        return is_tail_status;
    };

    public int get_get_status() {
        return get_status;
    };

    public int get_find_status() {
        return find_status;
    };

    public int get_replace_status() {
        return replace_status;
    };

    public int get_remove_status() {
        return remove_status;
    };

    public int get_put_right_status() {
        return put_right_status;
    };

    public int get_put_left_status() {
        return put_left_status;
    };

    public int get_right_status() {
        return right_status;
    };

    public int get_head_status() {
        return head_status;
    };

    public int get_tail_status() {
        return tail_status;
    };
}
