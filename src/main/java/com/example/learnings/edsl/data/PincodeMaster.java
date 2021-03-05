//package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.common.entity;
//
//import lombok.Data;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "PINCODE_MASTER")
//@Data
//public class PincodeMaster extends AbstractAuditableBaseEntity implements Serializable {
//
//
//	private static final long serialVersionUID = -2319508337893781233L;
//
//
//	@Column(name = "ID")
//	private Long id;
//
//	@Id
//	@Column(name = "PINCODE")
//	private Long pincode;
//
//	@Column(name = "CIRCLE")
//	private String circle;
//
//	@Column(name = "CIRCLE_ID")
//	private String circleId;
//
//	@Column(name = "CITY")
//	private String city;
//
//	@Column(name = "STATE")
//	private String state;
//
//	@Column(name = "STDCODE")
//	private String stdCode;
//
//	@Column(name = "NMS_CITY")
//	private String nmsCity;
//
//	@Column(name = "NETWORK_CITY")
//	private String networkCity;
//
//	@Column(name = "TM_CIRCLE")
//	private String crmCircle;
//
//
//	@Column(name = "GST_STATE_CODE")
//	private String gstStateCode;
//
//	@Override
//	public Long getId() {
//		return this.id;
//	}
//
//
//}
