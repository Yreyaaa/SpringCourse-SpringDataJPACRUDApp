package ru.alishev.springcourse.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Item;
import ru.alishev.springcourse.models.Person;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {


    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1() {
        Session session = entityManager.unwrap(Session.class);

//        List<Person> people = session.createQuery("select  p from Person p", Person.class).getResultList();
//        for (Person person : people) {
//            List<Item> itemList = person.getItemList();
//            System.out.println(itemList);
//        }


        Set<Person> people = new HashSet<Person>( session.createQuery("select  p from Person p left join fetch p.itemList", Person.class).getResultList());
        for (Person person : people) {

            System.out.println(person.getItemList());
        }

    }





}
