package md.finance.financemd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty
    @Size(min = 2, max = 100, message = "Title is short or long")
    private String title;


    @Min(0)
    private long price;


    @NotEmpty
    @Size(min = 0, max = 500, message = "Title is short or long")
    private String description;


    @OneToMany()
    private List<Order> orders;

}