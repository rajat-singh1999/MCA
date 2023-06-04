class Sample {
    int a;
    static int b;
    Sample(){
        b++;
    }
    public void showData(){
        System.out.println(a);
        System.out.println(b);
    }
}

public class StaticDemo{
    public static void main(String args[]){
        Sample s1 = new Sample();
        s1.showData();
        System.out.println(++Sample.b);
    }
}