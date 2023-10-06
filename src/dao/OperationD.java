package dao;

import database.ConnectionDB;
import dto.Operation;
import dto.TypeOperation;
import interfaces.iOperation;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class OperationD implements iOperation {
    Connection conn =ConnectionDB.getInstance().getConnection();
    @Override
    public Optional<Operation> AddOperation(Operation operation) {
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO operation(date,price,accountNumber,registrationNumber,type) VALUES(?,?,?,?,?) RETURNING * ");
            statement.setDate(1, Date.valueOf(operation.getDate()));
            statement.setDouble(2,operation.getPrice());
            statement.setString(3,operation.getAccount().getNrAccount());
            statement.setString(4, operation.getEmploye().getMatricule());
            statement.setObject(5,operation.getType(), Types.OTHER);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Operation operationResult = new Operation();
                operationResult.setNbOperation(resultSet.getInt("operationNumber"));
                operationResult.setDate(resultSet.getDate("date").toLocalDate());
                if(new AccountCurrantD().FindById(resultSet.getString("accountNumber")).isPresent()){
                    operationResult.setAccount(new AccountCurrantD().FindById(resultSet.getString("accountNumber")).get());

                }else if (new AccountSavingD().FindById(resultSet.getString("accountNumber")).isPresent()){
                    operationResult.setAccount(new AccountSavingD().FindById(resultSet.getString("accountNumber")).get());
                }
                operationResult.setPrice(resultSet.getDouble("price"));
                operationResult.setType(TypeOperation.valueOf(resultSet.getString("type")));
                operationResult.setEmploye(new EmployeD().SearchByMatricule(resultSet.getString("registrationNumber")).get());

            return  Optional.of(operationResult);
            }
        }catch (SQLException e){

         e.printStackTrace();

        }
        return Optional.empty();
    }

    @Override
    public int DeleteOperation(int nbOperation) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM operation WHERE operationNumber = ?");
            statement.setInt(1,nbOperation);
            int operationDelete = statement.executeUpdate();

            return operationDelete;

        }catch (SQLException e){

        }
        return 0;
    }



    @Override
    public Optional<Operation> SearchByNum(int nbOperation) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM operation WHERE operationNumber = ? ");
            statement.setInt(1,nbOperation);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Operation operationResult = new Operation();
                operationResult.setNbOperation(resultSet.getInt("operationNumber"));
                operationResult.setDate(resultSet.getDate("date").toLocalDate());
                if(new AccountCurrantD().FindById(resultSet.getString("accountNumber")).isPresent()){
                    operationResult.setAccount(new AccountCurrantD().FindById(resultSet.getString("accountNumber")).get());
                }else if (new AccountSavingD().FindById(resultSet.getString("accountNumber")).isPresent()){
                    operationResult.setAccount(new AccountSavingD().FindById(resultSet.getString("accountNumber")).get());
                }
                operationResult.setPrice(resultSet.getDouble("price"));
                operationResult.setType(TypeOperation.valueOf(resultSet.getString("type")));

                operationResult.setEmploye(new EmployeD().SearchByMatricule(resultSet.getString("registrationNumber")).get());

                return  Optional.of(operationResult);

        }
        return Optional.empty();

    }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Operation> SearchByDate(LocalDate date) {

        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM operation WHERE date = ? ");
            statement.setDate(1, Date.valueOf(date));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Operation operationResult = new Operation();
                operationResult.setNbOperation(resultSet.getInt("operationNumber"));
                operationResult.setDate(resultSet.getDate("date").toLocalDate());
                if(new AccountCurrantD().FindById(resultSet.getString("accountNumber")).isPresent()){
                    operationResult.setAccount(new AccountCurrantD().FindById(resultSet.getString("accountNumber")).get());
                }else if (new AccountSavingD().FindById(resultSet.getString("accountNumber")).isPresent()){
                    operationResult.setAccount(new AccountSavingD().FindById(resultSet.getString("accountNumber")).get());
                }
                operationResult.setPrice(resultSet.getDouble("price"));
                operationResult.setType(TypeOperation.valueOf(resultSet.getString("type")));
                operationResult.setEmploye(new EmployeD().SearchByMatricule(resultSet.getString("registrationNumber")).get());

                return  Optional.of(operationResult);

            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
