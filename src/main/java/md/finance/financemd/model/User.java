package md.finance.financemd.model;



import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(min =2,max=100,message = "name is short or long")
    @Column(name = "username")
    private String name;
    @Min(value = 1900, message = "year should be < 1990")
    @Column(name = "year_of_birth")
    private int year;

    @Min(0)
    @Max(100)
    @Column(name = "discount")
    private int discount;


    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;


    @OneToMany(mappedBy = "user")
    private List<Order> orders;


    public User() {
    }

    public User(@NotEmpty @Size(min = 2, max = 100, message = "name is short or long") String name, @Min(value = 1900, message = "year should be < 1990") int year) {
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", password='" + password + '\'' +
                '}';
    }
}
