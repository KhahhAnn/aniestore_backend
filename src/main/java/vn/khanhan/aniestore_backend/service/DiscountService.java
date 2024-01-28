package vn.khanhan.aniestore_backend.service;

import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Discount;

@Service
public interface DiscountService {
    public Discount addNewDiscount(Discount discount);
}
