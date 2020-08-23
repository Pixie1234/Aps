public class toString_Method {
    public static void main(String[] args) {
        /*toString method helps to print an object
        when we print an object it prints its memory location(blob)
        so we add toString method to the class and it prints out important information
         */
        Student s1 = new Student(1,"Bruce");
        Student s2 = new Student(2, "Jack");
//if we print any kind of object it prints its place in memory
        //keep in mind to delete the toString method so it prints the memory
        System.out.println(s1);//Student@6acbcfc0
        System.out.println(s2);//Student@5f184fc6
//unless there is a .toSting method that replaces its memory with something valuable
        // now that we overide the toSting method we can just call it
        System.out.println(s1);//1 Bruce
        System.out.println(s2);//2 Jack
        //or this way
        System.out.println(s1.toString());//1 Bruce
        System.out.println(s2.toString());//2 Jack
    }
}
// we dont need to say public since is in the same .java file
class Student {
    int studentID;
    String name;

    Student(int studentID, String name) {
        this.studentID=studentID;
        this.name=name;
    }
    //it has to be the same name toString so it knows to replace its memory with a value
    public String toString() {
        return studentID+ " " + name;
    }

}
