/*dadeni se 2 ednostrano povrzani listi, da napisheme funkcija koja
kje gi spoi dvete listi vo edna taka shto rezultantnata lisa da e sortirana*/


import java.util.Scanner;

public class zadaca3_vezbi{

    public static SLL<Integer> join(SLL<Integer> list1, SLL<Integer> list2) {
        SLL<Integer> result = new SLL<>();
        SLLNode<Integer> node1 = list1.getFirst();
        SLLNode<Integer> node2 = list2.getFirst();

        while (node1 != null && node2 != null) {
            if (node1.element < node2.element) {
                result.insertLast(node1.element);
                node1 = node1.succ;
            } else if (node1.element == node2.element) {
                result.insertLast(node1.element);
                node1 = node1.succ;
                node2 = node2.succ;
            } else {
                result.insertLast(node2.element);
                node2 = node2.succ;
            }
        }
            if (node1 != null) {
                while (node1 != null) {
                    result.insertLast(node1.element);
                    node1 = node1.succ;
                }
            }
            if (node2 != null) {
                while (node2 != null) {
                    result.insertLast(node2.element);
                    node2 = node2.succ;
                }
            }
        return result;

    }
    public static void main(String[] args) {

        SLL<Integer> list1 = new SLL<>();
        SLL<Integer> list2 = new SLL<>();

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] line = sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            //u eden red da gi procita
            list1.insertLast(Integer.parseInt(line[i]));
        }

        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            list2.insertLast(Integer.parseInt(sc.next()));
        }
        System.out.println(list1);
        System.out.println(list2);
        //od toj objekt
        //zadaca3_vezbi<Integer> lista = new zadaca3_vezbi<>();
        System.out.println(join(list1,list2));

    }

}
