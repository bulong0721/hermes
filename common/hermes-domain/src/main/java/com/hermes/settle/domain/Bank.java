package com.hermes.settle.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "C_BANK")
public class Bank extends GenericEntity<Long, Bank> {

    @Id
    @Column(name = "BANK_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "BANK_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "SWIFT_CODE", length = 60)
    private String swiftCode;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
