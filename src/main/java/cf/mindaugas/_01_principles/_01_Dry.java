package cf.mindaugas._01_principles;

import java.util.Arrays;

// is-a
class Person {
    private int id;
    private String name;
    private String surname;
    public int age;

    public Person(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}

class Employee extends Person {
    private double salary;
    public Employee(int id, String name, String surname, int age, double salary) {
        super(id, name, surname, age);
        this.salary = salary;
    }
}

class Student extends Person {
    public Student(int id, String name, int age, String surname) {
        super(id, name, surname, age);
    }
}

public class _01_Dry {
    // DRY with functions
    public static void bubbleSortAsc(Person arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].age > arr[j + 1].age) {
                    Person temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDesc(Person arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].age < arr[j + 1].age) {
                    Person temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDry(Person arr[], boolean reverse) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (reverse) {
                    if (arr[j].age > arr[j + 1].age) {
                        Person temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (arr[j].age < arr[j + 1].age) {
                        Person temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Person[] people = {
                new Person(1, "A", "A1", 21),
                new Person(2, "A", "A2", 22),
                new Person(3, "A", "A3", 23),
        };

        System.out.println(Arrays.asList(people));
        bubbleSortDry(people, false);
        System.out.println(Arrays.asList(people));
    }
}
