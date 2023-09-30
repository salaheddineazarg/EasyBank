package DAO;

import DATABASE.ConnectionDB;
import DTO.Client;
import DTO.Employe;
import DTO.Person;
import INTERFACES.Iclient;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class ClientD implements Iclient {

    Connection conn = ConnectionDB.getInstance().getConnection();





    @Override
    public Optional<Person> AddPerson(Person person) {

        Client client = new Client();

        try {
            conn.setAutoCommit(false);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO person(firstName,LastName,dateOfBirth,phoneNumber) VALUES(?,?,?,?) RETURNING *");

            // Set values for the parameters
            statement.setString(1,"salah");
            statement.setString(2, "azarg");
            statement.setDate(3, Date.valueOf(LocalDate.of(2023, 9, 25))); // Assuming dateBirth is of type LocalDate
            statement.setString(4, "0696102690");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                client.setId(resultSet.getInt(1));
                client.setFirstName(resultSet.getString("firstName"));
                client.setLastName(resultSet.getString("lastName"));
                client.setDateBirth(resultSet.getDate("dateOfBirth").toLocalDate());
                client.setNbPhone(resultSet.getString("phoneNumber"));


            }

            PreparedStatement statement1 = conn.prepareStatement("INSERT INTO client(id,code,adresse) VALUES(?,?,?) RETURNING * ");
            statement1.setInt(1,client.getId());
            statement1.setString(2, "SALAHE");
            statement1.setString(3, "salaheddine@gamil.com");

            ResultSet resultSet1 = statement1.executeQuery();


            if(resultSet1.next())
            {

                client.setCode(resultSet1.getString("code"));

                client.setAdresse(resultSet1.getString("adresse"));


            }

            conn.commit();

            conn.setAutoCommit(true);


            return Optional.of(client);

        } catch (SQLException e) {
            try {
                // Rollback the transaction in case of an error
                conn.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
            // Changed to printStackTrace() for better error handling
            return Optional.empty() ;
        }


    }

    @Override
    public int DeletePerson(String keyword ) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM person WHERE id = (SELECT id FROM client WHERE code = ?)");
            statement.setString(1,keyword);

            int DeleteClient = statement.executeUpdate();

            return DeleteClient;
        }catch (SQLException e){

            e.printStackTrace();

            return 0;
        }


    }

    @Override
    public Optional<Person> UpdatePerson(Person person) {
        Client client = new Client();
        try {
            conn.setAutoCommit(false);
            PreparedStatement statementUpdate = conn.prepareStatement("UPDATE person SET firstName = ? ,LastName = ?, dateOfBirth =?,phoneNumber = ? WHERE id= (SELECT id FROM client WHERE code = ?)  RETURNING *");

            // Set values for the parameters
            statementUpdate.setString(1, "sala");
            statementUpdate.setString(2, "azarg");
            statementUpdate.setDate(3, Date.valueOf(LocalDate.of(2023, 9, 25))); // Assuming dateBirth is of type LocalDate
            statementUpdate.setString(4, "0696102690");

            ResultSet resultSet = statementUpdate.executeQuery();

            if (resultSet.next()) {
                client.setId(resultSet.getInt("id"));
                client.setFirstName(resultSet.getString("firstName"));
                client.setLastName(resultSet.getString("lastName"));
                client.setDateBirth(resultSet.getDate("dateOfBirth").toLocalDate());
                client.setNbPhone(resultSet.getString("phoneNumber"));


            }

            PreparedStatement statementUpdate1 = conn.prepareStatement("UPDATE client SET code =?,adresse = ? WHERE code = client.getId  RETURNING * ");

            statementUpdate1.setString(1, "SAL");
            statementUpdate1.setString(3, "salaheddine@gamil.com");

            ResultSet resultSet1 = statementUpdate1.executeQuery();


            if (resultSet1.next()) {

                client.setCode(resultSet1.getString("code"));

                client.setAdresse(resultSet1.getString("adresse"));


            }

            conn.commit();

            conn.setAutoCommit(true);


            return Optional.of(client);

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
    public Optional<Client> SearchByCode(String code) {


        try {
            PreparedStatement statementSearch = conn.prepareStatement("SELECT * FROM person INNER JOIN client ON client.id = person.id WHERE client.code = ?");
            statementSearch.setString(1, code);
            ResultSet resultSet = statementSearch.executeQuery();

            if (resultSet.next()){
               Client clientSearchCode = new Client();
                clientSearchCode.setId(resultSet.getInt("id"));
                clientSearchCode.setFirstName(resultSet.getString("firstName"));
                clientSearchCode.setLastName( resultSet.getString("lastName"));
                clientSearchCode.setDateBirth( resultSet.getDate("dateOfBirth").toLocalDate());
                clientSearchCode.setNbPhone(resultSet.getString("phoneNumber"));
                clientSearchCode.setCode( resultSet.getString("code"));
                clientSearchCode.setAdresse(resultSet.getString("adresse"));

                return Optional.of(clientSearchCode) ;
            }
        } catch (SQLException e){
            e.printStackTrace();


        }

        return Optional.empty();


    }

    @Override
    public List<Map<String, Object>> GetAll() {

        List<Map<String, Object>> ClientGetAll = new ArrayList<>();

        try {
            PreparedStatement statementGetAll = conn.prepareStatement("SELECT * FROM person INNER JOIN client ON client.id = person.id ");

            ResultSet resultSet = statementGetAll.executeQuery();

            while (resultSet.next()){
                Map<String, Object> clientGetALLMap = new HashMap<>();
                clientGetALLMap.put("id", resultSet.getInt("id"));
                clientGetALLMap.put("firstName", resultSet.getString("firstName"));
                clientGetALLMap.put("lastName", resultSet.getString("lastName"));
                clientGetALLMap.put("dateBirth", resultSet.getDate("dateOfBirth").toLocalDate());
                clientGetALLMap.put("nbPhone", resultSet.getString("phoneNumber"));
                clientGetALLMap.put("code", resultSet.getString("code"));
                clientGetALLMap.put("adresse", resultSet.getString("adresse"));

                ClientGetAll.add(clientGetALLMap);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return ClientGetAll;
    }

}
