package hibernate;

import hibernate.model.Owner;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;


public class DB_Connection {

    public static void connect() {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            // FACTORY NAME HAS TO MATCHED THE ONE FROM PERSISTED.XML !!!
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();
            Session session = entityManager.unwrap(Session.class);

            //New transaction
            session.beginTransaction();

//            List persons = session.createNativeQuery(
//                    "SELECT \"OwnerID\"" +
//                            "\tFROM public.\"Owners\";" )
//                    .getResultList();

            //            //Simple Query
//            Owner own = new Owner();
//            own.setOwnerID(7);
//            own.setOwnerName(15);
//
//
//            session.save(own);

            Owner owner = session.get(Owner.class, 1);
//            owner.setOwnerName("Paweł");

            if (owner == null) {
                System.out.println(owner.getOwnerID() + " not found! ");
            } else {
                System.out.println("Found " + owner.getOwnerName());
            }

            System.out.println("Owner " + 1);


//            System.out.println(persons);

            //Commit transaction to database
            session.getTransaction().commit();

            System.out.println("Done");

            session.close();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed. " + ex);
        } finally {
            entityManagerFactory.close();
        }
    }
}
