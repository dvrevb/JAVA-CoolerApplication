package proje;

public class SogutucuAc implements IIslem{
    private IMerkeziIslemBirimi mib;
    private IAgArayuzu arayuz;
    private static SogutucuAc nesne;

    private SogutucuAc(){    // singleton tasarım deseni kullanıldığından parametre olarak nesne alınmamıştır.
        mib=MerkeziIslemBirimi.getInstance();
        arayuz=AgArayuzu.getInstance();
    }

    public static synchronized SogutucuAc getInstance(){
        if(nesne==null)
            nesne=new SogutucuAc();
        return nesne;
    }

    @Override
    public void islemYap() {         // ag arayüzünde çalıştırılır komut ordan gelir.
        boolean sonuc=mib.eyleyiciyeAcTalebiGonder();   // mib algılayıcıya istek gönderir ve algılayıcı bu sonucu mibe gönderir.
        if(!sonuc){   // soğutucu daha önceden açılmışsa
            Araclar.bekle(500);
            arayuz.mesajGoruntule("Soğutucu çalıştırılamadı (Soğutucu zaten açık)\n");
            Araclar.bekle(2000);
        }
        else{
            Araclar.bekle(500);
            arayuz.mesajGoruntule("Soğutucu başarılı bir şekilde çalıştırıldı\n");
            Araclar.bekle(2000);
        }
    }
}
