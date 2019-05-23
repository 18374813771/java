import cn.dhx.reflect.Generosity;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class GenerosityTest {
    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Generosity generosity = new Generosity();
        generosity.testGenerosity();
    }
}
