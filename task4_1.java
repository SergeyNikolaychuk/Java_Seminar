// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке
//  и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа 
// должны быть отрицательными.
// 3)*Реализовать стэк с помощью массива. Нужно реализовать методы:

// size(), empty(), push(), peek(), pop().
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.*;

public class task4_1 {
    public Deque<Integer> multiply(Deque<Integer> num1, Deque<Integer> num2) {
        int n1 = 0, n2 = 0;
        int multiplier = 1;

        // Преобразование первого числа из Deque в int
        while (!num1.isEmpty()) {
            n1 += num1.pollLast() * multiplier;
            multiplier *= 10;
        }

        multiplier = 1;

        // Преобразование второго числа из Deque в int
        while (!num2.isEmpty()) {
            n2 += num2.pollLast() * multiplier;
            multiplier *= 10;
        }

        // Умножение двух чисел
        int result = n1 * n2;

        // Преобразование результата обратно в Deque
        Deque<Integer> resDeque = new ArrayDeque<>();
        while (result > 0) {
            resDeque.offerLast(result % 10);
            result /= 10;
        }

        return resDeque;
    }
}



public class task4_1 {
    public Deque<Integer> add(Deque<Integer> num1, Deque<Integer> num2) {
        int n1 = 0, n2 = 0;
        int multiplier = 1;

        // Преобразование первого числа из Deque в int
        while (!num1.isEmpty()) {
            n1 += num1.pollLast() * multiplier;
            multiplier *= 10;
        }

        multiplier = 1;

        // Преобразование второго числа из Deque в int
        while (!num2.isEmpty()) {
            n2 += num2.pollLast() * multiplier;
            multiplier *= 10;
        }

        // Сложение двух чисел
        int result = n1 + n2;

        // Преобразование результата обратно в Deque
        Deque<Integer> resDeque = new ArrayDeque<>();
        while (result != 0) {
            resDeque.offerLast(Math.abs(result % 10));
            result /= 10;
        }

        return resDeque;
    }
}
public class Stack {
    private int[] arr;
    private int top;

    public Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean empty() {
        return top == -1;
    }

    public void push(int x) {
        if (top < arr.length - 1) {
            arr[++top] = x;
        } else {
            System.out.println("Stack overflow");
        }
    }

    public Integer peek() {
        if (empty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return arr[top];
        }
    }

    public Integer pop() {
        if (empty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return arr[top--];
        }
    }
}