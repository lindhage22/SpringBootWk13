package pet.store.entity;

import java.util.Set;

import jakarta.persistence.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.HashSet;

@Entity 
@Data

public class Customer {

	 
	@Id
	@GeneratedValue 
	 private Long customerId;
	 private String customerFristName;
	 private String customerLastName;
	 private String customerEmail;
	
	 @EqualsAndHashCode.Exclude
	 @ToString.Exclude
	 @ManyToMany(mappedBy = "customers", cascade =CascadeType.PERSIST)
	 private Set<PetStore> petStores = new HashSet<>();
	 
	 
	 
	 
}
