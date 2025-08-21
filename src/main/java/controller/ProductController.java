package controller;

import model.Product;
import model.ProductAttribute;
import service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/category/{categoryId}")
    public Product createProduct(@PathVariable Long categoryId, @RequestBody Product product) {
        return productService.createProduct(categoryId, product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{productId}/attributes")
    public ResponseEntity<Product> addAttributeValue(@PathVariable Long productId, @RequestBody ProductAttribute productAttribute) {
        return ResponseEntity.ok(productService.addAttributeValue(productId, productAttribute));
    }
}
