package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Order;
import vn.khanhan.aniestore_backend.repository.OrderRepository;
import vn.khanhan.aniestore_backend.service.OrderService;

import java.sql.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    @Override
    public Order addNewOrder(Order order) {
        Order newOrder = new Order();
        newOrder.setOrderDate(order.getOrderDate() != null ? order.getOrderDate() : new Date(System.currentTimeMillis()));
        newOrder.setOrderName(order.getOrderName());
        newOrder.setTotal(order.getTotal());
        newOrder.setStatus(order.isStatus());
        newOrder.setProductsList(order.getProductsList());
        newOrder.setCreateAt(new java.util.Date(System.currentTimeMillis()));
        newOrder.setUpdateAt(new java.util.Date(System.currentTimeMillis()));
        this.orderRepository.saveAndFlush(newOrder);
        return newOrder;
    }

    @Override
    public Order updateOrder(Order order, UUID id) {
        Order updateOrder = this.orderRepository.getReferenceById(id);
        if(updateOrder == null) {
            return null;
        }
        updateOrder.setUpdateAt(new java.util.Date(System.currentTimeMillis()));
        updateOrder.setOrderDate(order.getOrderDate() != null ? order.getOrderDate() : updateOrder.getUpdateAt());
        updateOrder.setOrderName(order.getOrderName() != null ? order.getOrderName() : updateOrder.getOrderName());
        updateOrder.setStatus(!order.isStatus() ? order.isStatus() : updateOrder.isStatus());
        updateOrder.setTotal(order.getTotal() >= 0 ? order.getTotal() : updateOrder.getTotal());
        updateOrder.setUpdateAt(new java.util.Date(System.currentTimeMillis()));
        return updateOrder;
    }

    @Override
    public ResponseEntity<?> deleteOrder(UUID id) {
        if(!this.orderRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Not exists!");
        }
        this.orderRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete complete!");
    }
}
