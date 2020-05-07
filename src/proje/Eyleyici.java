package proje;

import java.util.ArrayList;

public class Eyleyici implements IEyleyici,IObserver {

    private static final int ACIK=1;
    private static final int KAPALI=2;
    private static final int BEKLEME=3;
    private byte durum;
    private static Eyleyici nesne;
    private IAgArayuzu arayuz;
    private Eyleyici()
    {
        arayuz=AgArayuzu.getInstance();
    }

    public static synchronized Eyleyici getInstance()
    {
        if(nesne==null)
            nesne=new Eyleyici();
        return nesne;
    }

    @Override
    public boolean sogutucuCalistir() {
        if (durum==ACIK){  /// sogutucu zaten açık
           return false;
        }
        durum=ACIK;
        return true;

    }
    @Override
    public boolean sogutucuyuKapat() {
        if (durum==KAPALI){  /// sogutucu zaten kapalı
            return false;
        }
        durum=KAPALI;
        return true;

    }

    @Override     /* observer metodu*/
    public void update() {
        durum=BEKLEME;
        Araclar.bekle(1000);
        arayuz.mesajGoruntule("Soğutucu bekleme moduna alındı.\n");
    }
}
