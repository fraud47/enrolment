package zw.apkmechanik.enrolment.domain.models.grading;

import zw.co.dreamhub.domain.models.BaseEntity;
import zw.co.dreamhub.domain.models.users.student.Student;

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 23/3/2024
 */
public class TestGrading extends BaseEntity {
    private Test test;
    private Student student;
    private Double mark;
    private Grading grading;
}
