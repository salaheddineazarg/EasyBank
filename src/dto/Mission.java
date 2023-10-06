package dto;

import java.util.List;

public class Mission {

    private String code;
    private String name;
    private String description;

  private   List<Affectation> affectations;



  public Mission(){

  }

  public Mission(String code, String name,String description,List<Affectation> affectations){
      this.setCode(code);
      this.setName(name);
      this.setDescription(description);
      this.setAffectations(affectations);

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

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }
}
