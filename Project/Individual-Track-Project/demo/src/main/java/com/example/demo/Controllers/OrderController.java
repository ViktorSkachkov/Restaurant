package com.example.demo.Controllers;

import com.example.demo.Business.*;
import com.example.demo.RepositoryClasses.Adding_Cart_Relation;
import com.example.demo.RepositoryClasses.CartItem;
import com.example.demo.RepositoryClasses.Meal;
import com.example.demo.RepositoryClasses.Order;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.*;
@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final GetMealsUseCase getMealsUseCase;
    private final GetCategoriesUseCase getCategoriesUseCase;
    private final GetAddingsUseCase getAddingsUseCase;
    private final AddMealUseCase addMealUseCase;
    private final UpdateMealUseCase updateMealUseCase;
    private final DeleteMealUseCase deleteMealUseCase;
    private final GetOrderItemsUseCase getOrderItemsUseCase;
    private final AddCartItemUseCase addCartItemUseCase;
    private final AddAddingCartRelationUseCase addAddingCartRelationUseCase;
    private final AddOrdersUseCase addOrdersUseCase;
    private final GetCartItemsUseCase getCartItemsUseCase;
    private final GetAddingCartRelationsUseCase getAddingCartRelationsUseCase;
    private final GetAddingCartRelationsDTOUseCase getAddingCartRelationsDTOUseCase;
    private final SetOrderAsCompleteUseCase setOrderAsCompleteUseCase;


    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/Addings")
    public List<AddingDTO> GetAddings() {
       return getAddingsUseCase.getAddings().getAddings();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @GetMapping("/addOrders/{id}/{cutlaries}")
    public List<CartItem> addOrders(@PathVariable(value = "id") final long id,
                                    @PathVariable(value = "cutlaries") final String cutlaries) {
        List<CartItem> addedCartItem = addOrdersUseCase.addOrders(id, cutlaries);
        return addedCartItem;
    }



    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Meals")
    public List<MealDTO> getMeals() {
        return getMealsUseCase.getMeals().getMeals();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/getMealsBy")
    public List<MealDTO> groupMeals(@RequestBody @Valid SearchWordRequest searchWordRequest) {
        List<MealDTO> meals = new ArrayList<>();
        for(MealDTO mealDTO : getMealsUseCase.getMeals().getMeals()) {
            if(mealDTO.getName().toLowerCase(Locale.ROOT).contains(searchWordRequest.getSearchWord().toLowerCase(Locale.ROOT))) {
                meals.add(mealDTO);
            }
        }
        return meals;
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Desserts")
    public List<MealDTO> GetDesserts() {
        List<MealDTO> desserts = new ArrayList<>();
                for(MealDTO meal : getMealsUseCase.getMeals().getMeals()) {
                    if(meal.getCategory().getId() == 4) {
                        desserts.add(meal);
                    }
                }
                return desserts;
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Salads")
    public List<MealDTO> GetSalads() {
        List<MealDTO> salads = new ArrayList<>();
        for(MealDTO meal : getMealsUseCase.getMeals().getMeals()) {
            if(meal.getCategory().getId() == 3) {
                salads.add(meal);
            }
        }
        return salads;
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Pasta")
    public List<MealDTO> GetPasta() {
        List<MealDTO> pasta = new ArrayList<>();
        for(MealDTO meal : getMealsUseCase.getMeals().getMeals()) {
            if(meal.getCategory().getId() == 2) {
                pasta.add(meal);
            }
        }
        return pasta;
    }


    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Pizza")
    public List<MealDTO> getPizza() {
        List<MealDTO> pizza = new ArrayList<>();
        for(MealDTO meal : getMealsUseCase.getMeals().getMeals()) {
            if(meal.getCategory().getId() == 1) {
                pizza.add(meal);
            }
        }
        return pizza;
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/{id}")
    public MealDTO GetMeal(@PathVariable int id) {
        MealDTO mealDTO = null;
        for(MealDTO meal : getMealsUseCase.getMeals().getMeals()) {
            if(meal.getId() == id) {
                mealDTO = meal;
            }
        }
        return mealDTO;
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT"})
    @PostMapping("/addToCart")
    public CreateCartItemResponseDTO addToCart(@RequestBody @Valid CreateCartItemRequestDTO createCartRequestDTO) {
        CreateCartItemResponseDTO createCartItemResponseDTO = addCartItemUseCase.createCartItem(createCartRequestDTO);
        addAddingCartRelationUseCase.createAddingCartRelation(createCartRequestDTO.getAddings(), createCartItemResponseDTO);
        return createCartItemResponseDTO;
        //return "answer";
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/setAsOrderComplete/{id}")
    public CartItem setOrderAsComplete(@PathVariable(value = "id") final long id) {
        setOrderAsCompleteUseCase.removeOrder(id);
        return CartItem.builder()
                .id(id)
                .build();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_CLIENT", "ROLE_WORKER"})
    @GetMapping("/Categories")
    public List<CategoryDTO> GetCategories() {
        return getCategoriesUseCase.getCategories().getCategories();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @PostMapping("/createMeal")
    public CreateMealResponseDTO createMeal(@RequestBody @Valid CreateMealRequestDTO createMealRequestDTO) {
        return addMealUseCase.createMeal(createMealRequestDTO);
        /*return CreateMealResponseDTO.builder()
                .mealName("jjjj")
                .build();*/
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @PutMapping("/updateMeal")
    public UpdateMealResponseDTO updateMeal(@RequestBody @Valid UpdateMealRequestDTO mealRequest) {
        return updateMealUseCase.updateMeal(mealRequest);
    }
@IsAuthenticated
@RolesAllowed({"ROLE_WORKER"})
@GetMapping("deleteMeal/{id}")
public Meal deleteMeal(@PathVariable int id) {
    return deleteMealUseCase.deleteMeal(id);
}

    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("all")
    public List<CartItemDTO> getOrders() {
        List<CartItemDTO> specificCartItems = new ArrayList<>();
        for(CartItemDTO cartItemDTO: getCartItemsUseCase.getCartItems().getCartItems()) {
                if(cartItemDTO.getApproved().equals("true")) {
                    specificCartItems.add(cartItemDTO);
                }
        }
        return specificCartItems;
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("specificUsers")
    public List<UserDTO> getUsersForOrders() {
        List<UserDTO> specificUsers = new ArrayList<>();
        int userId = 0;
        for(CartItemDTO cartItemDTO: getCartItemsUseCase.getCartItems().getCartItems()) {
            if(cartItemDTO.getApproved().equals("true")) {
                if(userId != cartItemDTO.getUser().getId()) {
                    specificUsers.add(cartItemDTO.getUser());
                    userId = cartItemDTO.getUser().getId();
                }
            }
        }
        return specificUsers;
    }


    @IsAuthenticated
    @RolesAllowed({"ROLE_WORKER"})
    @GetMapping("/approvedAddings")
    public List<AddingCartRelationDTO> GetAdding_Cart_Relation() {
        List<AddingCartRelationDTO> return_List = new ArrayList<>();
        for(AddingCartRelationDTO adding_cart_relation: getAddingCartRelationsDTOUseCase.getAddingCartRelationDTO()) {
            if(adding_cart_relation.getApproved().equals("true")) {

                return_List.add(adding_cart_relation);
            }
        }
        return return_List;
    }
}
