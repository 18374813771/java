package cn.dhx.io;

import java.io.*;

public class BrAndBwOrPwDemo {

    public void copyFileByFileWriter(String srcFileName,String destFileName) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(srcFileName)));

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(destFileName)));

        String line;
        while ((line = reader.readLine()) != null){
            //一行读一次，不识别换行
            System.out.println(line);

            writer.write(line);
            //FileWriter不会识别换行，需要手动换行
            writer.newLine();
            writer.flush();
        }

        reader.close();
        writer.close();
    }

    public void copyFileByPrintWriter(String srcFileName,String destFileName) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(srcFileName)));

        PrintWriter printWriter = new PrintWriter(destFileName);

        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);

            printWriter.println(line);
            printWriter.flush();
        }

        reader.close();
        printWriter.close();
    }
}
