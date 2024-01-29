package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.ImportInvoice;

import java.util.UUID;

@Service
public interface ImportInvoiceService {
    public ImportInvoice addNewInvoice(ImportInvoice importInvoice);
    public ImportInvoice updateInvoice(ImportInvoice importInvoice, UUID id);
    public ResponseEntity<?> deleteInvoice(UUID id);

}
