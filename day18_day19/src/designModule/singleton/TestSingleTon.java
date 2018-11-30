package designModule.singleton;

public class TestSingleTon {
    public static void main(String[] args) {
        SingleTon s1= SingleTon.getinstance();
        SingleTon s2= SingleTon.getinstance();
        System.out.println(s1==s2);
    }
}
