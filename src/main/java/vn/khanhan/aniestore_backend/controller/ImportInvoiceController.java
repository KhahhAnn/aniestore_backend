package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Event;
import vn.khanhan.aniestore_backend.entity.ImportInvoice;
import vn.khanhan.aniestore_backend.service.EventService;
import vn.khanhan.aniestore_backend.service.ImportInvoiceService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/import-invoice")
public class ImportInvoiceController {
    private ImportInvoiceService importInvoiceService;

    @PostMapping
    public ResponseEntity<?> addImportInvoice(@RequestBody ImportInvoice importInvoice) {
        ImportInvoice response = this.importInvoiceService.addNewInvoice(importInvoice);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody ImportInvoice importInvoice, @PathVariable UUID id) {
        ImportInvoice response = this.importInvoiceService.updateInvoice(importInvoice, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable UUID id) {
        ResponseEntity<?> response = this.importInvoiceService.deleteInvoice(id);
        return response;
    }
}
