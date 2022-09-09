package com.example.spring_data_jpa.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
@Data
@Table(
        name = "product_Desc",
        schema = "spring_Jpa",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "sku"
                ),
                @UniqueConstraint(
                        name = "name_unique",
                        columnNames = "name"
                )
        }

)
@Entity
public class Product {

    /* @GeneratedValue(
             strategy = GenerationType.AUTO,
             generator = "product_generator"
     )
     @SequenceGenerator(
             name = "product_generator",
             sequenceName = "product_sequence_name",
             allocationSize = 1
     )*/
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator= "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
