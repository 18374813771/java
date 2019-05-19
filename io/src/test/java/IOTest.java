import cn.dhx.io.*;
import org.junit.Test;

import java.io.IOException;

public class IOTest {

    @Test
    public void fileTest() throws IOException {
        FileDemo fileDemo = new FileDemo();
        fileDemo.file();
    }

    @Test
    public void rafDemoTest() throws IOException{
        RafDemo rafDemo = new RafDemo();
        rafDemo.raf();
    }

    @Test
    public void fileOutWriteTest() throws IOException{
        String fileName = "write.txt";

        FileOutDemo demo = new FileOutDemo();
        demo.fileOutWrite(fileName);
    }

    @Test
    public void dataOutputTest() throws IOException{
        DataStreamDemo dataStreamDemo = new DataStreamDemo();
        dataStreamDemo.dateOutput("dataStreamDemo.txt");
    }

    @Test
    public void dataInputTest() throws IOException{
        DataStreamDemo dataStreamDemo = new DataStreamDemo();
        dataStreamDemo.dataInput("dataStreamDemo.txt");
    }

    @Test
    public void charStreamTest() throws IOException {
        String fileName = "E:\\ecpliseWorkspace\\io\\src\\main\\java\\cn\\dhx\\io\\Util\\IOUtil.java";
        CharStream stream = new CharStream();
        stream.charSteamDemo(fileName);
    }

    @Test
    public void fileReaderAndWriterTest() throws IOException {
        String fileName = "E:\\ecpliseWorkspace\\io\\src\\main\\java\\cn\\dhx\\io\\Util\\IOUtil.java";
        FileReaderAndWriter readerAndWriter = new FileReaderAndWriter();
        readerAndWriter.fileReaderAndWriter(fileName);
    }

    @Test
    public void copyFileByFileWriterTest() throws IOException {
        String srcfileName = "E:\\ecpliseWorkspace\\io\\src\\main\\java\\cn\\dhx\\io\\Util\\IOUtil.java";
        BrAndBwOrPwDemo demo = new BrAndBwOrPwDemo();
        demo.copyFileByFileWriter(srcfileName,"fileWriterTest.java");
    }

    @Test
    public void copyFileByPrintWriterTest() throws IOException {
        String srcfileName = "E:\\ecpliseWorkspace\\io\\src\\main\\java\\cn\\dhx\\io\\Util\\IOUtil.java";
        BrAndBwOrPwDemo demo = new BrAndBwOrPwDemo();
        demo.copyFileByPrintWriter(srcfileName,"printWriterTest.java");
    }
}
