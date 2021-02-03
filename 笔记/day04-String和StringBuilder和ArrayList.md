# day04-String和StringBuilder和ArrayList

## 今日内容

- String类
- StringBuilder类
- ArrayList集合

## 教学目标

- 能够知道字符串对象通过构造方法创建和直接赋值的区别
- 能够完成用户登录案例
- 能够完成统计字符串中大写,小写,数字字符的个数
- 能够知道String和StringBuilder的区别
- 能够完成String和StringBuilder的相互转换
- 能够使用StringBuilder完成字符串的拼接
- 能够使用StringBuilder完成字符串的反转
- 能够知道集合和数组的区别
- 能够完成ArrayList集合添加字符串并遍历
- 能够完成ArrayList集合添加学生对象并遍历

## 知识点--1.String类的常用方法

### 知识点--1.1 String类概述

#### 目标

- 理解String类概述

#### 路径

- String类的概述

#### 讲解

##### String类的概述

​	String 类代表字符串，Java 程序中的所有字符串文字（例如“abc”）都被实现为此类的实例。也就是说，Java 程序中所有的双引号字符串，都是 String 类的对象。String 类在 java.lang 包下，所以使用的时候不需要导包！

#### 小结

- String类表示字符串,在java程序中所有双引号的字符串都是String类的对象
- String类在java.lang包下,所以使用的时候不需要导包

### 知识点--1.2 String类的构造方法

#### 目标

- 掌握String类构造方法的使用

#### 路径

- String类常用的构造方法
- 使用String类的构造方法

#### 讲解

##### String类常用的构造方法

- 常用的构造方法

  ```java
  public String() 创建一个空字符串对象  例如: ""
  public String(byte[] bytes) 根据byte数组中的内容,来创建对应的字符串对象
  public String(byte[] bytes, int offset, int length) 指定byte数组的范围,根据指定范围中的内容,来创建对应的字符串对象
  public String(char[] value) 根据char数组中的内容,来创建对应的字符串对象
  直接写字符串字面值也是String类对象  例如: String str = "abc";    常用
  ```


##### 使用String类的构造方法

```java
public class StringDemo01 {
    public static void main(String[] args) {
        //public String()：创建一个空白字符串对象，不含有任何内容
        String s1 = new String();
        System.out.println("s1:" + s1);

        //public String(char[] chs)：根据字符数组的内容，来创建字符串对象
        char[] chs = {'a', 'b', 'c'};
        String s2 = new String(chs);
        System.out.println("s2:" + s2);

        //public String(byte[] bys)：根据字节数组的内容，来创建字符串对象
        byte[] bys = {97, 98, 99};
        String s3 = new String(bys);
        System.out.println("s3:" + s3);

        //String s = “abc”;	直接赋值的方式创建字符串对象，内容就是abc
        String s4 = "abc";
        System.out.println("s4:" + s4);
    }
}
```

#### 小结

略

### 知识点--1.3 创建字符串对象两种方式的区别

#### 目标

- 能够知道通过**构造方法创建字符串对象**与**直接赋值方式创建字符串对象**的区别

#### 路径

- 通过构造方法创建

- 直接赋值方式创建
- 绘制对比内存图

#### 讲解

##### 通过构造方法创建

- 通过 new 创建的字符串对象，每一次 new 都会申请一个内存空间，虽然字符串内容相同，但是地址值不同

  ```java
  char[] chs = {'a','b','c'};
  String s1 = new String(chs);// s1字符串的内容: abc
  String s2 = new String(chs);// s2字符串的内容: abc
  // 上面的代码中,JVM首先会先创建一个字符数组,然后每一次new的时候都会有一个新的地址,只不过s1和s2参考的字符串内容是相同的
  ```

##### 直接赋值方式创建

- 以“”方式给出的字符串，只要字符序列相同(顺序和大小写)，无论在程序代码中出现几次，JVM 都只会建立一个 String 对象，并在字符串池中维护

```java
String s3 = "abc";
String s4 = "abc";
// 上面的代码中,针对第一行代码,JVM会建立一个String对象放在字符串池中,并给s3参考;第二行代码,则让s4直接参考字符串池中String对象,也就是说他们本质上是同一个对象
```

##### 绘制内存图

```java
public class Test {
    public static void main(String[] args) {
        /*
             创建字符串对象两种方式的区别:
                - 通过构造方法创建: 通过 new 创建的字符串对象，每一次 new 都会申请一个内存空间，虽然字符串内容相同，但是地址值不同
                - 直接赋值方式创建: 以“”方式给出的字符串，只要字符序列相同(顺序和大小写)，无论在程序代码中出现几次，JVM 都只会建立一个 String 对象，并在字符串池中维护
         */
        char[] chs = {'a','b','c'};
        String str1 = new String(chs);
        String str2 = new String(chs);
        System.out.println("str1:"+str1);// str1: abc   打印的是字符串内容
        System.out.println("str2:"+str2);// str2: abc   打印的是字符串内容
        System.out.println(str1 == str2);// false == 引用数据类型比较的是地址值

        System.out.println("=========================");
        String str3 = "abc";
        String str4 = "abc";
        System.out.println(str3 == str4);// true
    }
}

```

![image-20200611091952496](img\image-20200611091952496.png)



#### 小结

- 通过new创建的字符串对象,每一次都会新开辟空间
- 通过""方式直接创建的字符串对象,是常量,在常量池中,只有一份

### 知识点--1.4 String类的特点

#### 目标

- 能够理解String类的特点

#### 路径

- String类的特点

#### 讲解

##### String类的特点

- String类的字符串不可变，它们的值在创建后不能被更改

  ```java
  String s1 = "abc";
  s1 += "d";
  System.out.println(s1); // "abcd" 
  // 内存中有"abc"，"abcd","d",3个对象，s1从指向"abc"，改变指向，指向了"abcd"。
  ```

- 虽然 String 的值是不可变的，但是它们可以被共享

  ```java
  String s1 = "abc";
  String s2 = "abc";
  // 内存中只有一个"abc"对象被创建，同时被s1和s2共享。
  ```

- 字符串效果上相当于字符数组( char[] )

  ```java
  例如： 
  String str = "abc";
  
  相当于： 
  char[] data = {'a', 'b', 'c'};     
  String str = new String(data);
  // String底层是靠字符数组实现的,jdk9底层是字节数组。
  
  byte[] bys = {97,98,99};
  String str = new String(bys);
  ```

#### 小结

- ```java
     String类的特点:
                  1.String类不可变
                  2.String类字符串常量对象可以共享
                  3. String底层是靠字符数组实现的,jdk9底层是字节数组。
  ```

### 知识点--1.5 字符串的比较

#### 目标

- 能够比较2个字符串内容是否相同

#### 路径

- ==号的比较
- equals方法的作用
- equalsIgnoreCase 方法的使用

#### 讲解

##### ==号的比较

- 比较基本数据类型：比较的是具体的值

  ```java
  int num1 = 10;
  int num2 = 20;
  num1 == num2  ===> 10==20  结果:false
  ```

- 比较引用数据类型：比较的是对象地址值

  ```java
  String str1 = new String("abc");
  String str2 = new String("abc");
  str1 == str2 ===> str1存储的对象地址值 == str2存储的对象地址值  结果: false
  ```

  ```java
    // ==比较运算符:
      private static void method01() {
          // 基本数据类型比较的是2个变量中的值是否相同
          int num1 = 10;
          int num2 = 10;
          System.out.println(num1 == num2);// true
  
          // 引用数据类型比较的是2个对象的地址值是否相同
          String str1 = "abc";
  
          char[] chs = {'a','b','c'};
          String str2 = new String(chs);// "abc"
  
          System.out.println(str1 == str2);// false
      }
  ```

##### equals方法的作用

- 字符串是对象,它比较内容是否相同,是通过一个方法来实现的,就是equals()方法

- 方法介绍

  ```java
  public boolean equals(String s)     比较两个字符串内容是否相同、区分大小写
  ```

- 示例代码

  ```java
  public class StringDemo02 {
      public static void main(String[] args) {
          //构造方法的方式得到对象
          char[] chs = {'a', 'b', 'c'};
          String s1 = new String(chs);
          String s2 = new String(chs);
  
          //直接赋值的方式得到对象
          String s3 = "abc";
          String s4 = "abc";
  
          //比较字符串内容是否相同
          System.out.println(s1.equals(s2));// true
          System.out.println(s1.equals(s3));// true
          System.out.println(s3.equals(s4));// true
      }
  }
  ```

##### 扩展

- ` public boolean equalsIgnoreCase (String anotherString)` ：将此字符串与指定对象进行比较，忽略大小写。

- 示例

  ```java
   public static void main(String[] args) {
          //  public boolean equalsIgnoreCase (String anotherString)
          // 1.创建一个字符串对象
          String str1 = "hello";
  
          // 2.创建一个字符串对象
          String str2 = "Hello";
  
          // 3.使用equalsIgnoreCase()方法比较str1和str2字符串是否相等
          boolean res1 = str1.equalsIgnoreCase(str2);
          System.out.println("res1的值是:"+res1);// true
      }
  
  ```

#### 小结

- 比较字符串内容是否相等,区分大小写,需要使用String类的equals方法,千万不要用 == 比较
- 如果比较字符串内容是否相等,不区分大小写,需要使用String类的equalsIgnoreCase()方法

### 知识点--1.6 String类获取功能的方法

#### 目标

- 理解String类中各个方法的作用\调用

#### 路径

- 介绍获取功能的方法
- 使用获取功能的方法

#### 讲解

##### 获取功能的方法

- `public int length () ` ：返回此字符串的长度。
- `public String concat (String str)` ：将指定的字符串连接到该字符串的末尾。
- ` public char charAt (int index) ` ：返回指定索引处的 char值。
- `public int indexOf (String str) ` ：返回指定子字符串第一次出现在该字符串内的索引。
- ` public String substring (int beginIndex) ` ：返回一个子字符串，从beginIndex开始截取字符串到字符串结尾。
- ` public String substring (int beginIndex, int endIndex) ` ：返回一个子字符串，从beginIndex到endIndex截取字符串。含beginIndex，不含endIndex。

##### 使用获取功能的方法

```java
  public class Test {
    public static void main(String[] args) {
        /*
            String类获取功能的方法:
                - public int length () ：返回此字符串的长度。
                - public String concat (String str) ：将指定的字符串连接到该字符串的末尾。
                - public char charAt (int index) ：返回指定索引处的 char值。
                - public int indexOf (String str) ：返回指定子字符串第一次出现在该字符串内的索引。
                - public int indexOf(String str, int fromIndex)
                - public int lastIndexOf(String str) 返回指定子字符串最后一次出现在该字符串内的索引。
                - public int lastIndexOf(String str, int fromIndex)

                - public String substring (int beginIndex) ：返回一个子字符串，从beginIndex开始截取字符串到字符串结尾。
                - public String substring (int beginIndex, int endIndex) ：返回一个子字符串，从beginIndex到endIndex截取字符串。含beginIndex，不含endIndex。
         */
        String str = "hello-world世界,你好";

        //  public int length () ：返回此字符串的长度。
        int len = str.length();
        System.out.println("str字符串的长度:"+len);// 16

        // public String concat (String str) ：将指定的字符串连接到该字符串的末尾。
        String newStr = str.concat("中国你好");
        System.out.println("拼接后的字符串:"+newStr);// hello-world世界,你好中国你好
        System.out.println("str:"+str);//  hello-world世界,你好

        // public char charAt (int index) ：返回指定索引处的 char值。
        // 获取1索引位置上的元素
        char c = str.charAt(1);
        System.out.println(c);// e

        // 遍历字符串中的每一个字符串
        /*for (int i = 0;i<len;i++){
            System.out.println(str.charAt(i));
        }*/

        // public int indexOf (String str) ：返回指定子字符串第一次出现在该字符串内的索引。
        // 获取l字符串第一次出现的索引
        int index1 = str.indexOf("l");
        System.out.println("index1:"+index1);// 2

        // public int indexOf(String str, int fromIndex)
        // 获取l字符串第二次出现的索引
        int index2 = str.indexOf("l", index1+1);
        System.out.println("index2:"+index2);// 3

        // 获取l字符串第三次出现的索引
        int index3 = str.indexOf("l", index2 + 1);
        System.out.println("index3:"+index3);// 9

        // public int lastIndexOf(String str) 返回指定子字符串最后一次出现在该字符串内的索引。
        // 获取l字符串最后一次出现的索引
        int index = str.lastIndexOf("l");
        System.out.println("index:"+index);// 9


        // public String substring (int beginIndex) ：返回一个子字符串，从beginIndex开始截取字符串到字符串结尾。
        String subStr1 = str.substring(2);
        System.out.println("subStr1:"+subStr1);//  llo-world世界,你好


        // public String substring (int beginIndex, int endIndex) ：返回一个子字符串，从beginIndex到endIndex截取字符串。含beginIndex，不含endIndex。
        // 截取world子字符串
        String subStr2 = str.substring(6, 11);
        System.out.println("subStr2:"+subStr2);// world
    }
}

```

#### 小结

略

### 实操--1.7 用户登录案例【应用】

#### 需求

​	已知用户名和密码，请用程序实现模拟用户登录。总共给三次机会，登录之后，给出相应的提示

#### 分析

1. 已知用户名和密码，定义两个字符串表示即可
2. 键盘录入要登录的用户名和密码，用 Scanner 实现
3. 拿键盘录入的用户名、密码和已知的用户名、密码进行比较，给出相应的提示。
4. 用循环实现多次机会，这里的次数明确，采用for循环实现，并在登录成功的时候，使用break结束循环

#### 实现

```java
/*
    思路：
        1:已知用户名和密码，定义两个字符串表示即可
        2:键盘录入要登录的用户名和密码，用 Scanner 实现
        3:拿键盘录入的用户名、密码和已知的用户名、密码进行比较，给出相应的提示。字符串的内容比较，用equals() 方法实现
        4:用循环实现多次机会，这里的次数明确，采用for循环实现，并在登录成功的时候，使用break结束循环
 */
public class StringTest01 {
    public static void main(String[] args) {
        //已知用户名和密码，定义两个字符串表示即可
        String username = "itheima";
        String password = "czbk";

        //用循环实现多次机会，这里的次数明确，采用for循环实现，并在登录成功的时候，使用break结束循环
        for(int i=0; i<3; i++) {

            //键盘录入要登录的用户名和密码，用 Scanner 实现
            Scanner sc = new Scanner(System.in);

            System.out.println("请输入用户名：");
            String name = sc.nextLine();

            System.out.println("请输入密码：");
            String pwd = sc.nextLine();

            //拿键盘录入的用户名、密码和已知的用户名、密码进行比较，给出相应的提示。字符串的内容比较，用equals() 方法实现
            if (name.equals(username) && pwd.equals(password)) {
                System.out.println("登录成功");
                break;
            } else {
                if(i == 2) {
                    System.out.println("你的账户被锁定，请与管理员联系");
                } else {
                    //i= 0,1
                    // 对应剩余的次数: 2次,1次
                    System.out.println("登录失败，你还有" + (2 - i) + "次机会");
                }
            }
        }
    }
}
```

#### 小结

### 实操--1.8 遍历字符串案例

#### 需求

​	键盘录入一个字符串，使用程序实现在控制台遍历该字符串

#### 分析

1. 键盘录入一个字符串，用 Scanner 实现
2. 遍历字符串，首先要能够获取到字符串中的每一个字符
3. 遍历字符串，其次要能够获取到字符串的长度
4. 遍历字符串的通用格式

#### 实现

```java
/*
    思路：
        1:键盘录入一个字符串，用 Scanner 实现
        2:遍历字符串，首先要能够获取到字符串中的每一个字符
            public char charAt(int index)：返回指定索引处的char值，字符串的索引也是从0开始的
        3:遍历字符串，其次要能够获取到字符串的长度
            public int length()：返回此字符串的长度
            数组的长度：数组名.length
            字符串的长度：字符串对象.length()
        4:遍历字符串的通用格式
 */
public class StringTest02 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        for(int i=0; i<line.length(); i++) {
            System.out.println(line.charAt(i));
        }
    }
}
```

#### 小结

略

### 实操--1.9 统计字符次数案例

#### 需求

​	键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不考虑其他字符)

#### 分析

1. 键盘录入一个字符串，用 Scanner 实现
2. 要统计三种类型的字符个数，需定义三个统计变量，初始值都为0 
3. 遍历字符串，得到每一个字符
4. 在循环中,判断该字符属于哪种类型，然后对应类型的统计变量+1
   1. 大写字母：ch>='A' && ch<='Z'
   2. 小写字母： ch>='a' && ch<='z'
   3. 数字： ch>='0' && ch<='9'
5. 输出三种类型的字符个数

#### 实现

```java
public class Test {
    public static void main(String[] args) {
        // 需求:键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不考虑其他字符)
        // 1.创建Scanner对象
        Scanner sc = new Scanner(System.in);

        // 2.获取键盘录入的字符串对象
        System.out.println("请输入一个字符串:");
        String str = sc.next();

        // 3.定义三个统计变量,分别用来统计大写字母,小写字母,数字字符出现的个数
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        // 4.循环遍历字符串对象
        for (int i = 0; i < str.length(); i++) {
            // 5.在循环中,获取遍历出来的字符
            char c = str.charAt(i);

            // 6.在循环中,判断遍历出来的字符是大写字母,小写字母,数字字符
            if (c >= 'A' && c <= 'Z') {
                // 7.如果是大写字母,记录大写字母个数的统计变量就+1
                count1++;
            } else if (c >= 'a' && c <= 'z') {
                // 7.如果是小写字母,记录小写字母个数的统计变量就+1
                count2++;
            } else if (c >= '0' && c <= '9') {
                // 7.如果是数字字符,记录数字字符个数的统计变量就+1
                count3++;
            }

        }
        // 8.打印统计变量
        System.out.println("大写字母个数:"+count1);
        System.out.println("小写字母个数:"+count2);
        System.out.println("数字字符个数:"+count3);
    }
}
```

#### 小结

略

### 实操--1.10 字符串拼接案例

#### 需求

​	定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，

​	并在控制台输出结果。例如，数组为 int[] arr = {1,2,3}; ，执行方法后的输出结果为：[1, 2, 3]

#### 分析

1. 定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
2. 定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回。返回值类型 String，参数列表 int[] arr
3. 在方法中遍历数组，按照要求进行拼接
4. 调用方法，用一个变量接收结果
5. 输出结果

#### 实现

```java
public class Test {
    public static void main(String[] args) {
        /*
             需求:
               定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，
        	  并在控制台输出结果。例如，数组为 int[] arr = {1,2,3}; ，执行方法后的输出结果为：[1, 2, 3]
         */
        // 定义一个int数组并初始化
        int[] arr = {1,2,3,4,5};
        
        // 调用arrayToString方法
        String s = arrayToString(arr);

        // 打印结果
        System.out.println(s);
    }

    // 定义一个方法,参数类型:int[] 返回值类型: String
    public static String arrayToString(int[] arr) {
        // 1.定义一个空字符串对象
        String str = "";

        // 2.循环遍历数组中的元素
        for (int i = 0; i < arr.length; i++) {
            // 3.判断遍历出来的元素所在的位置
            if (i == 0) {
                // 4.如果是遍历出来的是第一个元素,那么拼接的格式为:[ + 元素,空格
                str += "[" + arr[i] + ", ";
            } else if (i == arr.length - 1) {
                // 4.如果是遍历出来的是最后一个元素,那么拼接的格式为:元素 + ]
                str += arr[i] + "]";
            } else {
                // 4.如果是遍历出来的是中间元素,那么拼接的格式为: 元素,空格
                str += arr[i] + ", ";
            }
        }
        // 5.返回字符串
        return str;
    }
}

```

#### 小结

略

### 实操--1.11 字符串反转案例

#### 需求

​	定义一个方法，实现字符串反转。键盘录入一个字符串，调用该方法后，在控制台输出结果

​	例如，键盘录入 abc，输出结果 cba

#### 分析

1. 键盘录入一个字符串，用 Scanner 实现
2. 定义一个方法，实现字符串反转。返回值类型 String，参数 String s
3. 在方法中把字符串倒着遍历，然后把每一个得到的字符拼接成一个字符串并返回
4. 调用方法，用一个变量接收结果
5. 输出结果

#### 实现

```java
/*
    思路：
        1:键盘录入一个字符串，用 Scanner 实现
        2:定义一个方法，实现字符串反转。返回值类型 String，参数 String s
        3:在方法中把字符串倒着遍历，然后把每一个得到的字符拼接成一个字符串并返回
        4:调用方法，用一个变量接收结果
        5:输出结果
 */
public class StringTest05 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //调用方法，用一个变量接收结果
        String s = reverse(line);

        //输出结果
        System.out.println("s:" + s);
    }

    //定义一个方法，实现字符串反转
    /*
        两个明确：
            返回值类型：String
            参数：String s
     */
    public static String reverse(String s) {
        //在方法中把字符串倒着遍历，然后把每一个得到的字符拼接成一个字符串并返回
        String ss = "";

        for(int i=s.length()-1; i>=0; i--) {
            ss += s.charAt(i);
        }

        return ss;
    }
}
```

#### 小结

略

### 希望--有时间的同学

```java
 常用的方法：
        concat();  //把两个字符串拼接起来，获取一个新的字符串
        ★length();  //获取字符串的长度(其实就是获取字符串中 字符的个数)      
        ★equals();  //比较两个字符串的内容是否相同。    //区分大小写
        equalsIgnoreCase();  //比较两个字符串的内容是否相同。    //忽略大小写
        ★charAt();  //根据给定的索引，获取对应位置的字符
        ★indexOf(); //获取指定的字符 在字符串中 第一次出现的位置(索引)，找不到返回-1
            //int index = a1.indexOf('h');   从头找，'h'第一次出现的位置
            //int index = a1.indexOf('h',3); 从索引为3的元素开始往后找，'h'第一次出现的位置
       lastIndexOf();  //获取指定的字符 在字符串中 最后一次出现的位置(索引)，找不到返回-1
            //int index = a1.lastIndexOf('h');   从尾部找，'h'最后一次出现的位置
            //int index = a1.lastIndexOf('h',3); 从索引为3的元素开始往前找，'h'最后一次出现的位置 
       ★substring(); //截取字符串，返回新的字符串
                    //String newStr = a1.substring(2);       //从给定索引，直接截取到字符串末尾
                    //String newStr = a1.substring(2,5);     //包左不包右(前闭后开), 能取索引2的元素，不能取索引5的元素
		★isEmpty(); //判断字符串是否为空(长度为0返回true，不为0返回false)
        ★contains();    //判断字符串中是否包含 给定的字符串。
        endsWith(); //判断字符串是否以 给定的字符串 结尾。
        startsWith(); //判断字符串是否以 给定的字符串 开头。
		
        ★replace(); //用新内容替代旧内容，返回新的字符串    
        toLowerCase();  //把字母都转成其对应的小写形式。
        toUpperCase();  //把字母都转成其对应的大写形式。
		toCharArray() // 把字符串转换为数组
		getBytes() // 把字符串转换为字节数组        
		★trim();            //移除首尾空格。
		★split();   //根据给定的内容，切割字符串，返回字符串数组

```

```java
public class Test {
    public static void main(String[] args) {
        /*
            ★boolean isEmpty(); //判断字符串是否为空(长度为0返回true，不为0返回false)
            ★boolean contains(CharSequence s);    //判断字符串中是否包含 给定的字符串。
            endsWith(); //判断字符串是否以 给定的字符串 结尾。
            startsWith(); //判断字符串是否以 给定的字符串 开头。

            ★replace(); //用新内容替代旧内容，返回新的字符串
            toLowerCase();  //把字母都转成其对应的小写形式。
            toUpperCase();  //把字母都转成其对应的大写形式。
            toCharArray() // 把字符串转换为数组
            getBytes() // 把字符串转换为字节数组
            ★trim();            //移除首尾空格。
            ★split();   //根据给定的内容，切割字符串，返回字符串数组
         */
        // isEmpty(); //判断字符串是否为空(长度为0返回true，不为0返回false)
        String str1 = null;// 空 表示什么都没有
        String str2 = "";// 空字符串对象
        String str3 = " ";// 有一个空格字符的字符串对象
        //System.out.println(str1.isEmpty());// 报空指针异常,因为null不能调用方法
        System.out.println(str2.isEmpty());// true
        System.out.println(str3.isEmpty());// false

        System.out.println("=========================");

        String str = "itheima-itcast";
        // boolean contains(CharSequence s);    //判断字符串中是否包含 给定的字符串
        // 需求:判断str字符串中是否包含itcast
        System.out.println(str.contains("itcast"));// true
        System.out.println(str.contains("itcasts"));// false

        System.out.println("=========================");

        // boolean endsWith(String subff); //判断字符串是否以 给定的字符串 结尾。
        String fileName = "Test.java";
        System.out.println(fileName.endsWith(".java"));// true
        System.out.println(fileName.endsWith(".txt"));// false

        // startsWith(); //判断字符串是否以 给定的字符串 开头。
        System.out.println(fileName.startsWith("Test"));// true
        System.out.println(fileName.startsWith("Demo"));// false

        System.out.println("=========================");

        // ★String replace(CharSequence target, CharSequence replacement); //用新内容替代旧内容，返回新的字符串
        String message = "啊啊特朗普啊啊啊特朗普----特朗普";
        // 需求: 把特朗普替换为***
        String msg = message.replace("特朗普", "***");
        System.out.println("原字符串:"+message);// 啊啊特朗普啊啊啊特朗普----特朗普
        System.out.println("新字符串:"+msg);// 啊啊***啊啊啊***----***

        System.out.println("=========================");

        // toLowerCase();  //把字母都转成其对应的小写形式。
        String str4 = "aBcD";
        String s4 = str4.toLowerCase();
        System.out.println("s4:"+s4);// abcd

        // toUpperCase();  //把字母都转成其对应的大写形式。
        String s5 = str4.toUpperCase();
        System.out.println("s5:"+s5);// ABCD

        // toCharArray() // 把字符串转换为数组
        char[] chs = str4.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i]);// a   B   c   D
        }

        System.out.println("=========================");

        // getBytes() // 把字符串转换为字节数组
        byte[] bytes = str4.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);// 97,66,99,68
        }

        System.out.println("=========================");

        // ★trim();            //移除首尾空格。
        String username = "  zhangsan  ";
        String name = username.trim();
        System.out.println("==="+name+"===");

        System.out.println("=========================");

        // ★String[] split(String regex);   //根据给定的内容，切割字符串，返回字符串数组
        // 基本用法: 传入一个普通的字符串,没有特殊含义
        String str5 = "itcast,itheima,boxuegu";
        // 指定按照逗号进行切割字符串
        String[] arr = str5.split(",");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("=========================");
        // 高级用法: 传入有特殊含义的字符串,其实就是正则表达式
        String str6 = "abc bcd     cba              nba";
        String[] arr2 = str6.split(" +");
        System.out.println(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        System.out.println("=========================");
        String str7 = "abc.cba.nba.bac";
        String[] arr3 = str7.split("\\.");
        System.out.println(arr3.length);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
        
    }
}

```

## 知识点--2 StringBuilder类

### 知识点--2.1 String类字符串拼接问题

#### 目标:

- String类字符串拼接问题

#### 步骤:

- 字符串拼接问题

#### 讲解:

##### 字符串拼接问题

由于String类的对象内容不可改变，所以每当进行字符串拼接时，总是会在内存中创建一个新的对象。例如：

```java
public class StringDemo {
    public static void main(String[] args) {
        String s = "Hello";
        s += "World";// s = s + "World";
        System.out.println(s);// HelloWorld
    }
}
```

在API中对String类有这样的描述：字符串是常量，它们的值在创建后不能被更改。

根据这句话分析我们的代码，其实总共产生了三个字符串，即`"Hello"`、`"World"`和`"HelloWorld"`。引用变量s首先指向`Hello`对象，最终指向拼接出来的新字符串对象，即`HelloWord` 。

![](img\String拼接问题.bmp)

由此可知，如果对字符串进行拼接操作，每次拼接，都会构建一个新的String对象，**既耗时，又浪费空间**。为了解决这一问题，可以使用`java.lang.StringBuilder`类。

#### 小结

- 结论:
  - String类的字符串拼接,每一次拼接完都会得到一个新的字符串对象,所以比较耗时,也浪费空间

### 知识点--2.2 StringBuilder类概述以及与String类的区别

#### 目标

- 理解StringBuilder的概述和与String类的区别

#### 路径

- StringBuilder类的概述
- StringBuilder类和String类的区别

#### 讲解

##### StringBuilder类概述

​	**StringBuilder 是一个可变的字符串类**，我们可以把它看成是一个容器，这里的可变指的是 StringBuilder 对象中的内容是可变的

##### StringBuilder类和String类的区别

- String类：内容是不可变的

- StringBuilder类：内容是可变的

  ![06-StringBuilder的原理](img\06-StringBuilder的原理.png)

#### 小结

- StringBuilder 是一个可变的字符串类,表示字符串
- StringBuilder 拼接是直接在本身的字符串末尾进行拼接的

### 知识点--2.3 StringBuilder类的构造方法

#### 目标:

- StringBuilder构造方法

#### 路径:

- StringBuilder构造方法

#### 讲解:

- 常用的构造方法

  ```java
      public StringBuilder()创建一个空白可变字符串对象，不含有任何内容
      public StringBuilder(String   str)根据字符串的内容，来创建可变字符串对象
  ```

- 示例代码

```java
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //public StringBuilder()：创建一个空白可变字符串对象，不含有任何内容
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb);
        System.out.println("sb.length():" + sb.length());

        //public StringBuilder(String str)：根据字符串的内容，来创建可变字符串对象
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println("sb2:" + sb2);
        System.out.println("sb2.length():" + sb2.length());
    }
}
```

#### 小结

略

### 知识点--2.4 StringBuilder类拼接和反转方法

#### 目标:

- StringBuilder类拼接和反转方法

#### 路径:

- StringBuilder类拼接和反转方法

#### 讲解:

- 添加和反转方法

  ```java
  public StringBuilder append(任意类型) 拼接数据，并返回对象本身
  public StringBuilder insert(int offset, 任意类型) 在指定位置插入数据,并返回对象本身
  public StringBuilder reverse()  反转字符串,并返回对象本身
  ```

- 示例代码

```java
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //创建对象
        StringBuilder sb = new StringBuilder();

        //public StringBuilder append(任意类型)：添加数据，并返回对象本身
//        StringBuilder sb2 = sb.append("hello");
//
//        System.out.println("sb:" + sb);
//        System.out.println("sb2:" + sb2);
//        System.out.println(sb == sb2);

//        sb.append("hello");
//        sb.append("world");
//        sb.append("java");
//        sb.append(100);

        //链式编程
        sb.append("hello").append("world").append("java").append(100);

        System.out.println("sb:" + sb);

        //public StringBuilder reverse()：返回相反的字符序列
        sb.reverse();
        System.out.println("sb:" + sb);
    }
}
```

#### 小结

```java
StringBuilder类常用方法:
    public StringBuilder   append(任意类型)  添加数据，并返回对象本身
    public StringBuilder   reverse()  返回相反的字符序列
```

### 知识点--2.5 StringBuilder和String相互转换

#### 目标:

- StringBuilder和String相互转换

#### 路径:

- StringBuilder转换为String
- String转换为StringBuilder

#### 讲解:

##### StringBuilder转换为String

​        `public String toString()`：通过StringBuilder类中的 toString() 就可以实现把 StringBuilder 转换为 String

##### String转换为StringBuilder

​        `public StringBuilder(String s)`：通过StringBuilder的构造方法就可以实现把 String 转换为 StringBuilder

- 示例代码

```java
public class StringBuilderDemo02 {
    public static void main(String[] args) {
        /*
        //StringBuilder 转换为 String
        StringBuilder sb = new StringBuilder();
        sb.append("hello");

        //String s = sb; //这个是错误的做法

        //public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String
        String s = sb.toString();
        System.out.println(s);
        */

        //String 转换为 StringBuilder
        String s = "hello";

        //StringBuilder sb = s; //这个是错误的做法

        //public StringBuilder(String s)：通过构造方法就可以实现把 String 转换为 StringBuilder
        StringBuilder sb = new StringBuilder(s);

        System.out.println(sb);
    }
}
```

#### 小结

略

### 实操--2.6 字符串拼接升级版案例

#### 需求

​	定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，

​	并在控制台输出结果。例如，数组为int[] arr = {1,2,3}; ，执行方法后的输出结果为：[1, 2, 3]

#### 分析

1. 定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
2. 定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回。返回值类型 String，参数列表 int[] arr
3. 在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
4. 调用方法，用一个变量接收结果
5. 输出结果

#### 实现

```java
/*
    思路：
        1:定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        2:定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回。
          返回值类型 String，参数列表 int[] arr
        3:在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        4:调用方法，用一个变量接收结果
        5:输出结果
 */
public class StringBuilderTest01 {
    public static void main(String[] args) {
        //定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1, 2, 3};

        //调用方法，用一个变量接收结果
        String s = arrayToString(arr);

        //输出结果
        System.out.println("s:" + s);

    }

    //定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回
    /*
        两个明确：
            返回值类型：String
            参数：int[] arr
     */
    public static String arrayToString(int[] arr) {
        //在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i=0; i<arr.length; i++) {
            if(i == arr.length-1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(", ");
            }
        }

        sb.append("]");

        String s = sb.toString();

        return  s;
    }
}
```

#### 小结

略

### 实操--2.7 字符串反转升级版案例

#### 需求

​	定义一个方法，实现字符串反转。键盘录入一个字符串，调用该方法后，在控制台输出结果

​	例如，键盘录入abc，输出结果 cba

#### 分析

1. 键盘录入一个字符串，用 Scanner 实现
2. 定义一个方法，实现字符串反转。返回值类型 String，参数 String s
3. 在方法中用StringBuilder实现字符串的反转，并把结果转成String返回
4. 调用方法，用一个变量接收结果
5. 输出结果

#### 实现

```java
/*
    思路：
        1:键盘录入一个字符串，用 Scanner 实现
        2:定义一个方法，实现字符串反转。返回值类型 String，参数 String s
        3:在方法中用StringBuilder实现字符串的反转，并把结果转成String返回
        4:调用方法，用一个变量接收结果
        5:输出结果
 */
public class StringBuilderTest02 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //调用方法，用一个变量接收结果
        String s = myReverse(line);

        //输出结果
        System.out.println("s:" + s);
    }

    //定义一个方法，实现字符串反转。返回值类型 String，参数 String s
    /*
        两个明确：
            返回值类型：String
            参数：String s
     */
    public static String myReverse(String s) {
        //在方法中用StringBuilder实现字符串的反转，并把结果转成String返回
        //String --- StringBuilder --- reverse() --- String
//        StringBuilder sb = new StringBuilder(s);
//        sb.reverse();
//        String ss = sb.toString();
//        return ss;

       return new StringBuilder(s).reverse().toString();
    }
}
```

#### 小结

略

## 知识点--3. ArrayList

### 知识点--3.1 集合的概述以及与数组的区别

#### 目标

- 能够了解集合的概念和知道集合与数组的区别

#### 路径

- 集合的概述
- 集合与数组的区别

#### 讲解

##### 集合的概述

- 思考: 编程的时候如果要存储多个数据,首先我们想到的就是数组,但是数组的特点是长度固定,所以数组不一定能满足我们的需求,更适应不了变化的需求,那么应该如何选择呢? 
- 什么是集合
  - 集合其实就是一个大小可变的容器,可以用来存储多个数据
  - 集合的特点: 集合的大小可以动态改变,可以存储各种类型的数据

##### 集合与数组的区别

- 数组：数组大小固定，只能存储相同数据类型的数据 
- 集合：集合大小可动态扩展，可以存储各种引用类型的数据

#### 小结

- 集合: 是一个大小可变的容器,可以用来存储多个数据
- 集合和数组的区别:
  - 数组大小是固定,只能存储相同数据类型的数据
  - 集合大小是可变,可以存储各种引用类型的数据

### 知识点--3.2 ArrayList类概述

#### 目标

- 能够理解ArrayList类的概念

#### 路径

- ArrayList类概述

#### 讲解

集合类有很多,目前我们先学习一个: `ArrayList`

##### ArrayList类概述

- 通过查看ArrayList类的API:
  - `java.util.ArrayList <E>` ：该类需要 import导入使后使用。  
  - <E> 表示一种指定的数据类型,叫做泛型,用于约束集合中存储元素的数据类型
  - 怎么用呢?
    - 在出现E的地方我们使用引用数据类型替换即可，表示我们将存储哪种引用类型的元素。
    - 例如: 
      - ArrayList<String> 表示ArrayList集合中只能存储String类型的对象
      - ArrayList<Student> 表示ArrayList集合中只能存储Student类型的对象
      - .....
  - 概述:
    - ArrayList类底层是大小可变的数组的实现，存储在内的数据称为元素。也就是说ArrayList 中可以不断添加元素，其大小会自动增长。

#### 小结

- 概述: ArrayList类底层是一个大小可变的数组实现
- 使用ArrayList<E>类的时候,在E出现的位置使用引用数据类型替换,表示该集合可以存储哪种引用类型的元素

### 知识点--3.3 ArrayList类构造方法

#### 目标

- 能够使用ArrayList类的构造方法创建ArrayList集合对象

#### 路径

- 介绍ArrayList的构造方法
- 案例演示

#### 讲解

- 介绍ArrayList的构造方法

  - `ArrayList()`  构造一个初始容量为 10 的空列表。 

- 案例演示

  ```java
  public class Test {
      public static void main(String[] args) {
          /*
              ArrayList类构造方法:
                  ArrayList()  构造一个初始容量为 10 的空列表。
  
              如果一个集合需要存储基本数据类型的数据,那么需要把基本数据类型转换为对应的引用数据类型
                  基本数据类型            引用数据类型
                  byte                    Byte
                  short                   Short
                  int                     Integer
                  long                    Long
                  double                  Double
                  float                   Float
                  char                    Character
                  boolean                 Boolean
           */
          // 创建了一个ArrayList集合对象,限制集合中的元素类型为String类型
          ArrayList<String> list1 = new ArrayList<String>();
  
          // 创建一个ArrayList集合对象,限制集合中的元素类型为student类型
          ArrayList<Student> list2 = new ArrayList<Student>();
  
          // 简写:
          ArrayList<String> list11 = new ArrayList<>();
          ArrayList<Student> list22 = new ArrayList<>();
  
          // 创建一个ArrayList集合对象,可以存储任意引用类型的数据
          ArrayList list3 = new ArrayList();
  
          // 把基本数据类型转换为对应的引用数据类型
          Integer i = 10;// 基本数据类型转换为引用数据类型
          int num = i;// 引用数据类型转换为基本数据类型
  
          // 创建一个ArrayList集合对象,限制集合中的元素类型为Integer类型
          ArrayList<Integer> list4 = new ArrayList<>();
      }
  }
  ```

#### 小结

- 略

### 知识点-- 3.4 ArrayList类添加元素方法

#### 目标

- 能够往ArrayList集合中添加元素

#### 路径

- ArrayList添加元素的方法

#### 讲解

- ArrayList添加元素的方法

  -  public boolean add(E e)：将指定的元素追加到此集合的末尾
  -  public void add(int index,E element)：在此集合中的指定位置插入指定的元素

- 案例演示:

  ```java
  public class Test {
      public static void main(String[] args) {
          /*
              ArrayList类添加元素方法:
                  boolean add(E e)  将指定的元素添加在集合的末尾
                  void add(int index, E element)  将指定的元素插入在指定的索引位置。
           */
          // 创建了一个ArrayList集合对象,限制集合中的元素类型为String类型
          ArrayList<String> list1 = new ArrayList<>();
  
          // 往list1集合的末尾添加元素
          list1.add("张三丰");
          list1.add("章子怡");
          list1.add("张翠山");
  
  
          // 打印集合
          System.out.println(list1);// [张三丰, 章子怡, 张翠山]
  
          // 往list1集合所有为1的位置添加一个张无忌元素
          list1.add(1, "张无忌");
          System.out.println(list1);// [张三丰, 张无忌, 章子怡, 张翠山]
  
          System.out.println("======================================");
          // 创建一个ArrayList集合对象,可以存储任意引用类型的数据
          ArrayList list3 = new ArrayList();
  
          // 往list3集合中添加任意引用数据类型的元素
          list3.add("殷素素");
          list3.add(18);// int---->自动转换为Integer类型
          list3.add(3.14);// double--->自动转换为Double类型
          System.out.println(list3);// [殷素素, 18, 3.14]
  
          System.out.println("==========================");
          // 创建一个ArrayList集合对象,限制集合中的元素类型为Integer类型
          ArrayList<Integer> list4 = new ArrayList<>();
  
          //  往list4集合中添加任意引用数据类型的元素
          list4.add(10);
          list4.add(20);
          list4.add(30);
          System.out.println(list4);// [10, 20, 30]
      }
  }
  
  ```

#### 小结

- 略

### 知识点--3.5 ArrayList类常用方法

#### 目标

- 会使用ArrayList常用方法

#### 步骤

- ArrayList常用方法

#### 讲解

##### ArrayList常用方法

```java
public boolean   remove(Object o) 删除指定的元素，返回删除是否成功
public E   remove(int   index) 删除指定索引处的元素，返回被删除的元素
public E   set(int index, E  element) 修改指定索引处的元素，返回被修改的元素
public E   get(int   index) 返回指定索引处的元素
public int   size() 返回集合中的元素的个数
```



##### 示例代码

```java
public class Test {
    public static void main(String[] args) {
        /*
            public boolean   remove(Object o) 删除指定的元素，返回删除是否成功
            public E   remove(int   index) 删除指定索引处的元素，返回被删除的元素
            public E   set(int index, E  element) 修改指定索引处的元素，返回被修改的元素
            public E   get(int   index) 返回指定索引处的元素
            public int size() 返回集合中的元素的个数
         */
        // 创建一个ArrayList集合,限制集合中元素的类型为String类型
        ArrayList<String> list1 = new ArrayList<>();

        // 先往集合中添加一些元素
        list1.add("张柏芝");
        list1.add("白百合");
        list1.add("李小璐");
        list1.add("马蓉");
        System.out.println(list1);// [张柏芝, 白百合, 李小璐, 马蓉]

        // 需求:删除马蓉这个元素   boolean remove(Object o)
        list1.remove("马蓉");
        System.out.println("删除马蓉后的集合:" + list1);//  [张柏芝, 白百合, 李小璐]

        // 需求:删除索引为1的元素  E remove(int index)
        String removeE = list1.remove(1);
        System.out.println("被删除的元素是:" + removeE);// 白百合
        System.out.println("删除索引为1的元素后的集合:" + list1);//  [张柏芝, 李小璐]

        // 需求:修改索引为1的元素为罗志祥  E set(int index, E element)
        String setE = list1.set(1, "罗志祥");
        System.out.println("被替换的元素是:" + setE);// 李小璐
        System.out.println("替换索引为1的元素后的集合:" + list1);//  [张柏芝, 罗志祥]

        // 需求:获取索引为0的元素  E  get(int index)
        String e = list1.get(0);
        System.out.println("0索引上的元素是:" + e);// 张柏芝

        // 需求:获取集合中元素的个数 int size()
        int size = list1.size();
        System.out.println("集合中元素的个数是:" + size);// 2

        // 循环遍历集合中所有元素
        for (int i = 0; i < size; i++) {
            System.out.println(list1.get(i));
        }

    }
}

```

#### 小结

```java
ArrayList常用方法:
    public boolean remove(Object o)   删除指定的元素，返回删除是否成功
    public E   remove(int   index)    删除指定索引处的元素，返回被删除的元素
    public E   set(int index, E  element) 修改指定索引处的元素，返回被修改的元素
    public E   get(int   index) 返回指定索引处的元素
    public int   size() 返回集合中的元素的个数
```

### 扩展---问题

```java
public class Test {
    public static void main(String[] args) {
        /*
            1.指定位置添加元素问题
            2.删除元素的问题
                如果集合中的元素类型为Integer类型,调用remove方法默认是根据索引删除元素
         */
        // 2.删除元素的问题
        // 1.1 创建ArrayList集合,限制集合中元素的类型为Integer类型
        ArrayList<Integer> list = new ArrayList<>();

        // 1.2 往集合中添加一些元素
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("删除元素前的集合:"+list);

        // 需求:删除2这个元素
          list.remove(2);// 删除索引为2的元素
        //Integer i = new Integer(2);
        // list.remove(i);// 删除2这个元素

        System.out.println("删除元素后的集合:"+list);
    }

    // 1.指定位置添加元素问题  void add(int index, E element)
    private static void method01() {
        // 1.1 创建ArrayList集合,限制集合中元素的类型为String类型
        ArrayList<String> list1 = new ArrayList<>();

        // 1.2 往集合中添加一些元素
        list1.add("谢霆锋");
        list1.add("陈羽凡");
        list1.add("王宝强");
        list1.add("贾乃亮");
        System.out.println(list1);// [谢霆锋, 陈羽凡, 王宝强, 贾乃亮]

        // 需求:把陈冠希添加在索引为5的位置上,行不行?
        //list1.add(5, "陈冠希");// 报异常IndexOutOfBoundsException

        // 需求:把陈冠希添加在索引为4的位置上,行不行?
        // list1.add("陈冠希");// 4索引
        list1.add(4, "陈冠希");// 4索引
        System.out.println(list1);// [谢霆锋, 陈羽凡, 王宝强, 贾乃亮, 陈冠希]
    }
}

```



### 实操-3.6 ArrayList存储字符串并遍历

#### 需求

- 创建一个存储字符串的集合，存储3个字符串元素，使用程序实现在控制台遍历该集合

#### 分析

1. 创建集合对象
2. 往集合中添加字符串对象
3. 遍历集合，首先要能够获取到集合中的每一个元素，这个通过get(int index)方法实现
4. 遍历集合，其次要能够获取到集合的长度，这个通过size()方法实现
5. 遍历集合的通用格式

#### 实现

```java
import java.util.ArrayList;

/*
ArrayList存储字符串并遍历

需求
    - 创建一个存储字符串的集合，存储3个字符串元素，使用程序实现在控制台遍历该集合
分析:
    1.创建ArrayList集合对象,限制集合中元素的类型为String类型
    2.往集合对象中存储3个字符串元素  使用add()方法往集合中添加元素
    3.获取集合中元素的个数
    4.循环遍历集合中每一个元素

 */
public class Test1ArrayList {
    public static void main(String[] args) {
        // 1.创建ArrayList集合对象,限制集合中元素的类型为String类型
        ArrayList<String> list = new ArrayList<>();

        // 2.往集合对象中存储3个字符串元素  使用add()方法往集合中添加元素
        list.add("唐三");
        list.add("小舞");
        list.add("荣荣");

        // 3.获取集合中元素的个数
        //int size = list.size();

        // 4.循环遍历集合中每一个元素
        for (int i = 0;i<list.size();i++){
            // 获取元素,并打印
            System.out.println(list.get(i));
        }
    }
}
```

#### 小结

略

### 实操--3.7 ArrayList存储学生对象并遍历

#### 需求

- 创建一个存储学生对象的集合，存储3个学生对象，使用程序实现在控制台遍历该集合

#### 分析

1. 定义学生类
2. 创建集合对象
3. 创建学生对象
4. 添加学生对象到集合中
5. 遍历集合，采用通用遍历格式实现

#### 实现

```java
import java.util.ArrayList;

/*
ArrayList存储学生对象并遍历

需求:
    - 创建一个存储学生对象的集合，存储3个学生对象，使用程序实现在控制台遍历该集合
分析:
    1.创建学生类
    2.创建3个学生对象
    3.创建ArrayList集合对象,限制集合中元素的类型为学生类类型
    4.往集合中存储那3个学生对象
    5.循环遍历集合中的元素,打印输出
 */
public class Test2ArrayList {
    public static void main(String[] args) {
        // 创建3个学生对象
        Student stu1 = new Student("萧炎",18);
        Student stu2 = new Student("薰儿",19);
        Student stu3 = new Student("美杜莎",20);

        // 创建ArrayList集合对象,限制集合中元素的类型为学生类类型
        ArrayList<Student> list = new ArrayList<>();

        // 往集合中存储那3个学生对象
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        // 循环遍历集合中的元素,打印输出
        for (int i = 0;i<list.size();i++){
            // 获取集合元素
            Student stu = list.get(i);
            // System.out.println("stu:"+stu);// 打印地址值
            System.out.println( stu.getName()+","+ stu.getAge());
        }
    }
}
```

![1584413457112](H:\0228全国直播\day14_ArrayList\01_笔记\img\1584413457112.png)

#### 小结

略

### 实操--3.8 ArrayList存储学生对象并遍历升级版

#### 需求

- 创建一个存储学生对象的集合，存储3个学生对象，使用程序实现在控制台遍历该集合 ( 学生的姓名和年龄来自于键盘录入)

#### 分析

1. 定义学生类，为了键盘录入数据方便，把学生类中的成员变量都定义为String类型
2. 创建集合对象
3. 键盘录入学生对象所需要的数据
4. 创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
5. 往集合中添加学生对象
6. 遍历集合，采用通用遍历格式实现

#### 实现

```java
/*
    思路：
        1:定义学生类，为了键盘录入数据方便，把学生类中的成员变量都定义为String类型
        2:创建集合对象
        3:键盘录入学生对象所需要的数据
        4:创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        5:往集合中添加学生对象
        6:遍历集合，采用通用遍历格式实现
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Student> array = new ArrayList<Student>();

        //为了提高代码的复用性，我们用方法来改进程序
        addStudent(array);
        addStudent(array);
        addStudent(array);

        //遍历集合，采用通用遍历格式实现
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }
    }

    /*
        两个明确：
            返回值类型：void
            参数：ArrayList<Student> array
     */
    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生对象所需要的数据
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();

        System.out.println("请输入学生年龄:");
        String age = sc.nextLine();

        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student();
        s.setName(name);
        s.setAge(age);

        //往集合中添加学生对象
        array.add(s);
    }
}
```

#### 小结

略

## 总结

```java
String类:
	概述: 表示不可变的字符串
    创建字符串对象:
		1.通过String类的构造方法     堆区
            public String();
			public String(char[] chs)
            public String(byte[] bys);
			public String(String str); 例如:String str = new String("abc");// str:"abc"

        2.通过双引号直接赋值的方式    常量池
           String str = "abc";
     常用方法: 功能
         concat();  //把两个字符串拼接起来，获取一个新的字符串
        ★length();  //获取字符串的长度(其实就是获取字符串中 字符的个数)      
        ★equals();  //比较两个字符串的内容是否相同。    //区分大小写
        equalsIgnoreCase();  //比较两个字符串的内容是否相同。    //忽略大小写
        ★charAt();  //根据给定的索引，获取对应位置的字符
        ★indexOf(); //获取指定的字符 在字符串中 第一次出现的位置(索引)，找不到返回-1
            //int index = a1.indexOf('h');   从头找，'h'第一次出现的位置
            //int index = a1.indexOf('h',3); 从索引为3的元素开始往后找，'h'第一次出现的位置
       lastIndexOf();  //获取指定的字符 在字符串中 最后一次出现的位置(索引)，找不到返回-1
            //int index = a1.lastIndexOf('h');   从尾部找，'h'最后一次出现的位置
            //int index = a1.lastIndexOf('h',3); 从索引为3的元素开始往前找，'h'最后一次出现的位置 
       ★substring(); //截取字符串，返回新的字符串
                    //String newStr = a1.substring(2);       //从给定索引，直接截取到字符串末尾
                    //String newStr = a1.substring(2,5);     //包左不包右(前闭后开), 能取索引2的元素，不能取索引5的元素
		★isEmpty(); //判断字符串是否为空(长度为0返回true，不为0返回false)
        ★contains();    //判断字符串中是否包含 给定的字符串。
        endsWith(); //判断字符串是否以 给定的字符串 结尾。
        startsWith(); //判断字符串是否以 给定的字符串 开头。
		
        ★replace(); //用新内容替代旧内容，返回新的字符串    
        toLowerCase();  //把字母都转成其对应的小写形式。
        toUpperCase();  //把字母都转成其对应的大写形式。
		toCharArray() // 把字符串转换为数组
		getBytes() // 把字符串转换为字节数组        
		★trim();            //移除首尾空格。
		★split();   //根据给定的内容，切割字符串，返回字符串数组

   StringBuilder:
		概述: 表示可变的字符串
        创建StringBuilder对象:
			 StringBuilder();
			 StringBuilder(String str)
        常用方法:
		    StringBuilder append(任意数据)  拼接
            StringBuilder insert(int index,任意数据) 插入
            StringBuilder reverse() 反转
            String toString()  转换为String对象 
   ArrayList<E>:
		使用: 在出现E的位置写指定的引用数据类型替换,用来限制集合中元素的数据类型
		概述: 表示集合对象
        作用: 可以存储多个不固定数量的引用数据类型的数据
        构造方法:
				ArrayList(); 
		成员方法:
			add(E e) 在末尾增加元素
            add(int index, E e) 在指定位置添加元素
            remove(Object e) 删除指定的元素
            remove(int index) 删除指定索引位置上的元素
            set(int index,E e) 替换指定索引位置上的元素
            get(int index)  根据指定索引获取元素
            size() 获取集合元素个数(大小,长度)
                
- 能够知道字符串对象通过构造方法创建和直接赋值的区别
      字符串对象通过构造方法创建:每次new都会在堆区创建对象,哪怕字符串内容一样,都会新创建对象
	  直接赋值: 存在常量池,如果字符串内容一样,就不会创建新的字符串对象,直接共享
- 能够完成用户登录案例
     1.定义一个用户名和密码的字符串
     2.获取用户输入的用户名和密码
     3.拿用户输入的用户名和密码与定义的用户名和密码进行比较,如果都相同,就登录成功,否则就登录失败
- 能够完成统计字符串中大写,小写,数字字符的个数
     1.定义3个统计变量,分别统计大写,小写,数字字符的个数
     2.循环遍历字符串,根据索引获取字符串的每一个字符
     3.判断,计数
- 能够知道String和StringBuilder的区别
      String: 不可变
      StringBuilder:可变
- 能够完成String和StringBuilder的相互转换
     String---StringBuilder:  public StingBuilder(String str)
     StringBuilder---String:  String toString();
- 能够使用StringBuilder完成字符串的拼接
    StringBuilder append(任意数据);
- 能够使用StringBuilder完成字符串的反转
    StringBuilder  reverse();
- 能够知道集合和数组的区别
    1.集合的长度是不固定的,数组的长度是固定的
    2.集合中元素的类型是引用数据类型,数组中的元素类型可以是集合数据类型,也可以是引用数据类型
    3.集合中元素的类型可以不一致,数组中元素的类型必须一致
    
- 能够完成ArrayList集合添加字符串并遍历
     1.创建ArrayList集合
     2.往集合中添加字符串元素
     3.循环遍历,根据索引获取元素
- 能够完成ArrayList集合添加学生对象并遍历
     1.创建ArrayList集合
     2.往集合中添加学生对象元素
     3.循环遍历,根据索引获取元素
```

