package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取对象类型,得到一个类对象
        //方式1：类名.getClass()
        Class<? extends Person> aclass1 = new Person().getClass();
        System.out.println(aclass1);
        //方式2：Class.forName("类名");
        Class<?> aClass2 = Class.forName("reflect.Person");
        System.out.println(aClass2);
        //方式3：类名.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //是否是同一个对象呢？？
        System.out.println(aclass1==aClass2); //打印true
        /*****************************************************/

        //用反射方法创建对象：类对象.newInstance();
        Person p = Person.class.newInstance();

        /********获取方法*******/
        //1.类对象.getMethods(); 获取所有公共方法，包括从父类继承的。
        Method[] methods = Person.class.getMethods();
        for(Method method:methods){
            System.out.println(method);
        }
        //2.类对象.getDeclaredMethods(); 获取所有方法，但不包括从父类继承的
        Method[] methods1 = Person.class.getDeclaredMethods();
        for(Method m1:methods1){
            System.out.println(m1);
        }
        System.out.println("--------------------------------");
        //3.类对象.getMethod(方法名，参数类型) //找公共方法，包括继承的
        Method mth1 = Person.class.getMethod("setName", String.class);
        System.out.println(mth1);
        //4.类对象.getDeclaredMethod(方法名,参数类型) //找本类的所有方法，不包括继承的
        Method mth2 = Person.class.getDeclaredMethod("setAge", int.class);
        System.out.println(mth2);
        //如果方法没有形参，则参数类型不写
        Method mth3 = Person.class.getMethod("getName");
        System.out.println(mth3);

        //方法的反射调用：
        Person person=new Person();
        Method method = Person.class.getMethod("setAge", int.class);
        //若该方法为private方法限制，则通过下面的语句解除限制
        method.setAccessible(true);
        method.invoke(person, 18); //设置年龄为18
        System.out.println(person.getAge());

    }
}

