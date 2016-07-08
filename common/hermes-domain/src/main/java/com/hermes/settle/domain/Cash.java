package com.hermes.settle.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "C_CASH")
public class Cash extends GenericEntity<Long, Cash> {

    @Id
    @Column(name = "CASH_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "CASH_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_ACCT")
    private Date dateAcct;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "END_BALANCE")
    private BigDecimal endBalance = BigDecimal.ZERO;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "START_BALANCE")
    private BigDecimal startBalance = BigDecimal.ZERO;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAcct() {
        return dateAcct;
    }

    public void setDateAcct(Date dateAcct) {
        this.dateAcct = dateAcct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getEndBalance() {
        return endBalance;
    }

    public void setEndBalance(BigDecimal endBalance) {
        this.endBalance = endBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(BigDecimal startBalance) {
        this.startBalance = startBalance;
    }
}
