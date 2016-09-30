package com.hermes.transfer.domain;

import com.hermes.client.domain.Org;
import com.hermes.core.GenericEntity;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.DecimalMax;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "LOG_ROUTE")
public class Route extends GenericEntity<Long, Route> {

    @Id
    @Column(name = "ROUTE_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ROUTE_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name = "NAME", length = 40)
    private String name;

    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

    @Column(name = "FEE_HIGHWAY")
    private BigDecimal feeHighway;

    @Column(name = "DEPART_ORG")
    private Org departOrg;

    @Column(name = "ARRIVE_ORG")
    private Org arriveOrg;

    @Column(name = "INTERCITY")
    private boolean intercity;

    @Column(name = "TOTAL_MILEAGE")
    private int totalMileage;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
