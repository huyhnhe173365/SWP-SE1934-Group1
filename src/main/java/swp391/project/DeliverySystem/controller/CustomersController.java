package swp391.project.DeliverySystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import swp391.project.DeliverySystem.dto.CustomersDTO;
import swp391.project.DeliverySystem.dto.LoginDTO;
import swp391.project.DeliverySystem.service.CustomersService;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomersController {
    private CustomersService customersService;

    @PostMapping("/register")
    public ResponseEntity<CustomersDTO> register(@RequestBody CustomersDTO customersDTO) {
        CustomersDTO savedCustomers = customersService.createCustomers(customersDTO);
        return new ResponseEntity<>(savedCustomers, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Map<String, Object> response = customersService.login(loginDTO);
        return ResponseEntity.ok(response);
    }

    //Build your create APIs here
    @PostMapping
    public ResponseEntity<CustomersDTO> createCustomers(@RequestBody CustomersDTO customersDTO) {
        CustomersDTO savedCustomers = customersService.createCustomers(customersDTO);
        return new ResponseEntity<>(savedCustomers, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomersDTO> getCustomersById(@PathVariable("id") Long CustomersId) {
        CustomersDTO customersDTO = customersService.getCustomersById(CustomersId);
        return ResponseEntity.ok(customersDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomersDTO>> getAllCustomers() {
        List<CustomersDTO> customers = customersService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomersDTO> updateCustomers(@PathVariable("id") Long CustomersId, @RequestBody CustomersDTO updatedCustomers) {
        CustomersDTO customersDTO = customersService.updateCustomers(CustomersId, updatedCustomers);
        return ResponseEntity.ok(customersDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomers(@PathVariable("id") Long CustomersId) {
        customersService.deleteCustomers(CustomersId);
        return ResponseEntity.ok("Customers deleted successfully");
    }
    
}
