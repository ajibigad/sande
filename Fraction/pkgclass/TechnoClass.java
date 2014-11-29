package techno.pkgclass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 *
 * @author Julius
 */
public class TechnoClass {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        StreamTokenizer fin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        Fraction A = new Fraction(1, 2), B = new Fraction(3, 4),C=(A.add(B));
        //System.out.println(10%-1);
        System.out.printf("Final result = %s\n",A.subtract(B).add(C).subtract(C.subtract(A)).add(B).subtract(A.add(B)).subtract(Fraction.subtractAll(A,B,C).add(Fraction.addAll(A,A,B,B,C,C))));
        System.out.printf("Final result = %s\n",A.multiply(B).add(C).divide(C.add(A)).multiply(B).add(A.divide(Fraction.divideAll(A,A,C,B,B,C))).divide(Fraction.multiplyAll(A,B,C)));
        //System.out.println(Fraction.subtractAll(B,B,new Fraction(0,4),C));
    }

}
