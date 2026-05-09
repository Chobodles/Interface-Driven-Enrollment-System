package org.example.controller;

import org.example.exception.LoadFullException;
import org.example.model.*;
import org.example.service.*;

import java.util.List;

public class CampusRegistrarController {

    private final IStudentService studentService;
    private final IInstructorService instructorService;
    private final ICourseService courseService;
    private final IProgramService programService;
    private final ISectionService sectionService;
    private final ILoadingService loadingService;



    private static final int UNITS_PER_LOAD = 3;

    public CampusRegistrarController(
//            IStudentService studentService,
//            IInstructorService instructorService,
//            ICourseService courseService,
//            IProgramService programService,
//            ISectionService sectionService,
//            ILoadingService loadingService,
//            IDepartmentService departmentService,
//            ITuitionService tuitionService
    ) {
        this.studentService = new StudentServiceImpl();
        this.instructorService = instructorService;
        this.courseService = courseService;
        this.programService = programService;
        this.sectionService = sectionService;
        this.loadingService = loadingService;
        this.departmentService = departmentService;
        this.tuitionService = tuitionService;
    }

    //student


    //instructor

    //course


    //department

    //program

    //section

    //loading


    //tuition




}
