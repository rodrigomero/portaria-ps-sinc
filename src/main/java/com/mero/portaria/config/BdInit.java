package com.mero.portaria.config;

import com.mero.portaria.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
public class BdInit {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductOrdersRepository productOrdersRepository;

//    @Bean
//    public Boolean startDB() {
//        User user1 = new User(null, "rodrigo", "123", "meroo@gmail.com", true, null);
//        User user2 = new User(null, "rodrigo2", "123", "meroo@gmail.com", false, null);
//        User user3 = new User(null, "rodrigo3", "123", "meroo@gmail.com", true, null);
//        usersRepository.save(user1);
//        usersRepository.save(user2);
//        usersRepository.save(user3);
//
//        Company product1 = new Company(null, "Guitarra", "descricao", CategoryEnum.INSTRUMENTO, BigDecimal.TEN, 10, true, null);
//        Company product2 = new Company(null, "Afinador", "descricao", CategoryEnum.ACESSORIO, BigDecimal.TEN, 10, true, null);
//        Company product3 = new Company(null, "Marshall", "descricao", CategoryEnum.AMPLIFICADOR, BigDecimal.TEN, 10, true, null);
//        Company product4 = new Company(null, "Invisivel", "descricao", CategoryEnum.INSTRUMENTO, BigDecimal.TEN, 10, false, null);
//        Company product5 = new Company(null, "Guitarra4", "descricao", CategoryEnum.INSTRUMENTO, BigDecimal.TEN, 10, true, null);
//        Company product6 = new Company(null, "Guitarra4", "descricao", CategoryEnum.INSTRUMENTO, BigDecimal.TEN, 10, true, null);
//        productsRepository.save(product1);
//        productsRepository.save(product2);
//        productsRepository.save(product3);
//        productsRepository.save(product4);
//        productsRepository.save(product5);
//        productsRepository.save(product6);
//
//        Order order = new Order(null, user1.getId(), LocalDateTime.now(), StatusOrderEnum.CONFIRMADO,2, BigDecimal.valueOf(20), null, null );
//        ordersRepository.save(order);
//
//        ProductOrder productOrder1 = new ProductOrder(null, 2, BigDecimal.valueOf(20), product1.getId(), order.getId(), null, null);
//        productOrdersRepository.save(productOrder1);
//
//        return Boolean.TRUE;
//    }
}