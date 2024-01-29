package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.OrderDetail;

import java.util.UUID;

@Service
public interface OrderDetailService{
    public OrderDetail addNewOrderDetail(OrderDetail orderDetail);

    public OrderDetail updateOrderDetail(OrderDetail orderDetail, UUID id);

    public ResponseEntity<?> deleteOrderDetail(UUID id);
}
