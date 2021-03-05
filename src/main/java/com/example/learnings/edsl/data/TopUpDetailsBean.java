package com.example.learnings.edsl.data;


import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TopUpDetailsBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
    Double amount;
    String schemeId;
    Boolean isSelected;
}
