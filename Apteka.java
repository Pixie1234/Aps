/* Начинот на кој тој треба да пребарува е следен: доволно е да ги внесе првите 3 букви од името на лекот за да може да му се излиста листа од лекови кои
 ги има во системот. Работата на фармацевтот е да провери дали внесениот лек го има во системот и да му даде информација на клиентот.
 Информацијата што треба да му ја даде на клиентот е дали лекот се наоѓа на позитивната листа на лекови, која е цената и колку парчиња од лекот има на залиха.
  Доколку лекот постои клиентот го нарачува со што кажува колку парчиња ќе купи. Оваа акција фармацевтот треба да ја евидентира на системот
  (односно да ја намали залихата на лекови за онолку парчиња колку што му издал на клиентот).
Доколку нарачката на клиентот е поголема од залихата на лекот што ја има во системот, не се презема никаква акција.

Влез: Од стандарден влез прво се дава број N кој претставува број на лекови кои ќе бидат внесени во системот.
Во наредните N реда се дадени имињата на лековите, дали ги има на позитивната листа (1/0), цената и број на парчиња, сите разделени со по едно празно место.
Потоа се даваат редови со имиња на лекови и број на парчиња нарачани од клиентот. За означување на крај се дава зборот KRAJ.

На стандарден излез треба да се испечати за секој од влезовите следната информација: IME POZ/NEG CENA BR_LEKOVI.
 Доколку лекот не е најден се печати Nema takov lek.
 Доколку нарачката на клиентот е поголема од залихата се печати Nema dovolno lekovi инаку Napravena naracka

Забелешка: Задачата да се реши со хeш табела. Функцијата со која се врши мапирање на имињата на лековите во број е следна:
h(w)=(29∗(29∗(29∗0+ASCII(c1))+ASCII(c2))+ASCII(c3))%102780 каде зборот w=c1c2c3c4c5…. е составен од сите големи букви.

Исто така за лековите да се направи посебна класа која како атрибути ќе ги има наведените карактеристики на лекот во системот.
*/

import java.util.Hashtable;
import java.util.Scanner;

public class Apteka {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Hashtable<CureName, Cure> table = new Hashtable<>();

        int n = scan.nextInt();
        scan.nextLine();

        for (int i=0; i<n; ++i) {
            String line = scan.nextLine();
            String parts[] = line.split(" ");
            String name = parts[0];
            int positive = Integer.parseInt(parts[1]);
            int price = Integer.parseInt(parts[2]);
            int number = Integer.parseInt(parts[3]);
            Cure cure = new Cure(name, positive, price, number);
            CureName cureName = new CureName(name);
            table.put(cureName, cure);
        }

        while (true) {

            String name = scan.nextLine();
            if (name.equals("KRAJ"))
                break;
            int number = Integer.parseInt(scan.nextLine());
            CureName cureName = new CureName(name);
            if (table.containsKey(cureName)) {
                Cure cure = table.get(cureName);
                System.out.println(cure);
                if (cure.makeOrder(number))
                    System.out.println("Napravena naracka");
                else
                    System.out.println("Nema dovolno lekovi");
            }
            else
                System.out.println("Nema takov lek");

        }
    }
}

class Cure {

    String name;
    int positive;
    int price;
    int number;

    Cure(String name, int positive, int price, int number) {
        this.name = name.toUpperCase();
        this.positive = positive;
        this.price = price;
        this.number = number;
    }

    String getPositive() {
        if (positive == 1)
            return "POZ";
        else
            return "NEG";
    }

    boolean makeOrder(int n) {
        if (number >= n){
            number = number - n;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "\n");
        sb.append(getPositive() + "\n");
        sb.append(price + "\n");
        sb.append(number);
        return sb.toString();
    }


}

class CureName {

    String name;

    public CureName(String name){
        this.name = name.toUpperCase();
    }

    @Override
    public int hashCode() {
        return (29 * (29 * (29 * 0 + name.charAt(0)) + name.charAt(1))+ name.charAt(2)) % 102780;
    }
//in the Object
    @Override  //https://www.youtube.com/watch?v=7V3589CReug -> zaso mora za napraeme Override na equals explained 
 
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CureName other = (CureName) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
