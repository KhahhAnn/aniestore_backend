package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.ImportInvoice;

@Service
public interface ImportInvoiceService {
    public ImportInvoice addNewInvoice(ImportInvoice importInvoice);
}
