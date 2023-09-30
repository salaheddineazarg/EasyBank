package DTO;

import java.time.LocalDate;
import java.util.List;

public class Employe extends Person {
    private List<Affectation> affictations;
    private  List<Account> accounts;
    private List<Operation> operations;
    private String matricule;
    private LocalDate dateRecrutement;
    private  String email;

     public Employe(){

     }

     public Employe(int id, String firstName, String lastName, LocalDate dateBirth, String nbPhone ,String matricule,LocalDate dateRecrutement,String email,List<Affectation> affictations,List<Account> accounts,List<Operation> operations){
         super(id,firstName,lastName,dateBirth,nbPhone);
         this.setMatricule(matricule);
         this.setDateRecrutement(dateRecrutement);
         this.setEmail(email);
         this.setAffictations(affictations);
         this.setAccounts(accounts);
         this.setOperations(operations);


     }



    public List<Affectation> getAffictations() {
        return affictations;
    }

    public void setAffictations(List<Affectation> affictations) {
        this.affictations = affictations;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(LocalDate dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
