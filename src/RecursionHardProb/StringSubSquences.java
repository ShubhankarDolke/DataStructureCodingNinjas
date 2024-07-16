package RecursionHardProb;
import java.util.*;
public class StringSubSquences {


    public static ArrayList<String> stringSubSquences(String string) {

        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> stringOutput;

        if(string.isEmpty()) {
            output.add("");
            return output;
        }
        stringOutput = stringSubSquences(string.substring(1));
        for(String i : stringOutput) {
            output.add(i);
        }
        for(String i : stringOutput) {
            output.add(i + string.charAt(0));
        }

        return output;

    }

    public static void stringSubSeqVoid(String string, String stringSoFar) {
        if (string.length() == 0) {
            System.out.println(stringSoFar);
            return;
        }

        stringSubSeqVoid(string.substring(1),stringSoFar);

        stringSubSeqVoid(string.substring(1), stringSoFar + string.charAt(0));
    }
    public static void main(String[] args) {

//        ArrayList<String> output = stringSubSquences("abc");
//
//        for(String i : output) {
//            System.out.println(i);
//        }
        stringSubSeqVoid("abc", "");

    }
}
