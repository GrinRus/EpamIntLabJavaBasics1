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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class DemoServiceImpl implements DemoService {

    private CurriculumRepository curriculumRepository = new CurriculumRepositoryImpl();
    private MarkService markService = new MarkServiceImpl();
    private TrainingCenterService trainingCenterService = new TrainingCenterServiceImpl();
    private StudyTimeService studyTimeService = new StudyTimeServiceImpl();
    private TrainingCenter trainingCenter = new TrainingCenter("EPAM", new ArrayList<>(), 8L, 4.5, 5);
    private Curriculum curriculum1 = new Curriculum(1L, "J2EE Developer", new ArrayList<>(), LocalDate.of(2019, 12, 9));
    private Curriculum curriculum2 = new Curriculum(2L, "Java Developer", new ArrayList<>(), LocalDate.of(2019, 12, 9));
    private Curriculum curriculum3 = new Curriculum(3L, "J2EE Developer", new ArrayList<>(), LocalDate.of(2019, 12, 16));
    private Curriculum curriculum4 = new Curriculum(4L, "Java Developer", new ArrayList<>(), LocalDate.of(2019, 12, 16));
    private Student student1 = new Student(1L, "Ivanov", "Ivan", curriculum1, new ArrayList<>());
    private Student student2 = new Student(2L, "Petrov", "Petr", curriculum2, new ArrayList<>());
    private Student student3 = new Student(3L, "Vasiles", "Vasya", curriculum3, new ArrayList<>());
    private Student student4 = new Student(4L, "Grigoriev", "Grigorii", curriculum4, new ArrayList<>());
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
        curriculumRepository.setCurriculum(curriculum1).addCourse(new Course(1L, "Технология Java Servlets", 16L));
        curriculumRepository.setCurriculum(curriculum1).addCourse(new Course(2L, "Struts Framework", 24L));
        curriculumRepository.setCurriculum(curriculum1).addCourse(new Course(3L, "Spring Framework", 48L));
        curriculumRepository.setCurriculum(curriculum1).addCourse(new Course(4L, "Hibernate", 20L));
        curriculumRepository.setCurriculum(curriculum2).addCourse(new Course(1L, "Обзор технологий Java", 8L));
        curriculumRepository.setCurriculum(curriculum2).addCourse(new Course(2L, "Библиотека JFC/Swing", 16L));
        curriculumRepository.setCurriculum(curriculum2).addCourse(new Course(3L, "Технология JDBC", 16L));
        curriculumRepository.setCurriculum(curriculum2).addCourse(new Course(4L, "Технология JAX", 52L));
        curriculumRepository.setCurriculum(curriculum2).addCourse(new Course(5L, "Библиотеки commons", 44L));
        curriculumRepository.setCurriculum(curriculum3).addCourse(new Course(1L, "Технология Java Servlets", 16L));
        curriculumRepository.setCurriculum(curriculum3).addCourse(new Course(2L, "Struts Framework", 24L));
        curriculumRepository.setCurriculum(curriculum3).addCourse(new Course(3L, "Spring Framework", 48L));
        curriculumRepository.setCurriculum(curriculum3).addCourse(new Course(4L, "Hibernate", 20L));
        curriculumRepository.setCurriculum(curriculum4).addCourse(new Course(1L, "Обзор технологий Java", 8L));
        curriculumRepository.setCurriculum(curriculum4).addCourse(new Course(2L, "Библиотека JFC/Swing", 16L));
        curriculumRepository.setCurriculum(curriculum4).addCourse(new Course(3L, "Технология JDBC", 16L));
        curriculumRepository.setCurriculum(curriculum4).addCourse(new Course(4L, "Технология JAX", 52L));
        curriculumRepository.setCurriculum(curriculum4).addCourse(new Course(5L, "Библиотеки commons", 44L));
        System.out.println(student1.getSurname() + " - До окончания обучения по программе " + studyTimeService.calcStudentHoursUntilEndOfCurriculum(student1, trainingCenter) +
                " ч. Средний балл " + markService.calcAverageStudentMark(student1) + " " + markService.checkStudyStatus(student1, trainingCenter));
        System.out.println(student2.getSurname() + " - До окончания обучения по программе " + studyTimeService.calcStudentHoursUntilEndOfCurriculum(student2, trainingCenter) +
                " ч. Средний балл " + markService.calcAverageStudentMark(student2) + " " + markService.checkStudyStatus(student2, trainingCenter));
        System.out.println(student3.getSurname() + " - До окончания обучения по программе " + studyTimeService.calcStudentHoursUntilEndOfCurriculum(student3, trainingCenter) +
                " ч. Средний балл " + markService.calcAverageStudentMark(student3) + " " + markService.checkStudyStatus(student3, trainingCenter));
        System.out.println(student4.getSurname() + " - До окончания обучения по программе " + studyTimeService.calcStudentHoursUntilEndOfCurriculum(student4, trainingCenter) +
                " ч. Средний балл " + markService.calcAverageStudentMark(student4) + " " + markService.checkStudyStatus(student4, trainingCenter));

        for (Student student : trainingCenterService.sortStudentByAverageMark(trainingCenter)) {
            System.out.println(student.getSurname() + " - средний балл " + markService.calcAverageStudentMark(student));
        }

        for (Student student : trainingCenterService.sortStudentByTimeUntilStudyEnd(trainingCenter)) {
            System.out.println(student.getSurname() + " - до окончания обучения часов " + studyTimeService.calcStudentHoursUntilEndOfCurriculum(student, trainingCenter));
        }

        for (Student student : trainingCenterService.filterByChanceToSuccessfulCompleteCurriculum(trainingCenter)) {
            System.out.println(student.getSurname() + " - возможно успешно закончит курс");
        }

    }
}
