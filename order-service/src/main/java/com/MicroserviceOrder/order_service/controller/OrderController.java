package com.MicroserviceOrder.order_service.controller;

import com.MicroserviceOrder.order_service.dto.OrderResponseDto;
import com.MicroserviceOrder.order_service.dto.ProductDto;
import com.MicroserviceOrder.order_service.entity.Order;
import com.MicroserviceOrder.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
// base url//
@RequestMapping("/orders")
public class OrderController {
    //Automatic injection//
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WebClient.Builder webClientBuilder
    ;
    //create a method to place order//
    @PostMapping("/placeOrder")
    public Mono<ResponseEntity<OrderResponseDto>>placeOrder(@RequestBody Order order){
        //fetching the product details from product service//
        return webClientBuilder.build().get().uri("http://localhost:8082"+order.getProductId()).
                retrieve()
                .bodyToMono(ProductDto.class).map(productDto -> {
                    OrderResponseDto responseDto=new OrderResponseDto();
                    responseDto.setOrderId( order.getOrderId());
                    responseDto.setProductId(order.getProductId());

                    //set product details
                    responseDto.setProductName(productDto.getName());
                    responseDto.setProductPrize(productDto.getPrice());
                    responseDto.setTotalPrize(order.getQuantity()*productDto.getPrice());
                    //save this to db
                    orderRepository.save(order);
                    return  ResponseEntity.ok(responseDto);

                });

        }
        //get all orders from db or get na we use this//
    @GetMapping
    public List<Order>getAllOrder(){
        return orderRepository.findAll();

    }


}
