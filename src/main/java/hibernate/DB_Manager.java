package hibernate;

import hibernate.model.Owner;
import org.hibernate.Session;

import java.util.Scanner;

public class DB_Manager {

    void GET(Session session, String table, int ID)
    {
        if(table.equals("owners"))
        {
            Owner owner = session.get(Owner.class, ID);

            if (owner == null) {
                System.out.println(owner.getOwnerID() + " not found! ");

            } else {
                System.out.println("Found " + owner.getOwnerName());
                System.out.println(owner.getOwnerID());
                System.out.println(owner.getOwnerName());
                System.out.println(owner.getOwnerSurname());
            }
        }
    }

    void DELETE(Session session, String table, int ID)
    {
        if(table.equals("owners"))
        {
            Owner owner = session.get(Owner.class, ID);
            session.delete(owner);
        }
    }

    void ADD(Session session, String table, int ID, String Name, String Surname)
    {
        if(table.equals("owners"))
        {
            Owner owner = new Owner();
            owner.setOwnerID(ID);
            owner.setOwnerName(Name);
            owner.setOwnerSurname(Surname);
            session.save(owner);
        }
    }

}
