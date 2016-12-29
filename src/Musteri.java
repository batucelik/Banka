/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Batuhan
 */
class Musteri {

  private String ad,adres,tel;
    private int miktar,sifre,hesapNo;
    private boolean bloke;    
    public Musteri(){
      ad="";
      adres="";
      tel="";
      miktar=0;
      sifre=0;
      hesapNo=0;
      bloke=false;//bloke diil
        }
        
    public Musteri(String Ad,String Adres,String Tel,int Miktar,int Sifre,int HesapNo,boolean Bloke){
        ad=Ad;
        adres=Adres;
        tel=Tel;
        miktar=Miktar;
        sifre=Sifre;
        hesapNo=HesapNo;
        bloke=Bloke;
        }
public void set_ad(String Ad){ad=Ad;}    
    
public void set_adres(String Adres){adres=Adres;}    
 
public void set_tel(String Tel){tel=Tel;}
    
public void set_miktar_ekle(int Miktar){miktar=miktar+Miktar;}
    
public void set_miktar_eksilt(int Miktar){miktar=miktar-Miktar;}
 
public void set_sifre(int Sifre){sifre=Sifre;}    
        
public void set_hesapno(int HesapNo){hesapNo=HesapNo;}
 
public void set_bloke(boolean blokla){bloke=blokla;}
 
    public boolean get_bloke(){return bloke; }        
        
    public int get_hesapno(){return hesapNo;} 
    
    public int get_sifre(){return sifre;}
    
    public int get_miktar(){return miktar;}
    
    public boolean miktar_konrol(int mik){
      return mik>miktar;
        }
    
    public String Hesap_goster(){
        String str=toString();
        return str;
        }
 
  @Override
    public String toString(){
        String str="Adi: "+ad+"\nAdresi: "+adres+"\nTel: "+tel+"\nHesap Numarasi: "+hesapNo+"\nŞifre : "+sifre+"\nBakiye: "+miktar+" YTL\n";
        return str;
        }
    
    
}
