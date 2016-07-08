package com.hermes.pickup.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "LOG_ORDER_LINE")
public class OrderLine extends GenericEntity<Long, OrderLine> {

    @Id
    @Column(name = "ORDER_LINE_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "ORDER_LINE_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name = "LINE_NO")
    private Integer lineNo;

    @Basic
    private Integer amount = 1;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "PACKAGE_TYPE", length = 10)
    private String packageType;

    @Column(name = "VALUE", nullable = false)
    private BigDecimal value;

    @Column(name = "VOLUME",nullable = false)
    private BigDecimal volume;

    @Column(name = "WEIGHT",nullable = false)
    private BigDecimal weight;

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
