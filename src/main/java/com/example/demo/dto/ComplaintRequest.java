package com.example.demo.dto;

import com.example.demo.entity.Complaint;

public class ComplaintComputeRequest {

    private Complaint.Severity severity;
    private Complaint.Urgency urgency;
    private String category;
    private String channel;

    // getters & setters
    public Complaint.Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Complaint.Severity severity) {
        this.severity = severity;
    }

    public Complaint.Urgency getUrgency() {
        return urgency;
    }

    public void setUrgency(Complaint.Urgency urgency) {
        this.urgency = urgency;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
