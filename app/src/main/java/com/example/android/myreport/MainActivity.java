package com.example.android.myreport;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public class ReportCard {
        private ArrayList<Grade> grades;
        private int numGrades;

        /**
         * Constructor for ReportCard class.
         */
        public ReportCard() {
            this.grades = new ArrayList<>();
            this.numGrades = 0;
        }

        /**
         * Adds a new grade to the current list of grades, if it does not already exist.
         *
         * @param newSubject: name of the subject.
         * @param newGrade:   grade for the subject.
         * @return true, if the grade has been added, or false, if the subject already existed.
         */
        public boolean setGrade(String newSubject, double newGrade) {
            boolean res = true;
            for (Grade grade : this.grades) {
                if (grade.getSubject().toLowerCase().equals(newSubject.toLowerCase())) {
                    // Subject found. The grade will not be added.
                    res = false;
                    break;
                }
            }

            if (res) {
                // The grade is added because the subject has not been found in the list.
                Grade grade = new Grade(newSubject, newGrade);
                this.grades.add(grade);
                numGrades++;
            }

            return res;
        }

        /**
         * Modifies an existing grade.
         *
         * @param subject:  name of the subject.
         * @param newGrade: new grade for the subject.
         * @return true, if the grade has been modified, or false, if the subject does not exist.
         */
        public boolean modifyGrade(String subject, double newGrade) {
            boolean res = false;
            int n = 0;
            for (Grade grade : this.grades) {
                if (grade.getSubject().toLowerCase().equals(subject.toLowerCase())) {
                    // Subject found. The grade is modified.
                    grade.setGrade(newGrade);
                    this.grades.set(n, grade);
                    res = true;
                    break;
                }
                n++;
            }
            return res;
        }

        /**
         * Deletes an existing grade.
         *
         * @param subject; name of the subject.
         * @return true, if the grade has been deleted, or false, if the subject does not exist.
         */
        public boolean deleteGrade(String subject) {
            boolean res = false;
            int n = 0;
            for (Grade grade : this.grades) {
                if (grade.getSubject().toLowerCase().equals(subject.toLowerCase())) {
                    // Subject found. The grade is deleted.
                    this.grades.remove(n);
                    this.numGrades--;
                    res = true;
                    break;
                }
                n++;
            }
            return res;
        }

        /**
         * Looks for the grade of a subject.
         *
         * @param subject: name of the subject.
         * @return the grade fot the subject, if exists; -1 otherwise.
         */
        public double getGrade(String subject) {
            double res = -1;
            for (Grade grade : this.grades) {
                if (grade.getSubject().toLowerCase().equals(subject.toLowerCase())) {
                    // Subject found. Return the grade for the subject.
                    res = grade.getGrade();
                    break;
                }
            }
            return res;
        }

        /**
         * @return the current number of subjects/grades.
         */
        public int getNumGrades() {
            return this.numGrades;
        }

        /**
         * @return the list of grades in a human-readable string.
         */
        @Override
        public String toString() {
            String gradesList = "";
            for (int n = 0; n < this.numGrades; n++) {
                // Writes the current line with the name of the subject and its grade.
                gradesList = gradesList + "Subject \"" + this.grades.get(n).getSubject() +
                        "\": grade " + this.grades.get(n).getGrade();

                // Adds a "new line" character if the current line is not the last one.
                if (n < (this.numGrades - 1)) gradesList = gradesList + "\n";
            }
            return gradesList;
        }

        /**
         * Class for representing a pair subject/grade.
         */
        private class Grade {
            private String subject;    // Name of the subject.
            private double grade;      // Grade for the subject.

            /**
             * Constructor for Grade class.
             *
             * @param subject: name of the subject.
             * @param grade:   grade for the subject.
             */
            private Grade(String subject, double grade) {
                this.subject = subject;
                this.grade = grade;
            }

            /**
             * @return the name of the subject.
             */
            private String getSubject() {
                return this.subject;
            }

            /**
             * @return the grade of the subject.
             */
            private double getGrade() {
                return this.grade;
            }
            /**
             * Sets the name of the subject.
             *
             * @param subject: name of the subject.
             */
            public void setSubject(String subject) {
                this.subject = subject;
            }

            /**
             * Sets the grade for the subject.
             *
             * @param grade: grade of the subject.
             */
            private void setGrade(double grade) {
                this.grade = grade;
            }
        }
    }

    }
