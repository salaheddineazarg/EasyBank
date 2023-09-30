package DAO;

import DATABASE.ConnectionDB;
import DTO.Mission;
import INTERFACES.Imission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MissionD implements Imission {
    Connection conn = ConnectionDB.getInstance().getConnection();
    @Override
    public Optional<Mission> AddMission(Mission mission) {

        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO mission(code,name,description) VALUES(?,?,?) RETURNING * ");

            statement.setString(1,"code");
            statement.setString(2,"name");
            statement.setString(3,"description");
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Mission missionreturn = new Mission();
                missionreturn.setCode(resultSet.getString("code"));
                missionreturn.setName(resultSet.getString("name"));
                missionreturn.setDescription(resultSet.getString("description"));

                return Optional.of(missionreturn);
            }


        }
        catch (SQLException e){
            e.printStackTrace();


        }
        return Optional.empty();
        }




    @Override
    public int DeleteMission(String code) {
        try {
            PreparedStatement statementDelete = conn.prepareStatement("DELETE FROM mission WHERE code = ?");
            statementDelete.setString(1,code);
            int MissionDelete = statementDelete.executeUpdate();
            return MissionDelete;
        }catch (SQLException e){
          e.printStackTrace();
        }


        return 0;
    }
}
