package com.codesoom.assignment;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import com.codesoom.assignment.dto.ProductDTO;
import com.codesoom.assignment.model.Product;
import com.codesoom.assignment.repository.ProductRepository;
import com.codesoom.assignment.service.ProductService;

@Nested
@DisplayName("ProductService Ŭ������")
public class ProductServiceTest {
	private ProductRepository productRepository;
	private ProductService productService;

	@BeforeEach
	void setUp() {
		productRepository = mock(ProductRepository.class);
		productService = new ProductService(productRepository);

		Product product = new Product("test name", 1000, "test imageUrl", "test maker");

		given(productRepository.findById(1)).willReturn(Optional.of(product));

	}

	@Nested
	@DisplayName("getProduct �޼ҵ��")
	class getProductTest {
		@DisplayName("�ش� id �� product �� ��ȯ")
		public void createProduct() {
			Product product = productService.getProduct(1);
			verify(productRepository).findById(1);
			assertThat(productRepository.findById(1));
		}
	}
}
