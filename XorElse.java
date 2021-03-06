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

    BigInteger hexResult = null;
    String stringResult = "";
    int maxInputLength = 0;
    BigInteger[] hexValues = new BigInteger[args.length];
    for(int count = 0; count < args.length; count++) {
        args[count] = args[count].replace(" ", "")
                                 .replace("-", "")
                                 .replace(",", "")
                                 .replace(".", "");
        if ( args[count].charAt(0) == '0' && (args[count].charAt(1) == 'x' || args[count].charAt(1) == 'X') ) {
            args[count] = args[count].substring(2);
        }

        hexValues[count] = new BigInteger(args[count], RADIX_BASE);
        if(args[count].length() > maxInputLength) {
	    maxInputLength = args[count].length();
	}

	        System.out.println("Input " + (count+1) + ": " + formatHexString(args[count], args[count].length()));

        if ( count > 0 ) {
            hexResult = hexResult.xor(hexValues[count]);
        } else {
            hexResult = hexValues[count];
        } //if not first
        stringResult = hexResult.toString(RADIX_BASE);
        if ( count == (args.length-1) ) {
	        System.out.println("    XOr: " + formatHexString(stringResult, maxInputLength));
        } //if last
      
    }//for count

    System.exit(0);
  }//main

    public static String formatHexString(String inputString, int outputLength) {
      String outputString = "";
      int endCut = 0;
      int sectionLength = 8;
      //      System.out.println("L:"+inputString+" === "+inputString.length());
      for (int i = 0; i < inputString.length(); i+=sectionLength) {
         endCut = i+sectionLength;
         if ( i+sectionLength > inputString.length() ) {
            endCut = inputString.length();
         }
         String part = inputString.substring(i, endCut).toUpperCase();
	 while(part.length() < sectionLength) {
	     part = "0"+part;
	 }
         //System.out.println("  P:"+part);
         outputString += part;
         outputString += " ";
      }
      while(outputString.length() <= outputLength) {
	  if(outputString.length()%sectionLength == 0){
	      outputString += "x";
	  }
	  outputString = "_"+outputString;
      }
      return outputString;
   }//formatHexString

}//class
