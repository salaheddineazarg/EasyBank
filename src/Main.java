import dao.*;
import dto.*;
import helper.Display;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {


    static Scanner scanner = new Scanner(System.in);
    static  Scanner input = new Scanner(System.in);
    static Employe employe = new Employe();
    static EmployeD employeD = new EmployeD();

    static Client client = new Client();
    static ClientD clientD = new ClientD();
    static Mission mission = new Mission();
    static MissionD missionD = new MissionD();

    static AccountCurrant accountCurrant = new AccountCurrant();
    static AccountCurrantD accountCurrantD = new AccountCurrantD();
    static AccountSaving accountSaving = new AccountSaving();
    static AccountSavingD accountSavingD = new AccountSavingD();

    static Affectation affectation = new Affectation();
    static AffectationD affectationD = new AffectationD();

    static Operation operation = new Operation();
    static OperationD operationD = new OperationD();
    public static void main(String[] args) {



        int option;
        do {
            Display.MenuPrincipal();
            System.out.print("Please Enter Your Option: ");
            option = scanner.nextInt();


            switch (option) {
                case 1:
                   Display.MenuAcoount();
                    System.out.print("Please Enter Your Option: ");
                    option = scanner.nextInt();
                    switch (option) {

                        case 1:
                            Display.MenuAcoountCurrent();
                            System.out.print("Please Enter Your Option: ");
                            option = scanner.nextInt();
                            switch (option) {
                                case 1:
                                    System.out.println("Please Enter Currant Account: ");
                                    System.out.print("Account Number: ");
                                    accountCurrant.setNrAccount(input.next());
                                    System.out.print("Solde: ");
                                    accountCurrant.setSolde(input.nextDouble());
                                    System.out.print("Date Of Creation (YYYY-MM-JJ): ");
                                    accountCurrant.setDeteCreation(LocalDate.parse(input.next()));
                                    System.out.print("Owner Code: ");
                                    client.setCode(input.next());
                                    accountCurrant.setClient(client);
                                    System.out.print("Employe Matricule: ");
                                    employe.setMatricule(input.next());
                                    accountCurrant.setEmploye(employe);
                                    System.out.print("Max Price: ");
                                    accountCurrant.setMaxPrice(input.nextDouble());
                                    Scanner status = new Scanner(System.in);
                                    System.out.println("Choose the status for the Account:");
                                    System.out.println("1. Active");
                                    System.out.println("2. Blocked");
                                    System.out.println("3. Freeze");

                                    int choice = status.nextInt();
                                    switch (choice) {
                                        case 1:
                                            accountCurrant.setEtat(Etat.ACTIVE);
                                            break;
                                        case 2:
                                            accountCurrant.setEtat(Etat.BLOCKED);

                                            break;
                                        case 3:
                                            accountCurrant.setEtat(Etat.FREEZE);
                                            break;
                                        default:
                                            System.out.println("Invalid choice. The status remains unchanged.");
                                            break;
                                    }

                                    Optional<AccountCurrant> accountCurrantOP = accountCurrantD.AddAccount(accountCurrant);
                                    if (accountCurrantOP.isPresent()) {
                                        AccountCurrant accountCurrant1 = accountCurrantOP.get();
                                        System.out.println("Account Number: " + accountCurrant1.getNrAccount());
                                        System.out.println("Solde: " + accountCurrant1.getSolde());
                                        System.out.println("Date Of Creation: " + accountCurrant1.getDeteCreation());
                                        System.out.println("Owner: " + accountCurrant1.getClient());
                                        System.out.println("Creator: " + accountCurrant1.getEmploye());
                                        System.out.println("MAx Price: " +accountCurrant1.getMaxPrice());
                                        System.out.println("Status: " + accountCurrant1.getEtat());

                                    }

                                    break;

                                case 2:
                                    System.out.print("Please Enter The Account Number You want Status Update: ");
                                    String AccountNumebr = scanner.next();
                                    accountCurrant.setNrAccount(AccountNumebr);
                                    Optional<AccountCurrant> GetStatus = accountCurrantD.FindById(AccountNumebr);

                                    if (GetStatus.isPresent()) {
                                        AccountCurrant accountCurrant1 = GetStatus.get();
                                        System.out.println("Status: " + accountCurrant1.getEtat());
                                    }
                                    Scanner statuscanner = new Scanner(System.in);
                                    System.out.println("Choose the status for the Account:");
                                    System.out.println("1. Active");
                                    System.out.println("2. Blocked");
                                    System.out.println("3. Freeze");
                                     System.out.print("Please Enter Your Choice: ");
                                    int choicestatus = statuscanner.nextInt();
                                    switch (choicestatus) {
                                        case 1:
                                            accountCurrant.setEtat(Etat.ACTIVE);
                                            break;
                                        case 2:
                                            accountCurrant.setEtat(Etat.BLOCKED);

                                            break;
                                        case 3:
                                            accountCurrant.setEtat(Etat.FREEZE);
                                            break;
                                        default:
                                            System.out.println("Invalid choice. The status remains unchanged.");
                                            break;
                                    }

                                    boolean checkStatus = accountCurrantD.ChangeEtat(accountCurrant);
                                    if (checkStatus){
                                        System.out.println("The Etat is Changed:");

                                    }else {
                                        System.out.print("The Etat Doent Changed");
                                    }

                                    break;

                                case 3:
                                    System.out.print("Please Enter Account Number You Want You Delete:  ");
                                    int AccountDelete = accountCurrantD.DeleteAccount(scanner.next());
                                    System.out.print("The Number Of The Accounts You Deleted is : " + AccountDelete);
                                    break;

                                case 4:
                                    System.out.print("Please Ennter Account Number You Want Update: ");
                                    Optional<AccountCurrant> FindByIdAccount = accountCurrantD.FindById(scanner.next());
                                    if (FindByIdAccount.isPresent()) {
                                        AccountCurrant accountCurrant1 = FindByIdAccount.get();
                                        System.out.println("Account Number: " + accountCurrant1.getNrAccount());
                                        System.out.println("Solde: " + accountCurrant1.getSolde());
                                        System.out.println("Date Of Creation: " + accountCurrant1.getDeteCreation());
                                        System.out.println("Owner: " + accountCurrant1.getClient());
                                        System.out.println("Creator: " + accountCurrant1.getEmploye());
                                        System.out.println("Status: " + accountCurrant1.getEtat());
                                    }

                                    System.out.println("Please Enter Currant Account: ");
                                    System.out.print("Account Number: ");
                                    accountCurrant.setNrAccount(input.next());
                                    System.out.print("Solde: ");
                                    accountCurrant.setSolde(input.nextDouble());
                                    System.out.print("Date Of Creation (YYYY-MM-JJ): ");
                                    accountCurrant.setDeteCreation(LocalDate.parse(input.next()));
                                    System.out.print("Owner Code: ");
                                    accountCurrant.getClient().setCode(input.next());
                                    System.out.print("Employe Matricule: ");
                                    accountCurrant.getEmploye().setMatricule(input.next());
                                    System.out.print("Max Price: ");
                                    accountCurrant.setMaxPrice(input.nextDouble());
                                    Scanner status1 = new Scanner(System.in);
                                    System.out.println("Choose the status for the Account:");
                                    System.out.println("1. Active");
                                    System.out.println("2. Blocked");
                                    System.out.println("3. Freeze");
                                    int choice1 = status1.nextInt();
                                    switch (choice1) {
                                        case 1:
                                            accountCurrant.setEtat(Etat.ACTIVE);
                                            break;
                                        case 2:
                                            accountCurrant.setEtat(Etat.BLOCKED);

                                            break;
                                        case 3:
                                            accountCurrant.setEtat(Etat.FREEZE);
                                            break;
                                        default:
                                            System.out.println("Invalid choice. The status remains unchanged.");
                                            break;
                                    }

                                    Optional<AccountCurrant> accountCurrantUP = accountCurrantD.UpdateAccount(accountCurrant);
                                    if (accountCurrantUP.isPresent()) {
                                        AccountCurrant accountCurrant1 = accountCurrantUP.get();
                                        System.out.println("Account Number: " + accountCurrant1.getNrAccount());
                                        System.out.println("Solde: " + accountCurrant1.getSolde());
                                        System.out.println("Date Of Creation: " + accountCurrant1.getDeteCreation());
                                        System.out.println("Owner: " + accountCurrant1.getClient());
                                        System.out.println("Creator: " + accountCurrant1.getEmploye());
                                        System.out.println("Status: " + accountCurrant1.getEtat());

                                    }


                                    break;

                                case 5:
                                Map<String, Object> GetAllAcoountC = accountCurrantD.GetAll();


                                        for (String key : GetAllAcoountC.keySet()) {

                                            System.out.println(key + ": " + GetAllAcoountC.get(key));

                                            System.out.println("------------------------------");
                                        }



                                    break;

                                case 6:
                                    System.out.print("Please Enter Date You Want (YYYY-MM-JJ): ");
                                    Optional<AccountCurrant> accountCurrantDC = accountCurrantD.ShowByDateCreation(LocalDate.parse(scanner.next()));
                                    if (accountCurrantDC.isPresent()) {
                                        AccountCurrant accountCurrant1 = accountCurrantDC.get();
                                        System.out.println("Account Number: " + accountCurrant1.getNrAccount());
                                        System.out.println("Solde: " + accountCurrant1.getSolde());
                                        System.out.println("Date Of Creation: " + accountCurrant1.getDeteCreation());
                                        System.out.println("Owner: " + accountCurrant1.getClient());
                                        System.out.println("Creator: " + accountCurrant1.getEmploye());
                                        System.out.println("Status: " + accountCurrant1.getEtat());

                                    }
                                    break;
                                case 7:
                                    System.out.print("Please Enter Client Code You Want : ");
                                    Optional<AccountCurrant> accountCurrantCC = accountCurrantD.SearchByClient(scanner.next());

                                    if (accountCurrantCC.isPresent()) {
                                        AccountCurrant accountCurrant1 = accountCurrantCC.get();
                                        System.out.println("Account Number: " + accountCurrant1.getNrAccount());
                                        System.out.println("Solde: " + accountCurrant1.getSolde());
                                        System.out.println("Date Of Creation: " + accountCurrant1.getDeteCreation());
                                        System.out.println("Owner: " + accountCurrant1.getClient());
                                        System.out.println("Creator: " + accountCurrant1.getEmploye());
                                        System.out.println("Status: " + accountCurrant1.getEtat());

                                    }else {
                                        System.out.println("This Client Doesnt Exist");
                                    }
                                    break;

                                case 8:
                                    Scanner statusS = new Scanner(System.in);
                                    System.out.println("Choose the status for the Account:");
                                    System.out.println("1. Active");
                                    System.out.println("2. Blocked");
                                    System.out.println("3. Freeze");
                                    int choiceS = statusS.nextInt();
                                    switch (choiceS) {
                                        case 1:
                                            accountCurrant.setEtat(Etat.ACTIVE);
                                            break;
                                        case 2:
                                            accountCurrant.setEtat(Etat.BLOCKED);

                                            break;
                                        case 3:
                                            accountCurrant.setEtat(Etat.FREEZE);
                                            break;
                                        default:
                                            System.out.println("Invalid choice. The status remains unchanged.");
                                            break;
                                    }
                                    Map<String, Object> GetBYStatus = accountCurrantD.ShowByStatus(accountCurrant.getEtat().toString());


                                        for (String key : GetBYStatus.keySet()) {

                                            System.out.println(key + ": " + GetBYStatus.get(key));
                                        }
                                        System.out.println("------------------------------");


                                    break;
                                // ------------------End Currant Account------------------


                            }


                            break;
                        case 2:
                            Display.MenuAcoountSaving();
                            System.out.print("Please Enter Your Option: ");
                            option = scanner.nextInt();
                            switch (option) {

                                case 1:
                                    System.out.println("Please Enter Saving Account: ");
                                    System.out.print("Account Number: ");
                                    accountSaving.setNrAccount(input.next());
                                    System.out.print("Solde: ");
                                    accountSaving.setSolde(input.nextDouble());
                                    System.out.print("Date Of Creation (YYYY-MM-JJ): ");
                                    accountSaving.setDeteCreation(LocalDate.parse(input.next()));
                                    System.out.print("Owner Code: ");
                                    client.setCode(input.next());
                                    accountSaving.setClient(client);
                                    System.out.print("Employe Matricule: ");
                                    employe.setMatricule(input.next());
                                    accountSaving.setEmploye(employe);
                                    System.out.print("Interest Rate: ");
                                    accountSaving.setInterestRate(input.nextDouble());
                                    Scanner status = new Scanner(System.in);
                                    System.out.println("Choose the status for the Account:");
                                    System.out.println("1. Active");
                                    System.out.println("2. Blocked");
                                    System.out.println("3. Freeze");
                                    int choice = status.nextInt();
                                    switch (choice) {
                                        case 1:
                                            accountSaving.setEtat(Etat.ACTIVE);
                                            System.out.println(Etat.valueOf(accountSaving.getEtat().name()));
                                            break;
                                        case 2:
                                            accountSaving.setEtat(Etat.BLOCKED);

                                            break;
                                        case 3:
                                            accountSaving.setEtat(Etat.FREEZE);
                                            break;
                                        default:
                                            System.out.println("Invalid choice. The status remains unchanged.");
                                            break;
                                    }

                                    Optional<AccountSaving> accountSavingOP = accountSavingD.AddAccount(accountSaving);
                                   if (accountSavingOP.isPresent()) {
                                       AccountSaving accountCurrant1 = accountSavingOP.get();
                                       System.out.println("Account Number: " + accountCurrant1.getNrAccount());
                                       System.out.println("Solde: " + accountCurrant1.getSolde());
                                       System.out.println("Date Of Creation: " + accountCurrant1.getDeteCreation());
                                       System.out.println("Owner: " + accountCurrant1.getClient());
                                       System.out.println("Creator: " + accountCurrant1.getEmploye());
                                       System.out.println("Status: " + accountCurrant1.getEtat());

                                   }

                                    break;

                                case 2:
                                    System.out.print("Please Enter The Account Number :");
                                    accountSaving.setNrAccount(input.next());
                                    Scanner statusChange = new Scanner(System.in);
                                    int choiceStatus = statusChange.nextInt();
                                    switch (choiceStatus) {
                                        case 1:
                                            accountSaving.setEtat(Etat.ACTIVE);

                                            break;
                                        case 2:
                                            accountSaving.setEtat(Etat.BLOCKED);

                                            break;
                                        case 3:
                                            accountSaving.setEtat(Etat.FREEZE);
                                            break;
                                        default:
                                            System.out.println("Invalid choice. The status remains unchanged.");
                                            break;
                                    }


                                    break;

                                case 3:
                                    System.out.print("Please Enter Account Number You Want You Delete:  ");
                                    int AccountDelete = accountSavingD.DeleteAccount(scanner.next());
                                    System.out.print("The Number Of The Accounts You Deleted is : " + AccountDelete);
                                    break;

                                case 4:
                                    System.out.print("Please Ennter Account Number You Want Update: ");
                                    Optional<AccountSaving> FindByIdAccount = accountSavingD.FindById(scanner.next());
                                    if (FindByIdAccount.isPresent()) {
                                        AccountSaving accountSaving1 = FindByIdAccount.get();
                                        System.out.println("Account Number: " + accountSaving1.getNrAccount());
                                        System.out.println("Solde: " + accountSaving1.getSolde());
                                        System.out.println("Date Of Creation: " + accountSaving1.getDeteCreation());
                                        System.out.println("Owner: " + accountSaving1.getClient());
                                        System.out.println("Creator: " + accountSaving1.getEmploye());
                                        System.out.println("Status: " + accountSaving1.getEtat());
                                    }

                                    System.out.println("Please Enter Currant Account: ");
                                    System.out.print("Account Number: ");
                                    accountSaving.setNrAccount(input.next());
                                    System.out.print("Solde: ");
                                    accountSaving.setSolde(input.nextDouble());
                                    System.out.print("Date Of Creation (YYYY-MM-JJ): ");
                                    accountSaving.setDeteCreation(LocalDate.parse(input.next()));
                                    System.out.print("Owner Code: ");
                                    accountSaving.getClient().setCode(input.next());
                                    System.out.print("Employe Matricule: ");
                                    accountSaving.getEmploye().setMatricule(input.next());
                                    System.out.print("Interest Rate: ");
                                    accountSaving.setInterestRate(input.nextDouble());
                                    Scanner status1 = new Scanner(System.in);
                                    System.out.println("Choose the status for the Account:");
                                    System.out.println("1. Active");
                                    System.out.println("2. Blocked");
                                    System.out.println("3. Freeze");
                                    int choice1 = status1.nextInt();
                                    switch (choice1) {
                                        case 1:
                                            accountSaving.setEtat(Etat.ACTIVE);

                                            break;
                                        case 2:
                                            accountSaving.setEtat(Etat.BLOCKED);

                                            break;
                                        case 3:
                                            accountSaving.setEtat(Etat.FREEZE);
                                            break;
                                        default:
                                            System.out.println("Invalid choice. The status remains unchanged.");
                                            break;
                                    }

                                    Optional<AccountSaving> accountSavingUP = accountSavingD.UpdateAccount(accountSaving);
                                    if (accountSavingUP.isPresent()) {
                                        AccountSaving accountSaving1 = accountSavingUP.get();
                                        System.out.println("Account Number: " + accountSaving1.getNrAccount());
                                        System.out.println("Solde: " + accountSaving1.getSolde());
                                        System.out.println("Date Of Creation: " + accountSaving1.getDeteCreation());
                                        System.out.println("Owner: " + accountSaving1.getClient());
                                        System.out.println("Creator: " + accountSaving1.getEmploye());
                                        System.out.println("Status: " + accountSaving1.getEtat());

                                    }


                                    break;

                                case 5:
                                   Map<String, Object> GetAllAcoountS = accountSavingD.GetAll();


                                        for (String key : GetAllAcoountS.keySet()) {

                                            System.out.println(key + ": " + GetAllAcoountS.get(key));

                                        System.out.println("------------------------------");
                                    }

                                    break;

                                case 6:
                                    System.out.print("Please Enter Date You Want (YYYY-MM-JJ): ");
                                    Optional<AccountSaving> accountSavingDC = accountSavingD.ShowByDateCreation(LocalDate.parse(scanner.next()));
                                    if (accountSavingDC.isPresent()) {
                                        AccountSaving accountSaving1 = accountSavingDC.get();
                                        System.out.println("Account Number: " + accountSaving1.getNrAccount());
                                        System.out.println("Solde: " + accountSaving1.getSolde());
                                        System.out.println("Date Of Creation: " + accountSaving1.getDeteCreation());
                                        System.out.println("Owner: " + accountSaving1.getClient());
                                        System.out.println("Creator: " + accountSaving1.getEmploye());
                                        System.out.println("Status: " + accountSaving1.getEtat());

                                    }
                                    break;
                                case 7:
                                    System.out.print("Please Enter Client Code You Want : ");
                                    Optional<AccountSaving> accountSavingCC = accountSavingD.SearchByClient(scanner.next());
                                    if (accountSavingCC.isPresent()) {
                                        AccountSaving accountSaving1 = accountSavingCC.get();
                                        System.out.println("Account Number: " + accountSaving1.getNrAccount());
                                        System.out.println("Solde: " + accountSaving1.getSolde());
                                        System.out.println("Date Of Creation: " + accountSaving1.getDeteCreation());
                                        System.out.println("Owner: " + accountSaving1.getClient());
                                        System.out.println("Creator: " + accountSaving1.getEmploye());
                                        System.out.println("Status: " + accountSaving1.getEtat());
                                    }
                                    break;

                                case 8:
                                    Scanner statusS = new Scanner(System.in);
                                    System.out.println("Choose the status for the Account:");
                                    System.out.println("1. Active");
                                    System.out.println("2. Blocked");
                                    System.out.println("3. Freeze");
                                    int choiceS = statusS.nextInt();
                                    switch (choiceS) {
                                        case 1:
                                            accountSaving.setEtat(Etat.ACTIVE);
                                            break;
                                        case 2:
                                            accountSaving.setEtat(Etat.BLOCKED);

                                            break;
                                        case 3:
                                            accountSaving.setEtat(Etat.FREEZE);
                                            break;
                                        default:
                                            System.out.println("Invalid choice. The status remains unchanged.");
                                            break;
                                    }
                                    Map<String, Object> GetBYStatus = accountSavingD.ShowByStatus(accountSaving.getEtat().toString());


                                        for (String key : GetBYStatus.keySet()) {

                                            System.out.println(key + ": " + GetBYStatus.get(key));

                                        System.out.println("------------------------------");
                                    }

                                    break;
                                // ------------------End Currant Account------------------


                            }


                            break;

                    }

                    break;
                        //------------------------end Account------------------------------------------
                        case 2:
                            Display.MenuEmploye();
                            option = scanner.nextInt();
                            System.out.print("Please Enter Your Option: ");
                            switch (option) {
                                case 1:
                                    System.out.println("Please Enter Employe Informations:");
                                    System.out.print("Matricule: ");
                                    employe.setMatricule(input.next());
                                    System.out.print("First Name: ");
                                    employe.setFirstName(input.next());
                                    System.out.print("Last Name: ");
                                    employe.setLastName(input.next());
                                    System.out.print("Date Of Birth: ");
                                    employe.setDateBirth(LocalDate.parse(input.next()));
                                    System.out.print("N°Phone: ");
                                    employe.setNbPhone(input.next());
                                    System.out.print("Recruitment Date: ");
                                    employe.setDateRecrutement(LocalDate.parse(input.next()));
                                    System.out.print("Email: ");
                                    employe.setEmail(input.next());
                                    Optional<Employe> optionalEmployees = employeD.AddPerson(employe);
                                    if (optionalEmployees.isPresent()) {
                                        Employe employees = optionalEmployees.get();
                                        System.out.println("Matricule: " + employees.getMatricule());
                                        System.out.println("First Name:" + employees.getFirstName());
                                        System.out.println("Last Name:" + employees.getLastName());
                                        System.out.println("Date Of Birth: " + employees.getDateBirth());
                                        System.out.println("N°Phone: " + employees.getNbPhone());
                                        System.out.println("Recruitment Date: " + employees.getDateRecrutement());
                                        System.out.println("Email: " + employees.getEmail());

                                    }


                                    break;
                                case 2:
                                    System.out.print("Please Enter The Employe Matricule You Want Update: ");
                                    Optional<Employe> GetByMatricule = employeD.SearchByMatricule(input.next());
                                    if (GetByMatricule.isPresent()) {
                                        Employe employees = GetByMatricule.get();
                                        System.out.println("Matricule: " + employees.getMatricule());
                                        System.out.println("First Name:" + employees.getFirstName());
                                        System.out.println("Last Name:" + employees.getLastName());
                                        System.out.println("Date Of Birth: " + employees.getDateBirth());
                                        System.out.println("N°Phone: " + employees.getNbPhone());
                                        System.out.println("Recruitment Date: " + employees.getDateRecrutement());
                                        System.out.println("Email: " + employees.getEmail());
                                    }
                                    System.out.println("Please Enter The Informations You Want Update: ");
                                    System.out.print("Matricule: ");
                                    employe.setMatricule(input.next());
                                    System.out.print("First Name: ");
                                    employe.setFirstName(input.next());
                                    System.out.print("Last Name: ");
                                    employe.setLastName(input.next());
                                    System.out.print("Date Of Birth: ");
                                    employe.setDateBirth(LocalDate.parse(input.next()));
                                    System.out.print("N°Phone: ");
                                    employe.setNbPhone(input.next());
                                    System.out.print("Recruitment Date: ");
                                    employe.setDateRecrutement(LocalDate.parse(input.next()));
                                    System.out.print("Email: ");
                                    employe.setEmail(input.next());

                                    Optional<Employe> NewUpdates = employeD.UpdatePerson(employe);
                                    if (NewUpdates.isPresent()) {
                                        Employe employees = NewUpdates.get();
                                        System.out.println("Matricule: " + employees.getMatricule());
                                        System.out.println("First Name:" + employees.getFirstName());
                                        System.out.println("Last Name:" + employees.getLastName());
                                        System.out.println("Date Of Birth: " + employees.getDateBirth());
                                        System.out.println("N°Phone: " + employees.getNbPhone());
                                        System.out.println("Recruitment Date: " + employees.getDateRecrutement());
                                        System.out.println("Email: " + employees.getEmail());
                                    }


                                    break;

                                case 3:
                                    System.out.print("Please Enter The Employe Matricule You Want Delete: ");
                                    int NumberDelete = employeD.DeletePerson(input.next());
                                    System.out.print("The Number Of Employe You Deleted Is:" + NumberDelete);
                                    break;

                                case 4:

                                    System.out.print("Please Enter The Employe Matricule : ");
                                    Optional<Employe> SearchMatricule = employeD.SearchByMatricule(input.next());
                                    if (SearchMatricule.isPresent()) {
                                        Employe employees = SearchMatricule.get();
                                        System.out.println("Matricule: " + employees.getMatricule());
                                        System.out.println("First Name:" + employees.getFirstName());
                                        System.out.println("Last Name:" + employees.getLastName());
                                        System.out.println("Date Of Birth: " + employees.getDateBirth());
                                        System.out.println("N°Phone: " + employees.getNbPhone());
                                        System.out.println("Recruitment Date: " + employees.getDateRecrutement());
                                        System.out.println("Email: " + employees.getEmail());
                                    }
                                    break;

                                case 5:
                               Map<String, Object> getAllEmploye = employeD.GetAll();


                                        for (String key : getAllEmploye.keySet()) {

                                            System.out.println(key + ": " + getAllEmploye.get(key));

                                        System.out.println("------------------------------");
                                    }

                                    break;

                                case 6:
                                    System.out.println("Please Enter Choose The Attribute : ");
                                    System.out.println();
                                    Display.MenuAttrinutesE();
                                    System.out.print("Please Enter Your Choose: ");
                                    Scanner attributte = new Scanner(System.in);
                                    int att = attributte.nextInt();
                                    String attributeD = null;
                                    switch (att){
                                        case 1:
                                          attributeD = "registrationNumber";
                                            break;
                                        case 2:
                                            attributeD = "firstName";
                                            break;
                                        case 3:
                                            attributeD = "lastName";
                                            break;
                                        case 4:
                                          attributeD ="dateOfBirth";
                                            break;
                                        case 5:
                                            attributeD = "phoneNumber";
                                            break;
                                        case 6:
                                            attributeD = "recrutmentDate";
                                            break;
                                        case 7:
                                            attributeD = "email";
                                            break;

                                    }
                                    System.out.print("Please Enter  The Value: ");
                                    Map<String, Object> SearchbyAttr = employeD.Search(attributeD,input.next());


                                        for (String key : SearchbyAttr.keySet()) {

                                            System.out.println(key + ": " + SearchbyAttr.get(key));

                                        System.out.println("------------------------------");
                                    }


                                    break;
                            }

                            break;
                        //------------------------end Employe------------------------------------------
                        case 3:
                            Display.MenuClient();
                            System.out.print("Please Enter Your Option: ");
                            option = scanner.nextInt();

                            switch (option) {

                                case 1:
                                    System.out.println("Please Enter Client Informations:");
                                    System.out.print("Code: ");
                                    client.setCode(input.next());
                                    System.out.print("First Name: ");
                                    client.setFirstName(input.next());
                                    System.out.print("Last Name: ");
                                    client.setLastName(input.next());
                                    System.out.print("Date Of Birth: ");
                                    client.setDateBirth(LocalDate.parse(input.next()));
                                    System.out.print("N°Phone: ");
                                    client.setNbPhone(input.next());
                                    System.out.print("Adresse: ");
                                    client.setAdresse(input.next());

                                    Optional<Client> optionalClients = clientD.AddPerson(client);
                                    if (optionalClients.isPresent()) {
                                        Client clients = optionalClients.get();
                                        System.out.println("Code: " + clients.getCode());
                                        System.out.println("First Name:" + clients.getFirstName());
                                        System.out.println("Last Name:" + clients.getLastName());
                                        System.out.println("Date Of Birth: " + clients.getDateBirth());
                                        System.out.println("N°Phone: " + clients.getNbPhone());
                                        System.out.println("Adresse: " + clients.getAdresse());


                                    }

                                    break;
                                case 2:
                                    System.out.print("Please Enter The Client Matricule You Want Update: ");
                                    Optional<Client> GetByCode = clientD.SearchByCode(input.next());
                                    if (GetByCode.isPresent()) {
                                        Client clients = GetByCode.get();
                                        System.out.println("Code: " + clients.getCode());
                                        System.out.println("First Name:" + clients.getFirstName());
                                        System.out.println("Last Name:" + clients.getLastName());
                                        System.out.println("Date Of Birth: " + clients.getDateBirth());
                                        System.out.println("N°Phone: " + clients.getNbPhone());
                                        System.out.println("Adresse: " + clients.getAdresse());
                                    }
                                    System.out.println("Please Enter The Informations You Want Update: ");
                                    System.out.print("Code: ");
                                    client.setCode(input.next());
                                    System.out.print("First Name: ");
                                    client.setFirstName(input.next());
                                    System.out.print("Last Name: ");
                                    client.setLastName(input.next());
                                    System.out.print("Date Of Birth: ");
                                    client.setDateBirth(LocalDate.parse(input.next()));
                                    System.out.print("N°Phone: ");
                                    client.setNbPhone(input.next());
                                    System.out.print("Adresse: ");
                                    client.setAdresse(input.next());

                                    Optional<Client> NewUpdates = clientD.UpdatePerson(client);
                                    if (NewUpdates.isPresent()) {
                                        Client clients = NewUpdates.get();
                                        System.out.println("Code: " + clients.getCode());
                                        System.out.println("First Name:" + clients.getFirstName());
                                        System.out.println("Last Name:" + clients.getLastName());
                                        System.out.println("Date Of Birth: " + clients.getDateBirth());
                                        System.out.println("N°Phone: " + clients.getNbPhone());
                                        System.out.println("Adresse: " + clients.getAdresse());
                                    }


                                    break;
                                case 3:

                                    System.out.print("Please Enter The Client Code You Want Delete: ");
                                    int NumberClient = clientD.DeletePerson(input.next());
                                    System.out.print("The Number Of Client You Deleted Is: " + NumberClient);
                                    break;
                                case 4:
                                    System.out.print("Please Enter The Employe Code : ");
                                    Optional<Client> SearchCode = clientD.SearchByCode(input.next());
                                    if (SearchCode.isPresent()) {
                                        Client clients = SearchCode.get();
                                        System.out.println("Code: " + clients.getCode());
                                        System.out.println("First Name:" + clients.getFirstName());
                                        System.out.println("Last Name:" + clients.getLastName());
                                        System.out.println("Date Of Birth: " + clients.getDateBirth());
                                        System.out.println("N°Phone: " + clients.getNbPhone());
                                        System.out.println("Adresse: " + clients.getAdresse());
                                    }
                                    break;
                                case 5:
                                    Map<String, Object> getAllClient = clientD.GetAll();
                                      System.out.println();

                                        for (String key : getAllClient.keySet()) {

                                            System.out.println(key + ": " + getAllClient.get(key));

                                        System.out.println("------------------------------");
                                    }
                                    break;
                                case 6:
                                    System.out.println("Please Enter Choose The Attribute : ");
                                    System.out.println();
                                    Display.MenuAttrinutesC();
                                    System.out.print("Please Enter Your Choose: ");
                                    Scanner attributte = new Scanner(System.in);
                                    int att = attributte.nextInt();
                                    String attributeD = null;
                                    switch (att){
                                        case 1:
                                            attributeD = "code";
                                            break;
                                        case 2:
                                            attributeD = "firstName";
                                            break;
                                        case 3:
                                            attributeD = "lastName";
                                            break;
                                        case 4:
                                            attributeD ="dateOfBirth";
                                            break;
                                        case 5:
                                            attributeD = "phoneNumber";
                                            break;
                                        case 6:
                                            attributeD = "adresse";
                                            break;


                                    }
                                    System.out.print("Please Enter  The Value: ");
                                    Map<String, Object> SearchbyAttr = clientD.Search(attributeD,input.next());
                                    System.out.println();

                                        for (String key : SearchbyAttr.keySet()) {

                                            System.out.println(key + ": " + SearchbyAttr.get(key));

                                        System.out.println("------------------------------");
                                    }
                                    break;
                            }

                            break;
                        //------------------------end Client------------------------------------------

                        case 4:
                            Display.MenuMission();
                            System.out.print("Please Enter Your Option: ");
                            option = scanner.nextInt();
                            switch (option) {

                                case 1:
                                    System.out.println("Please Enter The Mission Informations: ");
                                    System.out.print("Code: ");
                                    mission.setCode(scanner.next());
                                    System.out.print("Name: ");
                                    mission.setName(scanner.next());
                                    System.out.print("Description: ");
                                    mission.setDescription(scanner.next());
                                    Optional<Mission> MissioAdd = missionD.AddMission(mission);
                                    if (MissioAdd.isPresent()) {
                                        Mission missions = MissioAdd.get();
                                        System.out.println("Code: " + missions.getCode());
                                        System.out.println("Name: " + missions.getName());
                                        System.out.println("Description: " + missions.getDescription());

                                    }

                                    break;
                                case 2:
                                    System.out.print("Please Enter The Mission Code You Want Delete: ");
                                    int missionDelete = missionD.DeleteMission(scanner.next());
                                    System.out.print("The Number Of Mission You Deleted Is: " + missionDelete);

                                    break;
                                case 3:
                                    Map<String, Object> getAllMission = missionD.GetAll();

                                        for (String key : getAllMission.keySet()) {

                                            System.out.println(key + ": " + getAllMission.get(key));
                                        }
                                        System.out.println("------------------------------");

                                    break;
                            }

                            break;
                case 5:
                       Display.MenuAffectation();
                    System.out.print("Please Enter Your Option: ");
                    option = scanner.nextInt();
                    switch (option){
                        case 1 :
                            System.out.println("Please Enter The Affectation Informations: ");
                            System.out.print("Employe Matricule: ");
                            employe.setMatricule(scanner.next());
                            affectation.setEmploye(employe);
                            System.out.print("Mission Code: ");
                            mission.setCode(scanner.next());
                            affectation.setMission(mission);
                            System.out.print("Start Date(YYYY-MM-JJ): ");
                            affectation.setStartdate(LocalDate.parse(scanner.next()));
                            Optional<Affectation> affectation1 = affectationD.AddAffictation(affectation);
                            if(affectation1.isPresent()){
                                Affectation affectation2 = affectation1.get();
                                System.out.print("Employe : "+affectation2.getEmploye());
                                System.out.print("Mission : "+affectation2.getMission());
                                System.out.print("Start Date: "+affectation2.getStartdate());
                                if(affectation2.getEndDate()== null){
                                    System.out.print("End Date : Present");
                                } else{
                                    System.out.print("End Date: "+affectation2.getEndDate());
                                }

                            }
                            break;
                        case 2 :
                            break;
                        case 3:
                            Map<String, Object> getAllAffictation = affectationD.HistoricAffictation();


                                for (String key : getAllAffictation.keySet()) {

                                    System.out.println(key + ": " + getAllAffictation.get(key));

                                System.out.println("------------------------------");
                            }

                            break;

                        case 4 :
                            break;

                    }

                    break;

                case 6:
                    Display.MenuOperation();
                    System.out.print("Please Enter Your Option: ");
                    option = scanner.nextInt();

                    switch (option){
                        case 1 :
                            System.out.println("Please Enter The Operation Informatios: ");
                            System.out.println("The Account Type: ");
                            Scanner Accounttype = new Scanner(System.in);
                            System.out.println("1. Currant ");
                            System.out.println("2. Saving");
                            System.out.print("Please Enter Your Choise: ");
                            int accountType = Accounttype.nextInt();
                            switch (accountType){
                                case 1 :
                                    System.out.print("Account Number: ");
                                    accountCurrant.setNrAccount(scanner.next());
                                    operation.setAccount(accountCurrant);
                                    System.out.println(operation.getAccount().getNrAccount());
                                    break;
                                case 2:
                                    System.out.print("Account Number: ");
                                    accountSaving.setNrAccount(scanner.next());
                                    operation.setAccount(accountSaving);
                                    break;
                            }
                            System.out.print("Employe Matricule: ");
                            employe.setMatricule(scanner.next());
                            operation.setEmploye(employe);

                            System.out.println("Choose the Type Of Operations:");
                            Scanner type = new Scanner(System.in);
                            System.out.println("1. Payment");
                            System.out.println("2. withdrawal");
                            System.out.print("Please Enter Your Choice: ");
                            int choice = type.nextInt();
                            switch (choice) {
                                case 1:
                                    operation.setType(TypeOperation.Payment);
                                    break;
                                case 2:
                                    operation.setType(TypeOperation.Withdrawal);

                                    break;
                                default:
                                    System.out.println("Invalid choice. The status remains unchanged.");
                                    break;
                            }

                                   System.out.print("The Price: ");
                                   operation.setPrice(scanner.nextDouble());
                                   System.out.print("Date: ");
                                   operation.setDate(LocalDate.parse(scanner.next()));

                                   Optional<Operation> operationResult = operationD.AddOperation(operation);
                                   if (operationResult.isPresent()){
                                       Operation operation1 = operationResult.get();
                                       System.out.println("The Operartion Number: "+operation1.getNbOperation());
                                       System.out.println("The Account : "+operation1.getAccount());
                                       System.out.println("The Client: "+operation1.getEmploye());
                                       System.out.println("The Type :"+operation1.getType());
                                       System.out.println("The Price :"+operation1.getPrice());
                                       System.out.println("The Date: "+operation1.getDate());
                                   }

                           break;
                        case 2:
                            System.out.print("Please Enter The Operation Number You Want Delete: ");
                            int operationDelete = operationD.DeleteOperation(scanner.nextInt());
                            System.out.print("The Number Of The Operation is :" +operationDelete);

                         break;
                        case 3:
                            System.out.print("Please Enter The Operation Date: ");

                            Optional<Operation> operationSearchdate = operationD.SearchByDate(LocalDate.parse(scanner.next()));
                            if (operationSearchdate.isPresent()){
                                Operation operation1 = operationSearchdate.get();
                                System.out.println("The Operartion Number: "+operation1.getNbOperation());
                                System.out.println("The Account : "+operation1.getAccount());
                                System.out.println("The Client : "+operation1.getEmploye());
                                System.out.println("The Type :"+operation1.getType().name());
                                System.out.println("The Price :"+operation1.getPrice());
                                System.out.println("The Date: "+operation1.getDate());
                            }


                            break;
                        case 4:
                            System.out.print("Please Enter The Operation Number: ");

                            Optional<Operation> operationSearch = operationD.SearchByNum(scanner.nextInt());
                            if (operationSearch.isPresent()){
                                Operation operation1 = operationSearch.get();
                                System.out.println("The Operartion Number: "+operation1.getNbOperation());
                                System.out.println("The Account : "+operation1.getAccount());
                                System.out.println("The Client : "+operation1.getEmploye());
                                System.out.println("The Type :"+operation1.getType());
                                System.out.println("The Price :"+operation1.getPrice());
                                System.out.println("The Date: "+operation1.getDate());
                            }

                            break;
                    }

                    break;
                    }

        } while (option != 0);


    }
}
