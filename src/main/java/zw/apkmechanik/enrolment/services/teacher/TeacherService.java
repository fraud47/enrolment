package zw.apkmechanik.enrolment.services.teacher;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import zw.apkmechanik.enrolment.domain.dto.response.ApiResponse;
import zw.apkmechanik.enrolment.domain.dto.response.PaginatedResponse;
import zw.apkmechanik.enrolment.domain.models.users.teacher.TeacherInfo;
import zw.apkmechanik.enrolment.domain.models.users.teacher.TeacherMapper;
import zw.apkmechanik.enrolment.domain.repositories.TeacherRepository;
import zw.apkmechanik.enrolment.utils.ResponseUtils;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper mapper;
    private final static String NAME = "teacher";

    public ApiResponse<PaginatedResponse<TeacherInfo>> getAllTeachers(
            int pageNumber,
            int pageCount
    ) {

        Page<TeacherInfo> data = teacherRepository.findTeachersByIdNotNull(PageRequest.of(pageNumber, pageCount));
        return ResponseUtils.success(
                ResponseUtils.pageResponse(data, pageNumber)
        );
    }


}
