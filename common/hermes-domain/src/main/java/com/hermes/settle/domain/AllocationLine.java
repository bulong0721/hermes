package com.hermes.settle.domain;

import com.hermes.core.GenericEntity;
import com.hermes.partner.domain.BPartner;
import com.hermes.pickup.domain.Invoice;
import com.hermes.pickup.domain.Order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "C_ALLOCATION_LINE")
public class AllocationLine extends GenericEntity<Long, AllocationLine> {

    @Id
    @Column(name = "ALLOCATION_LINE_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ALLOCATION_LINE_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @ManyToOne(targetEntity = BPartner.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "BPARTNER_ID", referencedColumnName = "BPARTNER_ID")
    private BPartner bPartner;

    @ManyToOne(targetEntity = CashLine.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CASH_LINE_ID", referencedColumnName = "CASH_LINE_ID")
    private CashLine cashLine;

    @OneToOne(targetEntity = Invoice.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID", referencedColumnName = "INVOICE_ID")
    private Invoice invoice;

    @OneToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    private Order order;

    @OneToOne(targetEntity = Payment.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PAYMENT_ID", referencedColumnName = "PAYMENT_ID")
    private Payment payment;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "DISCOUNT_AMT")
    private BigDecimal discountAmt;

    @Column(name = "OVERUNDER_AMT")
    private BigDecimal overunderAmt;

    @Column(name = "WRITEOFF_AMT")
    private BigDecimal writeoffAmt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIME_TRX")
    private Date timeTrx;

    @ManyToOne(targetEntity = Allocation.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ALLOCATION_ID")
    private Allocation allocation;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BPartner getbPartner() {
        return bPartner;
    }

    public void setbPartner(BPartner bPartner) {
        this.bPartner = bPartner;
    }

    public CashLine getCashLine() {
        return cashLine;
    }

    public void setCashLine(CashLine cashLine) {
        this.cashLine = cashLine;
    }

    public BigDecimal getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getOverunderAmt() {
        return overunderAmt;
    }

    public void setOverunderAmt(BigDecimal overunderAmt) {
        this.overunderAmt = overunderAmt;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getTimeTrx() {
        return timeTrx;
    }

    public void setTimeTrx(Date timeTrx) {
        this.timeTrx = timeTrx;
    }

    public BigDecimal getWriteoffAmt() {
        return writeoffAmt;
    }

    public void setWriteoffAmt(BigDecimal writeoffAmt) {
        this.writeoffAmt = writeoffAmt;
    }
}
