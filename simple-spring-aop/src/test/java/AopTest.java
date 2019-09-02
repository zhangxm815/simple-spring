import com.example.aop.Hello;
import com.example.aop.HelloImpl;
import com.example.aop.advice.AfterAdvice;
import com.example.aop.advice.BeforeAdvice;
import com.example.aop.proxy.SpringProxy;
import com.example.aop.supper.MethodHolder;

public class AopTest {
    public static void main(String[] args) {
        MethodHolder mh = () -> System.out.println("say");
        Hello hello = new HelloImpl();
        Hello hello2 = (Hello) SpringProxy.getProxy(hello, new BeforeAdvice(hello, mh));
        Hello hello1 = (Hello) SpringProxy.getProxy(hello, new AfterAdvice(hello, mh));
        hello2.sayHello();
    }
}