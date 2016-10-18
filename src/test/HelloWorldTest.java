package test;

import main.HelloWorld;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)

public class HelloWorldTest {

    public String sayHello()
    {
        return new HelloWorld().sayHelloWorld();
    }
}
