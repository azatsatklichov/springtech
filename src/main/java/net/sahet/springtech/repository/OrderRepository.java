package net.sahet.springtech.repository;

import org.springframework.data.repository.CrudRepository;

import net.sahet.springtech.domain.Order;
 

public interface OrderRepository 
         extends CrudRepository<Order, Long> {

}
