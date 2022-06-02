package com.example.demo.Controllers;

import com.example.demo.Business.*;
import com.example.demo.Business.impl.*;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final GetOrderedMealsUseCase getOrderedMealsUseCase;
    private final GetOrderItemsUseCase getOrderItemsUseCase;
    private final GetUsersUseCase getUsersUseCase;
    private final GetCartItemsUseCase getCartItemsUseCase;
    private final GetAddingCartRelationsUseCase getAddingCartRelationsUseCase;
    private final DeleteCartItemUseCart deleteCartItemUseCart;
    private final IncreaseNumberOfItemsUseCase increaseNumberOfItemsUseCase;
    private final DecreaseNumberOfItemsUseCase decreaseNumberOfItemsUseCase;

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/orderedMeals")
    public List<OrderedMealDTO> GetCart() {
        return getOrderedMealsUseCase.getOrderedMeals().getOrderedMeals();
    }


    /*@IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/cartItems")
    public List<CartItemDTO> GetCartItems() {
       return getCartItemsUseCase.getCartItems().getCartItems();
    }*/

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/cartItems")
    public List<CartItemDTO> GetCartItems(@RequestBody @Valid GetSpecificCartItemsRequestDTO getSpecificCartItemsRequestDTO) {
        return getCartItemsUseCase.getCartItems().getCartItems();
    }


    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/increase/{id}")
    public String increaseNumberOfItems(@PathVariable(value = "id") final long id) {
        increaseNumberOfItemsUseCase.increase(id);
        return "answer";
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/decrease/{id}")
    public String decreaseNumberOfItems(@PathVariable(value = "id") final long id) {
        decreaseNumberOfItemsUseCase.decrease(id);
        return "answer";
    }


    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/deleteCartItem/{id}")
    public CartItem deleteFromCart(@PathVariable(value = "id") final long id) {
        return deleteCartItemUseCart.deleteCartItem(id);
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/specificCartItems/{id}")
    public List<CartItemDTO> GetSpecificCartItems(/*@RequestBody @Valid GetSpecificCartItemsRequestDTO getSpecificCartItemsRequestDTO*/
            @PathVariable(value = "id") final long id) {
        List<CartItemDTO> specificCartItems = new ArrayList<>();
        for(CartItemDTO cartItemDTO: getCartItemsUseCase.getCartItems().getCartItems()) {
            if(cartItemDTO.getUser().getId() == id) {
                if(cartItemDTO.getApproved().equals("false")) {
                    specificCartItems.add(cartItemDTO);
                }
            }
        }
        return specificCartItems;
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/listOfNumbers/{id}")
    public List<Integer> GetListOfNumbers(/*@RequestBody @Valid GetSpecificCartItemsRequestDTO getSpecificCartItemsRequestDTO*/
            @PathVariable(value = "id") final long id) {
        List<Integer> specificCartItems = new ArrayList<>();
        for(CartItemDTO cartItemDTO: getCartItemsUseCase.getCartItems().getCartItems()) {
            if(cartItemDTO.getUser().getId() == id) {
                specificCartItems.add(cartItemDTO.getNumberOfItems());
            }
        }
        return specificCartItems;
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/specificAddings/{id}")
    public List<Adding_Cart_Relation> GetAdding_Cart_Relation(
            @PathVariable(value = "id") final long id) {
        List<Adding_Cart_Relation> return_List = new ArrayList<>();
        for(Adding_Cart_Relation adding_cart_relation: getAddingCartRelationsUseCase.getAddingCartRelations().getAddingDTOList()) {
            if(id == adding_cart_relation.getCartItem().getUser().getId() && adding_cart_relation.getApproved().equals("false")) {
                return_List.add(adding_cart_relation);
            }
        }
        return return_List;
    }



    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/{username}/{id}")
    public List<OrderedMealDTO> GetMeals(@PathVariable(value = "username") final String username, @PathVariable(value = "id") final long id) {
        List<OrderedMealDTO> orderedMealsList = new ArrayList<>();
            UserDTO user = null;
                    for(UserDTO u : getUsersUseCase.getUsers(id).getUsers()) {
                        if(u.getUsername().equals(username)) {
                            user = u;
                        }
                    }
        for(OrderedMealDTO omd : getOrderedMealsUseCase.getOrderedMeals().getOrderedMeals()) {
            if(omd.getUser() == user.getId()) {
                orderedMealsList.add(omd);
            }
        }
        return orderedMealsList;
        //return getMealsUseCase.GetMeals(username);
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/{id}")
    public OrderedMealDTO GetOrderedMeal(@PathVariable int id)
    {
       OrderedMealDTO orderedMeal = null;
        for(OrderedMealDTO omd : getOrderedMealsUseCase.getOrderedMeals().getOrderedMeals()) {
            if(omd.getId() == id) {
                orderedMeal = omd;
            }
        }
        return orderedMeal;
        //return getOrderedMealUseCase.GetOrderedMeal(id);
    }
    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/orderItems")
    public List<OrderDTO> GetOrders() {
        return getOrderItemsUseCase.getOrders().getOrders();
    }
}