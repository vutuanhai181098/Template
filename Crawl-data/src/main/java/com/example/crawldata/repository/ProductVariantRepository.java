package com.example.crawldata.repository;

import com.example.crawldata.entity.ProductImage;
import com.example.crawldata.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}
