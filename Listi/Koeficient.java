public class Koeficient implements Comparable<Koeficient>{
    //mora da nasleduva od Compararable interfejsot za da go napiseme
    //metodot compareTo, toa znaci deka Koeficient klasata e sporedliva
    // so drug Koeficient ->Comparable<Koeficient>
    //nie sakame da gi sporedime spored eksponentot so go imaat znaci
    //sami ke si ja napiseme compareTo

    int koeficient;
    int eksponent;

    public Koeficient(int koeficient, int eksponent) {
        this.koeficient = koeficient;
        this.eksponent = eksponent;
    }

    public Koeficient soberi(Koeficient k) {
        //eksponentot e isti a koeficientite gi sobirame na this.koeficient i na toj so go prakame k.koeficient
        return new Koeficient(this.koeficient + k.koeficient, eksponent );
    }

    @Override
    public String toString() {
        return koeficient + "x^" + eksponent + " ";
    }

    public int compareTo(Koeficient o) {
        if(this.eksponent > o.eksponent) return 1;
        if(this.eksponent< o.eksponent) return -1;
        return 0;
    }
}


