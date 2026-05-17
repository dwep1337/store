package github.dwep1337.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.dwep1337.store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}