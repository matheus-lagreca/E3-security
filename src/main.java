import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.Random;
import java.util.Scanner;

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
                //acha uma chave D
                d = e.modInverse(eulerN);
                if(((d.multiply(e)).mod(eulerN)).equals(BigInteger.ONE)){
                    //se o d*e ==1 em mod eulerN
                    ver1 = true;
                }
            }
        }while(!ver1);



        menu();

    }

    public static BigInteger geraBigRandom(BigInteger eul){
        Random rand = new Random();
        BigInteger e;
        do {
            e = new BigInteger(5,rand);
        }while(e.compareTo(eul)>0 || e.equals(BigInteger.ONE));
        return e;
    }


    public static void  criptografar(String msg){
        byte[] criptedMsg = msg.getBytes();
    //pega string
        //transforma em bytes
        //
        System.out.println();

    }


    public static void menu(){
        int op =-1;
        Scanner in = new Scanner(System.in);
        String msg = "default";
        String criptMsg = "";
        while(op !=0){

            System.out.println("Mensagem atual: " +msg);

            System.out.println("Digite a opcao");
            System.out.println("1: Escrever msg");
            System.out.println("2: Criptografar msg");
            System.out.println("3: Descriptografar msg");
            System.out.println("0: SAIR");
            op = in.nextInt();
            switch(op){
                case 1:
                   msg = in.nextLine();
                    System.out.println("Mensagem : "+ msg);
                break;
                case 2:
                    criptografar(msg);
                break;
                case 3:

                break;
                case 0:
                break;

                default:
                    System.out.println("errou");
            }
        }
    }
}
