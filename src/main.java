import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        System.out.println("Start");
      /*  primeGen pg = new primeGen();
        System.out.println("P: " + pg.getP());
        System.out.println("Q: " + pg.getQ());
        System.out.println("P and Q have a 2^-60 chance of not being a prime number...");

        System.out.println("should print 1");
        System.out.println(pg.getP().gcd(pg.getQ()));

        BigInteger [] seila = EuclidesExt.ExtendEuclid(pg.getP(),pg.getQ());
        System.out.println("D: "+seila[0]);
        //System.out.println("A: "+seila[1]);
       // System.out.println("B: "+seila[2]);


        //Modulo de p e q
        BigInteger n = pg.getP().multiply(pg.getQ());
        System.out.println("N: "+ n);

        //euler(n) = (p-1) * (q-1)
        BigInteger eulerN = (pg.getP().subtract(BigInteger.ONE)).multiply((pg.getQ().subtract(BigInteger.ONE)));
        System.out.println("O: "+eulerN);
        System.out.println("");
        //selecionar a chave `e`
        //tal que 1< `e` < eulerN
        //e gdc(`e`, eulerN) ==1
*/
        Random rand = new Random();
        BigInteger e= BigInteger.ONE;
        BigInteger d= BigInteger.ONE;


        BigInteger p = BigInteger.ONE.add(BigInteger.ONE.add(BigInteger.ONE));//3
        BigInteger q = BigInteger.TEN.add(BigInteger.ONE);

        BigInteger eulerN = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));

        System.out.println("p: "+p);
        System.out.println("q: "+q);
        System.out.println("euler: "+eulerN);

        boolean ver1 = false;//verificador para gerar chave E
        boolean ver2 = false;//verificador para gerar chave D
        int count =0;//so pra ver qnts vezes procura

        //acha uma chave E

        do {
           e= geraBigRandom(eulerN);
            if((e.gcd(eulerN)).equals(BigInteger.ONE)){
                ver1 = true;
                //acha uma chave D
                //tal que e*d == 1 mod eulerN
                do{
                  d= geraBigRandom(eulerN,e);
                    //d*e ==1 em Z*n && d < eulerN
                    BigInteger result = (d.multiply(e)).mod(eulerN);
                    if(result.equals(BigInteger.ONE)){
                        ver2=true;
                    }
                    //aqui

                }while(!ver2);
            }
        }while(!ver1 && !ver2);

        System.out.println("e:" +e);
        System.out.println("gcd: "+ e.gcd(eulerN));
        System.out.println("d:" +d);
        System.out.println("gcd: "+ d.gcd(eulerN));
        System.out.println("gcd: "+ d.gcd(e));
        System.out.println("count: "+ count);
        System.out.println("sera?: "+ ((d.multiply(e)).mod(eulerN)));
    }

    public static BigInteger geraBigRandom(BigInteger eul){
        Random rand = new Random();
        BigInteger e;
        do {
            e = new BigInteger(5,rand);
        }while(e.compareTo(eul)>0);
        return e;
    }
    public static BigInteger geraBigRandom(BigInteger eul, BigInteger e){
        Random rand = new Random();
        BigInteger d;
        do {//gera d diferente de e
            d = new BigInteger(5, rand);
        }while(d.equals(e) || d.compareTo(eul) >0);
        return d;
    }
}
