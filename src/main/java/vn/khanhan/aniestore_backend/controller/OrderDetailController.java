package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Event;
import vn.khanhan.aniestore_backend.entity.OrderDetail;
import vn.khanhan.aniestore_backend.service.EventService;
import vn.khanhan.aniestore_backend.service.OrderDetailService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order-detail")
public class OrderDetailController {
    private OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<?> addOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail response = this.orderDetailService.addNewOrderDetail(orderDetail);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(@RequestBody OrderDetail orderDetail, @PathVariable UUID id) {
        OrderDetail response = this.orderDetailService.updateOrderDetail(orderDetail, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable UUID id) {
        ResponseEntity<?> response = this.orderDetailService.deleteOrderDetail(id);
        return response;
    }
}
