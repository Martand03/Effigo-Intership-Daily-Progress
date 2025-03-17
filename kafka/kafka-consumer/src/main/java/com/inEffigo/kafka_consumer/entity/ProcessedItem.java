package com.inEffigo.kafka_consumer.entity;

import com.inffigo.common.model.MasterItemCommon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "processed_item", schema = "kafka")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessedItem {

    @Id
    @Column(name = "item_id")
    private String itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "item_category_id")
    private String itemCategoryId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "item_category_name")
    private String itemCategoryName;

    @Column(name = "sub_category_name")
    private String subCategoryName;

    @Column(name = "columnitem_code")
    private String columnItemCode;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "estimated_price")
    private BigDecimal estimatedPrice;

    @Column(name = "uom")
    private String uom;

    @Column(name = "type")
    private String type;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    @Column(name = "gl_code")
    private String glCode;

    @Column(name = "hsn_code")
    private String hsnCode;

    @Column(name = "item_sub_category_id")
    private String itemSubCategoryId;

    @Column(name = "lead_buyer_id")
    private String leadBuyerId;

    @Column(name = "generic_masters")
    private Integer genericMasters;

    @Column(name = "masters_type")
    private Integer mastersType;

    @Column(name = "quality")
    private Integer quality;

    @Column(name = "quality_assurance")
    private Boolean qualityAssurance;

    @Column(name = "l3_category_id")
    private String l3CategoryId;

    @Column(name = "generic_item")
    private Boolean genericItem;

    @Column(name = "cus_field_1")
    private String cusField1;

    @Column(name = "cus_field_2")
    private String cusField2;

    @Column(name = "cus_field_3")
    private String cusField3;

    @Column(name = "cus_field_4")
    private String cusField4;

    @Column(name = "cus_field_5")
    private String cusField5;

    @Column(name = "cus_field_6")
    private String cusField6;

    @Column(name = "cus_field_7")
    private String cusField7;

    @Column(name = "cus_field_8")
    private String cusField8;

    @Column(name = "cus_field_9")
    private String cusField9;

    @Column(name = "cus_field_10")
    private String cusField10;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "long_text")
    private String longText;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "partition_group")
    private String partitionGroup;

    @Column(name = "sub_category")
    private String subCategory;
}

