import cn.dhx.io.Util.FileUtil;
import org.junit.Test;

import java.io.File;

public class FileUtilTest {

    @Test
    public void listDirectoryTest(){
        File file = new File("E:\\ecpliseWorkspace");
        FileUtil fileUtil = new FileUtil();
        fileUtil.listDirectory(file);
    }
}
