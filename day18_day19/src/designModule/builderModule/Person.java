package designModule.builderModule;


public class Person {
    private String name;
    private int age;
    private char sex;
    private float height;

    static class PersonBuilder{
        private String name;
        private int age;
        private char sex;
        private float height;

        public PersonBuilder setName(String name){
            this.name=name;
            return this;
        }
        public PersonBuilder setAge(int age){
            this.age=age;
            return this;
        }
        public PersonBuilder setSex(char sex){
            this.sex=sex;
            return this;
        }
        public PersonBuilder setHeight(float height){
            this.height=height;
            return this;
        }
        //把信息收集起来
        public Person build(){
            return new Person(this.name,this.age,this.sex,this.height);
        }
    }


    private Person(String name,int age,char sex,float height){
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.height=height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                '}';
    }
}

