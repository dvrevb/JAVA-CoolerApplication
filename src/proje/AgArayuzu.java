package proje;

import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu {



    private static AgArayuzu nesne;
    private IBilgiSistemi bilgiSistemi;
    private int girisDenemesi; /// 5 ten fazla yanlışta doğrulama kutucuğu çıkacak
    private AgArayuzu()
    {
        girisDenemesi=0;
        bilgiSistemi=BilgiSistemi.getInstance();
    }

    public static synchronized AgArayuzu getInstance()
    {
        if(nesne==null)
            nesne=new AgArayuzu();
        return nesne;
    }

    @Override
    public void mesajGoruntule(String mesaj) {
        System.out.print(mesaj);
    }

    @Override
    public String seceneksun() {
        mesajGoruntule("******************************************\n");
        mesajGoruntule("1-Sıcaklık Görüntüle\n");
        mesajGoruntule("2-Soğutucuyu Çalıştır\n");
        mesajGoruntule("3-Soğutucuyu Kapat\n");
        mesajGoruntule("4-Cikis\n");
        mesajGoruntule("******************************************\n\n");
        mesajGoruntule("Seciminiz: ");
        return veriAl();  /// string veri alınıyor. inte çevrildi
    }
    @Override
    public boolean girisEkrani() {
        if (girisDenemesi>5)  // 5 ten fazla giriş denemesi yapılıp başarısız sonuç alındıysa
            Araclar.robotDogrulamaYap();
        mesajGoruntule("Kullanıcı Adınız: ");
        String kA=veriAl();
        mesajGoruntule("Şifreniz: ");
        String sifre=veriAl();

        boolean sonuc =bilgiSistemi.kullaniciKontrolEt(kA,sifre);
        if(!sonuc){
            girisDenemesi++;
            mesajGoruntule("Kullanıcı doğrulanamadı lütfen kullanıcı adınızı veya şifrenizi kontrol ediniz\n\n");
        }
        else{
            mesajGoruntule("Kullanıcı doğrulandı giriş yapılıyor\n");
            Araclar.bekle(1000);
            girisDenemesi=0;
        }
        return sonuc;
    }

    public String veriAl() {
        Scanner input=new Scanner(System.in);
        return input.next();
    }


    /* Observer metotları */
  //  @Override
    //public void update() {

    //}

}
