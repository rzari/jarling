package org.jarling.models.directDebits;

import java.util.Date;

/**
 *
 * Model class representing a direct debit mandate returned by the Direct Debit Mandate API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class DirectDebitMandate {
    private Date cancelled;
    private Date created;
    private String originatorName;
    private String originatorUid;
    private String reference;
    private DirectDebitMandateSource source;
    private DirectDebitMandateStatus status;
    private String uid;

    public Date getCancelled() {
        return cancelled;
    }

    public Date getCreated() {
        return created;
    }

    public String getOriginatorName() {
        return originatorName;
    }

    public String getOriginatorUid() {
        return originatorUid;
    }

    public String getReference() {
        return reference;
    }

    public DirectDebitMandateSource getSource() {
        return source;
    }

    public DirectDebitMandateStatus getStatus() {
        return status;
    }

    public String getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return "DirectDebitMandate{" +
                "cancelled=" + cancelled +
                ", created=" + created +
                ", originatorName='" + originatorName + '\'' +
                ", originatorUid='" + originatorUid + '\'' +
                ", reference='" + reference + '\'' +
                ", source=" + source +
                ", status=" + status +
                ", uid='" + uid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectDebitMandate that = (DirectDebitMandate) o;

        if (cancelled != null ? !cancelled.equals(that.cancelled) : that.cancelled != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (originatorName != null ? !originatorName.equals(that.originatorName) : that.originatorName != null)
            return false;
        if (originatorUid != null ? !originatorUid.equals(that.originatorUid) : that.originatorUid != null)
            return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (source != that.source) return false;
        if (status != that.status) return false;
        return uid != null ? uid.equals(that.uid) : that.uid == null;

    }

    @Override
    public int hashCode() {
        int result = cancelled != null ? cancelled.hashCode() : 0;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (originatorName != null ? originatorName.hashCode() : 0);
        result = 31 * result + (originatorUid != null ? originatorUid.hashCode() : 0);
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        return result;
    }
}
