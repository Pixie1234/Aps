
// zadaca za sobiranje na 2 polinomi
// kreirame Lista od vrednostite za polinomite : koeficient, eksponent
public class PolinomList {
    //sll lista za da moze da raboteme so samata cela lista da dodavame da briseme elementi
    SLL<Koeficient> listaKoeficienti = new SLL<>();

    //konstruktor (alt + insert)
    public PolinomList(SLL<Koeficient> listaKoeficienti) {
        this.listaKoeficienti = listaKoeficienti;
    }

    //getter
    public SLL<Koeficient> getListaKoeficienti() {
        return listaKoeficienti;
    }

    //setter
    public void setListaKoeficienti(SLL<Koeficient> listaKoeficienti) {
        this.listaKoeficienti = listaKoeficienti;
    }

    @Override
    public String toString() {
        //listaKoeficienti e SLL<Koeficient> toa znaci deka toString
        //toString tuka ke se povika od SLL Klasata
        return listaKoeficienti.toString();
    }

    //vazen metod za sobiranje na koeficientite
    public PolinomList soberi(PolinomList in) {
        //Onoj koj go davam kako parametar, listata na koeficienti ja zimame so geter

        // KREIRAME LISTA
        SLL<Koeficient> listaKoeficienti2 = in.getListaKoeficienti();

        // kreirame 1 node koj ja zema vrednosta na prviot od listaKoeficienti
        // KREIRAME 2 NODES OD 2 RAZLICNI LISTI
        SLLNode<Koeficient> node1 = listaKoeficienti.getFirst();
        SLLNode<Koeficient> node2 = listaKoeficienti2.getFirst();

        //SLL E LISTATA CELA
        //SLLNODE E SAMO 1 ELEMENT

        //ke treba da iame edna rezultantna lista
        //kade ke go cuvam rezultatot
        SLL<Koeficient> rezultat = new SLL<>();


        while (node1 != null && node2 != null) {
            //go preopovarivme compareTo vo klasata Koeficient i sporeduva po eksponent
            if (node1.element.compareTo(node2.element) < 0) {
                //pogolemiot treba da odi napred
                rezultat.insertLast(node2.element);
                node2 = node2.succ;
            }
            //eksponent1 > eksponent2
            else if (node1.element.compareTo(node2.element) > 0) {
                rezultat.insertLast(node1.element);
                node1 = node1.succ;
            }
            //eksponent1 == eksponent2
            else {
                //soberi od klasata Koeficient, gi zbirame samo koeficientite
                // praveme objekt od klasata Koeficient
                Koeficient zbir = node1.element.soberi(node2.element);
                //treba da go staveme toj zbir vo rezultatot
                rezultat.insertLast(zbir);
                node1 = node1.succ;
                node2 = node2.succ;
            }
        }
// da gi dodademe drugite elementi ako vo nekoja lista ima poveke od drugata

        while (node1 != null) {
            rezultat.insertLast(node1.element);
            node1 = node1.succ;
        }
        while (node2 != null) {
            rezultat.insertLast((node2.element));
            node2 = node2.succ;
        }
        // na kraj vrakame nov objekt koj sea go kreirame (zatoa so zborceto NEW)!
        // kade rezultatot e dobienot
        PolinomList rez = new PolinomList(rezultat);
        return rez;
    }
    public static void main(String[] args) {
        //praeme edna lista od koeficienti
        SLL<Koeficient> k1 = new SLL<>();
        k1.insertLast(new Koeficient(2, 4));
        //so toa new Koeficient kreirame objekt
        k1.insertLast(new Koeficient(3, 0));
        System.out.println("Polinom1: " + k1.toString());

        PolinomList p1 = new PolinomList(k1);

        SLL<Koeficient> k2 = new SLL<>();
        k2.insertLast(new Koeficient(1, 3));
        k2.insertLast(new Koeficient(2, 2));
        k2.insertLast(new Koeficient(8, 0));
        System.out.println("Polinom2: " + k2.toString());
        PolinomList p2 = new PolinomList(k2);

        System.out.println("Zbir: " + p1.soberi(p2));
        //se povikuva toString metod od object klasata i java nema da znae da go ispecati objektot
        // ne ni vraka kako so treba znaci treba da implementirame 2 toString metodi
        // ne znae da ispecati polinom i zbir ( a zbirot vraka PolinomList)
        //eden vo PolinomList i eden vo Koeficient
    }

}
