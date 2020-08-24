/*
Треба да изработите автоматски преведувач за зборови од анлиски јазик на македонски. Влезот се состои од парови од зборови разделени со празно место.
 Така прво е даден зборот на македонски, па има едно празно место, па преводот на зборот на англиски јазик
 Потоа на влез се добиваат странски зборови (секој во посебен ред). За излез треба да се преведат овие зборови.
 Доколку не е познат преводот на зборот на излез се печати "/"

Влез. Прво се дава број N на поими кои ќе ги содржи речникот. Потоа во наредните N реда се дадени поимите, прв на македонски, потоа на англиски.
 Потоа следуваат зборови на англиски (секој збор во посебен ред), кои треба да се преведат на македонски. За означување на крај во редицата се дава зборот KRAJ

Излез. За секој од дадените зборови на англиски во посебен ред е даден преводот на зборот на македонски. Доколку не е познат преводот на зборот се печати /

Забелешка. Работете со хеш табела со отворени кофички. Сами треба да го одредите бројот на кофички и хеш функцијата.

Име на класа: Preveduvac
*/

import java.util.Hashtable;
import java.util.Scanner;

public class Preveduvac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Hashtable<String, String> table = new Hashtable<String, String>();
        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            // ke gi staeme obratno oti vnesuvame value posle i da moze so get da zememe
            table.put(parts[1], parts[0]);
        }
        System.out.println(table);
//Ke mora prvo da vneseme neso
        String word = sc.nextLine();

        while (!word.equals("KRAJ")) {
            //System.out.println("yes");
            if (table.containsKey(word)) {
                System.out.println(table.get(word));
            }
            else System.out.println("/");
            //najbitnoto za da nema samo eden vlez i da ne ni prae beskonecen ciklus
            //stavi novo da vnese !!!!
            word = sc.nextLine();
        }

        sc.close();//mn vazno da se zatvore
    }
}
