import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Scanner;

/*
Квалитет на воздух Problem 1 (0 / 0)

Дадени се мерења на PM10 честички за населбите во Скопје. Ваша задача е за дадена населба да се најде просечната концентрација на PM10 честички.

Влез: Во првиот ред од влезот е даден бројот на мерења N (N<=10 000), а во секој нареден ред е прво дадена населбата
и концентрацијата на PM10 разделени со празно место. Во последниот ред е дадена населбата за која треба да најдете
просечна концентрација на PM10 честички.

Излез: Просечната концентрација на PM10 честички за дадената населба (заокружена на 2 децимали).

Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.

Забелешка: При реализација на задачите не е дозволено да се користат помошни структури како низи или сл.
На располагање од структурите имате само хеш структура.

Име на класа (Јава):PM10

Помош:
За заокружување во Java може да го користите следниот код:

DecimalFormat df = new DecimalFormat("######.##");
double a = 335.453333;
df.format(a);


Sample input

8
Centar 319.61
Karposh 296.74
Centar 531.98
Karposh 316.44
GaziBaba 384.05
GaziBaba 319.3
Karposh 393.18
GaziBaba 326.42
Karposh

Sample output

335.45

*/
public class PM10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Hashtable<String, String> table = new Hashtable<>();
        //String s = sc.nextLine();
        for (int i = 0; i <n ; i++) {
            String[] vnes = sc.nextLine().split(" ");
            String opstina = vnes[0];
            String pm = vnes[1];
            //kako da napraveme za da ako ima dupli da ne se prebrisat?
            if (table.get(opstina) == null) {
                table.put(opstina,pm);
            }
            else {
                //ako postio klucot
                String value = table.get(opstina)+" "+pm;
                table.put(opstina,value);
            }
        }
        //napunivme ja tabelata
        String vnes = sc.nextLine();//vnes na opstina
        String[] get = table.get(vnes).split(" ");

        float vkupno=0;
        for (int i = 0; i < get.length; i++) {
            vkupno = vkupno + Float.parseFloat(get[i]);
        }
        vkupno=vkupno/get.length;
        DecimalFormat df = new DecimalFormat("######.##");

        System.out.println(df.format(vkupno));
    }
}
