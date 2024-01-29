package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Discount;
import vn.khanhan.aniestore_backend.service.DiscountService;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/discount")
public class DiscountController {
    private DiscountService discountService;

    @PostMapping
    public ResponseEntity<?> addDiscount(@RequestBody Discount discount) {
        Discount response = this.discountService.addNewDiscount(discount);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDiscount(@RequestBody Discount discount, @PathVariable UUID id) {
        Discount response = this.discountService.updateDiscount(discount, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateDiscount(@PathVariable UUID id) {
        ResponseEntity<?> response = this.discountService.deleteDiscount(id);
        return response;
    }
}
