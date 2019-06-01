import java.math.BigInteger;

public class EuclidesExt {

    static BigInteger[] vet;

    public static BigInteger [] ExtendEuclid(BigInteger p, BigInteger q) throws StackOverflowError{
        if(q.equals(BigInteger.ZERO))
        {
            return new BigInteger[] {p, BigInteger.ONE, BigInteger.ZERO };
        }
        BigInteger[] val =  ExtendEuclid(q, p.mod(q));
        BigInteger d = val[0];
        BigInteger a = val[2];
        BigInteger b = val[1].subtract((p.divide(q)).multiply(val[2]));
        return new BigInteger[] {d, a, b};
    }

}
/*
Algoritmo extendido de Euclides:
 returns (d,a,b) where:
   d = gcd(x,y) and
   d == x*a + y*b

    ExtendeEuclid (x,y) {
        if (y == 0) return (x,1,0) ;
        (d1,a1,b1) = ExtendedEuclid(y, x mod y);
        d = d1;
        a = b1;
        b = a1 – (x div y) * b1;
        return (d,a,b);
    }
 */