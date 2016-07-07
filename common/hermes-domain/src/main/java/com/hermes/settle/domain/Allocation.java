package com.hermes.settle.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "C_ALLOCATION")
public class Allocation extends GenericEntity<Long, Allocation> {

    @Id
    @Column(name = "ALLOCATION_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ALLOCATION_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long                 id;
    @Basic
    private boolean              manual;
    @Column(name = "approval_amt")
    private BigDecimal           approvalAmt;
    @Column(name = "time_acct")
    private Timestamp            timeAcct;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "allocation")
    private List<AllocationLine> lines;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
