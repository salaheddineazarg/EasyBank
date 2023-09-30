package INTERFACES;

import DTO.Account;
import DTO.Etat;

import java.time.LocalDate;
import java.util.List;

public interface Iaccount {
    Account AddAccount(Account account);
    int DeleteAccount(int id );
    Account UpdateAccount(Account account);

    List<Account> ShowByDateCreation(LocalDate DateCreation);
    List<Account> ShowByStatus(String status);
    List<Account> GetAll();

    boolean ChangeEtat(Etat etat);

    List<Account> SearchByClient(String code);

}
