package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.ImportInvoice;
import vn.khanhan.aniestore_backend.entity.ImportInvoiceDetail;

import java.util.UUID;

@Service
public interface ImportInvoiceDetailService {
    public ImportInvoiceDetail addNewInvoiceDetail(ImportInvoiceDetail invoiceDetail);
    public ImportInvoiceDetail updateInvoiceDetail(ImportInvoiceDetail invoiceDetail, UUID id);
    public ResponseEntity<?> deleteInvoiceDetail(UUID id);

}
