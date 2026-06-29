package examples;


public class Test {

    static int RecordId = 10;

    public int GetRecordId() {

        Test t = new Test();

        return t.RecordId;
    }
}



public class Main {

    public static int nthFibonacci(int n) {
        if (n <= 1) return n;
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }


    public static void main(String[] args) {
//        System.out.println("Hello World");
//
//        int a = 11;

        Test t = new Test();
        System.out.println(t.GetRecordId());

//        System.out.println(nthFibonacci(a));
    }
}