package com.hermes.transfer.domain;

import com.hermes.core.GenericEntity;
import com.hermes.pickup.domain.Order;
import com.hermes.pickup.domain.OrderLine;

import javax.persistence.*;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "LOG_INOUT_LINE")
public class InoutLine extends GenericEntity<Long, InoutLine> {

    @Id
    @Column(name = "INOUT_LINE_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "INOUT_LINE_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name = "CONFIRMED_QTY")
    private Integer confirmedQty = 0;

    @Column(name = "MOVE_QTY")
    private Integer moveQty = 0;

    @Column(name = "PICK_QTY")
    private Integer pickQty = 0;

    @Column(name = "SCRAPPED_QTY")
    private Integer scrappedQty = 0;

    @Column(name = "TARGET_QTY")
    private Integer targetQty = 0;

    @ManyToOne(targetEntity = Inout.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "INOUT_ID", referencedColumnName = "INOUT_ID")
    private Inout inout;

    @OneToOne(targetEntity = OrderLine.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_LINE_ID", referencedColumnName = "ORDER_LINE_ID")
    private OrderLine orderLine;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConfirmedQty() {
        return confirmedQty;
    }

    public void setConfirmedQty(Integer confirmedQty) {
        this.confirmedQty = confirmedQty;
    }

    public Inout getInout() {
        return inout;
    }

    public void setInout(Inout inout) {
        this.inout = inout;
    }

    public Integer getMoveQty() {
        return moveQty;
    }

    public void setMoveQty(Integer moveQty) {
        this.moveQty = moveQty;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public Integer getPickQty() {
        return pickQty;
    }

    public void setPickQty(Integer pickQty) {
        this.pickQty = pickQty;
    }

    public Integer getScrappedQty() {
        return scrappedQty;
    }

    public void setScrappedQty(Integer scrappedQty) {
        this.scrappedQty = scrappedQty;
    }

    public Integer getTargetQty() {
        return targetQty;
    }

    public void setTargetQty(Integer targetQty) {
        this.targetQty = targetQty;
    }
}
