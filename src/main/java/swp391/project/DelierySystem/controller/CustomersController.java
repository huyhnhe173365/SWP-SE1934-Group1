package swp391.project.DelierySystem.controller;

import swp391.project.DelierySystem.dto.CustomersDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import swp391.project.DelierySystem.service.CustomersService;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    private CustomersService customersService;

    //Build your create APIs here
    @PostMapping
    private ResponseEntity<CustomersDTO> createCustomers(@RequestBody CustomersDTO customersdto) {
        CustomersDTO savedCustomers = customersService.createCustomers(customersdto);
        return new ResponseEntity<>(savedCustomers, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomersDTO> getCustomersById(@PathVariable("id") Long CustomersId) {
        CustomersDTO customersdto = customersService.getCustomersById(CustomersId);
        return ResponseEntity.ok(customersdto);
    }

    @GetMapping
    public ResponseEntity<List<CustomersDTO>> getAllCustomers() {
        List<CustomersDTO> customers = customersService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomersDTO> updateCustomers(@PathVariable("id") Long CustomersId, @RequestBody CustomersDTO updatedCustomers) {
        CustomersDTO customersdto = customersService.updateCustomers(CustomersId, updatedCustomers);
        return ResponseEntity.ok(customersdto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomers(@PathVariable("id") Long CustomersId) {
        customersService.deleteCustomers(CustomersId);
        return ResponseEntity.ok("Customers deleted successfully");
    }
}
