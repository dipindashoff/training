package generics;

public class NumericFns<T extends Number>{

    T num;

    public NumericFns(T obj) {
        this.num = obj;
    }

    public double square(){
        // return obj * obj; //Operator '*' cannot be applied to 'T', 'T' (without extends Number)
        // <T extends Number>  --> makes T always a number (not a String)
        return num.intValue() * num.doubleValue();
    }


    // Here, iOb.absValue(dOb);
    // I/P param dOb should also be an integer
    // So I cannot compare an Integer against a Double
    //public boolean absValue(NumericFns<T> ob){
    /*
        Error when it was 'absValue(NumericFns<T> ob)'
        Required type: NumericFns <Integer>
        Provided: NumericFns <Double>
    */
    // Replace NumericFns<T> with NumericFns<?> to accept any type
    // ? can be any Number Integer or Double
    public boolean absValue(NumericFns<?> ob){
        // Absolute value of ob.num == Absolute value of 'num'
        if(Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue()))
            return true;
        return false;
    }
}
