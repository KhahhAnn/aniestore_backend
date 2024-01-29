package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Products;

import java.util.UUID;

@Service
public interface ProductsService {
    public Products addNewProduct(Products product);

    public Products updateProduct(Products event, UUID id);

    public ResponseEntity<?> deleteProduct(UUID id);
}
