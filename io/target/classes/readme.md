# java IO
java.io.File
- File类只用于表示文件（目录）的信息（名称，大小等），不能用于文件内容的访问

RandomAccessFile 
   
  - java提供的对文件访问的类，即可以读文件也可以写文件。
  - 支持随机访问文件可以访问文件的任意位置。
  
java文件模型
- 在硬盘上的文件是以byte byte byte方式存储的 

>打开文件有两种方式 “rw(读写)”，“r(只读)”
RandomAccessFile raf = new RandomAccessFile(file,"rw");
文件指针，打开文件时指针在开头 point = 0;
写文件 raf.write(int);只写一个字节（后八位）同时指针指向下一个位置。准备再次写入。
读文件
int b = raf.read(),一次只读一个字节。
- 文件读取完成之后一定要关闭。

##IO流(输入流，输出流)
### 字节流，字符流
#### 字节流
- InputStream,OutputStream（抽象类）
  > InputStream 抽象了应用程序读取数据的方式。
    OutputStream 抽象了应用程序写出数据的方式。

- EOF = END 读到-1就是读到结尾。

- 输入流基本方式
  > int b = in.read()读取一个字节无符号，填充到int低八位，-1是EOF
    in.read(byte[] buf)  读取数据填充到字节数组buf
    in.read(byte[] buf,int  start,int size)  读取数据到字节buf，从buf的start位置开始，读取size的长度。

- 输出流基本方式
  > out.write(int b)写出一个byte到流，b的低八位。（一个int32位）
    out.write(byte[] buf)将字节数组buf的内容都写入到流
    out.write(byte[] buf,int  start,int size)  字节数组buf从start位置开始写size的长度字节到流。
    
    
- FileInputStream 继承自InputStream ----->具体实现了在文件上读取数据
- FileOutputStream OutputStream ----->具体实现了往文件中写入数据

- DataInputStream/DataOutputStream
  >对“流”功能的扩展，通过装饰模式，可以更加方便的读取int,long,字符的数据类型。
  >对“流”功能的扩展，通过装饰模式，可以更加方便的读取int,long,字符的数据类型。
  DataOutputStream
         writeInt()/writeDouble/WriteUTF()
- BufferedInputStream&BufferedOutputStream
 >  这两个流类位IO提供了带缓冲区的操作，一般打开文件进行写入
 或读取操作时，都会加上缓冲，这种流模式提高了IO的性能
 从应用程序中把输入放入文件，相当于将一缸水倒入到另一个缸中:
 FileOutputStream--->write()方法相当于一滴一滴地把水“转移”过去
 DataOutputStream-->writeXxx()方法会方便一些，相当于一瓢一瓢把水“转移”过去
 BufferedOutputStream--->write方法更方便，相当于一飘一瓢先放入桶中，再从桶中倒入到另一个缸中，性能提高了
  
  ## 字符流
  
  - 编码问题
  - 文本和文本文件
  > java的文本(char)是16位无符号整数,使用的是Unicode编码（双字符编码）
     文件是byte byte byte...的数据序列。
     文本文件是文本（char）序列是按照某种编码方式（gbk,utf-16be,utf-8）序列化为byte的储存结果。
    
  - 字符流（Reader,Writer）---> 通常操作的是文本文件
    > 字符的处理：一次处理一个字符。
      字符流的底层实现依然是基本的字节流
      字符流的基本实现：
      InputStreamReader()   完成byte的解析为char流，按照编码解析
      OutputStreamWriter()  提供char流到byte流，按照编码解析
      FileReader()/FileWriter()
      
  - 字符流的过滤器
  > BufferedReader  --->可进行一次读一行操作
    BufferedWriter/PrintWriter --->(可进行一次写一行操作)
  
### 对象的序列化，反序列化
    
  - 对象序列化就是将object转化为byte序列，反之叫反序列化。
  - 序列化流（ObjectOutputStream）是过滤流 ---writeObject
            ObjectInputStream ---- readObject
  - 序列化接口(Serializable) 
    对象必须实现序列化接口 ，才能进行序列化，否则将出现异常
       这个接口，没有任何方法，只是一个标准
  
  - transient关键字  关键字不会进行虚拟机默认的序列化，但是可以自己完成元素的序列化
  > private void writeObject(java.io.ObjectOutputStream s)
  		        throws java.io.IOException
  	private void readObject(java.io.ObjectInputStream s)
  		        throws java.io.IOException, ClassNotFoundException
  		        
     分析ArrayList源码中序列化和反序列化的问题
   
  5)序列化中 子类和父类构造函数的调用问题
  > 如果父类实现了序列化接口，子类反序列化时不会调用父类构造器
    如果父类没实现构造器，子类实现了序列化接口，子类反序列化时会调用父类构造器。