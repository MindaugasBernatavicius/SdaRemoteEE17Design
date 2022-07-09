package cf.mindaugas;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList(){{
            add(1);
        }};

        System.out.println(a);
    }
}
