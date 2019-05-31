import java.math.BigInteger;
import java.util.Random;
public class primeGen {
    private BigInteger p;
    private BigInteger q;

    public primeGen(){
        genPrimeRandom1024();
    }

    public void genPrimeRandom1024(){
        Random rand = new Random();
        p = BigInteger.probablePrime(1024,rand);
        q = BigInteger.probablePrime(1024,rand);
    }





    public BigInteger getP() {
        return p;
    }
    public BigInteger getQ() {
        return q;
    }
}

/*

Algoritmo:
        Generate a large random prime, receives the size of the prime number in bits. E.g. prime p of 1024 bits (i.e. p ≈ 21024 )

        – Step 1:  Choose a random integer  p ∈ [21024, 21025-1]
        – Step 2:  Test if 2p-1 = 1 in Zp
        If so, output  p  and stop.
        If not, goto step 1.
*/

/*
sendo n um numero positivo inteiro
Zn =  {0,1,2,3 ... n-1}

MDC = maior divisor comum
mdc(x,y)
mdc(12,18) = 6

se mdc(x,y) =1

x e y sao primos relativos

 */


/*
inverso em zn

o inverso de X em Zn é um y tal que x.y=1 em Zn

ex:   Z7 = {0,1,2,3,4,5,6}
3^-1 =5 em Z7 pois 3x5 =1 em Z7

seja N impar
o inverso de 2 em Zn = (n+1)/2

 */

/*
conjunto inversos z*

apenas numeros que possuem mdc(x,N) =1 em Zn
ex: z12* = {1,5,7,11}


sendo p um numero primo
Zp* =  zp -{0} = {1,2,3,..., p-1}





 */










//fermat

/*
    para todo valor que pertence a (Zp)* : x^(p-1) =1 em Zp





 */