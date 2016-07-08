package com.hermes.transfer.domain;

import com.hermes.client.domain.Org;
import com.hermes.core.GenericEntity;
import com.hermes.pickup.domain.OrderLine;

import javax.persistence.*;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "LOG_MOVEMENT_LINE")
public class MovementLine extends GenericEntity<Long, MovementLine> {

    @Id
    @Column(name = "MOVEMENT_LINE_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "MOVEMENT_LINE_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @OneToOne(targetEntity = Movement.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVEMENT_ID", referencedColumnName = "MOVEMENT_ID")
    private Movement movement;

    @OneToOne(targetEntity = Inventory.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "INVENTORY_ID", referencedColumnName = "INVENTORY_ID")
    private Inventory inventory;

    @OneToOne(targetEntity = OrderLine.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_LINE_ID", referencedColumnName = "ORDER_LINE_ID")
    private OrderLine orderLine;

    @ManyToOne(targetEntity = Org.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPART_ORG_ID", referencedColumnName = "ORG_ID")
    private Org departOrg;

    @ManyToOne(targetEntity = Org.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEST_ORG_ID", referencedColumnName = "ORG_ID")
    private Org destOrg;

    @Column(name = "line_status", length = 10)
    private String lineStatus;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Org getDepartOrg() {
        return departOrg;
    }

    public void setDepartOrg(Org departOrg) {
        this.departOrg = departOrg;
    }

    public Org getDestOrg() {
        return destOrg;
    }

    public void setDestOrg(Org destOrg) {
        this.destOrg = destOrg;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }
}
