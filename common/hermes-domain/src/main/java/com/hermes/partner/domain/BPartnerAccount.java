package com.hermes.partner.domain;

import com.hermes.client.domain.Client;
import com.hermes.core.GenericEntity;
import com.hermes.settle.domain.Bank;

import javax.persistence.*;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "LOG_BPARTNER_ACCOUNT")
public class BPartnerAccount extends GenericEntity<Long, BPartnerAccount> {

    @Id
    @Column(name = "BPARTNER_ACCOUNT_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "BPARTNER_ACCOUNT_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @OneToOne(targetEntity = Bank.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID", referencedColumnName = "BANK_ID")
    private Bank bank;

    @ManyToOne(targetEntity = BPartner.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "BPARTNER_ID", referencedColumnName = "BPARTNER_ID")
    protected BPartner bPartner;

    @Column(name = "NAME", length = 10)
    private String name;

    @Column(name = "ACCOUNT_NO", length = 20)
    private String accountNo;

    @Column(name = "ACCOUNT_TYPE", length = 10)
    private String accountType;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BPartner getBPartner() {
        return bPartner;
    }

    public void setBPartner(BPartner bPartner) {
        this.bPartner = bPartner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
