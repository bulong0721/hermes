package com.hermes.partner.domain;

import com.hermes.core.GenericEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "C_BPARTNER")
public class BPartner extends GenericEntity<Long, BPartner> {

    @Id
    @Column(name = "BPARTNER_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "BPARTNER_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;
    @Column(name = "pay_method")
    private String payMethod;
    @Column(name = "industry_type")
    private Integer industryType;
    @Basic
    private boolean consignee = true;
    @Basic
    private boolean consignor = false;
    @Basic
    private boolean shipper = false;
    @Column(name = "contract_no")
    private String contractNo;
    @Column(name = "date_firstsale")
    private Date dateFirstsale;
    @Column(name = "dock_addr")
    private String dockAddr;
    @Column(name = "fax", length = 20)
    private String fax;
    @Column(name = "important_note")
    private String importantNote;
    @Column(name = "fax", length = 20)
    private String mobile;
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "org_name", length = 40)
    private String orgName;
    @Column(name = "name", length = 20)
    private String phone;
    @Column(name = "name", length = 60)
    private String addr;
    @Column(name = "name", length = 10)
    private String zip;
    @Column(name = "credit_quota")
    private BigDecimal creditQuota;
    @Column(name = "accout_balance")
    private BigDecimal accoutBalance;
    @Column(name = "credit_balance")
    private BigDecimal creditBalance;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getIndustryType() {
        return industryType;
    }

    public void setIndustryType(Integer industryType) {
        this.industryType = industryType;
    }

    public boolean isConsignee() {
        return consignee;
    }

    public void setConsignee(boolean consignee) {
        this.consignee = consignee;
    }

    public boolean isConsignor() {
        return consignor;
    }

    public void setConsignor(boolean consignor) {
        this.consignor = consignor;
    }

    public boolean isShipper() {
        return shipper;
    }

    public void setShipper(boolean shipper) {
        this.shipper = shipper;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getDateFirstsale() {
        return dateFirstsale;
    }

    public void setDateFirstsale(Date dateFirstsale) {
        this.dateFirstsale = dateFirstsale;
    }

    public String getDockAddr() {
        return dockAddr;
    }

    public void setDockAddr(String dockAddr) {
        this.dockAddr = dockAddr;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getImportantNote() {
        return importantNote;
    }

    public void setImportantNote(String importantNote) {
        this.importantNote = importantNote;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public BigDecimal getCreditQuota() {
        return creditQuota;
    }

    public void setCreditQuota(BigDecimal creditQuota) {
        this.creditQuota = creditQuota;
    }

    public BigDecimal getAccoutBalance() {
        return accoutBalance;
    }

    public void setAccoutBalance(BigDecimal accoutBalance) {
        this.accoutBalance = accoutBalance;
    }

    public BigDecimal getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(BigDecimal creditBalance) {
        this.creditBalance = creditBalance;
    }
}
