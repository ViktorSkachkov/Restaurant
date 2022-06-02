package com.example.demo.Business.impl;

import com.example.demo.Business.GetCartItemsUseCase;
import com.example.demo.Repositories.AddingRepository;
import com.example.demo.Repositories.Adding_Cart_RelationRepository;
import com.example.demo.Repositories.CartItemRepository;
import com.example.demo.RepositoryClasses.Adding;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.dto.AddingDTO;
import com.example.demo.dto.CartItemDTO;
import com.example.demo.dto.GetCartItemsResponseDTO;
import com.example.demo.dto.GetUsersResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class GetCartItemsUseCaseImp implements GetCartItemsUseCase {
    private final CartItemRepository cartItemRepository;
    private final Adding_Cart_RelationRepository adding_cart_relationRepository;
    private final AddingRepository addingRepository;

    @Override
    public GetCartItemsResponseDTO getCartItems() {
        List<CartItemDTO> cartItemDTOS = cartItemRepository.findAll()
                .stream()
                .map(CartItemDTOConverter::convertToDTO)
                .toList();
List<Adding_Cart_Relation> adding_cart_relations = adding_cart_relationRepository.findAll();
List<AddingDTO> addingDTOList = new ArrayList<>();
for(CartItemDTO cartItemDTO : cartItemDTOS) {
    //if(cartItemDTO.getApproved().equals("false"))
    //{
    addingDTOList = new ArrayList<>();
    for(Adding_Cart_Relation adding_Cart_Relation: adding_cart_relationRepository.findAll()) {
        if(adding_Cart_Relation.getCartItem().getId() == cartItemDTO.getId()) {
            Adding adding = adding_Cart_Relation.getAdding();
            AddingDTO addingDTO = AddingDTO.builder()
                    .id(Math.toIntExact(adding.getId()))
                    .name(adding.getName())
                    .weight(adding.getWeight())
                    .price(adding.getPrice())
                    .build();
            addingDTOList.add(addingDTO);
        }
    }
  cartItemDTO.setAddings(addingDTOList);
   // }
}
        return GetCartItemsResponseDTO.builder()
                .cartItems(cartItemDTOS)
                .build();
    }
}
