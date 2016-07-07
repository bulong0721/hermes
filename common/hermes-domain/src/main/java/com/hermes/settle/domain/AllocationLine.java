package com.hermes.settle.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "C_ALLOCATION_LINE")
public class AllocationLine extends GenericEntity<Long, AllocationLine> {

    @Id
    @Column(name = "ALLOCATION_LINE_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ALLOCATION_LINE_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name = "bpartner_id")
    private Long       bpartnerID;
    @Column(name = "cashline_id")
    private Long       cashLineID;
    @Column(name = "invoice_id")
    private Long       invoiceID;
    @Column(name = "order_id")
    private Long       orderID;
    @Column(name = "payment_id")
    private Long       paymentID;
    @Basic
    private BigDecimal amount;
    @Column(name = "discount_amt")
    private BigDecimal discountAmt;
    @Column(name = "overunder_amt")
    private BigDecimal overunderAmt;
    @Column(name = "writeoff_amt")
    private BigDecimal writeoffAmt;
    @Column(name = "time_trx")
    private Timestamp  timeTrx;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_allocation_id")
    private Allocation allocation;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
