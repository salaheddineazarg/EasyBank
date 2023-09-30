package DTO;

import java.time.LocalDate;
import java.util.List;

public class AccountSaving extends Account {

    private  double interestRate;


    public AccountSaving(){

    }
    public AccountSaving(String nrAccount, double solde, LocalDate deteCreation, Etat etat, Employe employe, Client client, List<Operation> operations,double interestRate){
        super(nrAccount,solde,deteCreation,etat,employe,client,operations);
        this.setInterestRate(interestRate);
    }


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
