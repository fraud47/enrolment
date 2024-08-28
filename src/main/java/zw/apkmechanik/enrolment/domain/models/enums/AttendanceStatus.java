package zw.apkmechanik.enrolment.domain.models.enums;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/03/08
 */
public enum AttendanceStatus {
    PRESENT("present"),
    ABSENT("absent"),
    TARDY("tardy");
    private final String value;
    AttendanceStatus(String value) {
        this.value = value;
    }
}
