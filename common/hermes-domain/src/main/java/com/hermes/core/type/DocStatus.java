package com.hermes.core.type;

public enum DocStatus {
    Drafted("DR"),
    Completed("CO"),
    Approved("AP"),
    Invalid("IN"),
    NotApproved("NA"),
    Voided("VO"),
    Reversed("RE"),
    Closed("CL"),
    Unknown("??"),
    InProgress("IP"),
    WaitingPayment("WP"),
    WaitingConfirmation("WC");

    private String status;

    private DocStatus(String status) {
        this.status = status;
    }

    public static DocStatus fromString(String value) {
        for (DocStatus item : values()) {
            if (item.getValue().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return Unknown;
    }

    public String getValue() {
        return status;
    }

    public boolean isDrafted() {
        return Drafted == this;
    } // isDrafted

    /**
     * Document is Invalid
     * 
     * @return true if Invalid
     */
    public boolean isInvalid() {
        return Invalid == this;
    } // isInvalid

    /**
     * Document is In Progress
     * 
     * @return true if In Progress
     */
    public boolean isInProgress() {
        return InProgress == this;
    } // isInProgress

    /**
     * Document is Approved
     * 
     * @return true if Approved
     */
    public boolean isApproved() {
        return Approved == this;
    } // isApproved

    /**
     * Document is Not Approved
     * 
     * @return true if Not Approved
     */
    public boolean isNotApproved() {
        return NotApproved == this;
    } // isNotApproved

    /**
     * Document is Waiting Payment or Confirmation
     * 
     * @return true if Waiting Payment
     */
    public boolean isWaiting() {
        return WaitingConfirmation == this || WaitingPayment == this;
    } // isWaitingPayment

    /**
     * Document is Completed
     * 
     * @return true if Completed
     */
    public boolean isCompleted() {
        return Completed == this;
    } // isCompleted

    /**
     * Document is Reversed
     * 
     * @return true if Reversed
     */
    public boolean isReversed() {
        return Reversed == this;
    } // isReversed

    /**
     * Document is Closed
     * 
     * @return true if Closed
     */
    public boolean isClosed() {
        return Closed == this;
    } // isClosed

    /**
     * Document is Voided
     * 
     * @return true if Voided
     */
    public boolean isVoided() {
        return Voided == this;
    } // isVoided

    /**
     * Document Status is Unknown
     * 
     * @return true if unknown
     */
    public boolean isUnknown() {
        return Unknown == this
            || !(isDrafted() || isInvalid() || isInProgress() || isNotApproved() || isApproved() || isWaiting() || isCompleted()
                || isReversed() || isClosed() || isVoided());
    } // isUnknown

    public DocAction[] getActionOptions() {
        if (isInvalid())
            return new DocAction[] { DocAction.Prepare, DocAction.Invalidate, DocAction.Unlock, DocAction.Void };

        if (isDrafted())
            return new DocAction[] { DocAction.Prepare, DocAction.Invalidate, DocAction.Complete, DocAction.Unlock,
                DocAction.Void };

        if (isInProgress() || isApproved())
            return new DocAction[] { DocAction.Complete, DocAction.WaitComplete, DocAction.Approve, DocAction.Reject,
                DocAction.Unlock, DocAction.Void, DocAction.Prepare };

        if (isNotApproved())
            return new DocAction[] { DocAction.Reject, DocAction.Prepare, DocAction.Unlock, DocAction.Void };

        if (isWaiting())
            return new DocAction[] { DocAction.Complete, DocAction.WaitComplete, DocAction.ReActivate, DocAction.Void,
                DocAction.Close };

        if (isCompleted())
            return new DocAction[] { DocAction.Close, DocAction.ReActivate, DocAction.Reverse_Accrual, DocAction.Reverse_Correct,
                DocAction.Post, DocAction.Void };

        if (isClosed())
            return new DocAction[] { DocAction.Post, DocAction.ReOpen };

        if (isReversed() || isVoided())
            return new DocAction[] { DocAction.Post };

        return new DocAction[] {};
    } // getActionOptions
}
