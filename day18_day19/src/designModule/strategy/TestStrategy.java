package designModule.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestStrategy {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        list.add(new Student("zhangsan",18));
        list.add(new Student("lisi",20));
        list.add(new Student("wangwu",16));
        list.add(new Student("lisi",18));
        list.add(new Student("lisi",22));

        //按年龄排序
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //比较规则由我们自己定义
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(list);

        //按照姓名进行排序
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(list);

        //先按照姓名，再按照年龄进行排序???年龄会自动排序？？？
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int flag=o1.getName().compareTo(o2.getName());
                return flag;
            }
        });
        System.out.println(list);
    }
}
