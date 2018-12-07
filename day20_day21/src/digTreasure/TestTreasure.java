package digTreasure;

import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestTreasure {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //下面写一个类加载器，可以加载任意位置的类
        ClassLoader c1 = new ClassLoader(){
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    FileInputStream in  = new FileInputStream("Treasure.class");
                    byte[] bytes = new byte[1024*8];
                    int len = in.read(bytes);

                    // 调用父类的方法根据字节数组加载类
                    return defineClass(name, bytes, 0, len);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

        };
        Class<?> clazz = c1.loadClass("com.westos.Treasure"); // 根据类名加载类, 得到类对象
        Constructor<?> con = clazz.getDeclaredConstructor();//得到该类的空参构造方法
        con.setAccessible(true);  //将该构造方法设置为public
        Object obj=con.newInstance();  //通过反射得到Treasure类的一个对象
        System.out.println("---------------------------------------------");
        //遍历该类的所有方法
        for (Method method : clazz.getDeclaredMethods()){
            Annotation[] an = method.getAnnotations();//得到每个方法的注释
            System.out.println(an.length);
            if(an.length>0){   //该方法有注释，说明是挖到宝藏的方法
                System.out.println(method);
                method.invoke(obj);  //通过反射调用该方法
            }
        }

    }
}
