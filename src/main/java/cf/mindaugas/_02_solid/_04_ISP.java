package cf.mindaugas._02_solid;


import java.util.ArrayList;

interface Collection {
    void init();
    void get();
    void add();
    void addSeveral();
    void remove();
    void removeAll();
}

interface ImmutableCollection {
    void init();
    void get();
}

interface MutableCollection extends ImmutableCollection {
    void add();
    void addSeveral();
    void remove();
    void removeAll();
}

public class _04_ISP {
    public static void main(String[] args) {
    }
}
