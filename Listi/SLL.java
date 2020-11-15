import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                //znaci kon desno treba da mu bide before jazolot
                //znaci ins mi evrzan od ednata strana kon before i uste ostanuva drugata strana
                SLLNode<E> ins = new SLLNode<E>(o, before); // go stavame noviot el
                tmp.succ = ins;// vrskata na tmp da pokazuva na ins
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    //vrednosta na elemetot e o
    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            // vrednosta na elementot e o a negoviot sledbenik e null
            // eden jazol e sostaven od data i succ
            //ins jazokol ke bide sostaven od vrednost (o) i negov succ( null)
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            //go zimame prviot element
            SLLNode<E> tmp = first;
            // go stavame prv da e negoviot sledbenik
            first = first.succ;
            // i go vrakame stariot jazol koj bil prv, bidejki vrakame element vo ramki na jazol
            return tmp.element;

        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            // dodeka narednio ne e toj so ni treba i negovata vrska(link) ne e null
            // tmp.succ se misle na vrednosta(data)
            //tmp.succ se misle na negoviot link odnosno na vrednosta na sledniot
            while (tmp.succ != node && tmp.succ.succ != null)
                //zemi go toj naredniot vo tmp
                tmp = tmp.succ;
            //vidi dali negovata vrska pokazuva koj toj jazol so ni treba
            if (tmp.succ == node) {
                //a->b->c
                //ako e taka togas linkot na tmp (momentalniot- a) da ne sledniot (b) tuku da go preripne i da pokazuva kon c
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {

            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

    public Iterator<E> iterator() {

        // Return an iterator that visits all elements of this list, in left-to-right order.
        return new LRIterator<E>();
    }

    // //////////Inner class ////////////

    private class LRIterator<E> implements Iterator<E> {

        private SLLNode<E> place, curr;

        private LRIterator() {
            place = (SLLNode<E>) first;
            curr = null;
        }

        // proveruva dali ima nareden
        public boolean hasNext() {
            return (place != null);
        }

        //go vraka elementot na jazolok koj sto e nareden
        // ne jazelot tuku elementot

        public E next() {
            if (place == null)
                throw new NoSuchElementException();
            E nextElem = place.element;
            curr = place;
            place = place.succ;
            return nextElem;
        }

        public void remove() {
            //Not implemented
        }
    }

    // prevrtuvanje na jazli vo lista
    //a->b->c : c->b->a
    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next

            //prviot go zacuvuvame
            SLLNode<E> tmp = first;
            //ke ni bide jazolot koj sakame da ni e sledeniot po red
            SLLNode<E> newsucc = null;
            // sledniot jazol do koja sakame da pristapeme
            SLLNode<E> next;
//vo sekoja edna iteracija prevrtuvame po 1 element (a->b i sea b->a)
            while (tmp != null) { //a!=null 2.b!=null
                //next=b
                next = tmp.succ;
                //b=null
                tmp.succ = newsucc;
                //newsucc=a
                //naredniot sledbenik e a
                newsucc = tmp;
                //tmp=b
                tmp = next;
            }//
            first = newsucc;
        }

    }

    public void merge(SLL<E> in) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        } else {
            first = in.getFirst();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i==2) {
                it.remove();
            }
        }
        System.out.println(numbers);
        System.out.println();
    }
}