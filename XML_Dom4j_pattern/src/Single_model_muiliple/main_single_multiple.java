package Single_model_muiliple;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/4 下午3:40
 */
public class main_single_multiple {

    public static void main(String[] args) {
        //单例创建
        final Person person = Person.getInstance();
        final Person person2 = Person.getInstance();

        System.out.println(person == person2);

        //多例
        for (int i = 0; i < 8; i++) {
            final Person_multiple p2 = Person_multiple.getInstance();
            System.out.println(p2);
        }
    }
}
