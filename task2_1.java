// Реализуйте алгоритм сортировки пузырьком числового массива,
//  результат после каждой итерации запишите в лог-файл.
import java.io.FileWriter;
import java.io.IOException;
public class task2_1 { public static void main(String[] args) {
    int[] array = {5, 8, 2, 1, 6};

    // Вызываем метод сортировки пузырьком и передаем массив
    bubbleSort(array);
}

public static void bubbleSort(int[] array) {
    int n = array.length;
    boolean swapped;
   
    try (FileWriter writer = new FileWriter("log.txt")) {
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Меняем элементы местами
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
           
            // Записываем текущий массив в лог-файл
            writeArrayToLog(writer, array);
           
            // Если во внутреннем цикле не было обменов, то массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void writeArrayToLog(FileWriter writer, int[] array) throws IOException {
    for (int num : array) {
        writer.write(num + " ");
    }
    writer.write(System.lineSeparator());
}
}

