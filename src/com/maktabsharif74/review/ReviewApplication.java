package com.maktabsharif74.review;

import com.maktabsharif74.review.util.ApplicationContext;

public class ReviewApplication {

    public static void main(String[] args) {
        System.out.println("start main");
        ApplicationContext.getDatabaseInitializer().init();
        System.out.println("end main");
    }
}
