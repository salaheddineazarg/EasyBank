package DTO;

import java.time.LocalDate;

public class Operation {
  private  int nbOperation;
  private Employe Employe;
  private Account Account;
  private LocalDate date;
  private  TypeOperation type;
  private double price;

  public Operation(){


  }
  public Operation(int nbOperation,Employe employe ,Account account,LocalDate date,TypeOperation type,double price
  ){
    this.setNbOperation(nbOperation);
    this.setEmploye(employe);
    this.setAccount(account);
    

  }

  public int getNbOperation() {
    return nbOperation;
  }

  public void setNbOperation(int nbOperation) {
    this.nbOperation = nbOperation;
  }

  public DTO.Employe getEmploye() {
    return Employe;
  }

  public void setEmploye(DTO.Employe employe) {
    Employe = employe;
  }

  public DTO.Account getAccount() {
    return Account;
  }

  public void setAccount(DTO.Account account) {
    Account = account;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public TypeOperation getType() {
    return type;
  }

  public void setType(TypeOperation type) {
    this.type = type;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
