/**
 * Created by PS on 09-07-2018.
 */
import java.util.*;

public class playFair {
    public static void main(String args[]) {
        Scanner sc = new Scanner((System.in));
        System.out.println("Enter plain text for encryption: ");
        String plainText = sc.nextLine();
        playfairCipher p = new playfairCipher();
        plainText = plainText.toLowerCase();
        plainText= plainText.replaceAll("\\s","");

        char[] j=p.checkj(plainText);


        System.out.println("enter key: ");
        String key = sc.nextLine();
        key=key.toLowerCase();
        key= key.replaceAll("\\s","");
        String[][] matrix = p.keyMatrix(key);

        String digraph[] = p.digraph(plainText);
        System.out.println("dg "+Arrays.toString(digraph));
        String cipherText = "";
        for (int i = 0; i < digraph.length; i++) {
            cipherText += p.encrypt(digraph[i], matrix);
        }
        System.out.println("encrypted text is: "+cipherText);

        String[] ctdigraph=p.digraph(p.properDiagraphText(cipherText));
        String pt="";
        //System.out.println(Arrays.toString(j));
        for (int i = 0; i < digraph.length; i++) {
            pt+=p.decrypt(ctdigraph[i], matrix);
        }
        String pt2=pt;

        pt2=pt2.replace("x","");

        for (int i=0;i<j.length;i++)
        {
            if(	j[i] == 'j')
                pt2=pt2.substring(0,i)+"j"+pt2.substring(i+1,pt2.length());
            if(	j[i] == 'x')
                pt2=pt2.substring(0,i)+"x"+pt2.substring(i,pt2.length());
        }
        System.out.println("decrypted text is: "+pt2);
        sc.close();
    }
}
