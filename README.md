# <h1>Algoritmi </h1>
  
 1. Ctrl + Shift + I -> To see a quick definition of a method
 2. Try Ctrl + Space -> gives an examples of what should be written
 3. Alt + Enter -> very helpful




<h3>Hints:</h3>
 Za da na posle poslednio element nemame space, ako e prv element go dodavame samo nego, 
  a ako e bilo koj drug dodavame prvo space pa elementot
  
  //Pseudo code:<br>
    /*1. Create a StringBuilder<br>
     * 2.For each element in the list:<br>
     *       if it's the first element, append only the element<br>
     *       if it isn't the first element, append the separator and then append the element<br>
     * 3. Return the StringBuilder's string */<br>

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
    
    
<b>Java String Methods: </b>
String charAt()
String compareTo()
String concat()
String contains()
String endsWith()
String equals()
equalsIgnoreCase()
String format()
String getBytes()
String getChars()
String indexOf()
String intern()
String isEmpty()
String join()
String lastIndexOf()
String length()
String replace()
String replaceAll()
String split()
String startsWith()
String substring()
String toCharArray()
String toLowerCase()
String toUpperCase()
String trim()
String valueOf()

