package ru.alishev.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.models.Item;
import ru.alishev.springcourse.models.Person;

import java.util.List;

/**
 * @author Neil Alishev
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByItemName(String name);

    List<Item> findByOwner(Person owner);


}
