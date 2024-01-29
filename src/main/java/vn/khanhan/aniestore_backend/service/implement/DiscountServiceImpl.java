package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Discount;
import vn.khanhan.aniestore_backend.repository.DiscountRepository;
import vn.khanhan.aniestore_backend.service.DiscountService;

import java.sql.Date;
import java.util.UUID;

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
        newDiscount.setCreateAt(new java.util.Date(System.currentTimeMillis()));
        newDiscount.setUpdateAt(new java.util.Date(System.currentTimeMillis()));
        this.discountRepository.saveAndFlush(newDiscount);
        return newDiscount;
    }

    @Override
    public Discount updateDiscount(Discount discount, UUID id) {
        Discount updateDiscount = this.discountRepository.getReferenceById(id);
        if(updateDiscount == null) {
            return null;
        }
        updateDiscount.setDiscountName(discount.getDiscountName() != null ? discount.getDiscountName(): updateDiscount.getDiscountName());
        updateDiscount.setPercentDiscount(discount.getPercentDiscount() > 0 ? discount.getPercentDiscount() : updateDiscount.getPercentDiscount());
        updateDiscount.setApplyDate(discount.getApplyDate() != null ? discount.getApplyDate() : updateDiscount.getApplyDate());
        updateDiscount.setExpiry(discount.getExpiry() != null ? discount.getExpiry() : updateDiscount.getExpiry());
        updateDiscount.setUsersList(discount.getUsersList() == null ? updateDiscount.getUsersList() : discount.getUsersList());
        updateDiscount.setUpdateAt(new java.util.Date(System.currentTimeMillis()));
        this.discountRepository.saveAndFlush(updateDiscount);
        return updateDiscount;
    }

    @Override
    public ResponseEntity<?> deleteDiscount(UUID id) {
        if(!this.discountRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Not exists!");
        }
        this.discountRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete complete!");
    }
}
