package DTO;

import java.time.LocalDate;

public abstract class  Person {



    protected int id;
    protected  String firstName;
    protected  String lastName;
    protected LocalDate dateBirth;
    protected String nbPhone;

    public   Person(){

    }

    public Person(int id, String firstName,String lastName,LocalDate dateBirth,String nbPhone ){
      this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDateBirth(dateBirth);
        this.setNbPhone(nbPhone);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getNbPhone() {
        return nbPhone;
    }

    public void setNbPhone(String nbPhone) {
        this.nbPhone = nbPhone;
    }

}
