package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String dataType;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL)
    private List<ProductAttribute> productAttributes = new ArrayList<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDataType() { return dataType; }
    public void setDataType(String dataType) { this.dataType = dataType; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public List<ProductAttribute> getProductAttributes() { return productAttributes; }
    public void setProductAttributes(List<ProductAttribute> productAttributes) { this.productAttributes = productAttributes; }
}