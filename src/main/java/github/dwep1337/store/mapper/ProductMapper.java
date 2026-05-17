package github.dwep1337.store.mapper;

import org.springframework.stereotype.Component;

import github.dwep1337.store.dto.CreateProductDTO;
import github.dwep1337.store.dto.ProductResponseDTO;
import github.dwep1337.store.dto.UpdateProductDTO;
import github.dwep1337.store.entity.Product;

@Component
public class ProductMapper {

    public Product toEntity(CreateProductDTO dto) {
        return Product.builder()
            .name(dto.name().trim())
            .description(dto.description().trim())
            .price(dto.price())
            .build();
    }

    public void patch(Product product, UpdateProductDTO dto) {
        if (dto.name() != null) {
            product.setName(dto.name().trim());
        }
        if (dto.description() != null) {
            product.setDescription(dto.description().trim());
        }
        if (dto.price() != null) {
            product.setPrice(dto.price());
        }
    }

    public ProductResponseDTO toResponse(Product product) {
        return new ProductResponseDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice());
    }
}
