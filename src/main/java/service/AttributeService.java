package service;

import model.Attribute;
import model.Category;
import repository.AttributeRepository;
import repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeService {
    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    public Optional<Attribute> getAttributeById(Long id) {
        return attributeRepository.findById(id);
    }

    public Attribute createAttribute(Long categoryId, Attribute attribute) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        attribute.setCategory(category);
        return attributeRepository.save(attribute);
    }

    public Attribute updateAttribute(Long id, Attribute attributeDetails) {
        Attribute attribute = attributeRepository.findById(id).orElseThrow();
        attribute.setName(attributeDetails.getName());
        attribute.setDataType(attributeDetails.getDataType());
        return attributeRepository.save(attribute);
    }

    public void deleteAttribute(Long id) {
        attributeRepository.deleteById(id);
    }
}