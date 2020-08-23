
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapAwesomeness {
    public static void main(String[] args) {
        HashMap<String, String> hash = new HashMap<String, String>();
        hash.put("BOBBYjOE", "FluffyP0nies");
        hash.put("HELLOkitty", "Aloevera?");
        hash.put("coolguyswag", "password123");

        System.out.println(hash.containsKey("HELLOkitty"));//true
        System.out.println(hash.containsValue("password123"));//true

        hash.remove("HELLOkitty");// remove by key, go nema veke u hash
        System.out.println(hash.size());//2
        //replace ja vraka starata vrednosta: FluffyP0nies
        System.out.println(hash.replace("BOBBYjOE", "b3tt3rP@ssword!"));

        System.out.println(hash);//{coolguyswag=password123, BOBBYjOE=b3tt3rP@ssword!}

        System.out.println(hash.values());//[password123, b3tt3rP@ssword!]
        System.out.println(hash.keySet());//[coolguyswag, BOBBYjOE]

        Map<Character, Integer> m = new HashMap<Character, Integer>();

        //HashTable:
        Hashtable<Character, Integer> tabela = new Hashtable<Character, Integer>();
        String s = "asdfghjk";
        System.out.println(s.charAt(0));//a
        System.out.println(s.charAt(1));//s
        System.out.println(s.charAt(2));//d
        System.out.println(s.charAt(3));//f

        for (int i = 0; i < s.length(); i++) {

            tabela.put(s.charAt(i), i);//se polni hash tabelata
        }
        System.out.println(tabela);//{a=0, k=7, j=6, h=5, s=1, g=4, f=3, d=2}
        //mora so '' navodnici kaj get('h'); inaku so double quotes dava null
        System.out.println("Kofickata vo koja se naoga h e " + tabela.get('h'));//5

    }
}

