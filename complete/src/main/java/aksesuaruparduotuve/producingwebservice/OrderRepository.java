package aksesuaruparduotuve.producingwebservice;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Order;
import io.spring.guides.gs_producing_web_service.Courier;
import io.spring.guides.gs_producing_web_service.Category;
import io.spring.guides.gs_producing_web_service.OrderItem;
import io.spring.guides.gs_producing_web_service.Product;
import io.spring.guides.gs_producing_web_service.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class OrderRepository {
    private static final Map<Integer, Order> orders = new HashMap<>();

    @PostConstruct
    public void initData() {
        Order order1 = new Order();
        Courier courier1 = new Courier();
        courier1.setId(1);
        courier1.setCourierName("Peter");
        courier1.setCourierLastName("Hanses");
        courier1.setCourierphoneNumber("+123 123 123");
        User user1 = new User();
        user1.setId(1);
        user1.setUserEmail("test@mail.com");
        user1.setUserName("Bob");
        user1.setUserPassword("password");
        user1.setIsAdmin(false);
        order1.setCourier(courier1);
        order1.setOrderAddress("Vilnius, Lithuania");
        order1.setUser(user1);
        List<OrderItem> listOrderItems = order1.getOrderItems();
        Category category1 = new Category();
        category1.setId(1);
        category1.setCategoryName("Category1");
        Product product1 = new Product();
        product1.setId(1);
        product1.setCategory(category1);
        product1.setProductName("PhoneCase");
        product1.setPrice(500);;
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setId(1);
        orderItem1.setOrderItemQuantity(22);
        orderItem1.setProduct(product1);
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setId(2);
        orderItem2.setOrderItemQuantity(1);
        orderItem2.setProduct(product1);
        listOrderItems.add(orderItem1);
        listOrderItems.add(orderItem2);


        orders.put(order1.getId(), order1);

//        countries.put(spain.getName(), spain);
//
//        Order poland = new Order();
//        poland.setName("Poland");
//        poland.setCapital("Warsaw");
//        poland.setCurrency(Currency.PLN);
//        poland.setPopulation(38186860);
//
//        countries.put(poland.getName(), poland);
//
//        Order uk = new Order();
//        uk.setName("United Kingdom");
//        uk.setCapital("London");
//        uk.setCurrency(Currency.GBP);
//        uk.setPopulation(63705000);
//
//        countries.put(uk.getName(), uk);
    }

    public Order findOrder(Integer id) {
        Assert.notNull(id, "The order id must not be null");
        return orders.get(id);
    }
}
