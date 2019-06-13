import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Start");
        PrimeGen pg = new PrimeGen();
        System.out.println("Gerando primos");

        // Modulo de p e q
        // BigInteger n = pg.getP().multiply(pg.getQ());
        BigInteger n = generateModule(pg.getP(), pg.getQ());

        // System.out.println("N: "+ n);
        // euler(n) = (p-1) * (q-1)
        // BigInteger eulerN =
        // (pg.getP().subtract(BigInteger.ONE)).multiply((pg.getQ().subtract(BigInteger.ONE)));
        BigInteger eulerN = generateEuler(p, q);

        // System.out.println("O: "+eulerN);
        // System.out.println("");
        // selecionar a chave `e`
        // tal que 1< `e` < eulerN
        // e gdc(`e`, eulerN) ==1

        Random rand = new Random();
        BigInteger e = BigInteger.ONE;
        BigInteger d = BigInteger.ONE;

        BigInteger[] keys = { e, d };

        generateKeys(keys[0], keys[1]);

        boolean ver1 = false;// verificador para gerar chave E
        boolean ver2 = false;// verificador para gerar chave D
        int count = 0;// so pra ver qnts vezes procura

        do {
            e = geraBigRandom(eulerN);
            if ((e.gcd(eulerN)).equals(BigInteger.ONE)) {
                // acha uma chave D
                d = e.modInverse(eulerN);
                if (((d.multiply(e)).mod(eulerN)).equals(BigInteger.ONE)) {
                    // se o d*e ==1 em mod eulerN
                    ver1 = true;
                }
            }
        } while (!ver1);

        /*
         * System.out.println("e: "+e); System.out.println("d: "+d);
         * 
         * System.out.println("test"); BigInteger t = new BigInteger("8"); BigInteger
         * newT = t.modPow(e,n); System.out.println("msg cripted     : "+ newT);
         * BigInteger nnt = newT.modPow(d,n); System.out.println("msg desc        : "+
         * nnt);
         * 
         */

        // menu();

    }

    public static void generateKeys(BigInteger e, BigInteger d) {
        boolean ver1 = false;// verificador para gerar chave E
        boolean ver2 = false;// verificador para gerar chave D
        int count = 0;// so pra ver qnts vezes procura

        do {
            e = geraBigRandom(eulerN);
            if ((e.gcd(eulerN)).equals(BigInteger.ONE)) {
                // acha uma chave D
                d = e.modInverse(eulerN);
                if (((d.multiply(e)).mod(eulerN)).equals(BigInteger.ONE)) {
                    // se o d*e ==1 em mod eulerN
                    ver1 = true;
                }
            }
        } while (!ver1);

    }

    public static BigInteger generateModule(BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        return n;
    }

    public static BigInteger generateEuler(BigInteger p, BigInteger q) {
        BigInteger one = new BigInteger("1");
        BigInteger euler = (p.subtract(one)).multiply(q.subtract(one));
        return euler;
    }

    public static void generatePrimes(PrimeGen prigen) {
        prigen = new PrimeGen();
    }

    public static void printPrimes(PrimeGen prigen) {
        System.out.println("P: " + prigen.getP());
        System.out.println("Q: " + prigen.getQ());
        System.out.println("Gerando primos");
    }

    public static BigInteger geraBigRandom(BigInteger eul) {
        Random rand = new Random();
        BigInteger e;
        do {
            e = new BigInteger(1024, rand);
        } while (e.compareTo(eul) > 0 || e.equals(BigInteger.ONE));
        return e;
    }

    public static void criptografar(String msg) {
        byte[] criptedMsg = msg.getBytes();
        // pega string
        // transforma em bytes
        //
        System.out.println();

    }

    public static void menu() {
        int op = -1;
        Scanner in = new Scanner(System.in);
        String msg = "default";
        String criptMsg = "";
        while (op != 0) {

            System.out.println("Mensagem atual: " + msg);

            System.out.println("Digite a opcao");
            System.out.println("1: Escrever msg");
            System.out.println("2: Criptografar msg");
            System.out.println("3: Descriptografar msg");
            System.out.println("0: SAIR");
            op = in.nextInt();
            switch (op) {
            case 1:
                msg = in.nextLine();
                System.out.println("Mensagem : " + msg);
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
