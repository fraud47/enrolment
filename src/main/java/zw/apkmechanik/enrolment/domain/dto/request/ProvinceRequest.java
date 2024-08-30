package zw.apkmechanik.enrolment.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import zw.apkmechanik.enrolment.domain.models.common.Province;

import java.io.Serializable;

/**
 * DTO for {@link Province}
 */
public record ProvinceRequest(@NotNull String name) implements Serializable {
}