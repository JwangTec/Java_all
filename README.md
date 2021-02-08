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
>
> 使用锁对象调用wait（）进入无限等待，再使用锁对象调用notify被唤醒判断是否获取到锁，没锁--锁阻塞，有锁--runnable
>
> 线程调用Thread.sleep方法--计时等待 时间到--runnable  ｜ 锁对象调用wait(timeout) -- 计时等待 时间到，判断锁，时间没到被其他线程唤醒，判断锁

* 等待唤醒机制--多线程之间的一种协作机制 wait/notify  让线程依次进入无限等待，再唤醒 WaitNotify_demo/WN_main.java

>生产者--消费者案例
>
>使用锁对象调用wait进入无限等待
>
>使用相同锁对象notify/notifyAll唤醒对应线程进入无限等待
>
>若一个线程释放了锁，它还是会去竞争锁
>
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
* 转换流 -- 字符编码、字符集 解决乱码问题等 InputStreamReader:字节转字符输入流
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

* AIO：通道使用异步通道：AsynchronousSocketChannel ...方法与NIO差不多

> 进行事件处理(read,write,accept,connect)时需要指定事件处理类-CompletionHandler<V,A>（回调函数）
>> 回调函数有两个方法：completed(V result)和failed(Throwable)

## 反射、注解、动态代理

* 类加载器
* 反射
* 注解
* 代理模式--proxy
* 方法引用-- ：： --代替lambda表达式（表达式与另一个方法中的代码一样或者就是调用另一个方法，可以使用方法引用）
* Base64编码器：基本/URL/MIME

## XML、Dom4J、pattern表达式、单例、多例设计模式、枚举、工厂设计模式、Lombok插件

* xml：可扩展标记语言，传输数据的，不是显示数据的，需要自定义标签，W3C推荐标准，HTML显示数据的
* DTD约束（.xml）、schema约束（.xsd）
* Dom：xml解析--整个文档装载到内存，解析成Document对象（文档过大会内存溢出） SAX:一行一行扫描 ，PULL：安卓的
* 解析器：jaxp(sun)、Dom4j（将整个xml文档加载到内存，生成一个DOM树，并获得一个Document对象--节点）、JDom、Jsoup（DOM方式的解析包）
* 正则表达式 [] 表示匹配单个字符 ^取反 -范围  &&与 ｜或


* 单例-一个类只有一个对象实例：构造方法私有化+类内部产生一个唯一实例化对象并用静态方法返回该对象--懒汉/饿汉单例
* 多例-一个类在系统中有固定数量的实例：构造私有化+固定数量的实例化对象（集合存储）:静态代码块创建响应数量的对象存入集合+静态方法随机获取类对象
* 枚举=表示固定个数对象的特殊类，类的对象是固定个数的就可定义为枚举（本质为使用多例设计模式的类）
* 工厂设计模式：创建型模式--创建对象的最佳方式（创建一个类功能为专门创建其他多个类多人实例化对象并提供获取方法，需要这些类只需要与一个该工厂类关联即可）--降低耦合

## MYSQL函数 JDBC

* if（判断表达式，返回true的表达式，返回false的表达式） /ifnull(expr1,expr2):如果expr1不为null，则其返回值为expr1,否则为expr2

>select name, if(sex, 1,0) from student;  查询学生为男或者女的所有学生，如果sex为false，返回0，如果为true，返回1
>

* 字符串的相关函数

* JDBC：连接的接口，其各个实现类就是其连接的具体方法
* POJO编写规范
* JDBC工具类封装--硬编码问题--properties对象（ResourceBundle.getBundle(文件名)  -getString(key)）
* SQL注入--使用预编译对象进行占位赋值
* JDBC操作事务--setAutoCommit(false)--commit()--出现异常进行回滚（rollback）
* 普通BUG解决方法：

> 异常类型 -- course/course by 导致原因-- 出错问题：第一个蓝色，自己写的代码

* 连接池:解决普通JDBC连接频繁创建和销毁所带来的系统开销，高并发会有许多连接导致内存溢出或者服务器崩溃

>linkedList作为容器（增加和删除快）初始化创建多个连接，执行sql语句：有连接存在 - 获取-头部删除(removeFirst) 用完之后 - 归还-尾部添加（addLast）  
>
>连接用完-判断正在使用的连接数-没有达到最大--则新创建（用完归还连接池，连接池有一个属性-最大闲置连接数，闲时会销毁新创建连接，维持使其小于最大）
>
>-达到最大--进入等待队列（超时限定-超时报错-将使用时间最长的强制归还）

> 解决连接池耦合：连接池实现官方DataSource接口，使用直接反射创建，接口类对象进行接收连接即可--该接口的实现类没有归还连接的方法
>
>归还连接解决：连接对象.close() 为连接池原本对象不是销毁而是归还连接池，新创建销毁--动态代理-装饰着模式
>
>动态代理：增强Connection的close方法，不是执行原方法(method.invoke(connection,args))是就将代理连接对象添加到连接池
>
>装饰着模式：创建连接使用装饰者模式（wrapper装饰者实现Connection接口并重写相关方法--出现依赖倒置原则：尽量依赖抽象，不依赖具体）放在连接池中的就是装饰者连接重写close执行归还操作，未放就是原连接，执行原来的销毁方法

* 第三方连接池：C3P0(spring /hibernate使用)  DRUID连接池 --将其封装在一个工具类中并在静态代码块中创建连接池-单例

> DruidDataSourceFactory.createDataSource
>
>ComboPooledDataSource

* DBUtils：JDBC简单框架：解决执行sql语句繁琐，结果集的处理麻烦 

> QueryRunner对象，构造函数中传入datasource（使用连接池获取）对象 ，然后调用该对象方法update(sql),query(sql)执行语句

* 元数据：框架使用的

>DataBaseMetaData 数据库元数据:数据库相关信息
>
>ParameterMetaData:参数元数据：包含SQL语句参数个数等信息
>
>ResultSetMetaData:结果集元数据：结果集相关信息：个数、列名--POJO需要与此对应一样
>

* 内省机制 ：操作JAVABEAN的属性的相关get/set方法，使用的类PropertyDescriptor:属性描述器 ,.getWriteMethod()获取get方法，.invoke()运行


## html、JS

* 标签：a、img、
* 表单form-包裹表单项，指定向服务器传送的地址等（action：提交路径，method：提交方式，默认get）--文本框/单选多选框/文件选择框等（input），下拉框(select),文本域(textarea)

* JS：处理用户和页面交互

> 函数：调用时传入参数个数和声明时候的可以不一致、没有重载
>
>事件：两种绑定（动态-匿名函数绑定+静态-直接在标签上绑定事件方法名），常见事件：焦点、页面加载、内容改变、鼠标、键盘
>
>BOM：window对象-三种弹窗，两个定时器/location对象--href代表浏览器地址栏地址，可以通过location.href获取、设置、访问

## JAVA EE 

### http

* http：超文本传输协议
* 状态码
* 常见web服务器：WebLogic：使用较多的，支持J2EE规范，用于开发、集成、部署和管理大型分布式web应用、网络应用和数据库应用的Java应用服务器/tomcat服务器：并发量500

### tomcat

* url:统一资源定位符
* 项目虚拟路径映射：conf/catalina/localhost文件中创建xml文件进行配置docBase标签--访问xml文件名即虚拟路径就可以访问到相关真实路径下的页面

### servlet
