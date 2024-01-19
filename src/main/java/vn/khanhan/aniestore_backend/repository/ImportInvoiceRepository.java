package vn.khanhan.aniestore_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.khanhan.aniestore_backend.entity.ImportInvoice;

import java.util.UUID;

@RepositoryRestResource(path = "import-invoice")
public interface ImportInvoiceRepository extends JpaRepository<ImportInvoice, UUID> {
}
