package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.ImportInvoice;
import vn.khanhan.aniestore_backend.repository.ImportInvoiceRepository;
import vn.khanhan.aniestore_backend.service.ImportInvoiceService;

import java.sql.Date;

@Service
@AllArgsConstructor
public class ImportInvoiceServiceImpl implements ImportInvoiceService {
    private ImportInvoiceRepository importInvoiceRepository;
    @Override
    public ImportInvoice addNewInvoice(ImportInvoice importInvoice) {
        ImportInvoice newInvoice = new ImportInvoice();
        newInvoice.setImportDate(importInvoice.getImportDate() != null ? importInvoice.getImportDate() :new Date(System.currentTimeMillis()));
        newInvoice.setInvoiceName(importInvoice.getInvoiceName());
        newInvoice.setTotalPrice(importInvoice.getTotalPrice());
        newInvoice.setImportInvoiceDetails(importInvoice.getImportInvoiceDetails());
        this.importInvoiceRepository.saveAndFlush(newInvoice);
        return newInvoice;
    }
}
