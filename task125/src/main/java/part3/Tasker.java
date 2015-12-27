package part3;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by vlad on 09.11.15.
 */
public class Tasker {

    public static void main(String[] aggs) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("Task10");
        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields= clazz.getDeclaredFields();
        methods[0].invoke(clazz.newInstance(),null);
//        System.out.print();
    }

}
