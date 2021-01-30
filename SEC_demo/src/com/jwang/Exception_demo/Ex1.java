package com.jwang.Exception_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 异常
 * @USER: jwang
 * @DATE: 2021/1/30 下午5:30
 */
public class Ex1 {
    /**
     * 异常：Java是面相对象语言，异常本身也是一个类，出现异常就会创建异常的对象并抛出该对象
     *      异常体系：
     *         - Throwable:所有错误和异常的超类
     *              -- Error类：错误，无法通过代码进行纠正，只能避免
     *                      --- StackOverflowError等错误
     *              -- Exception：异常,可通过代码纠正
     *      异常分类：
     *          - 编译异常：编译期间异常
     *               -- 除RuntimeException及其子类之外都是编译器异常
     *          - 运行异常： 1/0
     *               -- RuntimeException及其子类
     *      jvm:jvm帮助创建相关异常类的对象-再抛出该异常对象
     *
     *      throw关键字：抛出指定的异常对象，用在方法内 throw new 异常（）
     *      throws：声明处理异常，只标识不处理，让调用者处理，方法名() throws 异常{}
     *              -- 声名处理异常仍然会造成异常程序终止
     * 捕获处理异常：对异常进行捕获，处理完后程序仍然可以向下执行
     *      try{可能出现异常的代码}catch(异常类型 变量名){处理异常}finally{一定会执行的代码块,即使try中有return，除非是system.exit()}
     *          -- try catch不能单独出现
     *          -- catch中的代码一定是try中的代码出现异常才会执行
     *          -- try某个位置出现异常，那么该位置之后try中的代码就不会执行
     * 获取异常信息：
     *      Throwable类中方法：
     *          -- getMessage()
     *          --toString()
     *          --printStackTrace()：打印异常跟踪栈信息并输出到控制台 --jvm就用这个
     *
     * 自定义异常：
     *      --编译期异常：继承Exception
     *      --运行期异常：继承RuntimeException
     *
     */
}
