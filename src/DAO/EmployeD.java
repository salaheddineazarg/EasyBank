package DAO;

import DATABASE.ConnectionDB;
import DTO.Client;
import DTO.Employe;
import DTO.Person;
import INTERFACES.Iemploye;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class EmployeD implements Iemploye {

    Connection conn = ConnectionDB.getInstance().getConnection();
    Employe employe = new Employe();


    @Override





    @Override
    public Optional<Person> AddPerson(Person person) {


        try {
            conn.setAutoCommit(false);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO person(firstName,LastName,dateOfBirth,phoneNumber) VALUES(?,?,?,?) RETURNING *");

            // Set values for the parameters
            statement.setString(1, "salah");
            statement.setString(2, "azarg");
            statement.setDate(3, Date.valueOf(LocalDate.of(2023, 9, 25))); // Assuming dateBirth is of type LocalDate
            statement.setString(4, "0696102690");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                employe.setId(resultSet.getInt(1));
                employe.setFirstName(resultSet.getString("firstName"));
                employe.setLastName(resultSet.getString("lastName"));
                employe.setDateBirth(resultSet.getDate("dateOfBirth").toLocalDate());
                employe.setNbPhone(resultSet.getString("phoneNumber"));


            }

            PreparedStatement statement1 = conn.prepareStatement("INSERT INTO employe(id,registrationNumber,recrutmentDate,email) VALUES(?,?,?,?) RETURNING * ");
            statement1.setInt(1, employe.getId());
            statement1.setString(2, "SALAHE");
            statement1.setObject(3, LocalDate.of(2023, 9, 25));
            statement1.setString(4, "salaheddine@gamil.com");

            ResultSet resultSet1 = statement1.executeQuery();


            if (resultSet1.next()) {

                employe.setMatricule(resultSet1.getString("registrationNumber"));

                employe.setDateRecrutement(resultSet1.getDate("recrutmentDate").toLocalDate());


            }

            conn.commit();

            conn.setAutoCommit(true);


            return Optional.of(employe);

        } catch (SQLException e) {
            try {
                // Rollback the transaction in case of an error
                conn.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            // Changed to printStackTrace() for better error handling

            e.printStackTrace();
            return Optional.empty();
        }


    }


    @Override
    public int DeletePerson(String keyword) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM person WHERE id = (SELECT id FROM employe WHERE registrationNumber = ?)");
            statement.setString(1, keyword);

            int DeleteEmploye = statement.executeUpdate();

            return DeleteEmploye;
        } catch (SQLException e) {

            e.printStackTrace();

            return 0;
        }


    }

    @Override
    public Optional<Person> UpdatePerson(Person person) {
        Employe employe = new Employe();

        try {
            conn.setAutoCommit(false);
            PreparedStatement statementUpdate = conn.prepareStatement("UPDATE person SET firstName = ? ,LastName = ?, dateOfBirth =?,phoneNumber = ? WHERE id= (SELECT id FROM employe WHERE registrationNumber = ?) RETURNING *");

            // Set values for the parameters
            statementUpdate.setString(1, "sala");
            statementUpdate.setString(2, "azarg");
            statementUpdate.setDate(3, Date.valueOf(LocalDate.of(2023, 9, 25))); // Assuming dateBirth is of type LocalDate
            statementUpdate.setString(4, "0696102690");

            ResultSet resultSet = statementUpdate.executeQuery();

            if (resultSet.next()) {
                employe.setId(resultSet.getInt("id"));
                employe.setFirstName(resultSet.getString("firstName"));
                employe.setLastName(resultSet.getString("lastName"));
                employe.setDateBirth(resultSet.getDate("dateOfBirth").toLocalDate());
                employe.setNbPhone(resultSet.getString("phoneNumber"));


            }

            PreparedStatement statementUpdate1 = conn.prepareStatement("UPDATE employe SET registrationNumber =?,recrutmentDate = ?,email = ? WHERE id = employe.getId  RETURNING * ");

            statementUpdate1.setString(1, "SALAH");
            statementUpdate1.setObject(2, LocalDate.of(2023, 9, 25));
            statementUpdate1.setString(3, "salaheddine@gamil.com");

            ResultSet resultSet1 = statementUpdate1.executeQuery();


            if (resultSet1.next()) {

                employe.setMatricule(resultSet1.getString("registrationNumber"));

                employe.setDateRecrutement(resultSet1.getDate("recrutmentDate").toLocalDate());


            }

            conn.commit();

            conn.setAutoCommit(true);


            return Optional.of(employe);

        } catch (SQLException e) {
            try {
                // Rollback the transaction in case of an error
                conn.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            // Changed to printStackTrace() for better error handling

            e.printStackTrace();
            return Optional.empty();
        }




    }




    @Override
    public Optional<Employe> SearchByMatricule(String matricule) {


        try {
            PreparedStatement statementSearch = conn.prepareStatement("SELECT * FROM person INNER JOIN employe ON employe.id = person.id WHERE employe.registrationNumber = ?");
            statementSearch.setString(1, matricule);  // Set the matricule parameter
            ResultSet resultSet = statementSearch.executeQuery();

            if (resultSet.next()){
                Employe EmployeSearchMatricule = new Employe();
                EmployeSearchMatricule.setId( resultSet.getInt("id"));
                EmployeSearchMatricule.setFirstName(resultSet.getString("firstName"));
                EmployeSearchMatricule.setLastName(resultSet.getString("lastName"));
                EmployeSearchMatricule.setDateBirth(resultSet.getDate("dateOfBirth").toLocalDate());
                EmployeSearchMatricule.setNbPhone(resultSet.getString("phoneNumber"));
                EmployeSearchMatricule.setMatricule(resultSet.getString("registrationNumber"));
                EmployeSearchMatricule.setDateRecrutement(resultSet.getDate("recrutmentDate").toLocalDate());
                EmployeSearchMatricule.setEmail(resultSet.getString("email"));

                return Optional.of(EmployeSearchMatricule);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }
    @Override
    public List<Map<String, Object>> GetAll() {
        List<Map<String, Object>> GetEmployes = new ArrayList<>();

        try {
            PreparedStatement statementSearch = conn.prepareStatement("SELECT * FROM person INNER JOIN employe ON employe.id = person.id ");
            // Set the matricule parameter
            ResultSet resultSet = statementSearch.executeQuery();

            while(resultSet.next()){
                Map<String, Object> GetAllMap = new HashMap<>();
                GetAllMap.put("id", resultSet.getInt("id"));
                GetAllMap.put("firstName", resultSet.getString("firstName"));
                GetAllMap.put("lastName", resultSet.getString("lastName"));
                GetAllMap.put("dateBirth", resultSet.getDate("dateOfBirth").toLocalDate());
                GetAllMap.put("nbPhone", resultSet.getString("phoneNumber"));
                GetAllMap.put("matricule", resultSet.getString("registrationNumber"));
                GetAllMap.put("dateRecrutement", resultSet.getDate("recrutmentDate").toLocalDate());
                GetAllMap.put("email", resultSet.getString("email"));
                GetEmployes.add(GetAllMap);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return GetEmployes;
    }

    @Override
    public List<Map<String, Object>> Search(String attributeName, String value) {
        List<Map<String, Object>> EmployesSearch = new ArrayList<>();
        try {
            String sqlQuery = "SELECT * FROM person INNER JOIN employe ON employe.id = person.id WHERE " + attributeName + " LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sqlQuery);
            statement.setString(1, "%" + value + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, Object> Employeresult = new HashMap<>();
                Employeresult.put("Id", resultSet.getInt(1));
                Employeresult.put("FirstName", resultSet.getString(2));
                Employeresult.put("LastName", resultSet.getString(3));
                Employeresult.put("DateBirth", resultSet.getDate(4));
                Employeresult.put("N°Phone", resultSet.getString(5));
                Employeresult.put("Matricule", resultSet.getString(6));
                Employeresult.put("DateRecrutement", resultSet.getDate(7).toLocalDate());
                Employeresult.put("Email", resultSet.getString(8));

                EmployesSearch.add(Employeresult);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return EmployesSearch;
    }

}