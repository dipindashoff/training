package generics;

public class MyClassGeneric<T> {

    T t;

    public MyClassGeneric(T t) {
        this.t = t;
    }

    public void print() {
        System.out.println(this.t);
    }
}
