package hibernate;

import hibernate.model.Owner;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;


public class DB_Connection {

    public static void connect() {

        System.out.println("Start");

        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();
            Session session = entityManager.unwrap(Session.class);

            //New transaction
            session.beginTransaction();

//            Action type manager
            DB_Manager manager = new DB_Manager();
            Scanner scanner = new Scanner(System.in);


            System.out.println("Write type of operation to execute");
            String inputQuery = scanner.nextLine();
            String[] inputValues = inputQuery.split("/");

            if(inputValues[0].equals("GET"))
            {
                manager.GET(session, inputValues[1], Integer.parseInt(inputValues[2]));
            }
            if(inputValues[0].equals("DELETE"))
            {
                manager.DELETE(session, inputValues[1], Integer.parseInt(inputValues[2]));
            }
            if(inputValues[0].equals("ADD"))
            {
                manager.ADD(session, inputValues[1], Integer.parseInt(inputValues[2]), inputValues[3], inputValues[4]);
            }

            session.getTransaction().commit();
            System.out.println("Done");
            session.close();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
        } finally {
            assert entityManagerFactory != null;
            entityManagerFactory.close();
        }
    }
}
