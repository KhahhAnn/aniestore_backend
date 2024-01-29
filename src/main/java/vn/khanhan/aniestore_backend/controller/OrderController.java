package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Event;
import vn.khanhan.aniestore_backend.entity.Order;
import vn.khanhan.aniestore_backend.service.EventService;
import vn.khanhan.aniestore_backend.service.OrderService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody Order order) {
        Order response = this.orderService.addNewOrder(order);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@RequestBody Order order, @PathVariable UUID id) {
        Order response = this.orderService.updateOrder(order, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable UUID id) {
        ResponseEntity<?> response = this.orderService.deleteOrder(id);
        return response;
    }
}
