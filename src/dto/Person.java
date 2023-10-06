package dto;

import java.time.LocalDate;

public abstract class  Person {




    protected  String firstName;
    protected  String lastName;
    protected LocalDate dateBirth;
    protected String nbPhone;

    public   Person(){

    }

    public Person(String firstName,String lastName,LocalDate dateBirth,String nbPhone ){

        setFirstName(firstName);
        setLastName(lastName);
        setDateBirth(dateBirth);
        setNbPhone(nbPhone);
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
