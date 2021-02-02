# Java基础练习整理

## 基础知识 Java_demo_basic

1.1 数据转换 com/jwang/demo_1/data_conversion.java

* 隐式转换 
* 强制转换
    
1.2 运算符 com/jwang/demo_1/Operator.java

* 算术运算符
* 赋值运算符
* 关系运算符
* 逻辑运算符
* 三元运算符
    
1.3 流程控制 com/jwang/demo_1/Control.java

* if
* switch
* for/while/doWhile
* random
    
1.4 数组 com/jwang/demo_2/mArray.java

* idea快捷键 
* 数组
* 二维数组

1.5 方法 com/jwang/demo_2/mMethod.java

* 方法
* 重载（与返回值无关）

1.6 面向对象OOP

* 构造
* 变量
* 对象

1.7 API

* scanner
* String
* StringBuilder

1.8 集合

* ArrayList

1.9 git

## 掌握知识  knowledge_demo

* 1 标准类: 符合JavaBean的公共类 com/jwang/demo_1/Standard_Student.java
* 2 匿名对象 com/jwang/demo_1/Anonymous_OOP.java
* 3 继承 com/jwang/demo_2
* 4 方法重写 
* 5 this/super 
* 6 抽象类 com/jwang/demo_3
* 7 模版设计模式:抽象类及其实现类
* 8 final关键字 com/jwang/dmeo_4/Final_test.java
* 9 static关键字 com/jwang/dmeo_4/Static_Test.java
* 10 接口(7:常量+抽象 8：默认+静态 9：私有) com/jwang/demo_5 
* 11 多态 com/jwang/demo_5
* 12 引用类型转型 com/jwang/demo_5
* 13 内部类 com/jwang/demo_6
* 14 匿名内部类 com/jwang/demo_6
* 15 类名作为参数和返回值都是其地址值，抽象类作为方法的参数和返回值（需要传入和返回该抽象类的子类对象，即匿名内部类）
* 16 权限修饰符 com/jwang/demo_7
* 17 代码块

## 集合 connections_demo/

### 字符串

* 1 String /demo_1
* 2 StringBuild (初始容量16)

### 单列集合 

* Collection
* 3 ArrayList  demo_2
* 单列集合
* 迭代器
* 增强for循环
* 泛型:限制数据类型  //泛型通配符
* List接口
* Collections工具类
* 可变参数...
* set集合

### 双列集合

* Map接口
* HashMap
* LinkedHashMap
* TreeMap
* Map遍历
* 字符串按照字典排序

## API API_demo

* Object  com/jwang/demo_object
* Date DateFormat(abstract) com/jwang/demo_date
* Calendar(abstract)
* Math (static)
* System (static)
* BigInteger com/jwang/demo_Big_
* BigDecimal
* Arrays(static)
* 包装类
* 基本类型--字符串：（+空字符串）/（valueOf(任意数据类型) -- static）// parseXxx(String s)--static 

## 排序算法、异常、多线程

### 排序算法 SEC_demo/com/jwang/sort_demo

* 冒泡排序 
* 选择排序
* 二分查找

### 异常 SEC_demo/com/jwang/Exception_demo

* 异常
* 异常捕获
* 异常处理
* 自定义异常

### 并发与并行 SEC_demo/com/jwang/Cu_demo/Thread_demo.java

* 并发：交替执行
* 并行：同时执行

* 进程：应用程序的可执行单元，每个进行都有独立的内存空间，一个应用程序可以有多个进程，一个Java程序其实就是一个进程，一个进程一次只能执行一个线程--Java只有高并发
* 线程：进程的一个执行单元，一个进程至少又一个线程，线程也是独立内存空间

* 线程调度： 分时调度（轮流使用cpu和分配时间） 抢占式调度（优先级高的线程先使用，优先级相同-随机）（Java使用抢占式）

* Thread类

## 线程安全、volatile、原子性，并发包、死锁、线程池 SVA_demo/

* 多条线程操作共享变量，会出现混乱问题--线程调度为抢占式 
* synchronized关键字:悲观锁-重量级锁 同步 将"多行代码"进行同步，只有这一块执行完才会执行下一个线程 S_demo/sync_demo.java
* Lock锁：同步锁，加锁、释放锁方法化 S_demo/sync_demo.java
* 同步代码块与同步方法共用--锁对象选择 S_demo/sync_demo.java
* 多线程安全性问题--可见性、有序性、原子性 Soft_demo/soft_main.java
* volatile关键字 --可以解决原子性，可同时执行，用于变量上
* 原子类 atomic atomic_demo/Atomic_demo.java
* 并发包 COMASoft_demo/CopyOnWriteArrayXX_main.java
* 线程池 ThreadTool_demo
* 死锁:多个线程中，使用多把锁，造成线程间等待，有同步代码块嵌套 -- 可能出现

* 线程状态 -- 6种 new--Runnable（start（））--Blocked锁阻塞--waiting（调用wait()）--Timed Waiting计时等待 锁对象调用wait(time)/sleep()--Terminated(run()终止，或者产生异常)、

> 调用wait（）和notify都需要使用相同的锁对象
> 使用锁对象调用wait（）进入无限等待，再使用锁对象调用notify被唤醒判断是否获取到锁，没锁--锁阻塞，有锁--runnable
> 线程调用Thread.sleep方法--计时等待 时间到--runnable  ｜ 锁对象调用wait(timeout) -- 计时等待 时间到，判断锁，时间没到被其他线程唤醒，判断锁

* 等待唤醒机制--多线程之间的一种协作机制 wait/notify  让线程依次进入无限等待，再唤醒 WaitNotify_demo/WN_main.java

>生产者--消费者案例
>使用锁对象调用wait进入无限等待
>使用相同锁对象notify/notifyAll唤醒对应线程进入无限等待
>若一个线程释放了锁，它还是会去竞争锁
>在同步代码中调用sleep方法，不会释放锁，只是不抢占cpu

* Lambda表达式  Lambda_demo/Lambda_main.java
* Stream流  Stream_demo/Stream_main.java

## 文件操作，IO流 IOandFile

* file 类 IOandFile/src/File_demo
* 递归

* IO流 IOandFile/src/IO_demo
* 字节流 IOandFile/src/IO_demo
* 字符流 IOandFile/src/IO_demo

* IO异常处理
* 属性集-Properties类
* 缓冲流 -- 对输入输出流进行增强，BufferedXXX 会默认创建一个缓冲字节数组：8192大小 --读写效率快
* 转换流 -- 字符编码、字符集 解决乱码问题等
* 序列化和反序列流 -- 使用字节序列表示一个对象，持久保存和读取一个对象的信息 ObjectInputStream/ObjectOutputStream
* 打印流 --PrintStream
* 装饰器模式 : 不改变原类，不使用继承的基础上动态扩展一个对象的功能
* commons-io工具包： apache提供的有关IO操作的类库


## 网络编程、NIO

* 网络编程三要素：ip,tcp/udp,端口
* InetAddress类：IP地址对象 静态方法：getLocalHost/getByName(String Host) -- 主机名获取ip /getHostName/getHostAddress
* tcp协议：面相连接 Socket(客服端)-IO流-ServerSocket（服务端）
* c/s
* b/s：注意图片上传需要开启线程
* 同步与异步

> 同步：调用方法后，必须有一个返回值
>
>异步：调用方法后，不需要返回值，但有一个回调函数（满足条件后自动执行的方法）
>
* 阻塞和非阻塞

> 阻塞：若没有达到方法的目的，就会一直等待：ServerSocket的accept方法
>
>非阻塞：不管方法有没有达到目的，都直接往下执行
>
>IO：同步阻塞 --面相流  Java1。4 面相块：NIO：同步非阻塞--Buffer/Channel/Selector，Java1.7: （NIO 2）AIO：异步非阻塞

* Buffer类（缓冲区）-- nio.Buffer：是一个对象，对基本类型的数组进行封装：ByteBuffer,CharBuffer,NIO中通过Buffer读取数据，所有数据通过Buffer来处理，为NIO读写数据的中转池
* Channel
* Selector




    