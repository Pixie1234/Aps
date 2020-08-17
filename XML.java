import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;


interface Stack<E>{

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}
class ArrayStack<E> implements Stack {
    // Stekot e pretstaven na sledniot nacin:
    //depth e dlabochinata na stekot, a
    // elems[0...depth-1] se negovite elementi.
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }
    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }
    public E peek() {// GO dobiva elementot od vrvot bez da go brise
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException(); // nema takov element
        return elems[depth - 1];
    }

    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }
        public void push(Object x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = (E) x; // CAST To (E)
    }
    public E pop() {// go dobiva elemetot od vrvot i go brise
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];// depth-1 - toa  e posledniot dodaden element
        elems[depth] = null;
        return topmost;
    }

}

public class XML {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);// a ovoa e brojot na elementi vo nizata zatoa e int
        String[] redovi = new String[n];// nizata ni e od tip String

        for (int i = 0; i < n; i++) {
            redovi[i] = br.readLine(); // toa so ke se vnese ke vo zememe kako ?
            // toa ne go parsirame si stoe vo String taka oti e element na nizata
        }

        int valid=1;

        ArrayStack<String> stek = new ArrayStack<String>(n);


        for (int i = 0; i < n; i++) {
            if (redovi[i].charAt(0) == '[' && redovi[i].charAt(1) != '/') { // tag za otvaranje
                System.out.println("ulava " + i + "indeks "+  redovi[i]);
                stek.push(redovi[i]);
            } else if (redovi[i].charAt(0) == '[' && redovi[i].charAt(1) == '/') { // tag za zatvaranje

                if (redovi[i].substring(2, redovi[i].length() - 1).compareTo(stek.peek().substring(1, stek.peek().length() - 1)) == 0) {
                    System.out.println("izlava " + redovi[i]);
                    stek.pop();
                } else {
                    break;
                }
                    /*if (redovi[i].substring(2, redovi[i].length()).compareTo(stek.peek().substring(1, stek.peek().length())) == 0) {
                        stek.pop();
                    }
                    else break;*/
            }

        }
        if (stek.isEmpty()) {
            valid=1;
        }
        else valid=0;
        System.out.println(valid);
        br.close();
    }
}
