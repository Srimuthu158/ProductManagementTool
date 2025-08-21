package controller;

import model.Attribute;
import service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {
    @Autowired
    private AttributeService attributeService;

    @GetMapping
    public List<Attribute> getAllAttributes() {
        return attributeService.getAllAttributes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable Long id) {
        Optional<Attribute> attribute = attributeService.getAttributeById(id);
        return attribute.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/category/{categoryId}")
    public Attribute createAttribute(@PathVariable Long categoryId, @RequestBody Attribute attribute) {
        return attributeService.createAttribute(categoryId, attribute);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attribute> updateAttribute(@PathVariable Long id, @RequestBody Attribute attributeDetails) {
        return ResponseEntity.ok(attributeService.updateAttribute(id, attributeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable Long id) {
        attributeService.deleteAttribute(id);
        return ResponseEntity.noContent().build();
    }
}
