import java.util.Scanner;

class NegatifBakiyeException extends Exception {
    public NegatifBakiyeException(String mesaj) {
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int toplamBakiye = 5000;
        int toplamBakiye2 = 5000;
        System.out.println("Bankaya hoş geldiniz. Her iki hesap türü için sadece 1 kullanıcı oluşturulabilmektedir. Başlangıç para miktarı her iki hesap için de 5000TL'dir.");
        
        tasarrufHesabi tasarrufHesabi = null;
        cariHesabi cariHesap = null;
        int i =0;
        while (i < 1) {
            System.out.println("Hesap türü seçiniz:(1-Tasarruf Hesabı 2-Cari Hesap 3-Program Çıkışı)");
            int hesapTuru = input.nextInt();
            input.nextLine();

            if (hesapTuru == 1) {
                if (tasarrufHesabi == null) {
                    System.out.println("Müşteri Adı: ");
                    String musteriAdi = input.nextLine();
                    System.out.println("Hesap Numarası: ");
                    int hesapNumarasi = input.nextInt();
                    
                    tasarrufHesabi = new tasarrufHesabi(musteriAdi, hesapNumarasi);
                    
                }
                System.out.println("Mevcut bakiye: " + toplamBakiye);
                System.out.println("Müşteri Adı: " + tasarrufHesabi.getMusteriAdi());
                System.out.println("Hesap Numarası: " + tasarrufHesabi.getHesapNumarasi());

                boolean devam = true;
                while (devam) {
                    System.out.println("Yapmak istediğiniz işlem türü: (1: Para Yatırma, 2: Para Çekme, 3: Faiz İşlemi, 4: Çıkış): ");
                    int islemTuru = input.nextInt();

                    switch (islemTuru) {
                        case 1:
                            System.out.println("Yatırmak istediğiniz para miktarını giriniz: ");
                            int yatirma = input.nextInt();
                            toplamBakiye += yatirma;
                            System.out.println("Yeni bakiyeniz: " + toplamBakiye);
                            break;
                        case 2:
                            System.out.println("Çekmek istediğiniz para miktarını giriniz: ");
                            int cekme = input.nextInt();
                            try {
                                if (toplamBakiye - cekme < 0) {
                                    throw new NegatifBakiyeException("Hesapta yeterli bakiye yok!");
                                } else {
                                    toplamBakiye -= cekme;
                                    System.out.println("Yeni bakiyeniz: " + toplamBakiye);
                                }
                            } catch (NegatifBakiyeException e) {
                                System.out.println("Hata: " + e.getMessage());
                            }
                            break;
                        case 3:
                            double faizorani = 3.50;
                            System.out.println("Bankamızda faiz oranı aylık 3.50'den hesaplanmaktadır.");
                            System.out.println("Kaç ay vade ile faiz hesaplamak istediğinizi giriniz: ");
                            int vade = input.nextInt();
                            double faizsonucu = (toplamBakiye / 100) * faizorani/12 * vade;
                            System.out.println(vade + " ay vade ile anaparanızdaki paranızın faizli tutarı: " + (faizsonucu+toplamBakiye));
                            break;
                        case 4:
                            devam = false;
                            break;
                        default:
                            System.out.println("Yanlış tuşlama yaptınız!");
                            break;
                    }
                }
            }   if (hesapTuru == 2) {
                if (cariHesap == null) {
                    System.out.println("Müşteri Adı: ");
                    String musteriAdi = input.nextLine();
                    System.out.println("Hesap Numarası: ");
                    int hesapNumarasi = input.nextInt();
                    
                    cariHesap = new cariHesabi(musteriAdi, hesapNumarasi);
                    
                }
                System.out.println("Mevcut bakiye: " + toplamBakiye2);
                System.out.println("Müşteri Adı: " + cariHesap.getMusteriAdi());
                System.out.println("Hesap Numarası: " + cariHesap.getHesapNumarasi());

                boolean devam = true;
                int k = 0;
                while (devam) {
                    System.out.println("Yapmak istediğiniz işlem türü: (1: Para Yatırma, 2: Para Çekme, 3: Hesap Kesim İşlemi, 4: Çıkış): ");
                    int islemTuru = input.nextInt();
                    
                    switch (islemTuru) {
                        case 1:
                            System.out.println("Yatırmak istediğiniz para miktarını giriniz: ");
                            int yatirma = input.nextInt();
                            toplamBakiye2 += yatirma;
                            System.out.println("Yeni bakiyeniz: " + toplamBakiye2);
                            break;
                        case 2:
                            System.out.println("Çekmek istediğiniz para miktarını giriniz: ");
                            int cekme = input.nextInt();
                            try {
                                if (toplamBakiye2 - cekme < 0) {
                                    throw new NegatifBakiyeException("Hesapta yeterli bakiye yok!");
                                } else {
                                    toplamBakiye2 -= cekme;
                                    System.out.println("Yeni bakiyeniz: " + toplamBakiye2);
                                }
                            } catch (NegatifBakiyeException e) {
                                System.out.println("Hata: " + e.getMessage());
                            }
                            break;
                        case 3:
                        int j=0;
                        if(j == 0){
                        double hesapKesimUcreti = 50.0;
                        try {
                            if (toplamBakiye2 - hesapKesimUcreti < 0) {
                                throw new NegatifBakiyeException("Hesap kesim ücreti için yeterli bakiye yok!");
                            } if(k == 0) {
                                toplamBakiye2 -= hesapKesimUcreti;
                                System.out.println("Hesap kesim işlemi gerçekleştirildi. İşlem ücreti: " + hesapKesimUcreti);
                                System.out.println("Yeni bakiyeniz: " + toplamBakiye2);
                            }
                            if(k>0){
                                System.out.println("Hesap kesiminiz daha yeni yapılmıştır.");
                            }
                        } catch (NegatifBakiyeException e) {
                            System.out.println("Hata: " + e.getMessage());
                        }
                        }
                            break;
                        case 4:
                            devam = false;
                            break;
                        default:
                            System.out.println("Yanlış tuşlama yaptınız!");
                            break;
                    }
                    k++;
                }
            } 
            if(hesapTuru ==3){
              break;
            }
            if (hesapTuru <1 && hesapTuru>3){
                System.out.println("Geçersiz hesap türü!");
            }
        }
        input.close();
    }
}