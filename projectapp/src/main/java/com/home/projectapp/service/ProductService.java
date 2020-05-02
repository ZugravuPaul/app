package com.home.projectapp.service;

import com.home.projectapp.dto.ProductDto;
import com.home.projectapp.entity.Product;
import com.home.projectapp.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService  {

    private ProductRepository productRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> show_all_products() {
        return ((List<Product>) productRepository.findAll())
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public void addProduct(ProductDto productDto) {
        productRepository.save(modelMapper.map(productDto, Product.class));
    }

    public void updateName(Long id, String name) {
        productRepository.updateName(id, name);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
