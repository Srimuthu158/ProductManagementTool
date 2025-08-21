package model;

import jakarta.persistence.*;

@Entity
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "attribute_value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "attributeId")
    private Attribute attribute;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Attribute getAttribute() { return attribute; }
    public void setAttribute(Attribute attribute) { this.attribute = attribute; }
}
