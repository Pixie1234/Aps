# <h1>Algoritmi </h1>
  
  <h3> 1. Shortcuts: </h3>
 1. Ctrl + Shift + I -> To see a quick definition of a method <br>
 2. Try Ctrl + Space -> gives an examples of what should be written<br>
 3. Alt + Enter -> very helpful<br><br>

https://pastebin.com/u/fensa08<br>
https://leetcode.com/problems/asteroid-collision/ -> kol1 (stek i red ) asteroidi<br>
https://pastebin.com/u/SlamkovD<br>
https://pastebin.com/u/Andziev<br>
https://pastebin.com/u/ekrajchevska<br>
https://pastebin.com/u/MitrovG<br>
https://pastebin.com/u/HristijanBosheski<br>
https://github.com/Aleksandar1932/APS_2019/tree/master/src/mk/ukim/finki/aps<br>
https://www.youtube.com/watch?v=C6KjYbAarYI&list=PLqM7alHXFySG6wgjVeEat_ouTIi0IBQ6D&index=2<br>
https://www.youtube.com/watch?v=jos1Flt21is -> Infix, Prefix and Postfix <br>


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


<h3> 2. Queues:</h3>
public void enqueue (E x) { <br>
if(length == elems.length) return;//redicata e polna<br>
elems[rear++] = x;//go stavame elementot na rear pa rear se zgolemuva <br>
if (rear == elems.length) rear = 0;<br>// ako zgolemen
length++;<br>
}<br><br>
public E dequeue () {<br>
if (length > 0) {<br>
E frontmost = elems[front];<br>
elems[front++] = null;<br>
if (front == elems.length) front = 0;<br>
length--;<br>
return frontmost;<br>
} else<br>
throw new NoSuchElementException();<br>
} <br>


