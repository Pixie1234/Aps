/*

Дадена е двојно поврзана листа од двојно поврзани листи. Да се најде
сума на секоја од подлистите, а потоа производ на овие суми

Влез: Број N кој кажува колку листи има Број М кој кажува колку елементи
 има во секоја листа Во следните М линии се податоците 1<=A<=1000за
 секоја од листите

Излез: Еден број што е производот на сумите од низите. Со седум децимали.

Пример влез: 3 4 1 2 3 4 2 3 4 5 6 7 8 9

Излез: 1400
*/

import java.util.Scanner;

public class ListaOdLisi {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {

        long product = 1;
        //prvo treba da go zeam prviot jazol od vakvata golema lista
        // koja ima vnatre druga lista
        //kje ja iteriram listata shto se naogja vnatre vo jazolot
        DLLNode<DLL<Integer>> outside = list.getFirst();
        int suma = 0;
        while (outside != null) {
            suma = 0;
            DLLNode<Integer> temp = outside.element.getFirst();
            while (temp != null) {
                suma += temp.element;
                temp = temp.succ;
            }
            product *= suma;
            outside = outside.succ;
        }
        return product;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(sc.nextInt());
            }
            list.insertLast(tmp);

        }
        System.out.println(findMagicNumber(list));
    }
}
