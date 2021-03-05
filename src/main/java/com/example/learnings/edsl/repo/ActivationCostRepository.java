package com.example.learnings.edsl.repo;


import com.example.learnings.edsl.data.ActivationCost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivationCostRepository extends JpaRepository<ActivationCost,Long> {

    List<ActivationCost> findByPincode(String pincode);

    ActivationCost findByPincodeAndType(String pincode, String type);
}
