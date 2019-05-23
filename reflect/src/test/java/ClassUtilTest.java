import cn.dhx.reflect.ClassUtil;
import org.junit.Test;

public class ClassUtilTest {
    @Test
    public void getClassMessageTest(){
        String  a = "aaa";
        ClassUtil util = new ClassUtil();
        util.getClassMessage(a);
    }

    @Test
    public void getFieldsTest(){
        String  a = "aaa";
        ClassUtil util = new ClassUtil();
        util.getFiledMessage(a);
    }

    @Test
    public void getConstructionsTest(){
        String  a = "aaa";
        ClassUtil util = new ClassUtil();
        util.getConstructors(a);
    }
}
