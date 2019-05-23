import cn.dhx.reflect.MethodInvoke;
import org.junit.Test;

public class MethodInvokeTest {
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MethodInvoke invoke = new MethodInvoke();

        invoke.methodInvoke(Class.forName("A").newInstance());
    }
}

