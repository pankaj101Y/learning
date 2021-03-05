//package com.example.learnings.edsl.data;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//
//@Entity
//@Table(name = "APPLICATION_PROPERTY")
//public class ApplicationProperty extends AbstractAuditableBaseEntity implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name = "PROPERTY_ID")
//	private Long id;
//
//	@Column(name = "KEY")
//	private String key;
//
//	@Column(name = "VALUE")
//	private String value;
//
//	@Override
//	public Long getId() {
//		return this.id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getKey() {
//		return key;
//	}
//
//	public void setKey(String key) {
//		this.key = key;
//	}
//
//	public String getValue() {
//		return value;
//	}
//
//	public void setValue(String value) {
//		this.value = value;
//	}
//
//}
