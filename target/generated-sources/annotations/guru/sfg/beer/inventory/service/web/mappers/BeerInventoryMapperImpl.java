package guru.sfg.beer.inventory.service.web.mappers;

import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.domain.BeerInventory.BeerInventoryBuilder;
import guru.sfg.beer.inventory.service.web.model.BeerInventoryDto;
import guru.sfg.beer.inventory.service.web.model.BeerInventoryDto.BeerInventoryDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-29T08:06:33+0100",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 1.3.1100.v20200828-0941, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class BeerInventoryMapperImpl implements BeerInventoryMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO) {
        if ( beerInventoryDTO == null ) {
            return null;
        }

        BeerInventoryBuilder beerInventory = BeerInventory.builder();

        beerInventory.beerId( beerInventoryDTO.getBeerId() );
        beerInventory.createdDate( dateMapper.asTimestamp( beerInventoryDTO.getCreatedDate() ) );
        beerInventory.id( beerInventoryDTO.getId() );
        beerInventory.lastModifiedDate( dateMapper.asTimestamp( beerInventoryDTO.getLastModifiedDate() ) );
        beerInventory.quantityOnHand( beerInventoryDTO.getQuantityOnHand() );

        return beerInventory.build();
    }

    @Override
    public BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory) {
        if ( beerInventory == null ) {
            return null;
        }

        BeerInventoryDtoBuilder beerInventoryDto = BeerInventoryDto.builder();

        beerInventoryDto.beerId( beerInventory.getBeerId() );
        beerInventoryDto.createdDate( dateMapper.asOffsetDateTime( beerInventory.getCreatedDate() ) );
        beerInventoryDto.id( beerInventory.getId() );
        beerInventoryDto.lastModifiedDate( dateMapper.asOffsetDateTime( beerInventory.getLastModifiedDate() ) );
        beerInventoryDto.quantityOnHand( beerInventory.getQuantityOnHand() );

        return beerInventoryDto.build();
    }
}
