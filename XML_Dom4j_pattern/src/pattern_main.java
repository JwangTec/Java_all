/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/4 下午3:11
 */
public class pattern_main {
    public static void main(String[] args) {
        String str = "had";

        //除开aeiou字符之外开头
        final boolean b = str.matches("[^aeiou]ad"); //true
        "aad".matches("[^aeiou]ad"); //false

        //X？：0或1次  X*：0或多次 X+：一或多次 X{n,}：至少n次

        //分组括号
        String str2 = "ASDFE_ADCSD_ASDCE_A6756_78654";
        final boolean b1 = str2.matches("([A-Z0-9]{5}_){4}([A-Z0-9]{5})");
        System.out.println(b1);

        // (.)\\1(.)\\2 :第一组括号里的再出现一次，以及第二组小括号再出现一次
        System.out.println("呵呵呵哈哈哈".matches("(.)\\1{2}(.)\\2{2}"));
        System.out.println("高薪高薪".matches("(..)\\1"));

    }
}
