//package com.CentralLink.admin.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.CentralLink.admin.entity.ServiceEntity;
//import com.CentralLink.admin.service.ServiceService;
//
//@RestController
//@RequestMapping("/api/admin/services")
//public class ServiceController {
//	@Autowired
//    private ServiceService serviceService;
//
//	@PostMapping
//    public ResponseEntity<ServiceEntity> createService(
//            @RequestParam String name,
//            @RequestParam String description,
//            @RequestParam String category,
//            @RequestParam(value = "imageFile", required = false) String imageFile) {
//
//        ServiceEntity serviceEntity = serviceService.createService(name, description, category, imageFile);
//        return new ResponseEntity<>(serviceEntity, HttpStatus.CREATED);
//    }
//
//    // Update an existing service
//    @PutMapping("/{id}")
//    public ResponseEntity<ServiceEntity> updateService(
//            @PathVariable Long id,
//            @RequestParam String name,
//            @RequestParam String description,
//            @RequestParam String category,
//            @RequestParam(value = "imageFile", required = false) String imageFile) {
//
//        ServiceEntity serviceEntity = serviceService.updateService(id, name, description, category, imageFile);
//        return new ResponseEntity<>(serviceEntity, HttpStatus.OK);
//    }
//
//    // Delete a service
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
//        serviceService.deleteService(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Get all services
//    @GetMapping
//    public ResponseEntity<List<ServiceEntity>> getAllServices() {
//        List<ServiceEntity> services = serviceService.getAllServices();
//        return new ResponseEntity<>(services, HttpStatus.OK);
//    }
//
//    // Get services by category
//    @GetMapping("/category/{category}")
//    public ResponseEntity<List<ServiceEntity>> getServicesByCategory(@PathVariable String category) {
//        List<ServiceEntity> services = serviceService.getServicesByCategory(category);
//        return new ResponseEntity<>(services, HttpStatus.OK);
//    }
//
//    // Get a service by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ServiceEntity> getServiceById(@PathVariable Long id) {
//        ServiceEntity serviceEntity = serviceService.getServiceById(id);
//        return new ResponseEntity<>(serviceEntity, HttpStatus.OK);
//    }
//    
//}
