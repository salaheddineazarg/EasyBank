package DAO;

import DTO.Account;
import DTO.Etat;
import INTERFACES.Iaccount;

import java.time.LocalDate;
import java.util.List;

public class AccountSavingD implements Iaccount {
    @Override
    public Account AddAccount(Account account) {
        return null;
    }

    @Override
    public int DeleteAccount(int id) {
        return 0;
    }

    @Override
    public Account UpdateAccount(Account account) {
        return null;
    }

    @Override
    public List<Account> ShowByDateCreation(LocalDate DateCreation) {
        return null;
    }

    @Override
    public List<Account> ShowByStatus(String status) {
        return null;
    }

    @Override
    public List<Account> GetAll() {
        return null;
    }

    @Override
    public boolean ChangeEtat(Etat etat) {
        return false;
    }

    @Override
    public List<Account> SearchByClient(String code) {
        return null;
    }
}
