package cf.mindaugas._03_patterns._03_Behavioral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _02_Strategy {
    private static void printContents(List<Persona> people) {
        for (Persona person : people) {
            System.out.println(person.getName());
        }
    }

    public static void main(String[] args) {
        Persona bryan = new Persona("Bryan", "801-555-1212", 39);
        Persona mark = new Persona("Mark", "801-444-1234", 41);
        Persona chris = new Persona("Chris", "801-222-5151", 38);

        List<Persona> people = new ArrayList<>();
        people.add(bryan);
        people.add(mark);
        people.add(chris);


        System.out.println("Not sorted");
        printContents(people);

        // Collections.sort(people, new Comparator<Persona>() {
        //     @Override
        //     public int compare(Persona o1, Persona o2) {
        //         return o1.getAge() - o2.getAge();
        //     }
        // });

        Collections.sort(people, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        System.out.println("\nAfter sorting");
        printContents(people);
    }
}

class Persona {
    private int age;
    private String name;
    private String phoneNumber;

    public Persona() {
    }

    public Persona(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}