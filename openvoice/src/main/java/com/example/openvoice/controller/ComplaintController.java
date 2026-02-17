package com.example.openvoice.controller;

import com.example.openvoice.entity.Complaint;
import com.example.openvoice.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "http://localhost:3000")
public class ComplaintController {

    private final ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    @PostMapping
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return service.createComplaint(complaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return service.getAllComplaints();
    }

    @PutMapping("/{id}/escalate")
    public Complaint escalate(@PathVariable Long id) {
        return service.escalateComplaint(id);
    }

    @PutMapping("/{id}/resolve")
    public Complaint resolve(@PathVariable Long id) {
        return service.resolveComplaint(id);
    }
}
