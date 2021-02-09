package guru.sfg.common.events;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto implements Serializable {

	/**
	 * Serialization added as another level of protection
	 */
	private static final long serialVersionUID = 1244279750057507484L;

	@Null
	private UUID id;
	
	@Null
	private Integer version;
	
	@Null
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = Shape.STRING)
	private OffsetDateTime createdDate;
	
	@Null
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = Shape.STRING)
	private OffsetDateTime lastModifiedDate;
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String beerName;
	
	@NotNull
	private BeerStyleEnum beerStyle;

	@NotNull
	private String upc;

	@Positive
	@NotNull
	@JsonFormat(shape = Shape.STRING)
	private BigDecimal price;
	
	@Positive
	private Integer quantityOnHand;
}
