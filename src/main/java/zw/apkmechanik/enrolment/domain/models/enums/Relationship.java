package zw.apkmechanik.enrolment.domain.models.enums;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/03/08
 */
public enum Relationship {
    FATHER("father"),
    MOTHER("mother"),
    BROTHER("brother"),
    SISTER("sister");
    private final String value;

    Relationship(String value) {
        this.value = value;
    }
}
