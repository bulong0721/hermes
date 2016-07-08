package com.hermes.transfer.domain;

import com.hermes.core.GenericEntity;
import com.hermes.customer.domain.Customer;
import com.hermes.pickup.domain.OrderLine;

import javax.persistence.*;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "LOG_INVENTORY")
public class Inventory extends GenericEntity<Long, Inventory> {

    @Id
    @Column(name = "INVENTORY_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "INVENTORY_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @ManyToOne(targetEntity = Warehouse.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "WAREHOUSE_ID", referencedColumnName = "WAREHOUSE_ID")
    private Warehouse warehouse;

    @Column(name = "INVENTORY_STATUS", length = 10)
    private String inventoryStatus;

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

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
