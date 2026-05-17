package github.dwep1337.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import github.dwep1337.store.dto.CreateProductDTO;
import github.dwep1337.store.dto.ProductResponseDTO;
import github.dwep1337.store.dto.UpdateProductDTO;
import github.dwep1337.store.entity.Product;
import github.dwep1337.store.exception.ProductNotFoundException;
import github.dwep1337.store.mapper.ProductMapper;
import github.dwep1337.store.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public void createProduct(CreateProductDTO createProductDTO) {
        Product product = productMapper.toEntity(createProductDTO);
        productRepository.save(product);
    }

    public List<ProductResponseDTO> listProducts() {
        return productRepository.findAll().stream()
            .map(productMapper::toResponse)
            .toList();
    }

    public ProductResponseDTO getProductById(Long id) {
        return productMapper.toResponse(findProductById(id));
    }

    @Transactional
    public ProductResponseDTO updateProduct(Long id, UpdateProductDTO updateProductDTO) {
        Product product = findProductById(id);
        productMapper.patch(product, updateProductDTO);
        return productMapper.toResponse(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
