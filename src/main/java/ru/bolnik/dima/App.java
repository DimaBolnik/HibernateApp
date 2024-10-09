package ru.bolnik.dima;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.bolnik.dima.model.Director;
import ru.bolnik.dima.model.Item;
import ru.bolnik.dima.model.Movie;
import ru.bolnik.dima.model.Person;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration()
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "true")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        Session session;
        try (SessionFactory factory = config.buildSessionFactory()) {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Movie movie = session.get(Movie.class, 14);
            session.delete(movie);



            session.getTransaction().commit();
        }
    }
}
