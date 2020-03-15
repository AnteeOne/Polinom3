public class Main {

    public static void main(String[] args) throws Exception {
        Polinom3 x = new Polinom3("src\\Test");
        System.out.println(x.toString());
        x.insert(5,5,5,5);
        System.out.println(x.toString());
        x.insert(5,0,0,0);
        System.out.println(x.toString());
        x.insert(5234,0,0,0);
        System.out.println(x.toString());



    }

}
