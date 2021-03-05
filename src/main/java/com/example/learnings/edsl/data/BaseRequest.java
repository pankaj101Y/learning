package com.example.learnings.edsl.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Getter
@Setter
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = -5401994280929167622L;

    private String customerIdentifier;

    private String appName;

    private String uniqueTxId;

    private String versionId;

}
