import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->
// К калькулятору из предыдущего дз добавить логирование.


public class task2_2 {public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        System.out.print("Введите первое число: ");
        int numb_a = sc.nextInt();
        System.out.println("Введите операцию + - / *: ");
        char operation = sc.next().charAt(0);
        System.out.print("Введите второе число: ");
        int numb_b = sc.nextInt();
       
        int res;
        FileWriter writer = new FileWriter("log.txt", true); 
         // Открываем файл calc_log.txt для логирования
       
        switch (operation) {
            case '+':
                res = numb_a + numb_b;
                System.out.printf("Результат: %d ",res);
                writeArrayToLog(writer, res);
                break;
            case '-':
                res = numb_a - numb_b;
                System.out.printf("Результат: %d ",res);
                writeArrayToLog(writer, res);
                break;
            case '/':
                res = numb_a / numb_b;
                System.out.printf("Результат: %d ",res);
                writeArrayToLog(writer, res);
                break;
            case '*':
                res = numb_a * numb_b;
                System.out.printf("Результат: %d ",res);
                writeArrayToLog(writer, res);
                break;
        }
       
        writer.close();  // Закрываем файл после завершения логирования
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void writeArrayToLog(FileWriter writer, int num) throws IOException {
    writer.write(num + " ");
    writer.write(System.lineSeparator());
}
}
    