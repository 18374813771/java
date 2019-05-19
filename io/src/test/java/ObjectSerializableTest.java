import cn.dhx.io.ObjectSerialzableDemo;
import org.junit.Test;

public class ObjectSerializableTest {

    @Test
    public void objectWriteTest() throws Exception{
        ObjectSerialzableDemo demo = new ObjectSerialzableDemo();
        demo.ObjectWrite();
    }

    @Test
    public void objectReadTest() throws Exception{
        ObjectSerialzableDemo demo = new ObjectSerialzableDemo();
        demo.readWrite();
    }
}
