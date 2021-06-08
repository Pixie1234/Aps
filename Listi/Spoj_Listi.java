import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spoj_Listi {

    public static void SLLJoinLists(SLL<Integer> lista1, SLL<Integer> lista2) {
        SLL<Integer> nova = new SLL<>();
        SLLNode<Integer> first1 = lista1.getFirst();
        SLLNode<Integer> first2 = lista2.getFirst();

        System.out.println(first1);
        System.out.println(first2);

        while (first1 != null && first2 != null) {
            if (first1.element.compareTo(first2.element) < 0) {
                nova.insertLast(first1.element);
                first1 = first1.succ;
            }
            if (first1 != null && first2 != null && first1.element == first2.element) {
                nova.insertLast(first1.element);
                first1 = first1.succ;
                first2 = first2.succ;
            }
        }
        if (first2 == null) {
            while (first1 != null) {
                nova.insertLast(first1.element);
                first1 = first1.succ;
            }
        }
        if (first1 != null) {
            while (first2 != null) {
                nova.insertLast(first2.element);
                first2 = first2.succ;
            }
        }
        System.out.println(nova);
    }

    public static void main(String[] args) throws IOException {

        SLL<Integer> lista1 = new SLL<Integer>();
        SLL<Integer> lista2 = new SLL<Integer>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();//citame cel red
        int n = Integer.parseInt(s);//go parsime istoto i go stavame u n
        s = stdin.readLine();//pa citame cel red
        String[] pomniza = s.split(" ");//toa so go citame go deleme so prazno mesto
        for (int i = 0; i < n; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }

        //sea istoto i za vtorata niza
        s = stdin.readLine();
        n = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        for (int i = 0; i < n; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }
        SLLJoinLists(lista1,lista2);
    }
}
