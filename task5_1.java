// Задание
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена 
// с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.
import java.util.*;
public class task5_1 {
    private HashMap<String, HashSet<String>> phoneBook;

    public task5_1() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        // Проверяем, есть ли уже такое имя в телефонной книге
        if (phoneBook.containsKey(name)) {
            // Если имя уже есть, добавляем новый номер телефона для этого имени
            phoneBook.get(name).add(phoneNumber);
        } else {
            // Если имени ещё нет, создаем новое множество для хранения номеров телефонов
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public void removeContact(String name) {
        phoneBook.remove(name);
    }

    public void printPhoneBook() {
        // Создаем список пар (имя, множество номеров телефонов)
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список по убыванию числа номеров телефонов
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        // Выводим отсортированный список
        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        task5_1 phoneBook = new task5_1();

        // Добавляем контакты в телефонную книгу
        phoneBook.addContact("Иванов", "1111111");
        phoneBook.addContact("Петров", "2222222");
        phoneBook.addContact("Сидоров", "3333333");
        phoneBook.addContact("Иванов", "4444444");
        phoneBook.addContact("Петров", "5555555");

        // Выводим телефонную книгу
        phoneBook.printPhoneBook();
    }
}