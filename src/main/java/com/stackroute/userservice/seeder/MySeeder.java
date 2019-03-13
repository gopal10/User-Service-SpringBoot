package com.stackroute.userservice.seeder;


import com.stackroute.userservice.domain.Restaurant;
import com.stackroute.userservice.service.RestaurantService;
import com.stackroute.userservice.userexception.UserAlreadyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MySeeder implements ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

    @Autowired
    RestaurantService restaurantService;

    public MySeeder(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public RestaurantService getRestaurantService() {
        return restaurantService;
    }

    public void setRestaurantService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Value("${name1}")
    String name1;

    @Value("${location1}")
    String location1;

    @Value("${image1}")
    String image1;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Restaurant restaurant= new Restaurant(0,name1, location1, image1);
        try {
            restaurantService.savedata(restaurant);
        } catch (UserAlreadyException e) {
            e.printStackTrace();
        }
    }

    @Value("${name}")
    String name;

    @Value("${location}")
    String location;

    @Value("${image}")
    String image;

    @Override
    public void run(String... args) throws Exception {
        Restaurant restaurant= new Restaurant(0,name, location, image);
        try {
            restaurantService.savedata(restaurant);
        } catch (UserAlreadyException e) {
            e.printStackTrace();
        }
    }
}
