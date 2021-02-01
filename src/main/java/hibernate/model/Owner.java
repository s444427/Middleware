package hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")

public class Owner {
    @Id
    @Column(name = "OwnerID")
    private int OwnerID;

    @Column(name = "Name")
    private String Name;

//    @Column(name = "Surname")
//    private String Surname;

//    @ElementCollection
//    private List<String> owners = new ArrayList<>();

    public Owner() {
    }

    public int getOwnerID(){return OwnerID;}
    public void setOwnerID(int Owner_ID){this.OwnerID = Owner_ID;}

    public String getOwnerName(){return Name;}
    public void setOwnerName(String Owner_Name){this.Name = Owner_Name;}

//    public String getOwnerSurname(){return Surname;}
//    public void setOwnerSurname(String Owner_Surname){this.Surname = Owner_Surname;}

}
