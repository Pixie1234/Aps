import java.util.HashMap;
import java.util.Scanner;


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
