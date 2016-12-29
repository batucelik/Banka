/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Batuhan
 */
import javax.swing.JOptionPane;

public class Banka {
     private static String ana_menu(){
          
        return "Bankamiza Hos Geldiniz\n1.Yeni Hesap Aç\n2.Islemler\n3.Cikis";
    }
    private static String islemler_menu(){
        return "Menüden işleminizi seçiniz.\n1.Sifre Degis\n2.Para Yatir\n3.Para Cek\n4.Yazdir\n5.Cikis";
    }    
   
    private static int HspNoAra(Musteri musteriler[],int aranan){
        for(int i=0;i<musteriler.length;i++){
            int hspno=musteriler[i].get_hesapno();
                if(hspno==aranan){
                    return i;
                }
        }
        return -2;
    }
 
    public static void main(String args[]){
        int ana_menu_secim=0,islemler_menu_secim=0,MusteriID=0;
        int miktar=0;
        int sifre =3478;
        int resifre=0;
        int hesapno=0;
        String ad="";
        String adres="";
        String tel="";
        
        
        
        Musteri musteriler[]=new Musteri[5];
        
        for(int a=0;a<musteriler.length;a++){
            musteriler[a]=new Musteri();    
            }
        
        
        ana_menu_secim=Integer.parseInt(JOptionPane.showInputDialog(ana_menu()));
            while(ana_menu_secim!=3){
                 
           if(ana_menu_secim==1){
               
                     sifre=Integer.parseInt(JOptionPane.showInputDialog("Sifrenizi Giriniz",sifre));
                     
                
                     
                       while(sifre!=resifre){
                            resifre=Integer.parseInt(JOptionPane.showInputDialog("Çıkmak için: -1\nSifrenizi Tekrar Giriniz"));
                      if(resifre==-1){break;}
                       }
                      
                    if(resifre!=-1){
                         ad=JOptionPane.showInputDialog("Adınızı Giriniz");
                         adres=JOptionPane.showInputDialog("Adresinizi Giriniz");
                         tel=JOptionPane.showInputDialog("Telefon Numaranızı Giriniz");
                       miktar=Integer.parseInt(JOptionPane.showInputDialog("Miktar giriniz"));
                        hesapno=100+MusteriID;
                        
                        musteriler[MusteriID]=new Musteri(ad,adres,tel,miktar,sifre,hesapno,false);
             
             
                         JOptionPane.showMessageDialog(null,musteriler[MusteriID].Hesap_goster(),"Oluşan Hesap Bilgisi",JOptionPane.INFORMATION_MESSAGE);
                       MusteriID++;
                       ana_menu_secim=    Integer.parseInt(JOptionPane.showInputDialog("Ana menüye dönmek için -1 işlemler için 2 giriniz."));
                   }
                   }
                      if(ana_menu_secim==2){//islemler seçilirse
                                    
                               int hspNo=Integer.parseInt(JOptionPane.showInputDialog("Ana Menuye donmek için: -1\nHesap Numaranızı giriniz:"));
                            int yanlis_sayisi=0;
                                int musteri_no=HspNoAra(musteriler,hspNo);    
                               
                       while(musteri_no==-2 && hspNo!=-1){
                                    hspNo=Integer.parseInt(JOptionPane.showInputDialog("Ana Menuye donmek için: -1\nYanlış numara,lütfen tekrar deneyiniz:"));
                                   musteri_no=HspNoAra(musteriler,hspNo);
                                }//while dongusu sonu (Hesap numarası doğru girildi)
                                
                               
                        if(musteri_no!=-2){//hesap varsa
                                 if(!(musteriler[musteri_no].get_bloke())){//Hesap numarası blocklu değilse
                                     int a=1;    
                                     sifre=Integer.parseInt(JOptionPane.showInputDialog("Sifrenizi Giriniz"));    
                            
                                        while(musteriler[musteri_no].get_sifre()!=sifre && a!=3){
                                            sifre=Integer.parseInt(JOptionPane.showInputDialog("Sifrenizi 3 defa yanlış girerseniz hesabınız bloke olacaktır\nYanlış girme sayısı: "+a));    
                                            a++;
                                         }//while sonu
                                            if(a==3){//hesabı blokla
                                                 musteriler[musteri_no].set_bloke(true);
                                                 JOptionPane.showMessageDialog(null,"3 Defa Yanlış şifre girdiğinizden hesabınız bloke edilmiştir.!!Acilen bankayı arayınız.","Hata",JOptionPane.ERROR_MESSAGE);
                                            }else{
                                            islemler_menu_secim=Integer.parseInt(JOptionPane.showInputDialog(islemler_menu()));
                                                while(islemler_menu_secim!=5){
                                                    
                                                    if(islemler_menu_secim==1){
                                                         int yeni_sifre=Integer.parseInt(JOptionPane.showInputDialog("Yeni şifrenizi giriniz: "));
                                                      int reyeni_sifre=Integer.parseInt(JOptionPane.showInputDialog("Yeni şifrenizi tekrar giriniz: "));
                                                         while(yeni_sifre!=reyeni_sifre){//şifre yanlış girilirse
                                                             JOptionPane.showMessageDialog(null,"Şifreleriniz uyuşmuyor.Lütfen Tekrar Deneyiniz","Şifre Uyuşma Hatası",JOptionPane.ERROR_MESSAGE);
                                                             yeni_sifre=Integer.parseInt(JOptionPane.showInputDialog("Yeni şifrenizi giriniz: "));
                                                             reyeni_sifre=Integer.parseInt(JOptionPane.showInputDialog("Yeni şifrenizi tekrar giriniz: "));
                                                        }
                                                    
                                                    musteriler[musteri_no].set_sifre(reyeni_sifre);
                                                     JOptionPane.showMessageDialog(null,"Şifreniz başarıyla değiştirilmiştir.");
                                                     }
                                                     
                                                    if(islemler_menu_secim==2){
                                                        int yatirilan_miktar=Integer.parseInt(JOptionPane.showInputDialog("Yatırılıcak miktarı giriniz"));
                                                         musteriler[musteri_no].set_miktar_ekle(yatirilan_miktar);
                                                         JOptionPane.showMessageDialog(null,"İşleminiz başarıyla tamamlanmıştır.");
                                                     }
                                                    
                                                     if(islemler_menu_secim==3){
                                                      if(musteriler[musteri_no].get_miktar()!=0){
                                                             int cekilen_miktar=Integer.parseInt(JOptionPane.showInputDialog("Çekilecek miktarı giriniz"));
                                                             while(musteriler[musteri_no].miktar_konrol(cekilen_miktar)){
                                                                JOptionPane.showMessageDialog(null,"Hesabınızda girdiğiniz miktar kadar para yok","Hesap Hatası",JOptionPane.WARNING_MESSAGE);
                                                                cekilen_miktar=Integer.parseInt(JOptionPane.showInputDialog("Çekilecek miktarı  tekrar giriniz"));
                                                            }
                                                             musteriler[musteri_no].set_miktar_eksilt(cekilen_miktar);
                                                         JOptionPane.showMessageDialog(null,"İşleminiz başarıyla tamamlanmıştır.");
                                                      }else{JOptionPane.showMessageDialog(null,"Hesabınızda hiç para olmadığı için para çekemezsiniz");}
                                                     }
                                                     
                                                    if(islemler_menu_secim==4){
                                                         JOptionPane.showMessageDialog(null,musteriler[musteri_no].Hesap_goster());
                                                    }
                                                    
                                                     islemler_menu_secim=Integer.parseInt(JOptionPane.showInputDialog(islemler_menu()));
                                                    }
                                                     JOptionPane.showMessageDialog(null,"Bankamızı kullandığınız için teşekkür ederiz");
                                                }                                
                                     }else{
                                         JOptionPane.showMessageDialog(null,"Hesabınız bloke edilmiştir.");
                                         }
                        }
                    }
                 ana_menu_secim=Integer.parseInt(JOptionPane.showInputDialog(ana_menu()));
            }       
    }       
}
    

