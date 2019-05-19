import cn.dhx.io.CharStream;
import cn.dhx.io.Util.IOUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class IOUtilTest {

    @Test
    public void printHexTest(){
        IOUtil.printHex("E:\\ecpliseWorkspace\\io\\src\\main\\java\\cn\\dhx\\io\\Util\\IOUtil.java");
    }

    @Test
    public void printHexByByteArray(){
        IOUtil.printHexByByteArray("E:\\ecpliseWorkspace\\io\\src\\main\\java\\cn\\dhx\\io\\Util\\IOUtil.java");
    }

    @Test
    public void fileCopyTest() throws IOException {
        File srcFile = new File("E:\\ecpliseWorkspace\\io\\src\\main\\java\\cn\\dhx\\io\\Util\\IOUtil.java");
        File destFile = new File("fileCopy.java");
        IOUtil.fileCopy(srcFile,destFile);
    }


}
