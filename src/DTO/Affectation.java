package DTO;

import java.time.LocalDate;

public class Affectation {
    private  Mission mission;
    private  Employe Employe;

    private LocalDate Startdate;
    private  LocalDate EndDate;


    public Affectation(){

    }
    public Affectation(Employe employe, Mission mission, LocalDate startdate, LocalDate endDate){
        setEmploye(employe);
        setMission(mission);
        setStartdate(startdate);
        setEndDate(endDate);

    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public DTO.Employe getEmploye() {
        return Employe;
    }

    public void setEmploye(DTO.Employe employe) {
        Employe = employe;
    }






    public LocalDate getStartdate() {
        return Startdate;
    }

    public void setStartdate(LocalDate startdate) {
        Startdate = startdate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }


}
