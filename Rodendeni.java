import java.util.HashMap;
import java.util.Scanner;
/* Дадена е листа на дати на раѓање на сите вработени во една организација. Ваша задача е за даден датум да испечатите кои вработени на организацијата ќе слават роденден 
тој ден и колку години ќе полнат (сортирани според името на вработениот). Доколку за дадениот датум нема родендени да се испечати Nema.

Влез: Во првиот ред од влезот е даден бројот на вработени, а во секој нареден ред е прво дадено името и презимето на вработениот и датата на раѓање (формат dd/mm/yyyy). 
Во последниот ред е даден датумот за кој треба да испечатите кои луѓе слават роденден на тој датум.

Излез: Името на вработениот и колку години полни, сортирани според името на вработениот.

Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест-примери.

Забелешка: При реализација на задачите не е дозволено да се користат помошни структури како низи или сл. На располагање од структурите имате само хеш структура. 
Единствено за сортирање на резултатите може да користите помошна структура.

Sample input

3
Magdalena Kostoska 15/05/1982
Hristina Mihajloska 30/05/1984
Ilinka Ivanoska 15/05/1986
15/05/2016

Sample output

Ilinka Ivanoska 30
Magdalena Kostoska 34



file:///D:/%D0%90%D0%BD%D0%B0%D1%81%D1%82%D0%B0%D1%81%D0%B8%D1%98%D0%B0/FINKI/3%20Semestar/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D0%B8%20%D0%B8%20%D0%9F%D0%BE%D0%B4%D0%B0%D1%82%D0%BE%D1%87%D0%BD%D0%B8%20%D0%A1%D1%82%D1%80%D1%83%D0%BA%D1%82%D1%83%D1%80%D0%B8/%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B8/1.%20Moi%20reseni/ispitni%20APS/%D0%A0%D0%BE%D0%B4%D0%B5%D0%BD%D0%B4%D0%B5%D0%BD%D0%B8%20_%20Code.html
*/

public class Rodendeni {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        HashMap<String,String> heshis = new HashMap<>(n);

        //System.out.println(n);
        for(int i=0;i<n;i++)
        {
            String pom[] =in.nextLine().split(" ");
		/*	if(heshis.get(pom[0]+" "+pom[1])==null)
			{
				heshis.put(pom[0]+" "+pom[1], value)
			}*/
            String datumi[] = pom[2].split("/");
            String hesh= datumi[0]+datumi[1];
            String value=pom[0]+" "+pom[1]+" "+datumi[2];
            if(heshis.get(hesh)==null)
            {
                heshis.put(hesh, value);
            }
            else
            {
                String zemi=heshis.get(hesh);
                zemi+="/"+value;
                System.out.println(zemi);
                heshis.put(hesh, zemi);
            }
        }
        String vrati=in.nextLine();
        String pom2[]=vrati.split("/");
        //System.out.println(heshis.get(pom2[0]+pom2[1]));
        if(heshis.get(pom2[0]+pom2[1])!=null)
        {
            String print[]=heshis.get(pom2[0]+pom2[1]).split("/");
            for(int i=0;i<print.length-1;i++)
            {
                for(int j=i+1;j<print.length;j++)
                {// сортирани според името
                    String Prva[]=print[i].split(" ");
                    String Vtora[]=print[j].split(" ");
                    //	System.out.println(print[i]);
                    //	System.out.println(print[j]);
                    if(Prva[0].compareTo(Vtora[0])>0)
                    {
                        String temp=print[i];
                        print[i]=print[j];
                        print[j]=temp;
                    }
                }
            }
            for(int i=0;i<print.length;i++)
            {
                String temp[]=print[i].split(" ");
                int k=Integer.parseInt(pom2[2])-Integer.parseInt(temp[2]);
                System.out.println(temp[0]+" "+temp[1]+" "+k);
            }
        }
        else
            System.out.println("Nema");
    }

}
