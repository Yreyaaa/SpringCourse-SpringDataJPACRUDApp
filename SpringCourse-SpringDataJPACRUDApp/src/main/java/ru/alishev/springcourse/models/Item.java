package ru.alishev.springcourse.models;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;




    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;


    @Column(name = "item_name", nullable = false, length = 100)
    private String itemName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    @Override
    public String toString() {
        return "Item{" +
                "owner=" + owner +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
