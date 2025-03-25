package com.example.masterlist;

import org.springframework.boot.SpringApplication;

public class TestMasterlistApplication {

	public static void main(String[] args) {
		SpringApplication.from(MasterlistApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
