package generics;

public class MyClassGenericTwo<T,V> {

    T t;
    V v;

    public MyClassGenericTwo(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public void getClassName() {
        System.out.println(this.t.getClass().getName() + ", " + this.v.getClass().getName()); //java.lang.Integer, java.lang.Double
//        System.out.println(this.t + ", " + this.v); // 10, 20.0
    }
}
