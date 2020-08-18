# <h1>Algoritmi </h1>
  
  <h3> 1. Shortcuts: </h3>
 1. Ctrl + Shift + I -> To see a quick definition of a method <br>
 2. Try Ctrl + Space -> gives an examples of what should be written<br>
 3. Alt + Enter -> very helpful<br>




<h3> 2. Hints:</h3>
 1. Za da na posle poslednio element nemame space, ako e prv element go dodavame samo nego, 
  a ako e bilo koj drug dodavame prvo space pa elementot
  
  //Pseudo code:<br>
     1. Create a StringBuilder<br>
     2.For each element in the list:<br>
     *       if it's the first element, append only the element<br>
     *       if it isn't the first element, append the separator and then append the element<br>
     3. Return the StringBuilder's string <br>

    private static String listWithSeparator(List<String> list, String separator) {
        StringBuilder sb = new StringBuilder(32);

        boolean first = true;

        for (String el : list){
            if (first) {
                first = false;
            }
            else{
                sb.append(separator); //every other element hit the else except the first
            }
            sb.append(el);//ovoa sekako ke se izvrse uste prvio pat

         }
        return sb.toString();

    }
    
 2. Dali zbovceto e palindrom:
 
  public static void main(String[] args) throws IOException {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(s +" "+ isPalindrome(s));
 }
  private static boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);

        String reverseWord = sb.reverse().toString();

        return reverseWord.equalsIgnoreCase(word);// vraka true ako se isti

    }
    
    
<b>Java String Methods: </b> <br>
String charAt()<br>
String compareTo()<br>
String concat()<br>
String contains()<br>
String endsWith()<br>
String equals()<br>
equalsIgnoreCase()<br>
String format()<br>
String getBytes()<br>
String getChars()<br>
String indexOf()<br>
String intern()<br>
String isEmpty()<br>
String join()<br>
String lastIndexOf()<br>
String length()<br>
String replace()<br>
String replaceAll()<br>
String split()<br>
String startsWith()<br>
String substring()<br>
String toCharArray()<br>
String toLowerCase()<br>
String toUpperCase()<br>
String trim()<br>
String valueOf()<br>

