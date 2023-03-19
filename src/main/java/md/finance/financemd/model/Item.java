package md.finance.financemd.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


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

    public Item() {
    }


    public Item(@NotEmpty @Size(min = 2, max = 100, message = "Title is short or long") String title, @Min(0) long price, @NotEmpty @Size(min = 0, max = 500, message = "Title is short or long") String description) {
        this.title = title;
        this.price = price;
        this.description = description;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
