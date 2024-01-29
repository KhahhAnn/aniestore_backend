package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.OrderDetail;
import vn.khanhan.aniestore_backend.repository.OrderDetailRepository;
import vn.khanhan.aniestore_backend.service.OrderDetailService;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailRepository orderDetailRepository;
    @Override
    public OrderDetail addNewOrderDetail(OrderDetail orderDetail) {
        OrderDetail newOrderDetail = new OrderDetail();
        newOrderDetail.setTotal(orderDetail.getTotal());
        newOrderDetail.setOrder(orderDetail.getOrder());
        newOrderDetail.setProducts(orderDetail.getProducts());
        newOrderDetail.setQuantity(orderDetail.getQuantity());
        newOrderDetail.setCreateAt(new Date(System.currentTimeMillis()));
        newOrderDetail.setUpdateAt(new Date(System.currentTimeMillis()));
        this.orderDetailRepository.saveAndFlush(newOrderDetail);
        return newOrderDetail;
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail, UUID id) {
        OrderDetail updateOrderDetail = this.orderDetailRepository.getReferenceById(id);
        if(updateOrderDetail == null) {
            return null;
        }
        updateOrderDetail.setTotal(orderDetail.getTotal() <= 0 ? orderDetail.getTotal() : updateOrderDetail.getTotal());
        updateOrderDetail.setOrder(orderDetail.getOrder() != null ? orderDetail.getOrder() : updateOrderDetail.getOrder());
        updateOrderDetail.setProducts(orderDetail.getProducts() != null ? orderDetail.getProducts() : updateOrderDetail.getProducts());
        updateOrderDetail.setQuantity(orderDetail.getQuantity() <= 0 ? orderDetail.getQuantity() : updateOrderDetail.getQuantity());
        updateOrderDetail.setUpdateAt(new Date(System.currentTimeMillis()));
        this.orderDetailRepository.saveAndFlush(updateOrderDetail);
        return updateOrderDetail;
    }

    @Override
    public ResponseEntity<?> deleteOrderDetail(UUID id) {
        if(!this.orderDetailRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Not exists!");
        }
        this.orderDetailRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete complete!");
    }
}
