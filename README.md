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







    