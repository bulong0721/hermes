package com.hermes.transfer.domain;

import com.hermes.core.GenericEntity;
import com.hermes.customer.domain.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Martin on 2016/4/11.
 */
@Entity
@Table(name = "LOG_VEHICLE")
public class Vehicle extends GenericEntity<Long, Vehicle> {

    @Id
    @Column(name = "VEHICLE_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "C_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "VEHICLE_SEQ_NEXT_VAL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer owner;

    @OneToOne(targetEntity = Movement.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTRUST_MOVE_ID", referencedColumnName = "MOVEMENT_ID")
    private Movement entrustMovement;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer driver;

    @Column(name = "VEHICLE_NATURE", length = 10)
    private String vehicleNature;

    @Column(name = "COMMENT", length = 20)
    private String comment;

    @Column(name = "CONTRACT_NO", length = 20)
    private String contractNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_DEPART")
    private Date dateDepart;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_SCRAP")
    private Date dateScrap;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_USING")
    private Date dateUsing;

    @Column(name = "DRIVER_NAME", length = 10)
    private String driverName;

    @Column(name = "DRIVER_ADDR", length = 60)
    private String driverAddr;

    //车名
    @Column(name = "name", length = 20)
    private String name;

    //行驶证号
    @Column(name = "operation_no")
    private String operationNo;

    //车主
    @Column(name = "owner_name", length = 20)
    private String ownerName;

    //车主地址
    @Column(name = "owner_addr", length = 60)
    private String ownerAddr;

    //车主电话
    @Column(name = "owner_phone", length = 20)
    private String ownerPhone;

    //车牌号
    @Column(name = "plate_no", length = 10)
    private String plateNo;

    //挂车车牌号
    @Column(name = "TRAILER_PLATE_NO", length = 10)
    private String trailerPlateNo;

    //司机驾驶证号
    @Column(name = "DRIVER_LICENCE_NO", length = 30)
    private String driverLicenceNo;

    //司机电话
    @Column(name = "DRIVER_PHONE", length = 20)
    private String driverPhone;

    //发动机号
    @Column(name = "ENGINE_NO", length = 30)
    private String engineNo;

    //保险单号
    @Column(name = "INSURANCE_NO", length = 30)
    private String insuranceNo;

    //车架号
    @Column(name = "LICENSE_NO")
    private String licenseNo;

    @Column(name = "限行", length = 60)
    private String limited;

    //当前里程
    @Column(name = "MILEAGE_CURRENT")
    private BigDecimal mileageCurrent;

    //开始里程
    @Column(name = "MILEAGE_START")
    private BigDecimal mileageStart;

    //报废里程
    @Column(name = "MILEAGE_TERMINAL")
    private BigDecimal mileageTerminal;

    //油耗
    @Column(name = "OIL_CONSUMPTION")
    private BigDecimal oilConsumption;

    //吨位
    @Column(name = "TONNAGE")
    private BigDecimal tonnage;

    //折旧费
    @Column(name = "DEPRECIATION_CHARGE")
    private BigDecimal depreciationCharge;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateScrap() {
        return dateScrap;
    }

    public void setDateScrap(Date dateScrap) {
        this.dateScrap = dateScrap;
    }

    public Date getDateUsing() {
        return dateUsing;
    }

    public void setDateUsing(Date dateUsing) {
        this.dateUsing = dateUsing;
    }

    public BigDecimal getDepreciationCharge() {
        return depreciationCharge;
    }

    public void setDepreciationCharge(BigDecimal depreciationCharge) {
        this.depreciationCharge = depreciationCharge;
    }

    public Customer getDriver() {
        return driver;
    }

    public void setDriver(Customer driver) {
        this.driver = driver;
    }

    public String getDriverAddr() {
        return driverAddr;
    }

    public void setDriverAddr(String driverAddr) {
        this.driverAddr = driverAddr;
    }

    public String getDriverLicenceNo() {
        return driverLicenceNo;
    }

    public void setDriverLicenceNo(String driverLicenceNo) {
        this.driverLicenceNo = driverLicenceNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public Movement getEntrustMovement() {
        return entrustMovement;
    }

    public void setEntrustMovement(Movement entrustMovement) {
        this.entrustMovement = entrustMovement;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getLimited() {
        return limited;
    }

    public void setLimited(String limited) {
        this.limited = limited;
    }

    public BigDecimal getMileageCurrent() {
        return mileageCurrent;
    }

    public void setMileageCurrent(BigDecimal mileageCurrent) {
        this.mileageCurrent = mileageCurrent;
    }

    public BigDecimal getMileageStart() {
        return mileageStart;
    }

    public void setMileageStart(BigDecimal mileageStart) {
        this.mileageStart = mileageStart;
    }

    public BigDecimal getMileageTerminal() {
        return mileageTerminal;
    }

    public void setMileageTerminal(BigDecimal mileageTerminal) {
        this.mileageTerminal = mileageTerminal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOilConsumption() {
        return oilConsumption;
    }

    public void setOilConsumption(BigDecimal oilConsumption) {
        this.oilConsumption = oilConsumption;
    }

    public String getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(String operationNo) {
        this.operationNo = operationNo;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public String getOwnerAddr() {
        return ownerAddr;
    }

    public void setOwnerAddr(String ownerAddr) {
        this.ownerAddr = ownerAddr;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public BigDecimal getTonnage() {
        return tonnage;
    }

    public void setTonnage(BigDecimal tonnage) {
        this.tonnage = tonnage;
    }

    public String getTrailerPlateNo() {
        return trailerPlateNo;
    }

    public void setTrailerPlateNo(String trailerPlateNo) {
        this.trailerPlateNo = trailerPlateNo;
    }

    public String getVehicleNature() {
        return vehicleNature;
    }

    public void setVehicleNature(String vehicleNature) {
        this.vehicleNature = vehicleNature;
    }
}
