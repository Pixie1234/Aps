# <h1>Algoritmi </h1>
  
  <h3> 1. Shortcuts: </h3>
 1. Ctrl + Shift + I -> To see a quick definition of a method <br>
 2. Try Ctrl + Space -> gives an examples of what should be written(Basic code completion)<br>
 3. Alt + Enter -> very helpful<br>
 4. Find class – Ctrl + N -> To find the class you seek simply press Ctrl + N and type the name.<br>
 5. Smart code completion –> Ctrl + Shift + Space -Smart code completion is much more effective as it will only display the autocomplete options relevant to context by filtering the list of suggestions to show only classes, variables, fields and methods of the type that can be expected<br>
 6. MNOGU KORISNO: so gluvceto postaveno na klasata pa na Code opcijata u menu->Generate -> moze da napraveme geteri seteri da override methods od tuka da go dobieme cel kod za equals na klasi da go @Override( look up the link for more )
 https://www.jetbrains.com/help/idea/generating-code.html#generate-getters-setters<br>
 <br><br>
 **Praveme void method ako metodot ne vraka nisto (toa znaci deka nema return, moze da printa da sortira ..)<br>
 
 https://www.youtube.com/watch?v=hLYOpvoM4vk -> super keyword<br>
https://www.youtube.com/watch?v=52frlN8webg ->THE big difference between abstract classes and interfaces (ubavo onjasneto)<br>
https://www.youtube.com/watch?v=70qy6_gw1Hc-> hesh objasneno ubavo<br>
https://www.youtube.com/watch?v=PeFyhRr42ac -> heshSet dodava elem so .add() <br> 
https://pastebin.com/LTjxUDz8 -> hesh PM10 cesticki -vezbi<br>
https://pastebin.com/u/fensa08-> kolokviumski i ispiti ubavi zadaci<br>
https://pastebin.com/u/DajanaS -> mn zadaci <br>
https://leetcode.com/problems/asteroid-collision/ -> kol1 (stek i red ) asteroidi<br>
https://pastebin.com/u/SlamkovD<br>
https://pastebin.com/u/Andziev<br>
https://pastebin.com/u/ekrajchevska<br>
https://pastebin.com/u/MitrovG<br>
https://pastebin.com/u/HristijanBosheski<br>
https://github.com/Aleksandar1932/APS_2019/tree/master/src/mk/ukim/finki/aps<br>
https://www.youtube.com/watch?v=C6KjYbAarYI&list=PLqM7alHXFySG6wgjVeEat_ouTIi0IBQ6D&index=2<br>
https://www.youtube.com/watch?v=jos1Flt21is -> Infix, Prefix and Postfix <br>



if(i == 0) ... //if i = 0 this will work and skip following statement<br>
else if(i == 1) ...//if i not equal to 0 and if i = 1 this will work and skip following statement<br>
else if(i == 2) ...// if i not equal to 0 or 1 and if i = 2 the statement will execute<br><br>


if(i == 0) ...//if i = 0 this will work and check the following conditions also<br>
if(i == 1) ...//regardless of the i == 0 check, this if condition is checked<br>
if(i == 2) ...//regardless of the i == 0 and i == 1 check, this if condition is checked<br>



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


<h2> 2. Queues:</h2>
Интерфејсот Queue во Java
• Нема готова класа за редица во Java, само интерфејс.<br>
Класи кои го имплементираат Queue интерфејсот се:<br>

– LinkedList<br>
– LinkedQueue<br>
– ArrayQueue<br>

<h3>Редица со низа:</h3><br>
<b>Додавање на елемент</b><br>
public void enqueue (E x) { <br>
if(length == elems.length) return;//redicata e polna<br>
elems[rear++] = x;//go stavame elementot na rear pa rear se zgolemuva <br>
if (rear == elems.length) rear = 0;<br>// ako zgolemen
length++;<br>
}<br>
<br>
<b>Oдзимање на елемент</b><br>
public E dequeue () {<br>
if (length > 0) {<br>
E frontmost = elems[front];<br>
elems[front++] = null; -> momentalniot front stanuva null, i sea front se pomestuva za 1<br>
if (front == elems.length) front = 0;<br>
length--;<br>
return frontmost;<br>
} else<br>
throw new NoSuchElementException();<br>
} <br>
<h3>Редица со листа:</h3><br>
<b>Додавање на елемент</b><br>
public void enqueue (E x) {<br>
//Praeme nov Node koj so treba da go staveme na kraj, koj so ja imae vrednosta na x so ja prakame kako argument i null kako successor (koga succ e null znaci ovoj Node se naogja na kraj).<br>
SLLNode<E> latest = new SLLNode<E>(x, null);<br>
//Ako rear e razlicno od null toa znaci deka imam barem eden element(listata ne e prazna) <br> 
if (rear != null) {<br>
rear.succ = latest;<br>
rear = latest;<br>
} else<br>
//inaku listata e prazna i elemetot so go dodavame ke e i front i rear<br>  
front = rear = latest;<br>
length++;<br>
}<br>
  <br>
  <b>Oдзимање на елемент</b><br>
public E dequeue () {<br>
if (front != null) {<br>
E frontmost = front.element;<br>
front = front.succ;<br>
if (front == null) rear = null;<br>
length--;<br>
return frontmost;<br>
} else<br>
throw new NoSuchElementException();<br>
}<br>
  <br>
