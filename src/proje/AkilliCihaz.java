package proje;

public class AkilliCihaz {
    private IAgArayuzu agArayuzu;
    private IMerkeziIslemBirimi merkeziIslemBirimi;
    private IEyleyici eyleyici;
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IBilgiSistemi bilgiSistemi;
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
    }
    public void Basla(){
        if(agArayuzu.girisEkrani()){
            agArayuzu.mesajGoruntule("Giriş yapıldı\n\n");
            Araclar.bekle(1000);// yarım saniye bekle
            islemSecimi();
        }
        else{
            Basla();
        }
    }

    private void islemSecimi(){
        String secim;
        do {
            secim = agArayuzu.seceneksun();
            switch (secim){
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
                case CIKIS:
                    System.exit(0);
                    break;
                default:
                    agArayuzu.mesajGoruntule("Hatalı bir seçim yaptınız\n");
                    break;
            }
        }while(secim!="4");

    }
}
