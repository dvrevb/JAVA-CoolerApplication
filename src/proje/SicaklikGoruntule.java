package proje;

public class SicaklikGoruntule implements IIslem {
    private IMerkeziIslemBirimi mib;
    private IAgArayuzu arayuz;
    private static SicaklikGoruntule nesne;

    private SicaklikGoruntule(){    // singleton tasarım deseni kullanıldığından parametre olarak nesne alınmamıştır.
        mib=MerkeziIslemBirimi.getInstance();
        arayuz=AgArayuzu.getInstance();
    }

    public static synchronized SicaklikGoruntule getInstance(){
        if(nesne==null)
            nesne=new SicaklikGoruntule();
        return nesne;
    }



    @Override
    public void islemYap() { // ag arayüzünde çalıştırılır komut ordan gelir.
        int deger=mib.algilayicidanSicaklikTalepEt(); // mib algılayıcıya istek gönderir ve algılayıcı bu değeri mibe gönderir.
        Araclar.bekle(1000);
        arayuz.mesajGoruntule("Sıcaklık Değeri: "+deger+"°C\n"); // mib üzerinden sıcaklık alındı ve arayüzde gösterildi.
        Araclar.bekle(2000);
    }
}
