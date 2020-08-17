# <h1>Algoritmi <h1>
  
 1. Ctrl + Shift + I -> To see a quick definition of a method
 2. Try Ctrl + Space -> gives an examples of what should be written
 3. Alt + Enter -> very helpful




<h3>Hints: <h3>
 Za da na posle poslednio element nemame space, ako e prv element go dodavame samo nego, 
  a ako e bilo koj drug dodavame prvo space pa elementot
  
  //Pseudo code:
    /*1. Create a StringBuilder
     * 2.For each element in the list:
     *       if it's the first element, append only the element
     *       if it isn't the first element, append the separator and then append the element
     * 3. Return the StringBuilder's string */

    private static String listWithSeparator(List<String> list, String separator) {
        StringBuilder sb = new StringBuilder(32);

        boolean first = true;

        for (String el : list){
            if (first) {
                first = false;
            }//ako e prvo ne ulava u else
            else{
                sb.append(separator);
            }
            sb.append(el);//ovoa sekako ke se izvrse uste prvio pat

         }
        return sb.toString();

    }
