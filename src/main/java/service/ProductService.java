package service;

import model.Category;
import model.Product;
import model.ProductAttribute;
import repository.CategoryRepository;
import repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Long categoryId, Product product) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Additional method for adding attribute values
    public Product addAttributeValue(Long productId, ProductAttribute productAttribute) {
        Product product = productRepository.findById(productId).orElseThrow();
        // Validate if attribute belongs to product's category (add logic if needed)
        productAttribute.setProduct(product);
        product.getProductAttributes().add(productAttribute);
        return productRepository.save(product);
    }
}