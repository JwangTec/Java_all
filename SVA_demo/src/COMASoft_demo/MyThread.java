package COMASoft_demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/1/31 下午4:30
 */
public class MyThread extends Thread{

    public static ArrayList<Integer> arr = new ArrayList<>();
    public static CopyOnWriteArrayList<Integer> arr1 = new CopyOnWriteArrayList<>();

    public static HashSet<Integer> set1 = new HashSet<>();
    public static CopyOnWriteArraySet<Integer> set2 = new CopyOnWriteArraySet<>();

    public static HashMap<Integer, Integer> map1 = new HashMap<>();
    public static Hashtable<Integer, Integer> map2 = new Hashtable<>(); //效率低，全加了悲观锁sync
    public static ConcurrentHashMap<Integer, Integer> map3 = new ConcurrentHashMap<>(); //效率高 CAS机制+局部sync锁（锁桶）

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
//            arr.add(i);
//            arr1.add(i);
//            set1.add(i);
//            set2.add(i);
//            map1.put(i, i);
//            map2.put(i,i);
            map3.put(i,i);
        }

    }
}
