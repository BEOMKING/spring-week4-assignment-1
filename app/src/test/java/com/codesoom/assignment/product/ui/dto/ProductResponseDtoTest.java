package com.codesoom.assignment.product.ui.dto;

import com.codesoom.assignment.product.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductResponseDtoTest {

    private static final String RESPONSE_DTO_STRING = "ProductResponseDto.ProductResponseDtoBuilder" +
            "(id=null, name=null, maker=null, price=0, imageUrl=null)";

    @DisplayName("id 기준으로 동일한 hashcode를 리턴한다")
    @Test
    void hashcode() {
        ProductResponseDto dto1 = ProductResponseDto.builder().id(1L).build();
        ProductResponseDto dto2 = ProductResponseDto.builder().id(1L).build();

        assertThat(dto1.hashCode()).isEqualTo(dto2.hashCode());
    }

    @DisplayName("id 기준으로 동일한 객체인지확인")
    @Test
    void equals() {
        ProductResponseDto dto1 = ProductResponseDto.builder().id(1L).build();
        ProductResponseDto dto2 = ProductResponseDto.builder().id(1L).build();
        Product product = Product.builder().build();

        assertThat(dto1.equals(dto1)).isTrue();
        assertThat(dto1.equals(dto2)).isTrue();
        assertThat(dto1.equals(product)).isFalse();
    }

    @DisplayName("dto response builder toString 테스트")
    @Test
    void responseDtoBuilderToString() {
        assertThat(ProductResponseDto.builder().toString()).isEqualTo(RESPONSE_DTO_STRING);
    }
}
