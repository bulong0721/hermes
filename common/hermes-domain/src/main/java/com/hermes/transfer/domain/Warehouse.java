package com.hermes.transfer.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "LOG_WAREHOUSE")
public class Warehouse extends GenericEntity<Long, Warehouse> {

    @Id
    @Column(name = "WAREHOUSE_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "WAREHOUSE_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name = "OWNER_ORG_ID")
    private Long ownerOrg;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    @Column(name = "START")
    private boolean start = true;

    @Column(name = "TERMINAL")
    private boolean terminal = true;

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

    public Long getOwnerOrg() {
        return ownerOrg;
    }

    public void setOwnerOrg(Long ownerOrg) {
        this.ownerOrg = ownerOrg;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }
}
