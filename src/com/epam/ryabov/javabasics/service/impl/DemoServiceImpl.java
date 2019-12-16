package com.epam.ryabov.javabasics.service.impl;

import com.epam.ryabov.javabasics.entity.Course;
import com.epam.ryabov.javabasics.entity.Curriculum;
import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;
import com.epam.ryabov.javabasics.repostiroy.CurriculumRepository;
import com.epam.ryabov.javabasics.repostiroy.impl.CurriculumRepositoryImpl;
import com.epam.ryabov.javabasics.service.DemoService;
import com.epam.ryabov.javabasics.service.MarkService;
import com.epam.ryabov.javabasics.service.StudyTimeService;
import com.epam.ryabov.javabasics.service.TrainingCenterService;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class DemoServiceImpl implements DemoService {

    private CurriculumRepository curriculumRepository = new CurriculumRepositoryImpl();
    private MarkService markService = new MarkServiceImpl();
    private TrainingCenterService trainingCenterService = new TrainingCenterServiceImpl();
    private StudyTimeService studyTimeService = new StudyTimeServiceImpl();
    private TrainingCenter trainingCenter = new TrainingCenter("EPAM", new ArrayList<>(), Duration.ofHours(8));
    private Curriculum curriculum1 = new Curriculum(1L, "J2EE Developer", new ArrayList<>(), LocalDate.of(2019, 12, 9));
    private Curriculum curriculum2 = new Curriculum(2L, "Java Developer", new ArrayList<>(), LocalDate.of(2019, 12, 9));
    private Curriculum curriculum3 = new Curriculum(3L, "J2EE Developer", new ArrayList<>(), LocalDate.of(2019, 12, 16));
    private Curriculum curriculum4 = new Curriculum(4L, "Java Developer", new ArrayList<>(), LocalDate.of(2019, 12, 16));
    private Student student1 = new Student(1L, "Ivanov Ivan", curriculum1, new ArrayList<>());
    private Student student2 = new Student(2L, "Petrov Petr", curriculum2, new ArrayList<>());
    private Student student3 = new Student(3L, "Vasiles Vasya", curriculum3, new ArrayList<>());
    private Student student4 = new Student(4L, "Grigoriev Grigorii", curriculum4, new ArrayList<>());
    private Integer[] marks1 = {5, 2, 2, 5, 3, 3, 5, 5};
    private Integer[] marks2 = {4, 5, 3, 2, 4, 3, 5, 5};
    private Integer[] marks3 = {4};
    private Integer[] marks4 = {3};

    @Override
    public void demoService() {
        for (Integer mark : marks1) {
            student1.getStudentProgress().add(mark);
        }
        for (Integer mark : marks2) {
            student2.getStudentProgress().add(mark);
        }
        for (Integer mark : marks3) {
            student3.getStudentProgress().add(mark);
        }
        for (Integer mark : marks4) {
            student4.getStudentProgress().add(mark);
        }
        trainingCenterService.addStudent(student1, trainingCenter);
        trainingCenterService.addStudent(student2, trainingCenter);
        trainingCenterService.addStudent(student3, trainingCenter);
        trainingCenterService.addStudent(student4, trainingCenter);
        curriculumRepository.addCourse(new Course(1L, "Технология Java Servlets", Duration.ofHours(16)), curriculum1);
        curriculumRepository.addCourse(new Course(2L, "Struts Framework", Duration.ofHours(24)), curriculum1);
        curriculumRepository.addCourse(new Course(3L, "Spring Framework", Duration.ofHours(48)), curriculum1);
        curriculumRepository.addCourse(new Course(4L, "Hibernate", Duration.ofHours(20)), curriculum1);
        curriculumRepository.addCourse(new Course(1L, "Обзор технологий Java", Duration.ofHours(8)), curriculum2);
        curriculumRepository.addCourse(new Course(2L, "Библиотека JFC/Swing", Duration.ofHours(16)), curriculum2);
        curriculumRepository.addCourse(new Course(3L, "Технология JDBC", Duration.ofHours(16)), curriculum2);
        curriculumRepository.addCourse(new Course(4L, "Технология JAX", Duration.ofHours(52)), curriculum2);
        curriculumRepository.addCourse(new Course(5L, "Библиотеки commons", Duration.ofHours(44)), curriculum2);
        curriculumRepository.addCourse(new Course(1L, "Технология Java Servlets", Duration.ofHours(16)), curriculum3);
        curriculumRepository.addCourse(new Course(2L, "Struts Framework", Duration.ofHours(24)), curriculum3);
        curriculumRepository.addCourse(new Course(3L, "Spring Framework", Duration.ofHours(48)), curriculum3);
        curriculumRepository.addCourse(new Course(4L, "Hibernate", Duration.ofHours(20)), curriculum3);
        curriculumRepository.addCourse(new Course(1L, "Обзор технологий Java", Duration.ofHours(8)), curriculum4);
        curriculumRepository.addCourse(new Course(2L, "Библиотека JFC/Swing", Duration.ofHours(16)), curriculum4);
        curriculumRepository.addCourse(new Course(3L, "Технология JDBC", Duration.ofHours(16)), curriculum4);
        curriculumRepository.addCourse(new Course(4L, "Технология JAX", Duration.ofHours(52)), curriculum4);
        curriculumRepository.addCourse(new Course(5L, "Библиотеки commons", Duration.ofHours(44)), curriculum4);
        System.out.println(student1.getFio() + " - До окончания обучения по программе " + studyTimeService.hoursUntilEndOfCurriculum(student1, trainingCenter) +
                " ч. Средний балл " + markService.averageStudentMark(student1) + " " + markService.studyStatus(student1));
        System.out.println(student2.getFio() + " - До окончания обучения по программе " + studyTimeService.hoursUntilEndOfCurriculum(student2, trainingCenter) +
                " ч. Средний балл " + markService.averageStudentMark(student2) + " " + markService.studyStatus(student2));
        System.out.println(student3.getFio() + " - До окончания обучения по программе " + studyTimeService.hoursUntilEndOfCurriculum(student3, trainingCenter) +
                " ч. Средний балл " + markService.averageStudentMark(student3) + " " + markService.studyStatus(student3));
        System.out.println(student4.getFio() + " - До окончания обучения по программе " + studyTimeService.hoursUntilEndOfCurriculum(student4, trainingCenter) +
                " ч. Средний балл " + markService.averageStudentMark(student4) + " " + markService.studyStatus(student4));


        for (Student student : trainingCenterService.sortStudentByAverageMark(trainingCenter)) {
            System.out.println(student.getFio() + " - средний балл " + markService.averageStudentMark(student));
        }

        for (Student student : trainingCenterService.sortStudentByTimeUntilStudyEnd(trainingCenter)) {
            System.out.println(student.getFio() + " - до окончания обучения часов " + studyTimeService.hoursUntilEndOfCurriculum(student, trainingCenter));
        }

        for (Student student : trainingCenterService.filterByChanceToSuccessfulCompleteCurriculum(trainingCenter)) {
            System.out.println(student.getFio() + " - возможно успешно закончит курс");
        }

    }
}
