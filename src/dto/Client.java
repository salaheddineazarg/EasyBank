package dto;

import java.time.LocalDate;
import java.util.List;

public class Client  extends  Person{



    private  String code;
    private String adresse;

    private List<Account> accountList;


     public  Client(){

     }

     public Client(String firstName, String lastName, LocalDate dateBirth, String nbPhone ,String code, String adresse,List<Account> accountList){
         super(firstName,lastName,dateBirth,nbPhone);
         this.setCode(code);
         this.setAdresse(adresse);
         this.setAccountList(accountList);

     }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
