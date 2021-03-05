//package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.common.entity;
//
//import java.util.Calendar;
//
//import javax.persistence.Column;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.metamodel.StaticMetamodel;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.apache.commons.lang3.time.DateUtils;
//
//
///**
// * The Class AuditableEntity is the base class for all the entities with
// * auditing properties.
// */
//@MappedSuperclass
//@StaticMetamodel(AbstractAuditableBaseEntity.class)
//public abstract class AbstractAuditableBaseEntity extends AbstractBaseEntity {
//
//	private static final long serialVersionUID = -2130827758358384837L;
//
//	/** The created date. */
//	@Column(name = "CREATED_ON", updatable = false)
//	private Calendar createdDate;
//
//	/** The created user. */
//	@Column(name = "CREATED_BY", updatable = false)
//	private String createdBy;
//
//	/** The modified date. */
//	@Column(name = "MODIFIED_ON")
//	private Calendar modifiedDate;
//
//	/** The modified user. */
//	@Column(name = "MODIFIED_BY")
//	private String modifiedBy;
//
//	/**
//	 * Instantiates a new auditable base entity.
//	 */
//	public AbstractAuditableBaseEntity() {
//		super();
//	}
//
//	/**
//	 * Instantiates a new auditable base entity.
//	 *
//	 * @param createdDate
//	 *            the created date
//	 */
//	public AbstractAuditableBaseEntity(final Calendar createdDate) {
//		super();
//		this.createdDate = createdDate;
//	}
//
//	/**
//	 * Initializes the {@link #id}, {@link #createdDate}, {@link #createdBy},
//	 * {@link #modifiedDate} and {@link #modifiedBy} attributes before a new
//	 * business object is persisted.
//	 */
//	@PrePersist
//	protected void prePersist() {
//		this.createdDate = DateUtils.round(Calendar.getInstance(), Calendar.SECOND);
//
//		this.modifiedDate = this.createdDate;
//		this.modifiedBy = this.createdBy;
//	}
//
//	/**
//	 * Initializes the {@link #modifiedDate} and {@link #modifiedBy} attributes
//	 * before an existing business object is persisted.
//	 */
//	@PreUpdate
//	protected void preUpdate() {
//
//		this.modifiedDate = DateUtils.round(Calendar.getInstance(), Calendar.SECOND);
//
//	}
//
//	/**
//	 * @return the createdDate
//	 */
//	@JsonIgnore
//	public Calendar getCreatedDate() {
//		return this.createdDate;
//	}
//
//	/**
//	 * @param createdDate
//	 *            the createdDate to set
//	 */
//	public void setCreatedDate(final Calendar createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	/**
//	 * @return the createdBy
//	 */
//	@JsonIgnore
//	public String getCreatedBy() {
//		return this.createdBy;
//	}
//
//	/**
//	 * @param createdBy
//	 *            the createdBy to set
//	 */
//	public void setCreatedBy(final String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	/**
//	 * @return the modifiedDate
//	 */
//	public Calendar getModifiedDate() {
//		return this.modifiedDate;
//	}
//
//	/**
//	 * @param modifiedDate
//	 *            the modifiedDate to set
//	 */
//	public void setModifiedDate(final Calendar modifiedDate) {
//		this.modifiedDate = modifiedDate;
//	}
//
//	/**
//	 * @return the modifiedBy
//	 */
//	public String getModifiedBy() {
//		return this.modifiedBy;
//	}
//
//	/**
//	 * @param modifiedBy
//	 *            the modifiedBy to set
//	 */
//	public void setModifiedBy(final String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
//}
