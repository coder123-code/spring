/*package com.ecommerce.sportscenter.service;

import com.ecommerce.sportscenter.entity.Product;

import com.ecommerce.sportscenter.model.ProductResponse;
import com.ecommerce.sportscenter.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse getProductById(Integer productId) {
        log.info("fetching Product by Id: {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Product doesn't exist"));
        //now convert the Product to Product Response
        ProductResponse productResponse = convertToProductResponse(product);
        log.info("Fetched Product by Product Id: {}", productId);
        return productResponse;
    }

    @Override
    public Page<ProductResponse> getProducts(Pageable pageable, Integer brandId, Integer typeId, String keyword) {
        Specification<Product> spec = Specification.where(null);

        if (brandId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("brand").get("id"), brandId));
        }

        if (typeId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type").get("id"), typeId));
        }

        if (keyword != null && !keyword.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + keyword + "%"));
        }

        return productRepository.findAll(spec, pageable).map(this::convertToProductResponse);
    }
    private ProductResponse convertToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .pictureUrl(product.getPictureUrl())
                .productBrand(product.getBrand().getName())
                .productType(product.getType().getName())
                .build();
    }
}
*/
/*
package com.ecommerce.sportscenter.service;

import com.ecommerce.sportscenter.entity.Product;
import com.ecommerce.sportscenter.model.ProductResponse;
import com.ecommerce.sportscenter.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse getProductById(Integer productId) {
        log.info("Fetching Product by Id: {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product doesn't exist"));
        ProductResponse productResponse = convertToProductResponse(product);
        log.info("Fetched Product by Product Id: {}", productId);
        return productResponse;
    }

    @Override
    public Page<ProductResponse> getProducts(Pageable pageable, Integer brandId, Integer typeId, String keyword) {
        Specification<Product> spec = Specification.where(null);

        if (brandId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("brand").get("id"), brandId));
        }

        if (typeId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type").get("id"), typeId));
        }

        if (keyword != null && !keyword.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + keyword + "%"));
        }

        return productRepository.findAll(spec, pageable).map(this::convertToProductResponse);
    }

    private ProductResponse convertToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getPictureUrl(),
                product.getBrand().getName(),
                product.getType().getName()
        );
    }
}
*/
package com.ecommerce.sportscenter.service;

import com.ecommerce.sportscenter.entity.Product;
import com.ecommerce.sportscenter.model.ProductResponse;
import com.ecommerce.sportscenter.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/*@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse getProductById(Integer productId) {
        log.info("Fetching Product by Id: {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product doesn't exist"));
        ProductResponse productResponse = convertToProductResponse(product);
        log.info("Fetched Product by Product Id: {}", productId);
        return productResponse;
    }

    @Override
    public Page<ProductResponse> getProducts(Pageable pageable, Integer brandId, Integer typeId, String keyword) {
        Specification<Product> spec = Specification.where(null);

        if (brandId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("brand").get("id"), brandId));
        }

        if (typeId != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type").get("id"), typeId));
        }

        if (keyword != null && !keyword.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + keyword + "%"));
        }

        return productRepository.findAll(spec, pageable).map(this::convertToProductResponse);
    }

    private ProductResponse convertToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getPictureUrl(),
                product.getBrand().getName(),
                product.getType().getName()
        );
    }
}
*/
import com.ecommerce.sportscenter.entity.Product;
import com.ecommerce.sportscenter.model.ProductResponse;
import com.ecommerce.sportscenter.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse getProductById(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
        return convertToProductResponse(product);
    }

    @Override
    public Page<ProductResponse> getProducts(Pageable pageable, Integer brandId, Integer typeId, String keyword) {
        Page<Product> products;

        // Handle all possible filter combinations
        if (keyword != null && !keyword.isEmpty()) {
            if (brandId != null && typeId != null) {
                products = productRepository.findByNameContainingIgnoreCaseAndBrandIdAndTypeId(keyword, brandId, typeId, pageable);
            } else if (brandId != null) {
                products = productRepository.findByNameContainingIgnoreCaseAndBrandId(keyword, brandId, pageable);
            } else if (typeId != null) {
                products = productRepository.findByNameContainingIgnoreCaseAndTypeId(keyword, typeId, pageable);
            } else {
                products = productRepository.findByNameContainingIgnoreCase(keyword, pageable);
            }
        } else {
            if (brandId != null && typeId != null) {
                products = productRepository.findByBrandIdAndTypeId(brandId, typeId, pageable);
            } else if (brandId != null) {
                products = productRepository.findByBrandId(brandId, pageable);
            } else if (typeId != null) {
                products = productRepository.findByTypeId(typeId, pageable);
            } else {
                products = productRepository.findAll(pageable);
            }
        }

        return products.map(this::convertToProductResponse);
    }

    private ProductResponse convertToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getPictureUrl(),
                product.getBrand().getName(),
                product.getType().getName()
        );
    }
}