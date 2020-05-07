package proje;

public class SogutucuKapat implements IIslem{
    private IMerkeziIslemBirimi mib;
    private IAgArayuzu arayuz;
    private static SogutucuKapat nesne;

    private SogutucuKapat(){    // singleton tasarım deseni kullanıldığından parametre olarak nesne alınmamıştır.
        mib=MerkeziIslemBirimi.getInstance();
        arayuz=AgArayuzu.getInstance();
    }

    public static synchronized SogutucuKapat getInstance(){
        if(nesne==null)
            nesne=new SogutucuKapat();
        return nesne;
    }

    @Override
    public void islemYap() {         // ag arayüzünde çalıştırılır komut ordan gelir.
        boolean sonuc=mib.eyleyiciyeKapatTalebiGonder();   // mib algılayıcıya istek gönderir ve algılayıcı bu sonucu mibe gönderir.
        if(sonuc==false){
            Araclar.bekle(500);
            arayuz.mesajGoruntule("Soğutucu kapatılamadı. (Soğutucu zaten kapalı)\n");
        }
        else{
            Araclar.bekle(500);
            arayuz.mesajGoruntule("Soğutucu başarılı bir şekilde kapatıldı\n");
        }
    }
}
