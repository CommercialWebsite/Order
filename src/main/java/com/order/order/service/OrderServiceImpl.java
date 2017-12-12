package com.order.order.service;

import com.order.order.model.OrderAdapter;
import com.order.order.model.OrderDTO;
import com.order.order.model.OrderRepository;
//import com.pachimari.product.ProductEntity;
//import com.pachimari.user.UserAdapter;
//import com.pachimari.user.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final MongoTemplate mongoTemplate;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, MongoTemplate mongoTemplate){
        this.orderRepository = orderRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public OrderDTO addOrder(OrderDTO order) {
        calculateAmountOrder(order);
        orderRepository.save(OrderAdapter.toOrderEntity(order));

        return order;
    }

    @Override
    public List<OrderDTO> getOrders() {
        return OrderAdapter.listToOrderDTO(orderRepository.findAll());
    }

    @Override
    public List<OrderDTO> getUserOrders(String userDTO) {
        return OrderAdapter.listToOrderDTO(orderRepository.findByUser(UserAdapter.toUserEntity(userDTO).getId()));
    }

    @Override
    public OrderDTO getIdOrder(String id) {
        return OrderAdapter.toOrderDTO(orderRepository.findById(id));
    }

    @Override
    public void calculateAmountOrder(OrderDTO orderDTO) {
        double amount = 0;

        for(Double item : orderDTO.getPricies()){
            amount += item;
        }

        orderDTO.setAmount(amount);
    }

}