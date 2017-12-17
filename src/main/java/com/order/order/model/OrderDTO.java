package com.order.order.model;

//import com.order.product.ProductEntity;
//import com.pachimari.user.User;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"user", "items"})
@ToString(exclude = "user")
@Getter
@Setter
public class OrderDTO {
    private String id;

    @NotNull
    private String user;

    @NotNull
    private HashMap<String, Double> items = new HashMap<>();
//ip prod , prix
    private double amount;

}
