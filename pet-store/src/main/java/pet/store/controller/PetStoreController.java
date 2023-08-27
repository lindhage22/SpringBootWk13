package pet.store.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pet.store.conroller.model.PetStoreData;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {

	@Autowired
	PetStoreService petStoreService;
	
	@PostMapping("/petstore")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData createPetStore(@RequestBody 
			PetStoreData petStoreData) {
		log.info("Creating store {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}

	@PutMapping("/petstore/{petStoreId}")
	public PetStoreData updatePetStore(@PathVariable Long petStoreId, 
			@RequestBody PetStoreData petStoreData) {
		petStoreData.setPetStoreId(petStoreId);
		log.info("Updating pet store {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}

	@GetMapping("/petstore")
	public List<PetStoreData> listAllPetStores() {
		log.info("Listing all pet stores");
		return petStoreService.retrieveAllPetStores();
	}

	@GetMapping("/petstore/{petStoreId}")
	public PetStoreData returnPetStoreById(@PathVariable 
			Long petStoreId) {
		log.info("Retrieving pet store with ID={}", petStoreId);
		return petStoreService.returnPetStoreById(petStoreId);
	}

	@DeleteMapping("/petstore/{petStoreId}")
	public Map<String, String> deletePetStoreById(
			@PathVariable Long petStoreId) {
		log.info("Deleting pet store with ID={}", petStoreId);
		
		petStoreService.deletePetStoreById(petStoreId);
		
		return Map.of("message", "Successfully deleted pet store with ID=" + petStoreId);
	}

}
