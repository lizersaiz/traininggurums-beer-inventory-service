package guru.sfg.beer.inventory.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import guru.sfg.common.events.BeerDto;
import guru.sfg.common.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryListener {

	BeerInventoryRepository beerInventoryRepository; 
	
	@Autowired
	public InventoryListener(BeerInventoryRepository repository) {
		
		this.beerInventoryRepository = repository;
	}
	
	@JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
	public void listen(NewInventoryEvent newInventoryEvent) {
		
		log.debug("Got inventory " + newInventoryEvent.toString());
		
		BeerDto beerDto = newInventoryEvent.getBeerDto();
		BeerInventory beerInventory = BeerInventory.builder()
				.beerId(beerDto.getId())
				.upc(beerDto.getUpc())
				.quantityOnHand(beerDto.getQuantityOnHand())
				.build();

		beerInventoryRepository.save(beerInventory);
	}
}
