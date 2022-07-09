package cf.mindaugas._02_solid;

// final
class Person {}

class Janitor extends Person { }

public class _02_OCP {
    public static void main(String[] args) {
        System.out.println(new Janitor());
    }
}
