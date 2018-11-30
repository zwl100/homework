package designModule.builderModule;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .setName("张三")  //方法返回值是PersonBuiler类，所以可以链式调用
                .setAge(18)
                .setSex('男')
                .setHeight(181)
                .build();
        System.out.println(person.toString());
    }
}
