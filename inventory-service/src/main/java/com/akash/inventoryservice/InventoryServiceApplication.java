package com.akash.inventoryservice;

import com.akash.inventoryservice.model.Inventory;
import com.akash.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(100);

			Inventory inventoryOne = new Inventory();
			inventoryOne.setSkuCode("iphone_13_red");
			inventoryOne.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventoryOne);
		};
	}

}
