package github.dwep1337.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.dwep1337.store.dto.CreateProductDTO;
import github.dwep1337.store.dto.ProductResponseDTO;
import github.dwep1337.store.dto.UpdateProductDTO;
import github.dwep1337.store.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProducts(@RequestBody @Valid CreateProductDTO request) {
        productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<ProductResponseDTO> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(
            @PathVariable Long id,
            @RequestBody @Valid UpdateProductDTO updateProductDTO) {
        return productService.updateProduct(id, updateProductDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
