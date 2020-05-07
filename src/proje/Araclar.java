package proje;

import java.util.Random;
import java.util.Scanner;

public class Araclar {
    public static void bekle(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void robotDogrulamaYap(){
        boolean dogruGirildimi=false;
        Random rastgele = new Random();
        int deger,girilen;
        Scanner scan=new Scanner(System.in);
        do {
            deger=rastgele.nextInt()%10000+50001;
            System.out.println("Robot olmadığınızı doğrulayın ...Değeri giriniz: "+deger);
            System.out.print(">>> ");
            girilen=scan.nextInt();
        }while(deger!=girilen);

    }
}
