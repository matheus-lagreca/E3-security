import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("Start");  
        menu();

    }
    public static void menu() throws UnsupportedEncodingException {
        int op = -1;
        Scanner in = new Scanner(System.in);
        PrimeGen pg = new PrimeGen();
        System.out.println("Gerando primos");

        // Modulo de p e q
        BigInteger n = generateModule(pg.getP(), pg.getQ());
        BigInteger eulerN = generateEuler(pg.getP(), pg.getQ());
        Random rand = new Random();
        BigInteger e = BigInteger.ONE;
        BigInteger d = BigInteger.ONE;

        BigInteger[] keys = { e, d };

        BigInteger msgCryp;
        String msg ="";
        String msg2="";

        generateKeys(eulerN, keys[0], keys[1]);

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
                if(msg.equals("")){
                    System.out.println("mensagem vazia");
                }else{
                   msgCryp = criptografar(msg, e, n);
                   System.out.println(msgCryp);
                }
                break;
            case 3:
                    System.out.println("Digite a msg criptografada");
                    BigInteger msgDecrypt = in.nextBigInteger();
                    msg2 = decrypt(msgDecrypt, d, n);
                break;
            case 0:
                break;

            default:
                System.out.println("errou");
            }
        }
    }


    public static BigInteger criptografar(String msg, BigInteger key, BigInteger N)
            throws UnsupportedEncodingException {
        try {
            // transform to ascii
            System.out.println(msg);
            byte[] bytes = msg.getBytes("US-ASCII");
            BigInteger ascMsg = new BigInteger(bytes);
            // crip
            BigInteger crip = ascMsg.modPow(key, N);

            return crip;
        } catch (UnsupportedEncodingException exception) {
            System.out.println("try another");
        }
        return BigInteger.ZERO;
    }

    public static String decrypt(BigInteger msg, BigInteger key, BigInteger N){
        //decrypt
        BigInteger dec = msg.modPow(key,N);
        // transform to string
        byte[] bytes= dec.toByteArray();
        String novaMsg = new String(bytes);
        return novaMsg;
    }

    public static void generateKeys(BigInteger euler, BigInteger e, BigInteger d) {
        boolean ver1 = false;// verificador para gerar chave E
        boolean ver2 = false;// verificador para gerar chave D
        int count = 0;// so pra ver qnts vezes procura

        do {
            e = geraBigRandom(euler);
            if ((e.gcd(euler)).equals(BigInteger.ONE)) {
                // acha uma chave D
                d = e.modInverse(euler);
                if (((d.multiply(e)).mod(euler)).equals(BigInteger.ONE)) {
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

   
}
