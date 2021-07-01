package maven;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JavaHelloWorldTestNg {

    @Test
    public void testHelloWorld() {
            JavaHelloWorld javaHelloWorld = new JavaHelloWorld();
            assertEquals("Hello World", javaHelloWorld.getWorld());
    }

}