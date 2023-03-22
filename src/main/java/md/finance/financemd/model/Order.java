package md.finance.financemd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import md.finance.financemd.model.enums.TypeStatus;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Item item;

    @Enumerated(EnumType.ORDINAL)
    private TypeStatus typeStatus;

    private int quantityItems;
}

   