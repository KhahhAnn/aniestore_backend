package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Discount;

import java.util.UUID;

@Service
public interface DiscountService {
    public Discount addNewDiscount(Discount discount);

    public Discount updateDiscount(Discount discount, UUID id);

    public ResponseEntity<?> deleteDiscount(UUID id);

}
