/*Индекс на книга Problem 1 (0 / 0)
Да се овозможи пребарување на збор или израз во индекс на книга и како резултат да се врати на која страна се
појавува или зборот или ако е израз, целиот израз. Доколку зборот не постои во индексот на книгата, да се
испечати “Not found”. Да не се прави разлика помеѓу големи и мали букви при пребарување на збор.
Доколку даден збор се повторува во повеќе изрази од индексот, при пребарување на тој збор,
се прикажува бројот на страната која е последно внесена.
(пример, доколку во индексот се внесе:
 Alan Turing, 72
 Alan Ford, 44 и потоа се пребара зборот Alan, програмата треба да отпечати 44,
 бидејќи таа страна е последно внесена.
Пребарувањата на изразите Alan Turing и Alan Ford како изрази треба да вратат 72 и 44,
 соодветно)

Влез: Се внесува индексот на книгата (израз и број на страница разделени со ,)
се до внесување на знакот #.
По знакот #, се внесува N кој означува колку зборови ќе се пребаруваат.
Во следните редови се читаат N зборови


Излез: За секој од внесените зборови/изрази, во нов ред треба да се ипечати страницата во
 која се наоѓа зборот (или “Not found”, доколку зборот не е во индексот на книгата).
Делумно решение: Проблемот е делумно решен ако поминат 7 тест случаи.
Име на класа (Јава): Book.java
Забелешка: При реализација на задачите МОРА да се користат соодветни податочни структури.
 Забрането користење на поврзани листи, низи и сл.

*/
// so .contains ustvari so .substring moze da videme u celiot izraz dali go ima toa zborce

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class IndeksNaKniga {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hashtable<String, String> table = new Hashtable<>();
        String vnes = sc.nextLine();
        while (!vnes.equals("#")) {
            vnes = vnes.toLowerCase();
            String[] niza=vnes.split(", ");
            table.put(niza[0], niza[1]);
            System.out.println(table);

            vnes=sc.nextLine();
        }
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {

            String key1 = sc.nextLine();
            key1 = key1.toLowerCase();
            String value="Not found";
            for(Map.Entry<String, String> entry : table.entrySet()){
                if(entry.getKey().contains(key1)){
                    value = entry.getValue();
                }
            }
            System.out.println(value);
        }
    }
}
