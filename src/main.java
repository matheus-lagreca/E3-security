import java.math.BigInteger;

public class main {
    public static void main(String[] args) {
        System.out.println("Start");
        primeGen pg = new primeGen();
        System.out.println("P: " + pg.getP());
        System.out.println("Q: " + pg.getQ());
        System.out.println("P and Q have a 2^-60 chance of not being a prime number...");

        System.out.println("should print 1");
        System.out.println(pg.getP().gcd(pg.getQ()));

        BigInteger [] seila = EuclidesExt.ExtendEuclid(pg.getP(),pg.getQ());
        System.out.println("D: "+seila[0]);
        System.out.println("A: "+seila[1]);
        System.out.println("B: "+seila[2]);





    }
}
