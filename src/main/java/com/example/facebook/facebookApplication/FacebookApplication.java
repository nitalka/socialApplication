package com.example.facebook.facebookApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableJpaRepositories(basePackages = "com/example/facebook/facebookApplication/Repository")
@SpringBootApplication /*(exclude={DataSourceAutoConfiguration.class}) */
@EnableSwagger2
public class FacebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacebookApplication.class, args);
	}

}


//test ------
//	myset------
//					mybin        mybin2
//		mykey ->   mybinBalue    faifaignag
//					ndanda       ianifna
//		myKey1 -> 	kfamska		kfnkanfak
//
//					mylike
//		myKey3 -> 	[aa, aa, aa, a]