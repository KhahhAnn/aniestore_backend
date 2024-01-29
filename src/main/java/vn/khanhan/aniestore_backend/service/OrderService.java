package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Order;

import java.util.UUID;

@Service
public interface OrderService {
    public Order addNewOrder(Order order);

    public Order updateOrder(Order order, UUID id);

    public ResponseEntity<?> deleteOrder(UUID id);
}
