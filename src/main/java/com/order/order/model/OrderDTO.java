package com.order.order.model;

//import com.order.product.ProductEntity;
//import com.pachimari.user.User;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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
    private List<String> items = new ArrayList<>(0);

    @NotNull
    private List<Double> pricies = new ArrayList<>(0);

    private double amount;
}
