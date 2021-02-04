import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * @Author：
 * @Date: 2020/6/30 11:21
 */
public class Test {
    public static void main(String[] args) throws IOException {
        /*
            面向对象:
                类:
                    定义类:
                            public class 类名{
                                成员变量
                                代码块
                                构造方法
                                成员方法
                            }
                    成员变量(属性):  数据类型 变量名;
                    代码块:
                        静态代码块:static{}   随着类的加载而执行,并且只执行一次
                        构造代码块:{}         每次调用构造方法之前都会执行一次
                    构造方法:
                        空参: public 类名(){}
                        满参: public 类名(形参){}
                    成员方法:  修饰符 返回值类型 方法名(形参列表){}
                对象:
                    创建对象: 通过new调用构造方法来创建对象
                    对象使用:
                        对象名.成员变量名
                        对象名.成员方法名(参数);
                封装:
                    对属性的封装: 使用private修饰成员变量,提供set\get方法
                    this: 谁调用this所在的方法,this就表示谁
                继承
                    格式:  public class 子类名 extends 父类名{}
                    特点: 子类拥有父类的所有成员变量和成员方法,单继承
                多态
                    条件:
                        继承或者实现
                        父类的引用指向子类对象
                        重写方法
                    多态成员访问特点:
                        除了非静态方法是编译看父类,运行看子类,其余都是看父类
                    多态的好处和弊端:
                        父类的引用可以接收一切子类对象,但无法访问子类特有的功能
                    多态类型转换:
                        向上转型: 父类类型 变量名 = 子类对象;
                        向下转型: 子类类型 变量名 = (子类类型)父类类型的变量;
                        判断:  变量名 instanceof 数据类型
                接口:
                    定义:
                          public interface 接口名{
                              常量(jdk7)
                              抽象方法(jdk7)
                              默认方法(jdk8)
                              静态方法(jdk8)
                              私有方法(jdk9)
                          }
                    实现:
                        public class 实现类名 implements 接口名1,接口名2,...{

                        }
                    接口和接口: 单继承,多继承,多层继承
                    接口和类 :  单实现,多实现,多层实现

                 匿名内部类:
                    表示: 本质就是一个类的匿名子类对象;或者一个接口的匿名实现类对象
                    格式:
                        new 类名\接口名(){重写方法};
                 static:
                    修饰成员变量: 使用类名.静态成员变量名          特点: 共享
                    修饰成员方法: 使用类名.静态成员方法名(实参)    特点: 共享
                    修饰代码块:static{}  随着类的加载而执行,且执行一次
                 final:
                    修饰类: 不能被继承
                    修饰方法: 不能被重写
                    修饰成员变量: 变成常量,只能赋值一次
                 模板设计模式:
                            体现在抽象类作为父类,在抽象类中能够确定的模板功能就使用有方法体的方法来表示,不能确定的模板功能就使用抽象方法来表示
                            体现在接口,在接口中能够确定的模板功能就使用有方法体的方法来表示,不能确定的模板功能就使用抽象方法来表示
            常用API:  借助idea的提示
                String类
                StringBuilder类
                Date
                SimpleDateFormat
                Calendar
                System
                Math
                Arrays
                BigInteger
                BigDecimal

                如何调用:  参数传什么,返回值是什么
                功能: 干什么用的---使用场景

            集合框架:
                单列集合: 以单个单个的元素进行存储
                    Collection集合: 接口,单列集合的顶层父接口,定义了所有单列集合共有的方法
                        List集合: 接口,元素存取有序,有索引,可以重复
                            ArrayList类: 查询快,增删慢
                            LinkedList类: 查询慢,增删快
                        Set集合: 接口,元素存取无序,无索引,不可以重复
                            HashSet类: 元素存取无序,无索引,不可以重复
                            LinkedHashSet类:元素存取有序,无索引,不可以重复
                            TreeSet类: 元素存取无序,无索引,不可以重复,可以对元素进行排序
                双列集合: 以键值对的形式进行存储
                    Map集合: 接口,双列集合的顶层父接口,定义了所有双列集合共有的方法
                        HashMap类: 键唯一,键值对存取无序
                        LinkedHashMap类: 键唯一,键值对存取有序
                        TreeMap类:键唯一,可以对键进行排序
                        Hashtable类:键唯一,线程安全

                API:  增删改查,遍历
                    Collection,List,Map接口
            算法:
                    冒泡排序
                    选择排序
                    二分查找(排序好)
            异常:
                产生异常: throw 创建异常对象;
                处理异常:
                        声明处理异常: 在方法的声明之上写上throws 异常类型
                        捕获处理异常: try...catch语句进行捕获处理
                        区别:
                            声明处理异常: 只是将异常声明出来,告诉调用者来处理,如果在执行的时候,代码没有出现异常,程序可以正常往下执行,如果出现了异常,还是会终止程序运行
                            捕获处理异常: 不管程序在执行的时候,是否出现异常,程序都可以正常的继续往下执行
            多线程:
                创建并启动线程:
                    方式一: 继承Thread类
                            1.定义一个子类继承Thread类,重写run方法
                            2.在run方法中,书写线程需要执行的任务代码
                            3.创建子类线程对象
                            4.调用start()方法启动线程,执行任务

                    方式二: 实现Runnable接口
                            1.定义一个实现类实现Runnable接口,重写run方法
                            2.在run方法中,书写线程需要执行的任务代码
                            3.创建实现类对象
                            4.创建Thread线程对象,把实现类对象作为参数传入
                            4.使用线程调用start()方法启动线程,执行任务
                    匿名内部类方式

               线程的调度: 抢占式调度
               执行步骤:
                    创建线程对象,调用start()方法启动线程,就会在栈区开辟一块独立的栈空间,在栈空间中执行run方法
               线程安全问题:
                    可见性问题: 一条线程对共享变量进行了修改,其他线程看不见
                    有序性问题: 在多线程情况下,如果编译器对某条线程的进行重排,可能会导致其他线程的执行结果受影响
                    原子性问题:
                         多条线程对共享变量同时进行修改,导致结果造成了覆盖的效果
                         多条线程执行同一段代码,相互干扰,造成结果不是预期的结果
                解决线程安全问题:
                    可见性\有序问题: volatile关键字
                    原子性问题: 原子类,或者加锁
                锁:
                    同步代码块:
                        格式: synchronized (锁对象) { }
                        锁对象:
                            1.任意类的对象
                            2.如果有条线程实现同步,那么这多条线程使用的锁对象要一致(相同的对象)
                    同步方法
                        概述: 使用synchronized修饰方法
                        锁对象:
                            非静态同步方法: this
                            静态同步方法: 该方法所在类的字节码对象 类名.class
                    Lock锁
                        创建Lock对象:  new ReentrantLock()
                        调用方法:
                            lock();加锁
                            unLock();释放锁

                 并发包: 线程安全
                 死锁: 尽量避免
                 线程池:
                    1.创建一个线程池,初始化线程
                    2.提交任务,执行任务
                    3.关闭线程(一般操作)
                 线程状态:
                    新建: 创建线程对象,还未调用start()方法启动线程
                    可运行状态: 调用start()方法启动了线程,可能在运行,可能没在运行
                    锁阻塞状态: 没有抢到锁对象
                    无限等待: 当使用了锁对象调用了wait()方法,等待其他线程使用相同的锁对象调用notify或者notifyAll方法
                    计时等待: 调用sleep()方法或者调用wait(long timeout)方法
                    被终止:  出现异常没有捕获处理,或者run方法任务执行完毕

                  等待唤醒机制: wait和notify方法之间协作机制

            JDK8新特性:
                Lambda表达式
                    使用前提:当接口中有且只有一个抽象方法的时候,就可以使用Lambda表达式
                    格式:
                        (参数)->{}
                        1.小括号中的内容和接口中抽象方法的形参一致
                        2.大括号中的内容其实就是要实现的抽象方法的方法体
                        3.当调用了接口的抽象方法,就会来执行Lambda表达式
                     省略规则:
                        1.小括号中的参数类型可以省略
                        2.如果小括号中只有一个参数,那么小括号和参数类型可以一起省略
                        3.如果大括号中只有一行代码,那么大括号和return,以及分号可以一起省略
                方法引用:
                    如果Lambda表达式大括号中的代码就是调用另一个方法,那么就可以直接把该方法引入过来从而替换Lambda表达式
                    如果Lambda表达式大括号中的代码和另一个方法的方法体一致,那么就可以直接把该方法引入过来从而替换Lambda表达式

                    格式:
                        构造方法: 类名::new
                        静态方法: 类名::方法名
                        成员方法:
                            有参数: 对象名::方法名
                            无参数:  类名::方法名
                Stream流
                    作用: 简化集合的复杂操作
                    API:
                        获取流
                            使用Collection的stream()方法
                            使用Stream的of()方法
                        操作流
                            过滤: filter
                            映射: map
                            取前几个: limit
                            跳过前几个: skip
                            拼接: concat
                        获取结果
                            统计流元素个数: count
                            逐一消费元素: forEach
                            收集流元素: collect\toArray
                Base64
                    获取编码器
                        getEncoder()
                        getMimeEncoder()
                        getUrlEncoder()
                    进行编码
                        encodeToString(byte[] args)
                    获取解码器
                        getDecoder()
                        getMimeDecoder()
                        getUrlDecoder()
                    进行解码
                        decode()
            IO流:
                读: 其他存储设备----内存
                写: 内存----其他存储设备
                字节输入流: 以字节为单位,进行读取数据
                字节输出流: 以字节为单位,进行写出数据
                字符输入流: 以字符为单位,进行读取数据
                字符输出流: 以字符为单位,进行写出数据

                API:
                    InputStream: 抽象类,定义了所有字节输入流共有的方法
                        常用方法:
                          read();
                          read(byte[] bys);
                          close()
                        子类:
                            FileInputStream,BufferedInputStream,ObjectInputStream,
                    OutputStream: 抽象类,定义了所有字节输出流共有的方法
                        常用方法:
                            write(int b)
                            write(byte[] bys,int off,int len)
                        子类:
                            FileOutputStream,BufferedOutputStream,ObjectOutputStream,PrintStream
                    Reader:抽象类,定义了所有字符输入流共有的方法
                        常用方法:
                            read()
                            read(char[] chs)
                        子类:
                            FileReader,BufferedReader,InputStreamReader
                    Writer:抽象类,定义了所有字符输出流共有的方法
                        常用方法:
                            write(int len)
                            write(char[] chs,int off,int len)
                            write(String str)
                            write(String str,int off,int len)
                       子类:
                            FileWriter,BufferedWriter,OutputStreamWriter
               高效流:
                字节缓冲流: 高效读写
                字符缓冲流: 读一行,根据系统平台写换行符
                转换流: 指定编码读,指定编码写
                序列化流: 把对象以字节的形式存储到文件中
                反序列化流; 把文件中的对象字节数据重构成原来的对象

              操作:
                 一次读写一个字节数据
                    1.创建字节输入流对象,关联数据源文件路径
                    2.创建字节输出流对象,关联目的地文件路径
                    3.定义一个变量,用来存储读取到的字节数据
                    4.循环读取
                    5.在循环中,写出数据
                    6.关闭流,释放资源

                 一次读写一个字节数组数据
                    1.创建字节输入流对象,关联数据源文件路径
                    2.创建字节输出流对象,关联目的地文件路径
                    3.定义一个字节数组,用来存储读取到的字节数据
                    3.定义一个int变量,用来存储读取到的字节个数
                    4.循环读取
                    5.在循环中,写出数据
                    6.关闭流,释放资源

                 一次读写一个字符数据
                    1.创建字符输入流对象,关联数据源文件路径
                    2.创建字符输出流对象,关联目的地文件路径
                    3.定义一个变量,用来存储读取到的字符数据
                    4.循环读取
                    5.在循环中,写出数据
                    6.关闭流,释放资源

                 一次读写一个字符数组数据
                    1.创建字符输入流对象,关联数据源文件路径
                    2.创建字符输出流对象,关联目的地文件路径
                    3.定义一个字节数组,用来存储读取到的字符数据
                    3.定义一个int变量,用来存储读取到的字符个数
                    4.循环读取
                    5.在循环中,写出数据
                    6.关闭流,释放资源
              File类:  API
              递归: 方法自己调用自己,   规律,出口

            TCP网络编程:
                Socket
                    getInputStream()
                    getOutputStream()
                    shutdownOutput()
                    close()
                ServerSocket
                    accept()
            NIO:
                Buffer: 缓冲数组
                    put(int byte);   添加字节数据
                    put(byte[] bys); 添加字节数组数据
                    limit();
                    position();
                    mark();
                    flip();   limit设置成当前position位置,position设置为0
                    clear();  limit设置成capacity位置,position设置为0
                Channel: 通道----可以读和写
                    FileChannel   拷贝文件
                    SocketChannel
                    ServerSocketChannel
                    DatagramChannel
                Selector: 选择器
                    作用: 多路复用
                    select() 等待客户端连接  阻塞
                            阻塞:
                                1.如果没有客户端连接,就会一直阻塞
                                2.如果有客户端连接了,但没有处理该客户端的请求,那么该方法就不阻塞
                                3.如果有客户端连接了,但有处理该客户端的请求,那么该方法就阻塞
                    selectedKeys() 获取所有已经连接的Channel

                    keys() : 获取所有已经注册的通道

                 AIO:
                    同步: 调用的方法有返回值,但没有回调函数
                    异步: 调用的方法没有返回值,但有回调函数
                   AsynchronousFileChannel   拷贝文件
                   AsynchronousSocketChannel
                   AsynchronousServerSocketChannel
                   AsynchronousDatagramChannel

                   异步方法:  read(),write(),connect(),accept()
                   异步方法中都有一个参数:  CompletionHandler接口
                             completed  成功执行
                             failed  失败执行

                    异步非阻塞:
                        异步连接,异步读
            JavaSE加强:
                Junit框架: 导jar包,添加classpath路径,使用@Test注解,进行单元测试
                反射:
                    类的class对象:
                            类名.class
                            对象名.getClass()
                            Class.forName("类的全路径")
                    构造方法:
                        getDeclaredConstructor(Class... c);获得指定的构造方法,参数c:要获取的构造方法的形参类型的class对象
                        getDeclaredConstructors() 获取所有的构造方法
                        newInstance(Object... args) 执行构造方法创建对象,参数args: 就是执行构造方法所需要的实际参数

                    成员方法:
                        getDeclaredMethod(String name,Class... c);获得指定的成员方法,参数name: 方法名, 参数c:要获取的成员方法的形参类型的class对象
                        getDeclaredMethods() 获取所有的成员方法
                        invoke(Object obj,Object... args) 执行成员方法,参数args: 就是执行成员方法所需要的实际参数

                    属性:
                        getDeclaredField(String name);获得指定的属性,参数name: 表示要获取的属性名
                        getDeclaredFields() 获取所有的属性
                        set(Object obj,Object value) 给属性赋值
                        get(Object obj) 获取属性

                    暴力反射:
                        setAccessible(true);

               注解:
                    使用注解:
                        注解带属性:  @注解名(属性名=属性值,属性名=属性值)
                        注解不带属性: @注解名  @注解名()
                        注意:
                            如果属性名为value,使用注解的时候那么value属性名可以省略
                            如果属性类型为数组类型,使用注解的时候,数组中只有一个值,那么大括号可以省略
                XML:
                    书写xml: 文档声明,标签,属性,注释,转义字符,字符区
                    使用Dom4j进行解析:
                        创建解析器
                        解析xml文件,生成Document对象
                        进行获取给个节点
               正则表达式: 要求能看懂正则表达式,并且可以书写一些简单的正则表达式规则

               单列设计模式
                    1.构造方法私有化
                    2.在类的内部创建一个该类对象
                    3.提供一个公共的静态方法,用来获取该类的对象

               多例设计模式
                    1.构造方法私有化
                    2.在类的内部创建固定数量的该类对象
                    3.提供一个公共的静态方法,用来获取该类的对象

               工厂设计模式
                    把创建对象的代码放入到工厂类的静态方法中
               枚举:
                定义枚举
                    public enum 枚举名{
                        枚举值,...
                    }
                 使用枚举:  枚举名.枚举值

               动态代理: 在执行的时候,为被代理类生成一个代理对象
         */
        // 需求: 使用动态代理对ArrayList集合中的remove方法进行增强,使其可以删除所有指定的元素
        ArrayList<String> list = new ArrayList<>();
        list.add("nba");
        list.add("nba");
        list.add("nba");
        list.add("abc");
        list.add("bac");
        list.add("cba");
        list.add("abc");
        list.add("abc");
        list.add("abc");
        list.add("abc");
        System.out.println("删除前:"+list);// [nba,nba,nba, abc, bac, cba, abc, abc, abc, abc]

        // 使用动态代理
        // 生成代理对象
        List<String> proxy = (List<String>)Proxy.newProxyInstance(ArrayList.class.getClassLoader(), ArrayList.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 代理对象调用方法就会来到这里,增强的功能就写在这
                // proxy:表达代理对象,慎用;  method: 代理对象调用的方法; args:代理对象调用的方法的实参; Object返回: 代理对象调用的方法的返回值类型
                // 为了保证代理对象调用的方法的返回值类型相匹配,就先执行一下代理对象调用的方法,然后再去增强
                Object res = method.invoke(list, args);// 根据代理对象调用的方法来返回对应返回值类型的数据,否则会报类型转换异常

                // 由于需要遍历的同时删除元素,所以只能使用迭代器
                if (method.getName().equals("remove")){
                    // 执行remove方法
                    Iterator<String> it = list.iterator();// 获取迭代器
                    while (it.hasNext()) {
                        // 获取元素
                        String e = it.next();
                        // 判断删除
                        if (e.equals(args[0])){// 1
                            it.remove();
                        }
                    }
                }

                if (method.getName().equals("set")) {
                    // 执行set方法
                    System.out.println("哈哈哈哈....");
                }
                return res;
            }
        });

        // 使用代理对象调用remove方法进行删除
        boolean res1 = proxy.remove("abc");
        System.out.println("是否删除成功:"+res1);// true
        System.out.println("删除后:"+list);// [nba,nba,nba, bac, cba]

        // 需求: 代理对象还需要增强set方法
        String replaceE = proxy.set(1, "cab");// true
        System.out.println("被修改的元素:"+replaceE);// nba
        System.out.println("修改后:"+list);// [nba,cab,nba, bac, cba]

        // 不使用动态代理
        // boolean res1 = list.remove("abc");
        // System.out.println("是否删除成功:"+res1);// true
        // System.out.println("删除后:"+list);// [nba,nba,nba, bac, cba, abc, abc, abc, abc]


    }
}
