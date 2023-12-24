package main.oop;

import java.util.List;

public class BoundedStack<T> {
    // скрытые поля
    private List<T> stack; // основное хранилище стека
    private int stackSizeBound; // ограничительный размер стека
    private int peek_status; // статус запроса peek()
    private int pop_status; // статус команды pop()
    private int push_status; // статус команды push()

    // интерфейс класса, реализующий АТД Stack
    public static final int POP_NIL = 0; // push() ещё не вызывалась
    public static final int POP_OK = 1; // последняя pop() отработала нормально
    public static final int POP_ERR = 2; // стек пуст
    public static final int PEEK_NIL = 0; // push() ещё не вызывалась
    public static final int PEEK_OK = 1; // последняя peek() вернула корректное значение
    public static final int PEEK_ERR = 2; // стек пуст
    public static final int PUSH_NIL = 0; // push() ещё не вызывалась
    public static final int PUSH_OK = 1; // последняя push() вернула корректное значение
    public static final int PUSH_ERR = 2; // стек полон

    public static final int defaultStackSizeBound = 32;


    // начальные статусы для предусловий peek() и pop()
    {
        peek_status = PEEK_NIL;
        pop_status = POP_NIL;
        push_status = PUSH_NIL;
    }

    // конструктор без задаваемого ограничения размера стека
    public BoundedStack() {
        this.stackSizeBound = defaultStackSizeBound;
    };

    // конструктор с задаваемым ограничением размера стека
    public BoundedStack(int stackSizeBound) {
        this.stackSizeBound = stackSizeBound;
    };

    public void push(T value) {
        stack.add(value);
        if (this.size() < defaultStackSizeBound) {
            stack.add(value);
            push_status = PUSH_OK;
        } else {
            push_status = PUSH_ERR;
        }
    }

    public void clear() { // пустой список/стек
        stack.clear();
    }

    public int size() {
        return stack.size();
    }

    // запросы статусов
    public int get_pop_status() {
        return pop_status;
    }

    public int get_peek_status() {
        return peek_status;
    }

    public int get_push_status() {
        return push_status;
    }

    public T peek() {
        T result = null;
        if (this.size() > 0) {
            result = stack.get(this.size() - 1);
            peek_status = PEEK_OK;
        } else {
            peek_status = PEEK_ERR;
        }
        return result;
    }

    public void pop() {
        if (this.size() > 0) {
            stack.remove(this.size() - 1);
            pop_status = POP_OK;
        } else {
            pop_status = POP_ERR;
        }
    }
}
