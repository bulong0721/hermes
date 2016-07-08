package com.hermes.settle.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;

/**
 * Created by Martin on 2016/7/8.
 */
@Entity
@Table(name = "C_BANKACCOUNT")
public class BankAccount extends GenericEntity<Long, BankAccount> {

    @Id
    @Column(name = "ACCOUNT_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ACCOUNT_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
