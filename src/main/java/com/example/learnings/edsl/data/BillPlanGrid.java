package com.example.learnings.edsl.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BILL_PLAN_GRID")
public class BillPlanGrid implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7979447764013632199L;
	
	@Id
	@Column(name = "MIN_DISTANCE")
	private int minDistance;

	@Column(name = "MAX_DISTANCE")
	private int maxDistance;
	
	@Column(name = "VDSL_SPEED")
	private int vdslSpeed;
	
	@Column(name = "ADSL_SPEED")
	private int adslSpeed;
	
	public int getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(int minDistance) {
		this.minDistance = minDistance;
	}

	public int getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}

	public int getVdslSpeed() {
		return vdslSpeed;
	}

	public void setVdslSpeed(int vdslSpeed) {
		this.vdslSpeed = vdslSpeed;
	}

	public int getAdslSpeed() {
		return adslSpeed;
	}

	public void setAdslSpeed(int adslSpeed) {
		this.adslSpeed = adslSpeed;
	}

}
