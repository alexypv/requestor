package requester.persistence.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@Data
public class AuditEntity implements Serializable {
    private static final long serialVersionUID = 2392069675124015962L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    protected Long id;

    @Column(name = "CREATED_BY", length = 32)
    private String createdBy;

    @Column(name = "CREATED_WHEN", columnDefinition = "TIMESTAMP NOT NULL DEFAULT now()")
    protected LocalDateTime createdWhen;

    @Column(name = "UPDATED_BY", length = 32)
    private String updatedBy;

    @Column(name = "UPDATED_WHEN", columnDefinition = "TIMESTAMP NOT NULL DEFAULT now()")
    protected LocalDateTime updatedWhen;

    public void setAuditParamsForCreation(String username) {
        this.createdBy = username;
        this.createdWhen = LocalDateTime.now();
        this.updatedBy = username;
        this.updatedWhen = LocalDateTime.now();
    }

    public void setAuditParamsForUpdate(String username) {
        this.updatedBy = username;
        this.updatedWhen = LocalDateTime.now();
    }

}