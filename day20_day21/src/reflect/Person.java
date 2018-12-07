package reflect;

public class Person {
    private String name;
    private int age;

    //set方法
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }

    //get方法
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

    //定义一个私有方法
    private void show(){

    }

}
