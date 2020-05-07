package proje;


import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici,IObserver{

    private static SicaklikAlgilayici nesne;
    private IAgArayuzu agArayuzu;
    private int sicaklik;
    Random random;

    private SicaklikAlgilayici(){
        random=new Random();
        agArayuzu=AgArayuzu.getInstance();
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


    @Override   /*observer metodu*/
    public void update() {  // kullanıcı giriş yaptığında ilk değer üretilecek
        sicaklik=random.nextInt(20)+15; // 15-35 arası sıcaklık degeri rastgele üretiliyor
        Araclar.bekle(1000);
        agArayuzu.mesajGoruntule("Sıcaklık algılayıcı ilk değeri okudu\n");
    }
}
