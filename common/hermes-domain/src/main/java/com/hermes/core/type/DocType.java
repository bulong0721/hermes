package com.hermes.core.type;

public enum DocType {
    New(0, "NEW", "** New **"),
    AR_Invoice(116, "ARI", "AR Invoice"),
    AR_Receipt(119, "ARR", "AR Receipt"),
    AP_Invoice(123, "API", "AP Invoice"),
    AP_Payment(125, "APP", "AP Payment"),
    Standard_Order(132, "SOO", "Standard Order"),
    Purchase_Order(126, "POO", "Purchase Order"),
    Payment_Allocation(137, "CMA", "Payment Allocation"),
    Cash_Journal(141, "CMC", "Cash Journal"),
    Transfer_Movement(110, "TM", "Transfer Movement"),
    Pickup_Movement(111, "PM", "Pickup Movement"),
    Delivery_Movement(112, "DM", "Delivery Movement");

    private int    docTypeID;
    private String baseType;
    private String description;

    private DocType(int docTypeID, String baseType, String description) {
        this.docTypeID = docTypeID;
        this.baseType = baseType;
        this.description = description;
    }

    public static DocType fromDocType(int value) {
        for (DocType item : values()) {
            if (item.docTypeID == value) {
                return item;
            }
        }
        return New;
    }

    public int getDocTypeID() {
        return docTypeID;
    }

    public String getBaseType() {
        return baseType;
    }

    public String getDescription() {
        return description;
    }

}
