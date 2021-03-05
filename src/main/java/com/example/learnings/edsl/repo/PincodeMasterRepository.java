//package com.example.learnings.edsl.repo;
//
//import java.util.List;
//
//import com.example.learnings.edsl.data.PincodeMaster;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//
//public interface PincodeMasterRepository extends JpaRepository<PincodeMaster,Long> {
//	@Query("Select city from PincodeMaster  where PINCODE=:pincode")
//	String findcity(@Param("pincode") Long pincode);
//
//	@Query("Select networkCity from PincodeMaster  where PINCODE=:pincode")
//	String findnetworkCity(@Param("pincode") Long pincode);
//
//	@Query("Select crmCircle from PincodeMaster  where PINCODE=:pincode")
//	String findcrmCircle(@Param("pincode") Long pincode);
//
//
//	@Query("Select stdCode from PincodeMaster  where PINCODE=:pincode")
//	String findStdCode(@Param("pincode") Long pincode);
//
//	List<PincodeMaster> findByPincode(@Param("pincode") Long pincode);
//
//	List<PincodeMaster> findByCircleId(@Param("circleId")String circleId);
//
//
//	//PincodeMaster findByPincode(@Param("pincode") Long pincode);
//
//
//}
