package proje;


import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{

    private static SicaklikAlgilayici nesne;
    private int sicaklik;
    Random random;
    private SicaklikAlgilayici(){
        random=new Random();
        sicaklik=random.nextInt(20)+15; // 15-35 arası sıcaklık degeri rastgele üretiliyor
    }
    Random rastgele=new Random();
    public static synchronized SicaklikAlgilayici getInstance()
    {
        if (nesne==null)
            nesne=new SicaklikAlgilayici();
        return nesne;
    }

    @Override
    public int sicaklikOku() {
        return sicaklik;
    }



}
