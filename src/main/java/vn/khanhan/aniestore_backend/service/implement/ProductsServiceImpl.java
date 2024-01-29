package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Products;
import vn.khanhan.aniestore_backend.repository.ProductsRepository;
import vn.khanhan.aniestore_backend.service.ProductsService;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    private ProductsRepository productsRepository;
    @Override
    public Products addNewProduct(Products product) {
        Products newProduct = new Products();
        newProduct.setProductName(product.getProductName());
        newProduct.setTypeProduct(product.getTypeProduct());
        newProduct.setCategory(product.getCategory());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setColor(product.getColor());
        newProduct.setSize(product.getSize());
        newProduct.setPurchasePrice(product.getPurchasePrice());
        newProduct.setOriginPrices(product.getOriginPrices());
        newProduct.setSalePrices(product.getSalePrices());
        newProduct.setOrderDetail(product.getOrderDetail());
        newProduct.setCreateAt(new java.util.Date(System.currentTimeMillis()));
        newProduct.setUpdateAt(new java.util.Date(System.currentTimeMillis()));
        this.productsRepository.saveAndFlush(newProduct);
        return newProduct;
    }

    @Override
    public Products updateProduct(Products product, UUID id) {
        Products updateProduct = this.productsRepository.getReferenceById(id);
        if(updateProduct == null) {
            return null;
        }
        updateProduct.setProductName(product.getProductName() != null ? product.getProductName() : updateProduct.getProductName());
        updateProduct.setTypeProduct(product.getTypeProduct() != null ? product.getTypeProduct() : updateProduct.getTypeProduct());
        updateProduct.setCategory(product.getCategory() != null ? product.getCategory() : updateProduct.getCategory());
        updateProduct.setQuantity(product.getQuantity() <= 0 ? product.getQuantity() : updateProduct.getQuantity());
        updateProduct.setColor(product.getColor() != null ? product.getColor() : updateProduct.getColor());
        updateProduct.setSize(product.getSize() != null ? product.getSize() : updateProduct.getSize());
        updateProduct.setPurchasePrice(product.getPurchasePrice() <= 0 ? product.getPurchasePrice() : updateProduct.getPurchasePrice());
        updateProduct.setOriginPrices(product.getOriginPrices() <= 0 ? product.getOriginPrices() : updateProduct.getOriginPrices());
        updateProduct.setSalePrices(product.getSalePrices() <= 0 ? product.getSalePrices() : updateProduct.getSalePrices());
        updateProduct.setOrderDetail(product.getOrderDetail() != null ? product.getOrderDetail() : updateProduct.getOrderDetail());
        updateProduct.setUpdateAt(new java.util.Date(System.currentTimeMillis()));
        this.productsRepository.saveAndFlush(updateProduct);
        return updateProduct;
    }

    @Override
    public ResponseEntity<?> deleteProduct(UUID id) {
        if(!this.productsRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Not exists!");
        }
        this.productsRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete complete!");
    }
}
