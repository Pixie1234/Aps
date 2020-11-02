
/*
test case 1    output : 3
5
1
2
3
4
5
test case 2     output : 1
2
3
1
test case 3    output : 1
1
1
test case 4    output : 60
14
99
60
11
99
88
3
47
24
97
54
56
89
82
31
test case 5    output : 49
15
79
87
78
37
65
59
48
99
49
19
47
37
25
21
8
test case 6    output : 57
14
74
93
98
6
11
46
16
93
49
54
57
32
72
91
test case 7    output : 61
16
27
93
86
76
14
10
57
72
82
88
49
61
83
12
75
94
test case 8    output : 61
19
38
61
97
78
94
58
100
82
68
78
2
87
87
27
18
31
95
36
85
test case 9    output : 56
19
9
72
18
97
43
68
63
82
89
7
18
2
66
31
46
56
57
96
88
test case 10    output : 3
4
2
3
7
8


*/

package Listi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Array<E> {
    private E data[]; // declared to be an Object since it would be too
    // complicated with generics
    private int size;

    //konstruktor that creates an empty array of size "size"
    public Array(int size) {
//vo ovoj konstruktor kreirame nova niza so golemina size
//tuka kastirame bidejki predhodno sme napravile niza od objekt
//oti ne znaeme so e mu stavame new od Object a posle toa so ke go dodeleme( Integer String go kastirame vo E)
   //OVIE ZAGRADI ZNACAT () KASTIRANJE
        data = (E[]) new Object[size];
        this.size = size;
    }

    public void set(int position, E o) {
        if (position >= 0 && position < size)
            data[position] = o;
        else
            System.out.println("Ne moze da se vmetne element na dadenata pozicija");
    }

    public E get(int position) {
        if (position >= 0 && position < size)
            return data[position];
        else
            System.out.println("Ne e validna dadenata pozicija");
        return null;
    }

    public int getLength() {
        return size;
    }

    public int find(E o) {
        for (int i = 0; i < size; i++){
            if(o.equals(data[i]))
                return i;
        }
        return -1;
    }

    public void insert(int position, E o) {
        // before all we check if position is within range
        if (position >= 0 && position <= size) {
            // first resize the storage array
            E[] newData = (E[]) new Object[size + 1];
            // copy the data prior to the insertion
            for (int i = 0; i < position; i++)
                newData[i] = data[i];
            // insert the new element
            newData[position] = o;
            // move the data after the insertion
            for (int i = position; i < size; i++)
                newData[i + 1] = data[i];
            // replace the storage with the new array
            data = newData;
            size = size + 1;
        }
    }

    public void delete(int position) {
        // before all we check if position is within range
        if (position >= 0 && position < size) {
            // first resize the storage array
            E[] newData = (E[]) new Object[size - 1];
            // copy the data prior to the delition
            for (int i = 0; i < position; i++)
                newData[i] = data[i];
            // move the data after the deletion
            for (int i = position + 1; i < size; i++)
                newData[i - 1] = data[i];
            // replace the storage with the new array
            data = newData;
            size = size - 1;
        }
    }

    public void resize(int newSize) {
        // first resize the storage array
        E[] newData = (E[]) new Object[newSize];
        // copy the data
        int copySize = size;
        if (newSize < size)
            copySize = newSize;
        for (int i = 0; i < copySize; i++)
            newData[i] = data[i];
        // replace the storage with the new array
        data = newData;
        size = newSize;
    }
    // ovie site metodi above so se dodadeni ne ni trebat u ovaa zadaca ama osnovni se
    // nie treba da implementirame nas nov metod vo ovaa klasa so ni treba :


    public static int brojDoProsek(int[] niza) {


        int sum =0;
        int prosek = 0;

        for (int i = 0; i < niza.length; i++) {
            sum += niza[i];
        }
        prosek= sum /niza.length;
        int rezultat = niza[0];

        //minimalnata razlika e prvata
        //Math.abs e absolutna vrednost (+ i -)
        int minRazlika = Math.abs(prosek - niza[0]);
        for (int i = 1; i < niza.length; i++) {
            //Ako e isti proseko so nekoj broj odma go vrati
            if (prosek == niza[i]) {
                return niza[i];
            }
            //Ako e momentalniot broj ima pomala razlika od minimalnata vrati go taj
            if (Math.abs(prosek - niza[i]) < minRazlika) {
                minRazlika = Math.abs(prosek - niza[i]);
                rezultat = niza[i];
            }
//Ako momentalniot broj e isti so minimalnata razlika, zemi go pomaniot broj od tie 2ta so ja imaat istata razlika od prosekot
            else if (Math.abs(prosek - niza[i]) == minRazlika){
                if (niza[i] < rezultat) {
                    rezultat=niza[i];
                }
            }
        }
        return rezultat;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader stdin  = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        if (!(1 <= N && N <= 50 )) {
            return;
        }
        //alociranje na memorija za niza so N elementi
        int[] niza = new int[N];

        for (int i = 0; i < N; i++) {
            niza[i] = Integer.parseInt(stdin.readLine());
        }

        System.out.println(brojDoProsek(niza));

    }

}
