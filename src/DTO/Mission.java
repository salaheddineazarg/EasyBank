package DTO;

import java.awt.*;
import java.util.List;

public class Mission {

    private String code;
    private String name;
    private String description;

  private   List<Employe> employes;



  public Mission(){

  }

  public Mission(String code, String name,String description,List<Employe> employes){
      this.setCode(code);
      this.setName(name);
      this.setDescription(description);
      this.setEmploye(employes);

  }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employe> getEmploye() {
        return employes;
    }

    public void setEmploye(List<Employe> employe) {
        employe = employe;
    }
}
