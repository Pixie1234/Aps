/*Потребно е да се симулира најава на еден систем. Притоа корисникот внесува корисничко име и лозинка.
Доколку корисничкото име одговара со лозинката тогаш се печати Najaven, доколку не одговара се печати
Nenajaven и на корисникот му се дава повторна шанса на корисникот да внесе корисничко име и лозинка.
Во моментот кога корисникот ќе биде најавен престануваат обидите за најава.

Влез: Прво се дава број N на кориснички имиња и лозинки кои ќе бидат внесени во системот.
Во наредните N реда се дадени корисничките имиња и лозинки разделени со едно празно место.
 Потоа се даваат редови со кориснички имиња и лозинки на корисници кои се обидувата да се најават (Пр. ana banana)
За означување на крај на обидите во редицата се дава зборот KRAJ.

Излез: За секој од влезовите кои се обид за најава се печати Nenajaven се додека не дoбиеме Najaven или додека имаме обиди за најава.

Пример. Влез: 3 ana banana pero zdero trpe trpi ana ana ana banana trpe trpi KRAJ

Излез: Nenajaven Najaven

Забелешка: Работете со хеш табела со затворени кофички. Самите решавате за големината на хеш табела, а хеш функцијата ви е дадена.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Lozinki {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String imelozinka = br.readLine();
            String[] parts = imelozinka.split(" ");
            //gi stavame vo hesh prvo imeto pa lozinkata
            map.put(parts[0], parts[1]);
        }
        //obidi da se najavat so tocno korisnicko ime i lozinka
        String s = br.readLine();//za prvio tuka citame
        while (!s.equals("KRAJ")) {
            String[] parts = s.split("\\s++");
//
            //prvo provere dali postoe taj key u mapata
            if (map.containsKey(parts[0])) {
                //get go vima value na dadeniot key i da videme dali e isto so vistinskiot key

                //parts[0] e bidejki vidovme deka e ist so toj so e vnesen go zimame od mapata originalniot value
                //parts[1] e vneseniot pass
                if (map.get(parts[0]).equals(parts[1])) {//get.parts[0]-> vraka banana od mapata. parts[1] e vnesenoto sega ->bannnana
                    System.out.println("Najaven");
                    break;
                } else System.out.println("Nenajaven");
            } else System.out.println("Nenajaven");
            s = br.readLine();// posle za ostanatite tuka citame
        }
    }
}
