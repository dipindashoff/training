package generics;

public class MyClassGeneric<T> {

    T i;

    public MyClassGeneric(T i) {
        this.i = i;
    }

    public void print() {
        System.out.println(this.i);
    }
}
