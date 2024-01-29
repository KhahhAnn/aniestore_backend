package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Event;
import vn.khanhan.aniestore_backend.entity.Products;
import vn.khanhan.aniestore_backend.service.EventService;
import vn.khanhan.aniestore_backend.service.ProductsService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductsController {
    private ProductsService productsService;

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Products products) {
        Products response = this.productsService.addNewProduct(products);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Products products, @PathVariable UUID id) {
        Products response = this.productsService.updateProduct(products, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable UUID id) {
        ResponseEntity<?> response = this.productsService.deleteProduct(id);
        return response;
    }
}
