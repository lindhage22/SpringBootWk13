package pet.store.entity;


import java.util.HashSet;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Set; 

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private Long   employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeEmail;
	private String employeeJobTitle;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	
	
	@ManyToOne(cascade = CascadeType.ALL)

	
	@JoinColumn(name = "pet_store_id")
	private Set <PetStore> petStore = new HashSet<>();
	
}
