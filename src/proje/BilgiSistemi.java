package proje;

public class BilgiSistemi implements IBilgiSistemi{

    private IKullaniciRepository kullaniciRepository;
    private static BilgiSistemi nesne;

    private BilgiSistemi()
    {
        kullaniciRepository= KullaniciRepositoryPostgreSQL.getInstance();
    }

    public static synchronized BilgiSistemi getInstance(){
        if(nesne==null)
            nesne=new BilgiSistemi();
        return nesne;
    }
    @Override
    public boolean kullaniciKontrolEt(String kullaniciAdi, String sifre) {
        if(kullaniciRepository.kullaniciDogrula(kullaniciAdi,sifre)){   // veritabanına bağlanılıyor ve kontrol yapılıyor
            return true;
        }
        return false;
    }
}
