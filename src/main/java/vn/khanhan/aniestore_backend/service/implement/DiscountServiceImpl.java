package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Discount;
import vn.khanhan.aniestore_backend.repository.DiscountRepository;
import vn.khanhan.aniestore_backend.service.DiscountService;

import java.sql.Date;

@Service
@AllArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private DiscountRepository discountRepository;
    @Override
    public Discount addNewDiscount(Discount discount) {
        Discount newDiscount = new Discount();
        newDiscount.setDiscountName(discount.getDiscountName());
        newDiscount.setPercentDiscount(discount.getPercentDiscount());
        newDiscount.setApplyDate(discount.getApplyDate() != null ? discount.getApplyDate() : new Date(System.currentTimeMillis()));
        newDiscount.setExpiry(discount.getExpiry() != null ? discount.getExpiry() : new Date(System.currentTimeMillis() + 604800000));
        newDiscount.setUsersList(discount.getUsersList());
        this.discountRepository.saveAndFlush(newDiscount);
        return newDiscount;
    }
}
