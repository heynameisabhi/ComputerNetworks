import java.util.*;

public class Java3 {
    public static void main(String[] args) {
        String msg;
        int mlen;
        long[] pt = new long[100];
        long[] ct = new long[100];
        long[] dt = new long[100];
        long z, n, d = 0, e = 0, p, q;
        Scanner in = new Scanner(System.in);

        // Input two large primes
        do {
            System.out.println("Enter two large prime numbers for p and q:");
            p = in.nextLong();
            q = in.nextLong();
        } while (!isPrime(p) || !isPrime(q) || p == q);

        n = p * q;
        z = (p - 1) * (q - 1);

        // Find e such that 1 < e < z and gcd(e, z) == 1
        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1)
                break;
        }

        // Find d such that (e * d) % z == 1
        for (d = 2; d < z; d++) {
            if ((e * d) % z == 1)
                break;
        }

        System.out.println("Public Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");

        in.nextLine(); // consume newline
        System.out.println("Enter the message for encryption:");
        msg = in.nextLine();
        mlen = msg.length();

        // Convert message to ASCII
        for (int i = 0; i < mlen; i++)
            pt[i] = msg.charAt(i);

        System.out.println("ASCII values of PT array:");
        for (int i = 0; i < mlen; i++)
            System.out.print(pt[i] + " ");
        System.out.println();

        // Encryption
        System.out.println("Encryption: Cipher Text Obtained:");
        for (int i = 0; i < mlen; i++) {
            ct[i] = modPow(pt[i], e, n);
            System.out.print(ct[i] + " ");
        }
        System.out.println();

        // Decryption
        System.out.println("Decryption: Plain Text Obtained:");
        for (int i = 0; i < mlen; i++) {
            dt[i] = modPow(ct[i], d, n);
            System.out.print((char) dt[i]);
        }
        System.out.println();
    }

    // Efficient modular exponentiation
    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return result;
    }

    // GCD function
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Prime check function
    public static boolean isPrime(long num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
