package com.example.demo.Business;

import com.example.demo.dto.CreateCartItemRequestDTO;
import com.example.demo.dto.CreateCartItemResponseDTO;

public interface AddCartItemUseCase {
    CreateCartItemResponseDTO createCartItem(CreateCartItemRequestDTO request);
}
