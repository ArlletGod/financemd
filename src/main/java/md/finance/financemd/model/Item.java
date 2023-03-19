package md.finance.financemd.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty
    @Size(min =2,max=100,message = "Title is short or long")
    @Column(name = "title")
    private String title;


    @Min(0)
    @Column(name = "price")
    private long price;



    @NotEmpty
    @Size(min =0,max=500,message = "Title is short or long")
    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "item")
    private List<Order> orders;


    public Item() {
    }


    public Item(int id, @NotEmpty @Size(min = 2, max = 100, message = "Title is short or long") String title, @Min(0) long price, @NotEmpty @Size(min = 0, max = 500, message = "Title is short or long") String description, List<Order> orders) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return title;
    }
}
