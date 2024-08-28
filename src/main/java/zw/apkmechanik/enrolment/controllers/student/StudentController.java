package zw.apkmechanik.enrolment.controllers.student;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sheltons
 * Email sheltshamu@gmail.com
 * Created on 2024/04/03
 */

@RestController
@RequestMapping("${info.url.unSecured}/students")
@Tag(name = "Student Controller", description = "student controller")
public class StudentController {
    //todo request details modification
}
