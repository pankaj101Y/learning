//package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.common.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
//import org.springframework.data.domain.Persistable;
//
//import javax.persistence.MappedSuperclass;
//import javax.persistence.metamodel.StaticMetamodel;
//import java.io.Serializable;
//
///**
// * The Base Model class of all the entity classes: AbstractBaseEntity.
// *
// * @param <T>
// */
//@MappedSuperclass
//@StaticMetamodel(AbstractBaseEntity.class)
//public abstract class AbstractBaseEntity<T extends Serializable> implements Persistable<T> {
//
//	private static final long serialVersionUID = -310573247842361598L;
//
//	@Override
//	@JsonIgnore
//	public boolean isNew() {
//		return null == this.getId();
//	}
//
//	@Override
//	public String toString() {
//		String strObj = ReflectionToStringBuilder.toString(this);
//		return strObj;
//	}
//
//}
