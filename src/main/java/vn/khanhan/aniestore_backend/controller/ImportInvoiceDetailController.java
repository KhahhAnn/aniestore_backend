package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Event;
import vn.khanhan.aniestore_backend.entity.ImportInvoiceDetail;
import vn.khanhan.aniestore_backend.repository.ImportInvoiceDetailRepository;
import vn.khanhan.aniestore_backend.service.EventService;
import vn.khanhan.aniestore_backend.service.ImportInvoiceDetailService;
import vn.khanhan.aniestore_backend.service.ImportInvoiceService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/import-invoice-detail")
public class ImportInvoiceDetailController {
    private ImportInvoiceDetailService importInvoiceDetailService;

    @PostMapping
    public ResponseEntity<?> addImportInvoiceDetail(@RequestBody ImportInvoiceDetail invoiceDetail) {
        ImportInvoiceDetail response = this.importInvoiceDetailService.addNewInvoiceDetail(invoiceDetail);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateImportInvoiceDetail(@RequestBody ImportInvoiceDetail invoiceDetail, @PathVariable UUID id) {
        ImportInvoiceDetail response = this.importInvoiceDetailService.updateInvoiceDetail(invoiceDetail, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateImportInvoiceDetail(@PathVariable UUID id) {
        ResponseEntity<?> response = this.importInvoiceDetailService.deleteInvoiceDetail(id);
        return response;
    }
}
