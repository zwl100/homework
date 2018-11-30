package designModule.singleton;

public class SingleTon {
    //饿汉式单例，在创建类时就已经创建对象
    //1.使构造方法私有，其他类中无法创建该类的实例
    private SingleTon(){

    }
    //2.自己通过私有构造方法创建这个实例
    private static final SingleTon ST=new SingleTon();
    //3.定义方法获取到这个实例
    public static SingleTon getinstance(){ //static，可以通过类名调用来创建实例
        return ST;
    }

}
