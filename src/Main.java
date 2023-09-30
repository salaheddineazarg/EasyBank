import DAO.ClientD;
import HELPER.Display;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Display.MenuPrincipal();
        System.out.println("-----------------------------------------");
        ClientD clientD = new ClientD();
        // EmployeD employeD = new EmployeD();
        //  Employe employe1 = new  Employe();
        List<Map<String, Object>> client = clientD.GetAll();
        //  Optional<Person> client = clientD.AddPerson(employe1);
        System.out.println(client);

        // MissionD missionD = new MissionD();
        // Mission mission1 = new Mission();
        // int mission = missionD.DeleteMission("code");
        // System.out.println(mission);


    }
}