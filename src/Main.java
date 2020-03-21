import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("src\\Test");
        StringBuilder res = new StringBuilder();
        int[] data = {1,2,4,8,16,32,64,100,128,200,256,378,512,1024,1568,2048,3053,4096,9000,18000,36000,72000,100000};
        for (int j = 0; j < data.length; j++) {
            for (int i = 1; i <= data[j]; i++) {
                fileWriter.write(i + " " + i + " " + i + " " + i + "\n");
            }
            fileWriter.flush();
            long startTime = System.currentTimeMillis();
            Polinom3 x = new Polinom3("src\\Test");
            x.toString();
            long finishTime = System.currentTimeMillis();
            res.append(finishTime - startTime + ",");

        }
        fileWriter.close();
        System.out.println(res.toString());
    }

}
