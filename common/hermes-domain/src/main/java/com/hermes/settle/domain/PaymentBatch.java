package com.hermes.settle.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "C_PAYMENT_BATCH")
public class PaymentBatch extends GenericEntity<Long, PaymentBatch> {

    @Id
    @Column(name = "PAYMENT_BATCH_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "PAYMENT_BATCH_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name = "PAYMENT_PROCESSOR_ID")
    private Long    paymentProcessor;

    @Column(name ="NAME", length = 20)
    private String  name;

    @Column(name ="PROCESSED")
    private boolean processed = false;

    @Column(name ="PROCESSING")
    private boolean processing = true;

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

    public Long getPaymentProcessor() {
        return paymentProcessor;
    }

    public void setPaymentProcessor(Long paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isProcessing() {
        return processing;
    }

    public void setProcessing(boolean processing) {
        this.processing = processing;
    }
}
