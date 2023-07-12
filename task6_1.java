// Задание.
// 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
//  Реализовать в java.
// 2. Создать множество ноутбуков.
// 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
//  Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить
//  параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
import java.util.*;
import java.util.stream.Collectors;

public class task6_1 {
    private String brand;
    private String model;
    private int ram; 
    private int storage;
    private String os; 
    private String color;
    
    public task6_1(String brand, String model, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        task6_1 notebook = (task6_1) o;
        return ram == notebook.ram &&
                storage == notebook.storage &&
                Objects.equals(brand, notebook.brand) &&
                Objects.equals(model, notebook.model) &&
                Objects.equals(os, notebook.os) &&
                Objects.equals(color, notebook.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, ram, storage, os, color);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

class NotebookShop {
    private List<task6_1> notebooks;

    public NotebookShop(List<task6_1> notebooks) {
        this.notebooks = notebooks;
    }

    public List<task6_1> filterNotebooks() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the minimum RAM size (in GB): ");
            int minRam = scanner.nextInt();

            System.out.println("Enter the color: ");
            String color = scanner.next();

            System.out.println("Enter the minimum storage size (in GB): ");
            int minStorage = scanner.nextInt();

            return notebooks.stream()
                    .filter(notebook -> notebook.getRam() >= minRam)
                    .filter(notebook -> notebook.getColor().equalsIgnoreCase(color))
                    .filter(notebook -> notebook.getStorage() >= minStorage)
                    .collect(Collectors.toList());
        }
    }
}

 class Main {
    public static void main(String[] args) {
        List<task6_1> notebooks = new ArrayList<>();
        notebooks.add(new task6_1("Lenovo", "IdeaPad", 8, 512, "Windows", "Black"));
        notebooks.add(new task6_1("Apple", "MacBook Pro", 16, 1024, "macOS", "Silver"));
        notebooks.add(new task6_1("Dell", "XPS", 16, 512, "Windows", "White"));
        notebooks.add(new task6_1("Asus", "ROG", 32, 1024, "Windows", "Black"));

        NotebookShop shop = new NotebookShop(notebooks);
        List<task6_1> filteredNotebooks = shop.filterNotebooks();
        for(task6_1 notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }
}