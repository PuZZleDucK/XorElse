//(c)me & GPL3
// V1.0 - Functional release (2012)
// V1.1 - Visual improvements and formatting (Jan 2013)
// V1.2 - Better input handling (Jan 2013)

import java.math.BigInteger;
import java.lang.StringBuilder;

public class XorElse {

  private final static int RADIX_BASE = 16;

  public static void main(String[] args) {
    if(args.length < 2) {
        System.out.println("XorElse Usage:");
        System.out.println("Usage: java XorElse <hex> <hex> ...");
        System.out.println("                        ^  ^    ^");
        System.out.println("                        | /    /");
        System.out.println("                 _Two_ or more hexidecimal strings");

        System.exit(1);
    }//if args

    //TODOne: add check for quoted strings in arguments and allow for spaced input of the forms:
    //  "2134 1234 1234 1234 1234 1234 1234 1243" and "21341234 12341234 12341234 12341243"
    // if startsWith() is '"', ''' or '`' (or'<', '{', '(' or '[') then trim and concat until 
    // endsWith() char is a match to opening quote.
//    if( args[0].charAt(0) == '"' || args[0].charAt(0) == '\'' || args[0].charAt(0) == '[' ) {
    //  system already handles quotes... I'll just need to strip spaces, comas, dashes, anything


    BigInteger hexResult = null;
    String stringResult = "";
    BigInteger[] hexValues = new BigInteger[args.length];
    for(int count = 0; count < args.length; count++) {
        args[count] = args[count].replace(" ", "");
        args[count] = args[count].replace("-", "");
        args[count] = args[count].replace(",", "");
        args[count] = args[count].replace(".", "");
        if ( args[count].charAt(0) == '0' && (args[count].charAt(1) == 'x' || args[count].charAt(1) == 'X') ) {
            args[count] = args[count].substring(2);
        }
        hexValues[count] = new BigInteger(args[count], RADIX_BASE);

//      System.out.println("  Hex input:" + args[count] 
//                            + " --> Dec bigInt:" + hexValues[count]);
        System.out.println("Raw input " + (count+1) + ": " + formatHexString(args[count]) );

        if ( count > 0 ) {
            hexResult = hexResult.xor(hexValues[count]);
        } else {
            hexResult = hexValues[count];
        } //if not first
        stringResult = hexResult.toString(RADIX_BASE);
        if ( count == (args.length-1) ) {
            System.out.println("  XOr Result: " + formatHexString(stringResult));
        } //if last
      

    }//for count

      //System.out.println("Final result: " + stringResult);
    System.out.println("Done:");
    System.exit(0);
  }//main

   public static String formatHexString(String inputString) {
      StringBuilder outputString = new StringBuilder();
      int endCut = 0;
      int sectionLength = 8;
      for (int i = 0; i < inputString.length(); i+=sectionLength) {
         endCut = i+sectionLength;
         if ( i+sectionLength > inputString.length() ) {
            endCut = inputString.length();
         }
         outputString.append(inputString.substring(i, endCut).toUpperCase() );
         outputString.append(" ");
      }
      return outputString.toString();
   }//formatHexString

}//class
