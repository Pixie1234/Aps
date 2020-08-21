/* 1. Постфикс нотација - Java Задача 3 (0 / 0)
Да се напише алгоритам кој ќе врши евалуација на израз во постфикс нотација. На влез се чита низа од знаци за изразот (стринг), а на излез се печати вредноста на изразот по евалуацијата. Име на класата: PostFixEvaluation
Вашето решение:
Програмски јазик: Java

Тест случај#  Влез                        Излез
1               1 2 +                       3
2               7 4 -                       3
3               0 3 /                       0
4               5 2 *                       10
5               100 20 -                    80
6               1 2 3 * + 5 -               2
7               28 72 * 13 + 20 67 * +      3369
8               1 1 1 - - 1 + 1 +           3
9               60 80 * 20 40 * /           6
10              8 9 * 4 3 - + 2 3 6 * + -   53

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFixEvaluation {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        //we are converting a String into array of chars using toCharArray() method
        char exp[] = expression.toCharArray();
/*toCharArray() method converts this string into character array.
It returns a newly created character array, its length is similar to this
string and its contents are initialized with the characters of this string.*/
//so exp prakame samo eden znak i go testirame dole so znak e
        System.out.println(result(exp));
        br.close();
    }

    public static int result(char [] ch) {
        Stack<Integer> intStack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {

//Character e klasa so metodi za manipulacija so karakteri: Character ch = new Character('a');
            if (Character.isDigit(ch[i])) {
                if (Character.isDigit(ch[i + 1])) {
                    sb.append(ch[i]); // append all the digits elements to our StringBuilder
                    continue;
                } else {
                    sb.append(ch[i]);
                    intStack.push(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }
            }
            else if (ch[i] == '+') {
                int num1 = intStack.pop();
                int num2 = intStack.pop();
                intStack.push(num1 + num2);
            }
            else if (ch[i] == '-') {
                int num1 = intStack.pop();
                int num2 = intStack.pop();
                intStack.push(num2 - num1);
            }
            else if (ch[i] == '*') {
                int num1 = intStack.pop();
                int num2 = intStack.pop();
                intStack.push(num1 * num2);
            }
            else if (ch[i] == '/') {
                int num1 = intStack.pop();
                int num2 = intStack.pop();
                intStack.push(num2 / num1);
            }
        }
        return intStack.pop();
    }
}
