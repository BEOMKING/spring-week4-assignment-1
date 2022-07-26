package com.codesoom.assignment.service;

import com.codesoom.assignment.domain.CatToy;
import com.codesoom.assignment.domain.CatToyDto;

public interface ToyService {
    /**
     * 장난감을 생성한다.
     *
     * @param catToyDto 고양이 장난감 Dto
     * @return 고양이 장난감
     */
    CatToy create(CatToyDto catToyDto);

    /**
     * 장난감을 조회한다.
     *
     * @param id 식별자
     * @return 장난감
     */
    CatToy findById(Long id);
}
