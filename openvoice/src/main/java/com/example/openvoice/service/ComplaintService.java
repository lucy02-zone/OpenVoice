package com.example.openvoice.service;

import com.example.openvoice.entity.Complaint;
import com.example.openvoice.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository repository;

    public ComplaintService(ComplaintRepository repository) {
        this.repository = repository;
    }

    public Complaint createComplaint(Complaint complaint) {
        return repository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return repository.findAll();
    }

    public Complaint escalateComplaint(Long id) {
        Complaint complaint = repository.findById(id).orElseThrow();

        if (complaint.getLevel().equals("MENTOR")) {
            complaint.setLevel("HOD");
        } else if (complaint.getLevel().equals("HOD")) {
            complaint.setLevel("PRINCIPAL");
        }

        complaint.setStatus("IN_PROGRESS");

        return repository.save(complaint);
    }

    public Complaint resolveComplaint(Long id) {
        Complaint complaint = repository.findById(id).orElseThrow();
        complaint.setStatus("RESOLVED");
        return repository.save(complaint);
    }
}
