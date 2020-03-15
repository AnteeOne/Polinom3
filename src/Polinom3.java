/**
 * @author AnteeOne
 * @author EvilKashmir
 * @version 0.1a
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Polinom3 {

    private ArrayList<Monomial> data;

    /**
     * Private class of Monomial
     */
    private class Monomial implements Comparable<Monomial>{
        private int c;
        private int x;
        private int y;
        private int z;

        public Monomial(int c, int x, int y, int z) {
            this.c = c;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Monomial o) {
            if(this.getX() - o.getX() > 0){
                return -1;
            }
            else if(this.getX() - o.getX() < 0){
                return 1;
            }
            else{
                if(this.getY() - o.getY() > 0){
                    return -1;
                }
                else if(this.getY() - o.getY() < 0){
                    return 1;
                }
                else{
                    if(this.getZ() - o.getZ() > 0){
                        return -1;
                    }
                    else if(this.getZ() - o.getZ() < 0){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        }

        @Override
        public String toString() {
            String xx = "";
            String yy = "";
            String zz = "";
            if(x == 1) {
                xx = "x";
            } else if (x > 1){
                xx = "x^" + x;
            }
            if(y == 1) {
                yy = "y";
            } else if (y > 1){
                yy = "y^" + y;
            }
            if(z == 1) {
                zz = "z";
            } else if (z > 1){
                zz = "z^" + z;
            }
            if(c == -1){
                return "-" + xx + "*" + yy + "*" + zz;
            }
            return (c == 1  ? "" : c) + (x == 0 ? "": xx) +  (y == 0 ? "": "*" + yy) + (z == 0 ? "": "*" + zz );
        }

        public int getC() {
            return c;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }

    /**
     * Constructor , which builds a list based on a polynomial specified by
     * a list of coefficients and powers in a text file
     * @param filename
     * @throws FileNotFoundException
     */
    public Polinom3(String filename) throws FileNotFoundException {
        data = new ArrayList<>();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            data.add(new Monomial(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        data.sort(Monomial::compareTo);
    }

    /**
     * Method , which inserts new monomial in polinom.If in polinom already exist monomial with same degrees , replaces it.
     * @param coeff
     * @param deg1
     * @param deg2
     * @param deg3
     * @throws Exception
     */
    public void insert(int coeff, int deg1, int deg2, int deg3) throws Exception {
        if(deg1 < 0 || deg2 < 0 || deg3 < 0) {
            throw new Exception("Invalid Input!");
        }
        Monomial mon = new Monomial(coeff,deg1,deg2,deg3);
        for (int i = 0; i < data.size(); i++) {
            if(mon.compareTo(data.get(i)) == 0){
                data.set(i,mon);
                return;
            }
            else if(mon.compareTo(data.get(i)) < 0){
                data.add(i,mon);
                return;
            }
        }
        data.add(mon);
    }

    public void delete(int deg1, int deg2, int deg3){
        //TODO method , which deletes some monomial with some degrees at Polinom
    }

    public void add(Polinom3 p){
        //TODO method , which adds another Polinom
    }

    /**
     * Method , which calculates the value in some point(x,y,z)
     * @param x
     * @param y
     * @param z
     * @return value in point
     */
    public long value(int x, int y, int z){
        long sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i).c * Math.pow(x,data.get(i).x) * Math.pow(y,data.get(i).y) * Math.pow(z,data.get(i).z);
        }
        return sum;
    }

    /**
     * Method which calculate partial derivative at one of three variables
     * @param i - one of three variables{1,2,3}
     */
    public void derivate(int i){
        //TODO method which calculate partial derivative at one of three variables
    }

    /**
     * Method , which return string implementation of polinom
     * @return string implementation of polinom
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            if(i != 0){
                res.append(data.get(i).getC() > 0 ? " +" : " ");
            }
            res.append(data.get(i));
        }
        return res.toString();
    }



}
