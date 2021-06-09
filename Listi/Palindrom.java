import java.util.Scanner;
/*7
* 1 2 3 4 3 2 1
* output:
* 1*/

public class Palindrom {
    //VTOR NACIN
    public static int Palindrom(DLL<Integer> list) {
        DLLNode first = list.getFirst();
        DLLNode last = list.getLast();
        while (first != null) {
            if (first.element == last.element) {
                first = first.succ;
                last = last.pred;
            } else {
                return -1;
            }
        }
        return 1;
    }

    /* PRV NACIN
    public static int Palindrom(DLL<Integer> list) {
        DLLNode first = list.getFirst();
        DLLNode last = list.getLast();
        while (first != null && last != null && first != last) {
            if (first.element != last.element) {
                return -1;
            } else {
                first = first.succ;
                last = last.pred;
            }
        }
        return 1;
    }*/
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<>();

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        System.out.println(Palindrom(list));
    }
}
