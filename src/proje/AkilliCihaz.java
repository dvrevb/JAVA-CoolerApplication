package proje;

public class AkilliCihaz {
    private IAgArayuzu agArayuzu;
    private IMerkeziIslemBirimi merkeziIslemBirimi;
    private IEyleyici eyleyici;
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IBilgiSistemi bilgiSistemi;
    private Publisher publisher;
    private static final String SICAKLIK_GORUNTULE = "1";
    private static final String SOGUTUCU_AC = "2";
    private static final String SOGUTUCU_KAPAT = "3";
    private static final String CIKIS = "4";
    public AkilliCihaz() {
       agArayuzu = AgArayuzu.getInstance();
       merkeziIslemBirimi=MerkeziIslemBirimi.getInstance();
       eyleyici=Eyleyici.getInstance();
       sicaklikAlgilayici=SicaklikAlgilayici.getInstance();
        bilgiSistemi=BilgiSistemi.getInstance();

        publisher=Publisher.getInstance();   // observerlar diziye atanıyor
        publisher.attach((IObserver) eyleyici);
        publisher.attach((IObserver) sicaklikAlgilayici);
    }
    public void Basla(){
        if(agArayuzu.girisEkrani()){
            agArayuzu.mesajGoruntule("Giriş yapıldı\n\n");
            Araclar.bekle(1000);// 1 saniye bekle
            islemSecimi();  // menü işlemleri sunulur.
        }
        else{
            Basla();
        }
    }

    private void islemSecimi(){
        String secim;
        do {
            secim = agArayuzu.seceneksun();   // menu secenekleri sunulur. kullanıcıdan seçim alınır
            switch (secim){   // seçimlere göre işlemler yapılır.
                case SICAKLIK_GORUNTULE:
                    agArayuzu.mesajGoruntule("Sıcaklık görüntüleme işlemini seçtiniz\n");
                    IIslem s_Goruntuleme=SicaklikGoruntule.getInstance();
                    s_Goruntuleme.islemYap();
                    break;
                case SOGUTUCU_AC:
                    agArayuzu.mesajGoruntule("Soğutucu açma işlemini seçtiniz\n");
                    IIslem s_Ac=SogutucuAc.getInstance();
                    s_Ac.islemYap();
                    break;
                case SOGUTUCU_KAPAT:
                    agArayuzu.mesajGoruntule("Soğutucu kapatma işlemini seçtiniz\n");
                    IIslem s_Kapat=SogutucuKapat.getInstance();
                    s_Kapat.islemYap();
                    break;
                case CIKIS:   // başlangıç ekranına döner
                    agArayuzu.mesajGoruntule("Çıkış yapılıyor\n");
                    Araclar.bekle(1000);
                    Basla();
                    break;
                default:
                    agArayuzu.mesajGoruntule("Hatalı bir seçim yaptınız\n\n");
                    break;
            }
        }while(!secim.equals("4"));
    }
}
