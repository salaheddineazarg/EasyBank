package dto;

import java.time.LocalDate;
import java.util.List;


public abstract class Account {
    protected String nrAccount;
    protected double solde;
    protected LocalDate deteCreation;
    protected Etat etat;

    protected  Employe employe;
    protected Client client;
    protected List<Operation> operations;

     public  Account(){

     }

     public Account(String nrAccount,double solde,LocalDate deteCreation,Etat etat,Employe employe,Client client,List<Operation> operations){
         this.setNrAccount(nrAccount);
         this.setSolde(solde);
         this.setDeteCreation(deteCreation);
         this.setEtat(etat);
         this.setEmploye(employe);
         this.setClient(client);
         this.setOperations(operations);

     }



    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public String getNrAccount() {
        return nrAccount;
    }

    public void setNrAccount(String nrCompte) {

        this.nrAccount = nrCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public LocalDate getDeteCreation() {
        return deteCreation;
    }

    public void setDeteCreation(LocalDate deteCreation) {
        this.deteCreation = deteCreation;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
