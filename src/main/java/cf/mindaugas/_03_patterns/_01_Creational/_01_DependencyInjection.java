package cf.mindaugas._03_patterns._01_Creational;

public class _01_DependencyInjection {
    public static void main(String[] args) {
        // ... this is the so called "client code"

        // ... with DI we control the dependencies from "client code"
        // new Car(new Engine(52));
        var c1 = new Car();
        c1.setEngine(new Engine(200));
    }
}

class Engine {
    private double horsePower;

    public Engine(double horsePower) {
        this.horsePower = horsePower;
    }
}

class GasolineEngine extends Engine {
    public GasolineEngine(double horsePower) {
        super(horsePower);
    }
}

//// 0. No dependency injection
//class Car {
//    private Engine engine = new Engine(152);
//    public Car() {}
//}

//// 0. No dependency injection (different variation)
//class Car {
//    private Engine engine;
//    public Car() {
//        this.engine = new Engine(152);
//    }
//}

// 1. Dependency injection (constructor injection + setter injection)
class Car {
    private Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car() {}

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}