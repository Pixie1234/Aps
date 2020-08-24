/*
Sample input:
2
192.124.1.1
10.10.10.0,12.12.12.0,45.5.5.0
22.4.5.6
88.7.7.0,45.3.3.0,8.8.8.0
3
22.4.5.6
45.3.3.1
3.3.3.3
22.22.2.2
192.124.1.1
12.12.12.4
Program output:
postoi
ne postoi
postoi
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class RoutingHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());//broj na ruteri

        //gi stavame string i key i value oti imat tocki u niv i brojki toa e string
        //Ako e samo brojka e Integer a vaka mesano char i int e string
        Hashtable<String, String> tabela = new Hashtable<String, String>();

        for (int i = 0; i < N; i++) {
            String router  = sc.nextLine();//IP адресата на влезниот интерфејс
            String value  = sc.nextLine();//IP адресите на мрежите до кој рутерот има статички рути
            tabela.put(router, value);
        }
        System.out.println(tabela);// {192.168.1.1=20.2.2.0, 23.3.3.3=10.10.10.0} ->size =2

        /*String s = sc.nextLine(); ili vaka moze da citavme br na paketi
        int n = Integer.parseInt(s);*/
        N = Integer.parseInt(sc.nextLine());// broj na paketi

        for (int i = 0; i < N; i++) {//N=2
            String source = sc.nextLine();//192.168.1.1
            String destination = sc.nextLine();//20.2.2.1
            //so we gonna get an array when we split it and we store it at dest
            String[] dest = destination.split("\\.");

            if (!tabela.containsKey(source)) {//ako go nema toj kluc odma ne postoi
                System.out.println("ne postoi");
            }
            else {// a ako go ima klucot
                //.get(key) -> value (a ako go nema vraka null)
//praeme get na source(istot kako vo Lozinki) go imame tocniot key i od nego so get gi zimame values (ovde ni se vo niza)
                String[] destAdr = tabela.get(source).split(",");//dokolku se vneseni poveke oddeleni so zapirki gi deleme posebno i gi stavame vo niza
                boolean flag= false;
                for (int j = 0; j < destAdr.length; j++) {
                    //konkretnata taa vrednosta da ja sporedeme so maska /24
                    String[] temp= destAdr[j].split("\\.");
                    //sporeduvame so .equals oti se objekti u hesh
                    if (temp[0].equals(dest[0]) && temp[1].equals(dest[1]) && temp[2].equals(dest[2])) {
                        System.out.println(temp[0]);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("postoi");
                }
                else System.out.println("ne postoi");
            }

        }

    }
}

