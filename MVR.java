/*Шалтерот на МВР Problem 3 (0 / 0)
Луѓето доаѓаат наутро во МВР за да извадат еден или повеќе документи.
Документите може да бидат:
1. Лична карта
2. Пасош
3. Возачка дозвола
Кога се отвора шалтерот прво се услужуваат луѓето кои чекаат за лична карта, па потоа оние за пасош и на крај оние за возачка дозвола.
Секој човек кога ќе дојде си застанува во редицата за соодветната исправа која ја вади (т.е. или во редицата за лични карти или во редицата за пасоши или во редицата за возачки дозволи). Доколку еден човек има повеќе документи за вадење прво вади лична карта, па пасош и на крај возачка. Така ако еден човек треба да вади и лична карта и возачка дозвола прво застанува во редицата за лични карти и откако ќе заврши таму оди на крајот на редицата за возачки дозволи.

Влез: Првиот ред означува колку луѓе вкупно дошле во МВР. Потоа за секој човек се внесуваат четири реда, во првиот е името и презимето на човекот, а во останатите три реда се кажува кој документ соодветно (лична карта, пасош и возачка) треба да се земе, притоа 1 значи дека треба да се земе тој документ, 0 значи дека не треба да се земе.

На пример:

Aleksandar Aleksandrovski
1
0
1
означува дека Александар Александровски ќе вади и лична карта и возачка дозвола, но нема да вади пасош.
Излез: Ги печати имињата на луѓето по редоследот по кој завршуваат со вадење на документи.

Име на класата (Java): MVR

Sample input
4
Aleksandar Aleksandrovski
0
0
1
Petre Petreski
1
0
0
Branka Brankovska
0
0
1
Jana Janevska
0
1
0
Sample output
Petre Petreski
Jana Janevska
Aleksandar Aleksandrovski
Branka Brankovska

Sample input:               Sample output:

10                          Jana Janevska
Ana Anovska                 Aleksandar Aleksandrovski
0                           Maja Majevska
1                           Petko Petkovski
1                           Mite Mitevski
Marko Markovski             Trajko Trajkovski
1                           Marko Markovski
0                           Petre Petreski
1                           Ana Anovska
Branka Brankovska           Branka Brankovska
0
1
1
Jana Janevska
0
1
0
Petko Petkovski
1
1
0
Aleksandar Aleksandrovski
0
1
0
Trajko Trajkovski
0
0
1
Petre Petreski
1
0
1
Mite Mitevski
1
1
0
Maja Majevska
0
1
0
 */

import java.util.NoSuchElementException;
import java.util.Scanner;

interface Queue<E> {

    // Elementi na redicata se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size ();
    // Ja vrakja dolzinata na redicata.

    public E peek ();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear ();
    // Ja prazni redicata.

    public void enqueue (E x);
    // Go dodava x na kraj od redicata.

    public E dequeue ();
    // Go otstranuva i vrakja pochetniot element na redicata.

}
/* ne ni treba sea ArrayQueue ama ova e kakva bi bila
class ArrayQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue (int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty () {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear () {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue (E x) {
        // Go dodava x na kraj od redicata.
        elems[rear++] = x;
        if (rear == elems.length)  rear = 0;
        length++;
    }

    public E dequeue () {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length)  front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}*/
class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue () {
        clear();
    }

    public boolean isEmpty () {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear () {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue (E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue () {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}

class Gragjanin {
    private String name;
     int ID;
     int drivingLicence;
     int passport;

    public Gragjanin(String name, int ID, int passport, int drivingLicence) {
        this.name=name;
        this.ID=ID;//1
        this.passport = passport;//2
        this.drivingLicence = drivingLicence;//3
    }
    @Override
    public String toString() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getDrivingLicence() {
        return drivingLicence;
    }

    public int getPassport() {
        return passport;
    }
}

public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        int N = Integer.parseInt(br.nextLine());
//redicite:
        LinkedQueue<Gragjanin> licna = new LinkedQueue<>();
        LinkedQueue<Gragjanin> pasos = new LinkedQueue<>();
        LinkedQueue<Gragjanin> vozacka = new LinkedQueue<>();

        for(int i=1;i<=N;i++){
            String imePrezime = br.nextLine();//Go citame imeto
            int lKarta = Integer.parseInt(br.nextLine());//citame za L.K.
            int pasos1 = Integer.parseInt(br.nextLine());//citame pasos
            int vozacka1 = Integer.parseInt(br.nextLine());//citame vozacka
            Gragjanin covek = new Gragjanin(imePrezime,lKarta,pasos1,vozacka1);

            if (lKarta == 1) {// na redicata licna go dodavame toj covek
                licna.enqueue(covek);//ako saka licnaKarta, stavi go u taj red
            } else if (pasos1 == 1) {// ako saka pasos staj go u taj red
                pasos.enqueue(covek);
            } else {
                vozacka.enqueue(covek);//ako nejke ni toa ni toa znaci saka vozacka, i staj go u taj red da ceka
            }
        }
        while (!licna.isEmpty()) {// dodeka ima u redo za licna
            Gragjanin pom = licna.dequeue(); //ja vademe od redicata licna
            //ako toj graganin ima i pasos za zimanje neka ide u redicata za pasos, pa ako ima i vozacka tamo u taa redica ke si go proverat dali ima
            if (pom.getPassport() == 1) {
                pasos.enqueue(pom);// stavi go u redicata za pasos
            } else if (pom.getDrivingLicence() == 1) {
                vozacka.enqueue(pom);
            } else {
                System.out.println(pom);
            }
        }
        while (!pasos.isEmpty()) {
            Gragjanin pom = pasos.dequeue();
            if (pom.getDrivingLicence() == 1) {
                vozacka.enqueue(pom);
            } else System.out.println(pom);
        }
        while (!vozacka.isEmpty()) {
            System.out.println(vozacka.dequeue());
        }

    }
}
