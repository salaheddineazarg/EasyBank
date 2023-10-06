package dto;

import java.time.LocalDate;
import java.util.List;

public class AccountCurrant extends Account {


    private double maxPrice;



    public AccountCurrant(){

    }

    public AccountCurrant(String nrAccount, double solde, LocalDate deteCreation, Etat etat, Employe employe, Client client, List<Operation> operations, double maxPrice){
        super(nrAccount,solde,deteCreation,etat,employe,client,operations);
        this.setMaxPrice(maxPrice);

    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }


}
