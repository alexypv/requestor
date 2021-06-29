package requester.persistence.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import requester.enums.RequestTypeEnum;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "request")
@Table(name = "REQUEST", schema = "REQUEST_COUNTER")
@Data
public class Request extends AuditEntity {

    @Column(name = "REQUEST_TYPE", length = 16)
    @Enumerated(EnumType.STRING)
    private RequestTypeEnum type;

    @Column(name = "COUNTER_VALUE")
    private Long value;

    @Column(name= "COUNTER_VERSION")
    private Long version;

}
