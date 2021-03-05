package com.example.learnings.edsl.data;

import java.io.Serializable;

public class ProductSpecification implements Serializable{

    private String dbpFlagValue;

    private ProductSpecCharacteristic productSpecCharacteristic;

    public ProductSpecCharacteristic getProductSpecCharacteristic() {
        return productSpecCharacteristic;
    }

    public void setProductSpecCharacteristic(ProductSpecCharacteristic productSpecCharacteristic) {

        this.productSpecCharacteristic=productSpecCharacteristic;
    }


    public String getDbpFlagValue() {
        return dbpFlagValue;
    }

    public void setDbpFlagValue(String dbpFlagValue) {
        this.dbpFlagValue = dbpFlagValue;
    }


    public class ProductSpecCharacteristic implements Serializable
    {
        private String name;

        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this. name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }


    }

}
