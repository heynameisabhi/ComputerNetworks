import java.util.Scanner;

public class CRCDemo {
    static String msg ;//= "100010000100001";
    static String genPoly = "1011";
    static char t[] = new char[128];   // Array for message appended with checksum
    static char cs[] = new char[128];  // Temporary array for checksum calculation
    static char g[] = new char[128];   // Array to store generator polynomial
    static int mlen, glen, x, c, flag, test;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the message to be transferred");
        msg = in.nextLine();
        mlen = msg.length(); // Length of the original message

        for (int i = 0; i < mlen; i++) {
            t[i] = msg.charAt(i);
        }

        System.out.println("Predefined Generator Polynomial is: " + genPoly);
        g = genPoly.toCharArray();
        glen = genPoly.length(); // Length of Generator Polynomial

        // Append zero bits (glen - 1) to message
        for (x = mlen; x < mlen + glen - 1; x++) {
            t[x] = '0';
        }
        System.out.println("Zero extended message is: " + new String(t));

        // Checksum computation
        crc();
        System.out.println("CheckSum is: " + new String(cs));

        // Append checksum to original message
        for (x = mlen; x < mlen + glen - 1; x++) {
            t[x] = cs[x - mlen];
        }
        System.out.println("Final codeword generated is: " + new String(t));

        System.out.println("Test Error detection 1(yes) 0(no)? : ");
        test = in.nextInt();

        if (test == 1) {
            System.out.println("Enter position where error is to be inserted : ");
            x = in.nextInt();
            // Flip the bit
            t[x] = (t[x] == '0') ? '1' : '0';
            System.out.println("Erroneous data : " + new String(t));
            
        }
        crc();

        // Computation at receiver side
        flag = 0;
        for (x = 0; x < glen - 1; x++) {
            if (cs[x] == '1') {
                flag = 1;
                break;
            }
        }

        if (flag == 1)
            System.out.println("Error was detected during transfer");
        else
            System.out.println("No Error Detected during transfer");

        in.close();
    }

    // CRC computation
    public static void crc() {
        for (x = 0; x < glen; x++) {
            cs[x] = t[x];
        }
        do {
            if (cs[0] == '1') xor();
            for (c = 0; c < glen - 1; c++) {
                cs[c] = cs[c + 1];
            }
            cs[c] = t[x++];
        } while (x <= mlen + glen - 1);
    }

    // XOR operation
    public static void xor() {
        for (c = 1; c < glen; c++) {
            cs[c] = (cs[c] == g[c]) ? '0' : '1';
        }
    }

}
