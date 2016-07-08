package com.hermes.settle.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "C_ALLOCATION")
public class Allocation extends GenericEntity<Long, Allocation> {

    @Id
    @Column(name = "ALLOCATION_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ALLOCATION_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name = "MANUAL")
    private boolean manual = false;

    @Column(name = "APPROVAL_AMT")
    private BigDecimal approvalAmt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIME_ACCT")
    private Date timeAcct;

    @OneToMany(targetEntity = AllocationLine.class, fetch = FetchType.LAZY, mappedBy = "allocation")
    private List<AllocationLine> lines;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getApprovalAmt() {
        return approvalAmt;
    }

    public void setApprovalAmt(BigDecimal approvalAmt) {
        this.approvalAmt = approvalAmt;
    }

    public List<AllocationLine> getLines() {
        return lines;
    }

    public void setLines(List<AllocationLine> lines) {
        this.lines = lines;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public Date getTimeAcct() {
        return timeAcct;
    }

    public void setTimeAcct(Date timeAcct) {
        this.timeAcct = timeAcct;
    }
}
