package com.hermes.pickup.domain;

import com.hermes.core.GenericEntity;
import com.hermes.customer.domain.Customer;
import com.hermes.transfer.domain.Movement;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "LOG_INVOICE_LINE")
public class InvoiceLine extends GenericEntity<Long, InvoiceLine> {

    @Id
    @Column(name = "INVOICE_LINE_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "INVOICE_LINE_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name = "CHARGE_ID")
    private Long chargeID;

    @ManyToOne(targetEntity = Customer.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER1_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer user1;

    @ManyToOne(targetEntity = Customer.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER2_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer user2;

    @Column(name = "LINE_AMT")
    private BigDecimal lineAmt;

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    private Order order;

    @ManyToOne(targetEntity = Invoice.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID", referencedColumnName = "INVOICE_ID")
    private Invoice invoice;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getChargeID() {
        return chargeID;
    }

    public void setChargeID(Long chargeID) {
        this.chargeID = chargeID;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getLineAmt() {
        return lineAmt;
    }

    public void setLineAmt(BigDecimal lineAmt) {
        this.lineAmt = lineAmt;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getUser1() {
        return user1;
    }

    public void setUser1(Customer user1) {
        this.user1 = user1;
    }

    public Customer getUser2() {
        return user2;
    }

    public void setUser2(Customer user2) {
        this.user2 = user2;
    }
}
