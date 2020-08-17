import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class StringBuilder_example {
    public static void main(String[] args) {
        // a list filled with strings
        List<String> trees;
        // Arrays class and asList method to instantiate our class
        trees = Arrays.asList("oak", "pine", "fir", "ash", "birch", "elm");
        System.out.println(listToString(trees));// we can use our method
    }

    /*other functionality to turn our list into a string,
    so its good idea to separate that out into a private method
    we make it static so it will work in our static main method, and it will
    return a string representation of out list and we need to take a
    List inside ( its a list of stings type and we give it a name )
     */
    private static String listToString(List<String> list) { //list of strings
// now we need a new stringBuilder variable that we can append our list items
        StringBuilder sb = new StringBuilder(32);

//now we need to iterate through our list and
// append every item to the StringBuilder
// we need to go through every item and we have no need for an index
// we will use enhanced for loop (set type of the elem which is string)


        for (String el : list) {
// for each elem we get from out list, we want to add it to our StringBuilder which we named it as "sb"
            sb.append(el).append(" "); // we append our elem and a space between each elem
        }
// return the string that is stored by our StringBuilder and we do this with toString()
        return sb.toString();
    }
}

