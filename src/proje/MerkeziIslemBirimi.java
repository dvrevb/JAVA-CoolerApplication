package proje;

public class MerkeziIslemBirimi implements  IMerkeziIslemBirimi{

    private static MerkeziIslemBirimi nesne;
    private ISicaklikAlgilayici algilayici;
    private IAgArayuzu arayuz;
    private IEyleyici eyleyici;
    private MerkeziIslemBirimi()
    {
        algilayici=SicaklikAlgilayici.getInstance();
        arayuz=AgArayuzu.getInstance();
        eyleyici=Eyleyici.getInstance();
    }

    public static synchronized MerkeziIslemBirimi getInstance()
    {
        if(nesne==null)
            nesne=new MerkeziIslemBirimi();
        return nesne;
    }


    @Override
    public int algilayicidanSicaklikTalepEt() {
        return algilayici.sicaklikOku();  // talep edilen değer mibe geldi.
    }

    @Override
    public boolean eyleyiciyeKapatTalebiGonder() {
        arayuz.mesajGoruntule("Kapat talebi alındı\n");
        Araclar.bekle(1000);
        return eyleyici.sogutucuyuKapat();     // talep edilen işlemin sonucu mibe geldi.
    }

    @Override
    public boolean eyleyiciyeAcTalebiGonder() {
        arayuz.mesajGoruntule("Aç talebi alındı\n");
        Araclar.bekle(1000);
       return eyleyici.sogutucuCalistir();          // talep edilen işlemin sonucu mibe geldi.
    }
}
