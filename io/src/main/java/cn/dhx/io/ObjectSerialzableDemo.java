package cn.dhx.io;

import cn.dhx.io.entity.People;

import java.io.*;

public class ObjectSerialzableDemo {

    public void ObjectWrite() throws IOException {

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serializableTeat.dat"));

        People people = new People(10,"张三",20);

        outputStream.writeObject(people);
        outputStream.flush();
        outputStream.close();
    }

    public void readWrite() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializableTeat.dat"));


        People p = (People) ois.readObject();
        System.out.println(p);
        ois.close();
    }
}
