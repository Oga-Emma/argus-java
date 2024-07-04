package com.github.ogaemma.argus.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class ArgusEvent {
    private String action;
    private String actionDescription;
    private String name;
    private OffsetDateTime timestamp;

    public ArgusEvent() {
    }

    public ArgusEvent(String action, String actionDescription, String name, OffsetDateTime timestamp) {
        this.action = action;
        this.actionDescription = actionDescription;
        this.name = name;
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    @Override
    public String toString() {
        return "ArgusEvent{" +
                "action='" + action + '\'' +
                ", actionDescription='" + actionDescription + '\'' +
                ", name='" + name + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
