package factory_demo;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: 加工车对象
 * @USER: jwang
 * @DATE: 2021/2/4 下午4:22
 */
public class CarFactory {

    public static Car createCar(String carName){
        if(carName.equals("falali")){
            return new falali();
        }

        if(carName.equals("benci")){
            return new benci();
        }
        return null;
    }
}
