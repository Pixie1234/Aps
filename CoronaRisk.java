import java.util.Hashtable;
import java.util.Scanner;

public class CoronaRisk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Hashtable<String, Integer> pozitive = new Hashtable<>();
        //ke ni trebat 2 hesh tabeli
        Hashtable<String, Integer> negative = new Hashtable<>();

        int counter_poz=1;
        int counter_neg=1;

        for (int i = 0; i < n; i++) {
            String[] vnes = sc.nextLine().split(" ");
            String key = vnes[0];
            String value = vnes[1];
            if (vnes[2].equals("pozitiven")) {
                if (pozitive.get(key) != null) {
                    counter_poz++;
                    pozitive.put(key, counter_poz);
                }
                else{
                    pozitive.put(key,1);
                }
            } else if (vnes[2].equals("negativen")) {
                if (negative.get(key) != null) {
                    counter_neg++;
                    negative.put(key, counter_neg);
                }
                else{
                    negative.put(key, 1);
                }
            }
        }
        //citame input za koja naselba
        String input = sc.nextLine();
        float vrednost_poz= pozitive.get(input);
        float vrednost_neg = negative.get(input);

        System.out.println(vrednost_poz / (vrednost_neg + vrednost_poz));

    }
}
