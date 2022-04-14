package com.example.demo.Administrations;

import com.example.demo.DataHelpers.CartDataHelper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartAdministration {
    CartDataHelper CartDataHelper;
    public CartAdministration(CartDataHelper CartDataHelper) {
        this.CartDataHelper = CartDataHelper;

    }
}
