package com.hermes.pickup.domain;

import com.hermes.client.domain.Org;
import com.hermes.core.GenericEntity;
import com.hermes.customer.domain.Customer;
import com.hermes.partner.domain.BPartner;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "LOG_ORDER")
public class Order extends GenericEntity<Long, Order> {

    @Id
    @Column(name = "ORDER_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ORDER_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @ManyToOne(targetEntity = BPartner.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSIGNEE_BPARTNER_ID", referencedColumnName = "BPARTNER_ID")
    private BPartner consigneeBPartner;

    @ManyToOne(targetEntity = BPartner.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSIGNOR_BPARTNER_ID", referencedColumnName = "BPARTNER_ID")
    private BPartner consignorBPartner;

    @ManyToOne(targetEntity = BPartner.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHIPPER_BPARTNER_ID", referencedColumnName = "BPARTNER_ID")
    private BPartner shipperBPartner;

    @ManyToOne(targetEntity = Org.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTURE_ORG_ID", referencedColumnName = "ORG_ID")
    private Org departureOrg;

    @ManyToOne(targetEntity = Org.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ARRIVAL_ORG_ID", referencedColumnName = "ORG_ID")
    private Long arrivalOrg;

    @ManyToOne(targetEntity = Customer.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER1_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer user1;

    @ManyToOne(targetEntity = Customer.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER2_ID", referencedColumnName = "CUSTOMER_ID")
    private Long user2;

    @OneToOne(targetEntity = Invoice.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID", referencedColumnName = "INVOICE_ID")
    private Invoice invoice;

    @Column(name = "RECEIPT_COPIES")
    private Integer receiptCopies;

    @Column(name = "TOTAL_CHARGE")
    private BigDecimal totalCharge;

    @Column(name = "CHARGE_ADDITIONAL")
    private BigDecimal chargeAdditional;

    @Column(name = "CHARGE_DELIVERY")
    private BigDecimal chargeDelivery;

    @Column(name = "CHARGE_DOCK")
    private BigDecimal chargeDock;

    @Column(name = "CHARGE_INSURANCE")
    private BigDecimal chargeInsurance;

    @Column(name = "CHARGE_PACKAGE")
    private BigDecimal chargePackage;

    @Column(name = "CHARGE_PICKUP")
    private BigDecimal chargePickup;

    @Column(name = "CHARGE_STORE")
    private BigDecimal chargeStore;

    @Column(name = "CHARGE_FREIGHT")
    private BigDecimal chargeFreight;

    @Column(name = "INSURANCE_LIMIT")
    private BigDecimal insuranceLimit;

    @Column(name = "PAID_CONSIGNEE")
    private BigDecimal paidConsignee;

    @Column(name = "PAID_CONSIGNOR")
    private BigDecimal paidConsignor;

    @Column(name = "PAID_MONTHLY")
    private BigDecimal paidMonthly;

    @Column(name = "PAID_RECEIPT")
    private BigDecimal paidReceipt;

    @Column(name = "COST_ADDITIONAL")
    private BigDecimal costAdditional;

    @Column(name = "COST_CLAIM")
    private BigDecimal costClaim;

    @Column(name = "COST_COMMISSION")
    private BigDecimal costCommission;

    @Column(name = "DELIVERY")
    private boolean delivery = false;

    @Column(name = "PICKUP")
    private boolean pickup = false;

    @Column(name = "PICKUPED")
    private boolean pickuped = false;

    @Column(name = "SOTRX")
    private boolean sotrx = false;

    @Column(name = "COMMENT", length = 60)
    private String comment;

    @Column(name = "COMMENT_RECEIPT", length = 10)
    private String commentReceipt;

    @Column(name = "PAYMENT_RULE", length = 10)
    private String paymentRule;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_ORDERED")
    private Date dateOrdered;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_PROMISE")
    private Date datePromise;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "order")
    private List<OrderLine> lines;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public BPartner getConsigneeBPartner() {
        return consigneeBPartner;
    }

    public void setConsigneeBPartner(BPartner consigneeBPartner) {
        this.consigneeBPartner = consigneeBPartner;
    }

    public BPartner getConsignorBPartner() {
        return consignorBPartner;
    }

    public void setConsignorBPartner(BPartner consignorBPartner) {
        this.consignorBPartner = consignorBPartner;
    }

    public BPartner getShipperBPartner() {
        return shipperBPartner;
    }

    public void setShipperBPartner(BPartner shipperBPartner) {
        this.shipperBPartner = shipperBPartner;
    }

    public Org getDepartureOrg() {
        return departureOrg;
    }

    public void setDepartureOrg(Org departureOrg) {
        this.departureOrg = departureOrg;
    }

    public Long getArrivalOrg() {
        return arrivalOrg;
    }

    public void setArrivalOrg(Long arrivalOrg) {
        this.arrivalOrg = arrivalOrg;
    }

    public Customer getUser1() {
        return user1;
    }

    public void setUser1(Customer user1) {
        this.user1 = user1;
    }

    public Long getUser2() {
        return user2;
    }

    public void setUser2(Long user2) {
        this.user2 = user2;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Integer getReceiptCopies() {
        return receiptCopies;
    }

    public void setReceiptCopies(Integer receiptCopies) {
        this.receiptCopies = receiptCopies;
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getChargeAdditional() {
        return chargeAdditional;
    }

    public void setChargeAdditional(BigDecimal chargeAdditional) {
        this.chargeAdditional = chargeAdditional;
    }

    public BigDecimal getChargeDelivery() {
        return chargeDelivery;
    }

    public void setChargeDelivery(BigDecimal chargeDelivery) {
        this.chargeDelivery = chargeDelivery;
    }

    public BigDecimal getChargeDock() {
        return chargeDock;
    }

    public void setChargeDock(BigDecimal chargeDock) {
        this.chargeDock = chargeDock;
    }

    public BigDecimal getChargeInsurance() {
        return chargeInsurance;
    }

    public void setChargeInsurance(BigDecimal chargeInsurance) {
        this.chargeInsurance = chargeInsurance;
    }

    public BigDecimal getChargePackage() {
        return chargePackage;
    }

    public void setChargePackage(BigDecimal chargePackage) {
        this.chargePackage = chargePackage;
    }

    public BigDecimal getChargePickup() {
        return chargePickup;
    }

    public void setChargePickup(BigDecimal chargePickup) {
        this.chargePickup = chargePickup;
    }

    public BigDecimal getChargeStore() {
        return chargeStore;
    }

    public void setChargeStore(BigDecimal chargeStore) {
        this.chargeStore = chargeStore;
    }

    public BigDecimal getChargeFreight() {
        return chargeFreight;
    }

    public void setChargeFreight(BigDecimal chargeFreight) {
        this.chargeFreight = chargeFreight;
    }

    public BigDecimal getInsuranceLimit() {
        return insuranceLimit;
    }

    public void setInsuranceLimit(BigDecimal insuranceLimit) {
        this.insuranceLimit = insuranceLimit;
    }

    public BigDecimal getPaidConsignee() {
        return paidConsignee;
    }

    public void setPaidConsignee(BigDecimal paidConsignee) {
        this.paidConsignee = paidConsignee;
    }

    public BigDecimal getPaidConsignor() {
        return paidConsignor;
    }

    public void setPaidConsignor(BigDecimal paidConsignor) {
        this.paidConsignor = paidConsignor;
    }

    public BigDecimal getPaidMonthly() {
        return paidMonthly;
    }

    public void setPaidMonthly(BigDecimal paidMonthly) {
        this.paidMonthly = paidMonthly;
    }

    public BigDecimal getPaidReceipt() {
        return paidReceipt;
    }

    public void setPaidReceipt(BigDecimal paidReceipt) {
        this.paidReceipt = paidReceipt;
    }

    public BigDecimal getCostAdditional() {
        return costAdditional;
    }

    public void setCostAdditional(BigDecimal costAdditional) {
        this.costAdditional = costAdditional;
    }

    public BigDecimal getCostClaim() {
        return costClaim;
    }

    public void setCostClaim(BigDecimal costClaim) {
        this.costClaim = costClaim;
    }

    public BigDecimal getCostCommission() {
        return costCommission;
    }

    public void setCostCommission(BigDecimal costCommission) {
        this.costCommission = costCommission;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean isPickup() {
        return pickup;
    }

    public void setPickup(boolean pickup) {
        this.pickup = pickup;
    }

    public boolean isPickuped() {
        return pickuped;
    }

    public void setPickuped(boolean pickuped) {
        this.pickuped = pickuped;
    }

    public boolean isSotrx() {
        return sotrx;
    }

    public void setSotrx(boolean sotrx) {
        this.sotrx = sotrx;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentReceipt() {
        return commentReceipt;
    }

    public void setCommentReceipt(String commentReceipt) {
        this.commentReceipt = commentReceipt;
    }

    public String getPaymentRule() {
        return paymentRule;
    }

    public void setPaymentRule(String paymentRule) {
        this.paymentRule = paymentRule;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Date getDatePromise() {
        return datePromise;
    }

    public void setDatePromise(Date datePromise) {
        this.datePromise = datePromise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }
}
