package com.hermes.core.domain;

import com.hermes.core.type.DocAction;
import com.hermes.core.type.DocStatus;
import com.hermes.core.type.DocType;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Document {
    @Column(name = "DOC_ACTION", length = 2)
    private String docAction;
    @Column(name = "DOC_STATUS", length = 2)
    private String docStatus;
    @Column(name = "DOC_NO", length = 20)
    private String documentNo;
    @Column(name = "DOC_TYPE")
    private Integer docType;
    @Basic
    private boolean processed;
    @Basic
    private boolean processing;
    @Basic
    private boolean approved;

    public Document() {
        this.setDocStatus(DocStatus.Unknown);
        this.setDocAction(DocAction.None);
        this.processing = false;
        this.processed = false;
        this.approved = false;
    }

    public DocAction getDocAction() {
        return DocAction.fromString(docAction);
    }

    public void setDocAction(DocAction docAction) {
        this.docAction = docAction.getValue();
    }

    public DocStatus getDocStatus() {
        return DocStatus.fromString(docStatus);
    }

    public void setDocStatus(DocStatus docStatus) {
        this.docStatus = docStatus.getValue();
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public DocType getDocType() {
        return DocType.fromDocType(docType);
    }

    public void setDocType(DocType type) {
        this.docType = type.getDocTypeID();
    }
}
