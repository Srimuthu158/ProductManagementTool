package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String name;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Attribute> attributes = new ArrayList<>();
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Attribute> getAttributes() { return attributes; }
    public void setAttributes(List<Attribute> attributes) { this.attributes = attributes; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}