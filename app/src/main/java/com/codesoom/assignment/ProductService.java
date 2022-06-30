package com.codesoom.assignment;

import com.codesoom.assignment.exceptions.ProductNotFoundException;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    /**
     * 인자로 넘어온 ID를 가진 Toy를 찾아 리턴한다. 없을 경우 ToyNotFoundException을 던진다.
     * @param id - Toy의 숫자 ID
     * @return Toy - 인자로 넘어온 ID를 가진 Toy
     * @throws ProductNotFoundException - 인자로 넘어온 ID를 가진 Toy가 없는 경우
     */
    public Product getToyById(long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    /**
     * 인자로 넘어온 Toy를 저장하고, 저장된 Toy를 리턴한다. Toy는 호출된 순서대로 ID가 부여된다.
     * @param product - 저장할 Toy, ID 필드는 null인 상태이다.
     * @return Toy - 저장된 Toy, ID 필드가 추가된채로 리턴된다.
     */
    public Product register(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    /**
     * 저장된 모든 Toy를 리스트 형태로 리턴한다. Toy는 ID를 기준으로 정렬되어 있다.
     * @return List<Toy> - 저장된 모든 Toy들을 리스트 형태로 리턴한다.
     */
    public List<Product> getToys() {
        return productRepository.findAll();
    }

    /**
     * 인자로 넘어온 ID를 가진 Toy를 수정한다. 없을 경우 ToyNotFoundException을 던진다.
     * @param id - 수정하고 싶은 Toy의 숫자 ID
     * @param newProduct - 수정할 값이 담긴 Toy 객체이며 ID 필드는 null인 상태이다.
     * @return updatedToy - 수정된 Toy, ID 필드가 추가된채로 리턴된다.
     * @throws ProductNotFoundException - 인자로 넘어온 ID를 가진 Toy가 없는 경우
     */
    public Product update(Long id, Product newProduct) throws ProductNotFoundException {
        Product target = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        Product updatedProduct = new Product(target.getId(), Category.TOY, newProduct.getName(), newProduct.getMaker(), newProduct.getPrice(), newProduct.getImageUrl());
        return productRepository.update(updatedProduct);
    }

    /**
     * 인자로 넘어온 ID를 가진 Toy를 삭제한다. 없을 경우 ToyNotFoundException을 던진다.
     * @param id - 삭제하고 싶은 Toy의 숫자 ID
     * @throws ProductNotFoundException - 인자로 넘어온 ID를 가진 Toy가 없는 경우
     */
    public void delete(Long id) throws ProductNotFoundException {
        productRepository.deleteById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
