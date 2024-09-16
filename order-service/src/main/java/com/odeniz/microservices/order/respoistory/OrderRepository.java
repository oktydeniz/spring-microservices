package com.odeniz.microservices.order.respoistory;

import com.odeniz.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
