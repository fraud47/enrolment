package zw.apkmechanik.enrolment.controllers.teacher;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zw.apkmechanik.enrolment.domain.dto.response.ApiResponse;
import zw.apkmechanik.enrolment.domain.dto.response.PaginatedResponse;
import zw.apkmechanik.enrolment.domain.models.users.teacher.TeacherInfo;
import zw.apkmechanik.enrolment.services.teacher.TeacherService;
import zw.apkmechanik.enrolment.utils.ResponseUtils;


@RestController
@RequestMapping("${info.url.unSecured}/teachers")
@Tag(name = "Teacher Controller", description = "teacher controller")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Teachers", description = "Get All Teachers")
    public ResponseEntity<ApiResponse<PaginatedResponse<TeacherInfo>>> getAllTeachers(
            @RequestParam(name = "pageNumber") int pageNumber,
            @RequestParam(name = "pageCount") int pageCount
    ) {
        var response = service.getAllTeachers(pageNumber, pageCount);
        return ResponseUtils.respond(response);
    }

}
