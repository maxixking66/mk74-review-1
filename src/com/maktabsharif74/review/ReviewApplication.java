package com.maktabsharif74.review;

import com.maktabsharif74.review.util.ApplicationContext;

import java.sql.SQLException;

public class ReviewApplication {

    public static void main(String[] args) throws SQLException {
        System.out.println("start database init");
        ApplicationContext.getDatabaseInitializer().init();
        System.out.println("end database init");


        /*UserRepository userRepository = ApplicationContext.getUserRepository();
        User newUser = userRepository.save(
                new User(
                        null, "mohsen", "asgari", "mat", "123456", 29
                )
        );

        System.out.println(newUser);

        User user = userRepository.getById(newUser.getId());
        System.out.println(user);*/

        System.out.println(ApplicationContext.getUserRepository().countAll());
        ApplicationContext.getUserRepository().deleteById(1L);
        System.out.println(ApplicationContext.getUserRepository().countAll());

    }
}
