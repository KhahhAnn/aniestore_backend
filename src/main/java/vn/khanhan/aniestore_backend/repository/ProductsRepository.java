package vn.khanhan.aniestore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khanhan.aniestore_backend.entity.Products;

import java.util.UUID;

@RepositoryRestResource(path = "product")
public interface ProductsRepository extends JpaRepository<Products, UUID> {
}
