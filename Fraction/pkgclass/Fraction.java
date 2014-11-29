/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techno.pkgclass;

public class Fraction {

    int num;
    int denom;

    Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    static Fraction add(Fraction A, Fraction B) {
        System.out.println(A + " + " + B);
        int lcm = Math.max(A.denom, B.denom) == A.denom ? A.denom % B.denom : B.denom % A.denom;
        //System.out.println(lcm);
        lcm = lcm == 0 ? Math.max(A.denom, B.denom) : A.denom * B.denom;
        //System.out.println(lcm);
        int nNum = (lcm / A.denom) * A.num + (lcm / B.denom) * B.num;
        //System.out.println(nNum);
        if (nNum == lcm) {
            return new Fraction(nNum, lcm);
        }
        if (nNum == 0) {
            return new Fraction(nNum, lcm);
        }
        int val[] = reduce(nNum, lcm);
        nNum = val[0];
        lcm = val[1];
        // System.out.println("result " + new Fraction(nNum, lcm));
        return new Fraction(nNum, lcm);
    }

    static Fraction subtract(Fraction A, Fraction B) {
        System.out.println(A + " - " + B);
        int lcm = Math.max(A.denom, B.denom) == A.denom ? A.denom % B.denom : B.denom % A.denom;
        //System.out.println(lcm);
        lcm = lcm == 0 ? Math.max(A.denom, B.denom) : A.denom * B.denom;
        //System.out.println(lcm);
        int nNum = (lcm / A.denom) * A.num - (lcm / B.denom) * B.num;
        //System.out.println(nNum);
        if (nNum == lcm) {
            return new Fraction(nNum, lcm);
        }
        if (nNum == 0) {
            return new Fraction(nNum, lcm);
        }
        int val[] = reduce(nNum, lcm);
        nNum = val[0];
        lcm = val[1];
        //System.out.println("result " + new Fraction(nNum, lcm));
        return new Fraction(nNum, lcm);
    }

    static Fraction multiply(Fraction A, Fraction B) {
        System.out.println(A + " * " + B);
        int nNum = A.num * B.num;
        int dem = A.denom * B.denom;
        if (nNum == dem) {
            return new Fraction(nNum, dem);
        }
        if (nNum == 0 || dem == 0) {
            return new Fraction(nNum, dem);
        }
        int val[] = reduce(nNum, dem);
        return new Fraction(val[0], val[1]);
    }

    static Fraction divide(Fraction A, Fraction B) {
        System.out.println(A + " / " + B);
        int nNum = A.num * B.denom;
        int dem = A.denom * B.num;
        if (nNum == dem) {
            return new Fraction(nNum, dem);
        }
        if (nNum == 0 || dem == 0) {
            return new Fraction(nNum, dem);
        }
        int val[] = reduce(nNum, dem);
        return new Fraction(val[0], val[1]);
    }

    Fraction add(Fraction a) {
        //System.out.println("ooo");
        return add(this, a);
    }

    Fraction subtract(Fraction a) {
        return subtract(this, a);
    }

    Fraction multiply(Fraction a) {
        return multiply(this, a);
    }

    Fraction divide(Fraction a) {
        return divide(this, a);
    }

    static Fraction subtractAll(Fraction... a) {
        Fraction temp = a[0];
        for (int i = 1; i < a.length; i++) {
            temp = temp.subtract(a[i]);
        }
        return temp;
    }

    static Fraction addAll(Fraction... a) {
        //System.out.println("nfvkv");
        Fraction sum = a[0];
        for (int i = 1; i < a.length; i++) {
            sum = sum.add(a[i]);
        }
        return sum;
    }

    static Fraction multiplyAll(Fraction... a) {
        Fraction temp = a[0];
        for (int i = 1; i < a.length; i++) {
            temp = temp.multiply(a[i]);
        }
        return temp;
    }

    static Fraction divideAll(Fraction... a) {
        Fraction temp = a[0];
        for (int i = 1; i < a.length; i++) {
            temp = temp.divide(a[i]);
        }
        return temp;
    }

    private static int findCommonDivisor(int n, int m) {
        //System.out.println("fvfvfv");
        while (n % m != 0) {
            int r;
            r = n % m;
            n = m;
            m = r;
        }
        return m;
    }

    private static int[] reduce(int nNum, int lcm) {
        int div = findCommonDivisor(lcm, nNum);
        while ((div != 1 && div != -1) && nNum % div == 0 && lcm % div == 0) {
            nNum /= div;
            lcm /= div;
        }
        return new int[]{nNum, lcm};
    }

    @Override
    public String toString() {
        if (num == 0) {
            return String.valueOf(0);
        }
        if (denom == 1) {
            return String.valueOf(num);
        }
        if (denom == -1) {
            return String.valueOf("-" + num);
        }
        if (num == denom) {
            return String.format("%d/%d = %d", num, denom, 1);
        }
        return String.format("%d/%d", num, denom);
    }

}
