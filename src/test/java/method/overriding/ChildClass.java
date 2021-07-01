package method.overriding;

public class ChildClass extends BaseClass{
	
	@Override
	public void doSomething(String str){
        System.out.println("Child impl:"+str);
    }

}
