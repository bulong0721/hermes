package com.hermes.core.util.ajax;

import java.util.Map;

public class AjaxPageableResponse extends AjaxResponse {
    private long draw;
    private long recordsTotal;
    private long recordsFiltered;

    @Override
    public void addDataEntry(Map<String, Object> dataEntry) {
        super.addDataEntry(dataEntry);
        recordsFiltered = rows.size();
        recordsTotal = rows.size();
    }

    public long getDraw() {
        return draw;
    }

    public void setDraw(long draw) {
        this.draw = draw;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
}
