import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

class InvalidException extends RuntimeException {
    public InvalidException(String message) {
        super(message);
    }
}

interface Menu {
    default void head_message() {
        System.out.println("\n\t\t\t**********************************************************");

        System.out.println("\t\t\t********* SRM APUNIVERSITY ***********");
        System.out.println("\t\t\t********* STUDENT AND STAFFMANAGEMENT ***********");
        System.out.println("\t\t\t********* SYSTEM***********");
        System.out.println("\t\t\t**********************************************************");
    }

    void display_menu();

    void display_choices();

    void get_userchoices() throws InterruptedException;
}

class Validation {
    public static boolean isNameValid(String name) {
        try {
            int i, len = name.length();
            for (i = 0; i < len; i++) {
                if (Character.isAlphabetic(name.charAt(i)) || name.charAt(i)

                        == ' ') {

                    continue;
                } else {
                    throw new InvalidException("Illegal characters entered in the name!!!");
                }
            }
            return true;
        } catch (InvalidException ex) {
            System.out.println("\n\t\t\t" + ex + "\n");
            return false;
        }
    }

    public static boolean isEmailValid(String email) {
        try {
            int i, len = email.length();
            if (email.charAt(0) == '.') {
                throw new InvalidException("Illegal characters entered in the email!!!");
            }
            for (i = 0; i < len; i++) {
                if (Character.isAlphabetic(email.charAt(i)) ||

                        Character.isDigit(email.charAt(i))

                        || email.charAt(i) == '.' || email.charAt(i) == '@') {

                    continue;
                } else {
                    throw new InvalidException("Illegal characters entered in the email!!!");
                }
            }
            return true;
        } catch (InvalidException ex) {
            System.out.println("\n\t\t\t" + ex + "\n");
            return false;
        }
    }

    public static boolean isPasswordValid(String password) {
        try {
            int i, len = password.length();
            for (i = 0; i < len; i++) {
                if (password.charAt(i) != ' ') {
                    continue;
                } else {
                    throw new InvalidException("Password cannot contain spaces!!!");
                }
            }
            return true;
        } catch (InvalidException ex) {
            System.out.println("\n\t\t\t" + ex + "\n");
            return false;
        }
    }

    public static boolean isNumberValid(String number) {
        try {
            int i, len = number.length();
            if (len == 10) {
                for (i = 0; i < len; i++) {
                    if (Character.isDigit(number.charAt(i))) {
                        continue;
                    } else {
                        throw new InvalidException("Illegal Phone Number Format");

                    }
                }
                return true;
            } else {
                throw new InvalidException("Illegal Phone Number Format");

            }
        } catch (InvalidException ex) {
            System.out.println("\n\t\t\t" + ex + "\n");
            return false;
        }
    }
}

class College {
    private int total_fee;
    private int total_classes;
    private double attendance_percentage;
    private int student_count;
    private int teacher_count;
    public List<Student> students;
    public List<Teacher> teachers;
    public List<String> subjects;
    public boolean f_check;
    public boolean a_check;
    public boolean c_check;
    public boolean s_check;

    public College() {
        total_fee = 0;
        total_classes = 0;
        attendance_percentage = 0.0d;
        student_count = 0;
        teacher_count = 0;
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        subjects = new ArrayList<>();
        f_check = false;
        a_check = false;
        c_check = false;
        s_check = false;
    }

    public void addStudent(Student s) {
        students.add(s);
        student_count++;
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
        teacher_count++;
    }

    public void addSubject(String s) {
        subjects.add(s);
    }

    public void setFees(int fee) {
        f_check = true;
        total_fee = fee;
    }

    public int getFees() {
        return total_fee;
    }

    public void setTotalclasses(int c) {
        c_check = true;
        total_classes = c;
    }

    public int getTotalclasses() {
        return total_classes;
    }

    public void setAttendancepercetange(double a) {
        a_check = true;
        attendance_percentage = a;
    }

    public double getAttendancepercentage() {
        return attendance_percentage;
    }

    public int getTotalStudents() {
        return student_count;
    }

    public int getTotalTeachers() {
        return teacher_count;
    }
}

class Student {
    static int student_regnumber = 21001181;
    private String name;
    private String reg_no;
    private String surname;
    private String f_name;
    private String f_surname;

    private String m_name;
    private String m_surname;
    private String email_id;
    private String parent_email_id;
    private String mobile_number;
    private String m_mobile_number;
    private String f_mobile_number;
    private int[] marks;
    private int fee_paid;
    private int fee_balance;
    private int attended_classes;
    private int absent_classes;
    private double attendance_percentage;
    private double marks_percentage;
    private String password;
    public boolean a_check;
    public boolean m_check;
    public boolean f_check;

    public Student() {
        name = "";
        surname = "";
        f_name = "";
        f_surname = "";
        m_name = "";
        m_surname = "";
        email_id = "";
        parent_email_id = "";
        mobile_number = "";
        m_mobile_number = "";
        f_mobile_number = "";
        fee_paid = 0;
        fee_balance = 0;
        marks = null;
        attended_classes = 0;
        absent_classes = 0;
        attendance_percentage = 0.0d;
        marks_percentage = 0.0d;
        password = "";
        a_check = false;
        m_check = false;
        f_check = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setRegNo(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getRegNo() {
        return reg_no;
    }

    public String getFullName() {
        return surname.toUpperCase() + " " + name.toUpperCase();
    }

    public void setFname(String f_name) {
        this.f_name = f_name;
    }

    public String getFname() {
        return f_name;
    }

    public void setFsurname(String f_surname) {
        this.f_surname = f_surname;
    }

    public String getFsurname() {
        return f_surname;
    }

    public String get_F_FullName() {
        return f_surname.toUpperCase() + " " + f_name.toUpperCase();
    }

    public void setMname(String m_name) {
        this.m_name = m_name;
    }

    public String getMname() {
        return m_name;
    }

    public void setMsurname(String m_surname) {
        this.m_surname = m_surname;
    }

    public String getMsurname() {
        return m_surname;
    }

    public String get_M_FullName() {
        return m_surname.toUpperCase() + " " + m_name.toUpperCase();
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getEmailid() {
        return email_id;
    }

    public void setPEmail_id(String parent_email_id) {
        this.parent_email_id = parent_email_id;
    }

    public String getPEmail_id() {
        return parent_email_id;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_F_number(String f_mobile_number) {
        this.f_mobile_number = f_mobile_number;
    }

    public String get_F_Mobile_number() {
        return f_mobile_number;
    }

    public void setMobile_M_number(String m_mobile_number) {
        this.m_mobile_number = m_mobile_number;
    }

    public String get_M_Mobile_number() {
        return m_mobile_number;
    }

    public void setMarks(int m[]) {
        int n = m.length;
        marks = new int[n];
        for (int i = 0; i < n; i++) {
            marks[i] = m[i];
        }
    }

    public int[] getMarks() {
        return marks;
    }

    public void setFeepaid(int fee_paid) {
        this.fee_paid = fee_paid;
    }

    public int getFeepaid() {
        return fee_paid;
    }

    public void setFeebalance(int fee_balance) {
        this.fee_balance = fee_balance;
    }

    public int getFeebalance() {
        return fee_balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String e_password) {
        if (password.equals(e_password)) {
            return true;
        }
        return false;
    }

    public void setAttendedClasses(int a) {

        attended_classes = a;
    }

    public int getAttendedClasses() {
        return attended_classes;
    }

    public void setAbsentClasses(int a) {
        absent_classes = a;
    }

    public int getAbsentClasses() {
        return absent_classes;
    }

    public void setAttendancepercetange(double ap) {
        this.attendance_percentage = ap;
    }

    public double getAttendancepercentage() {
        return attendance_percentage;
    }

    public void displayDetails() {
        System.out.println("\n\t\t\tSTUDENT NAME : " +
                getFullName());
        System.out.println("\t\t\tREGISTRATION NUMBER : " + getRegNo());
        System.out.println("\t\t\tFATHER NAME : " +
                get_F_FullName());
        System.out.println("\t\t\tMOTHER NAME : " +
                get_M_FullName());
        System.out.println("\t\t\tEMAIL ID : " + getEmailid());
        System.out.println("\t\t\tPARENT EMAIL ID : " +
                getPEmail_id());
        System.out.println("\t\t\tMOBILE NUMBER : " +
                getMobile_number());
        System.out.println("\t\t\tMOTHER MOBILE NUMBER : " +
                get_M_Mobile_number());
        System.out.println("\t\t\tFATHER MOBILE NUMBER : " +
                get_F_Mobile_number());
    }

    @Override
    public String toString() {
        return "Registration Number: " + getRegNo() + " Name: " + getName();
    }
}

class Teacher {
    public static int teacher_id = 190181;
    private String name;
    private String id;
    private String password;

    public Teacher() {
        name = "";
        id = "";
        password = "";
    }

    public Teacher(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public boolean checkPassword(String e_password) {
        if (password.equals(e_password)) {
            return true;
        }
        return false;
    }

    public void displayDetails() {
        System.out.println("\t\t\tTEACHER NAME : " + name);
        System.out.println("\t\t\tTEACHER ID : " + id);

        System.out.println("\t\t\tLOGIN PASSWORD : " + password + "\n");
    }
}

class StudentMenu implements Menu {
    private College c;
    private Scanner scan;

    public StudentMenu(College c) {
        this.c = c;
        scan = new Scanner(System.in);
    }

    public void display_menu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        head_message();
        System.out.println("\t\t\t==========================================================");
        System.out.println("\t\t\t============= STUDENT LOGINPAGE =============");
        System.out.println("\t\t\t==========================================================");
    }

    public void display_choices() {
        System.out.println("\n\t\t\t 1.Register");
        System.out.println("\t\t\t 2.Personal Details");
        System.out.println("\t\t\t 3.Attendance Details");
        System.out.println("\t\t\t 4.Fee Details");
        System.out.println("\t\t\t 5.Examination Marks Details");
        System.out.println("\t\t\t 0.Exit");
    }

    public void get_userchoices() throws InterruptedException {
        while (true) {
            display_menu();
            display_choices();
            int choice;
            System.out.print("\n\t\t\t Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                register_student();
            } else if (choice == 2) {
                show_personalDetails();
            } else if (choice == 3) {
                show_attendanceDetails();

            } else if (choice == 4) {
                show_feeDetails();
            } else if (choice == 5) {
                show_examMarks();
            } else if (choice == 0) {
                System.out.println("\n\t\t\t Exiting...");
                Thread.sleep(1000);
                break;
            }
        }
        System.out.print("\n\t\t\t Press Enter to Continue...");
        scan.nextLine();
    }

    private void register_student() {
        display_menu();
        String x;
        Student s = new Student();
        System.out.println("\n\t\t\t--- PLEASE ENTER YOUR DETAILSBELOW ---\n");
        x = "AP" + Integer.toString(Student.student_regnumber);
        System.out.println("\n\t\t\tYour registration number is " + x);
        s.setRegNo(x);
        do {
            System.out.print("\t\t\tEnter your Name : ");
            x = scan.nextLine();
        } while (!Validation.isNameValid(x));
        s.setName(x);
        do {
            System.out.print("\t\t\tEnter your Surname : ");
            x = scan.nextLine();
        } while (!Validation.isNameValid(x));
        s.setSurname(x);
        do {
            System.out.print("\t\t\tEnter your Father name : ");
            x = scan.nextLine();
        } while (!Validation.isNameValid(x));
        s.setFname(x);
        do {
            System.out.print("\t\t\tEnter your Father Surname : ");
            x = scan.nextLine();
        } while (!Validation.isNameValid(x));
        s.setFsurname(x);
        do {
            System.out.print("\t\t\tEnter your Mother Name : ");
            x = scan.nextLine();
        } while (!Validation.isNameValid(x));
        s.setMname(x);

        do {
            System.out.print("\t\t\tEnter your Mother Surname : ");
            x = scan.nextLine();
        } while (!Validation.isNameValid(x));
        s.setMsurname(x);
        do {
            System.out.print("\t\t\tEnter your Email Id : ");
            x = scan.nextLine();
        } while (!Validation.isEmailValid(x));
        s.setEmail_id(x);
        do {
            System.out.print("\t\t\tEnter your Parent Email Id : ");
            x = scan.nextLine();
        } while (!Validation.isEmailValid(x));
        s.setPEmail_id(x);
        do {
            System.out.print("\t\t\tEnter your Mobile Number : ");
            x = scan.nextLine();
        } while (!Validation.isNumberValid(x));
        s.setMobile_number(x);
        do {
            System.out.print("\t\t\tEnter your Father Mobile Number : ");
            x = scan.nextLine();
        } while (!Validation.isNumberValid(x));
        s.setMobile_F_number(x);
        do {
            System.out.print("\t\t\tEnter your Mother Mobile Number : ");
            x = scan.nextLine();
        } while (!Validation.isNumberValid(x));
        s.setMobile_M_number(x);
        String password, c_password;
        boolean ok;
        System.out.println("\n\t\t\t>>> SET PASSWORD FOR YOUR LOGIN:");
        do {
            do {
                System.out.print("\t\t\t>>> Enter your Password : ");
                password = scan.nextLine();
            } while (!Validation.isPasswordValid(password));
            do {
                System.out.print("\t\t\t>>> Confirm your Password : ");
                c_password = scan.nextLine();
            } while (!Validation.isPasswordValid(c_password));
            if (password.equals(c_password) != true) {
                System.out.println("\n\t\t\tError Confirm Password Not Match!!!\n");

                ok = false;
            } else {
                ok = true;

                s.setPassword(c_password);
            }
        } while (!ok);
        c.addStudent(s);
        Student.student_regnumber++;
        System.out.print("\n\t\t\tPress Enter to continue...");
        x = scan.nextLine();
    }

    private void show_personalDetails() {
        display_menu();
        int i, chances = 0;
        String reg_no, password;
        Student s;
        boolean found = false;
        System.out.print("\n\t\t\tEnter your registration number: ");
        reg_no = scan.nextLine();
        for (i = 0; i < c.students.size(); i++) {
            s = c.students.get(i);
            if (reg_no.equals(s.getRegNo())) {
                found = true;
                do {
                    System.out.print("\t\t\tEnter your password :");

                    password = scan.nextLine();
                    if (s.checkPassword(password)) {
                        s.displayDetails();
                        chances = 0;
                    } else {
                        System.out.println("\n\t\t\tIncorrect Password, Please Enter the correct Password!!!");
                        chances++;
                    }
                } while (chances != 0 && chances <= 3);
                break;
            }
        }
        if (!found) {
            System.out.println("\n\t\t\tSorry, The registration number does not exist!!!");
        }
        System.out.print("\n\t\t\tPress Enter to continue...");
        reg_no = scan.nextLine();
    }

    private void show_attendanceDetails() {
        display_menu();

        int i, chances = 0;
        String reg_no, password;
        Student s;
        boolean found = false;
        System.out.print("\n\t\t\tEnter your registration number: ");
        reg_no = scan.nextLine();
        for (i = 0; i < c.students.size(); i++) {
            s = c.students.get(i);
            if (reg_no.equals(s.getRegNo())) {
                found = true;
                do {
                    System.out.print("\t\t\tEnter your password :");

                    password = scan.nextLine();
                    if (s.checkPassword(password)) {
                        if (s.a_check == true) {
                            System.out.println("\n\t\t\tStudent Name : " +

                                    s.getName());

                            System.out.println("\t\t\tStudent Reg No : " +

                                    s.getRegNo());

                            System.out.println("\t\t\tClasses Attended : " +

                                    s.getAttendedClasses());

                            System.out.println("\t\t\tClasses Absent : " +

                                    s.getAbsentClasses());

                            System.out.printf("\t\t\tAttendance Percentage :%.2f\n", s.getAttendancepercentage());
                        } else {
                            System.out.println("\n\t\t\tYou attendance details are not Updated!!!");
                        }
                        chances = 0;
                    } else {
                        System.out.println("\n\t\t\tIncorrect Password, Please Enter the correct Password!!!");
                        chances++;
                    }
                } while (chances != 0 && chances <= 3);
                break;
            }
        }
        if (!found) {
            System.out.println("\n\t\t\tSorry, The registration number does not exist!!!");
        }
        System.out.print("\n\t\t\tPress Enter to continue...");
        reg_no = scan.nextLine();
    }

    private void show_feeDetails() {
        display_menu();
        int i, chances = 0;
        String reg_no, password;
        Student s;
        boolean found = false;
        System.out.print("\n\t\t\tEnter your registration number: ");
        reg_no = scan.nextLine();
        for (i = 0; i < c.students.size(); i++) {
            s = c.students.get(i);
            if (reg_no.equals(s.getRegNo())) {
                found = true;
                do {
                    System.out.print("\t\t\tEnter your password :");

                    password = scan.nextLine();
                    if (s.checkPassword(password)) {
                        if (s.f_check == true) {
                            System.out.println("\n\t\t\tStudent Name : " +

                                    s.getName());

                            System.out.println("\t\t\tStudent Reg No: " +

                                    s.getRegNo());

                            System.out.println("\t\t\tFee Paid : " +

                                    s.getFeepaid());

                            System.out.println("\t\t\tFee Due : " +

                                    s.getFeebalance());

                        } else {
                            System.out.println("\n\t\t\tYou Fee details are not Updated!!!");
                        }
                        chances = 0;
                    } else {
                        System.out.println("\n\t\t\tIncorrect Password, Please Enter the correct Password!!!");
                        chances++;
                    }
                } while (chances != 0 && chances <= 3);
                break;
            }
        }
        if (!found) {
            System.out.println("\n\t\t\tSorry, The registration number does not exist!!!");
        }
        System.out.print("\n\t\t\tPress Enter to continue...");
        reg_no = scan.nextLine();
        System.out.println("\n");
    }

    private void show_examMarks() {
        display_menu();
        int i, j, chances = 0;
        int[] marks;
        String reg_no, password;
        Student s;
        boolean found = false;
        System.out.print("\n\t\t\tEnter your registration number: ");
        reg_no = scan.nextLine();
        for (i = 0; i < c.students.size(); i++) {
            s = c.students.get(i);
            if (reg_no.equals(s.getRegNo())) {
                found = true;
                do {
                    System.out.print("\t\t\tEnter your password :");

                    password = scan.nextLine();
                    if (s.checkPassword(password)) {
                        if (s.m_check == true) {
                            System.out.println("\n\t\t\tExam Marks Details...");

                            marks = s.getMarks();
                            for (j = 0; j < marks.length; j++) {
                                System.out.println("\n\t\t\t[ Subject: " +

                                        c.subjects.get(j) + " ]");

                                System.out.println("\t\t\tMarks Secured in Subject: " + marks[j]);
                            }
                        } else {
                            System.out.println("\n\t\t\tYour marks are not Updated!!!");

                        }
                        chances = 0;
                    } else {
                        System.out.println("\n\t\t\tIncorrect Password, Please Enter the correct Password!!!");
                        chances++;
                    }
                } while (chances != 0 && chances <= 3);
                break;
            }
        }
        if (!found) {
            System.out.println("\n\t\t\tSorry, The registration number does not exist!!!");
        }
        System.out.print("\n\t\t\tPress Enter to continue...");

        scan.nextLine();
    }
}

class StaffMenu implements Menu {
    private College c;
    private Scanner scan;

    public StaffMenu(College c) {
        this.c = c;
        scan = new Scanner(System.in);
    }

    public void display_menu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        head_message();
        System.out.println("\t\t\t==========================================================");
        System.out.println("\t\t\t=============== STAFF LOGINPAGE ===============");
        System.out.println("\t\t\t==========================================================");
    }

    public void enter_menu() {
        display_menu();
        int i, chances = 0;
        String id, password;
        boolean found = false;
        Teacher t;
        System.out.print("\n\t\t\tEnter your Id : ");
        id = scan.nextLine();
        for (i = 0; i < c.teachers.size(); i++) {
            t = c.teachers.get(i);
            if (id.equals(t.getId())) {
                found = true;
                do {
                    System.out.print("\t\t\tEnter your Password : ");
                    password = scan.nextLine();
                    if (t.checkPassword(password)) {
                        get_userchoices();
                    } else {
                        System.out.println("\n\t\t\tIncorrect Password, Please Enter the correct Password!!!");
                        chances++;
                    }
                } while (chances != 0 && chances <= 3);

                break;
            }
        }
        if (!found) {
            System.out.println("\n\t\t\tSorry, The Teacher Id does not exist!!!");
        }
        System.out.print("\t\t\tPress Enter to continue...");
        scan.nextLine();
        System.out.println("\n");
    }

    public void display_choices() {
        System.out.println("\n\t\t\t 1.View Student Details");
        System.out.println("\t\t\t 2.Update Student Personal Details");
        System.out.println("\t\t\t 3.Update Student Fee Details");
        System.out.println("\t\t\t 4.Update Student Marks");
        System.out.println("\t\t\t 5.Update Student Attendance Details");
        System.out.println("\t\t\t 6.Delete a Student");
        System.out.println("\t\t\t 7.View Total Students");
        System.out.println("\t\t\t 8.View Total Student Details");
        System.out.println("\t\t\t 9.Update Classes");
        System.out.println("\t\t\t 10.Update Subjects");
        System.out.println("\t\t\t 0.Exit");
    }

    public void get_userchoices() {
        int choice;
        while (true) {
            display_menu();
            display_choices();
            System.out.print("\n\t\t\t Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                view_studentDetails();
            } else if (choice == 2) {
                update_studentPersonalDetails();
            } else if (choice == 3) {
                update_studentFeeDetails();
            } else if (choice == 4) {
                update_studentMarks();
            } else if (choice == 5) {
                update_studentAttendanceDetails();
            } else if (choice == 6) {
                delete_student();
            } else if (choice == 7) {
                view_totalStudents();

            } else if (choice == 8) {
                view_totalStudentDetails();
            } else if (choice == 9) {
                update_classes();
            } else if (choice == 10) {
                update_subjects();
            } else if (choice == 0) {
                break;
            }
        }
        System.out.print("\n\t\t\tPress Enter to continue...");
        scan.nextLine();
    }

    private void view_studentDetails() {
        display_menu();
        int i;
        String reg_no;
        Student s;
        boolean found = false;
        System.out.print("\n\t\t\tEnter student registration number: ");
        reg_no = scan.nextLine();
        for (i = 0; i < c.students.size(); i++) {
            s = c.students.get(i);
            if (reg_no.equals(s.getRegNo())) {
                System.out.println("\n\t\t\tStudent Details...");
                s.displayDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\n\t\t\tSorry, The registration number does not exist!!!");
        }
        System.out.print("\n\t\t\tPress Enter to continue...");
        scan.nextLine();
        System.out.println("\n");
    }

    private void update_studentPersonalDetails() {
        display_menu();
        int i, choice;
        String x, reg_no;
        Student s;
        boolean found = false;
        System.out.print("\n\t\t\tEnter student registration number: ");

        reg_no = scan.nextLine();
        for (i = 0; i < c.students.size(); i++) {
            s = c.students.get(i);
            if (reg_no.equals(s.getRegNo())) {
                do {
                    display_menu();
                    System.out.println("\n\t\t\t 1.Update Student Name");
                    System.out.println("\t\t\t 2.Update Student Surname");
                    System.out.println("\t\t\t 3.Update Student Father Name");
                    System.out.println("\t\t\t 4.Update Student Father Surname");

                    System.out.println("\t\t\t 5.Update Student Mother Name");
                    System.out.println("\t\t\t 6.Update Student Mother Surname");

                    System.out.println("\t\t\t 7.Update Student Email Id");
                    System.out.println("\t\t\t 8.Update Student Parent Email Id");

                    System.out.println("\t\t\t 9.Update StudentMobileNumber");

                    System.out.println("\t\t\t 10.Update Student Mother MobileNumber");

                    System.out.println("\t\t\t 11.Update student Father MobileNumber");

                    System.out.println("\t\t\t 0.Exit");
                    System.out.print("\n\t\t\tEnter your choice: ");
                    choice = scan.nextInt();
                    scan.nextLine();
                    if (choice == 1) {
                        System.out.println("\n\t\t\tStudent Name [Previous] :" + s.getName());

                        do {
                            System.out.print("\t\t\tEnter Student Name [New] :");

                            x = scan.nextLine();
                        } while (!Validation.isNameValid(x));
                        s.setName(x);
                        System.out.println("\n\t\t\tStudent Name Updated!!!");
                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 2) {
                        System.out.println("\n\t\t\tStudent Surname[Previous] : " + s.getSurname());
                        do {
                            System.out.print("\t\t\tEnter Student Surname[New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isNameValid(x));
                        s.setSurname(x);

                        System.out.println("\n\t\t\tStudent Surname Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 3) {
                        System.out.println("\n\t\t\tStudent FatherName[Previous] : " + s.getFname());
                        do {
                            System.out.print("\t\t\tEnter Student FatherName[New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isNameValid(x));
                        s.setFname(x);
                        System.out.println("\n\t\t\tStudent FatherName Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 4) {
                        System.out.println("\n\t\t\tStudent Father Surname[Previous] : " + s.getFsurname());
                        do {
                            System.out.print("\t\t\tEnter Student Father Surname [New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isNameValid(x));
                        s.setFsurname(x);
                        System.out.println("\n\t\t\tStudent Father Surname Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 5) {
                        System.out.println("\n\t\t\tStudent MotherName[Previous] : " + s.getMname());
                        do {
                            System.out.print("\t\t\tEnter Student MotherName[New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isNameValid(x));
                        s.setMname(x);
                        System.out.println("\n\t\t\tStudent MotherName Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 6) {
                        System.out.println("\n\t\t\tStudent Mother Surname[Previous] : " + s.getMsurname());
                        do {

                            System.out.print("\t\t\tEnter Student Mother Surname [New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isNameValid(x));
                        s.setMsurname(x);
                        System.out.println("\n\t\t\tStudent Mother Surname Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 7) {
                        System.out.println("\n\t\t\tStudent Email Id[Previous] : " + s.getEmailid());
                        do {
                            System.out.print("\t\t\tEnter Student Email Id[New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isEmailValid(x));
                        s.setEmail_id(x);
                        System.out.println("\n\t\t\tStudent Email Id Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 8) {
                        System.out.println("\n\t\t\tStudent Parent EmailId[Previous] : " + s.getPEmail_id());
                        do {
                            System.out.print("\t\t\tEnter Student Parent EmailId [New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isEmailValid(x));
                        s.setPEmail_id(x);
                        System.out.println("\n\t\t\tStudent Parent EmailId Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 9) {
                        System.out.println("\n\t\t\tStudent Mobile Number[Previous] : " + s.getMobile_number());

                        do {
                            System.out.print("\t\t\tEnter Student MobileNumber [New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isNumberValid(x));
                        s.setMobile_number(x);
                        System.out.println("\n\t\t\tStudent Mobile Number Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();

                    } else if (choice == 10) {
                        System.out.println(
                                "\n\t\t\tStudent Mother MobileNumber [Previous] : " + s.get_M_Mobile_number());

                        do {
                            System.out.print("\t\t\tEnter Student MotherMobileNumber [New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isNumberValid(x));
                        s.setMobile_M_number(x);
                        System.out.println("\n\t\t\tStudent MotherMobileNumber Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 11) {
                        System.out.println(
                                "\n\t\t\tStudent Father MobileNumber[Previous] : " + s.get_F_Mobile_number());

                        do {
                            System.out.print("\t\t\tEnter Student FatherMobileNumber [New] : ");

                            x = scan.nextLine();
                        } while (!Validation.isNumberValid(x));
                        s.setMobile_F_number(x);
                        System.out.println("\n\t\t\tStudent Father MobileNumber Updated!!!");

                        System.out.print("\t\t\tPress Enter to continue...");
                        scan.nextLine();
                    } else if (choice == 0) {
                        break;
                    }
                } while (true);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\n\t\t\tSorry, The registration number does not exist!!!");
        }
        System.out.print("\n\t\t\tPress Enter to continue...");
        scan.nextLine();
    }

    private void update_studentFeeDetails() {
        display_menu();
        int i, f, b;
        String reg_no;

        Student s;
        boolean found = false;
        if (c.f_check == true) {
            System.out.print("\n\t\t\tEnter student registration number: ");
            reg_no = scan.nextLine();
            for (i = 0; i < c.students.size(); i++) {
                s = c.students.get(i);
                if (reg_no.equals(s.getRegNo())) {
                    if (s.f_check == true) {
                        System.out.print("\n\t\t\tFee paid : " +

                                s.getFeepaid());

                        System.out.print("\t\t\tFee Due : " +

                                s.getFeebalance());
                    }
                    System.out.print("\n\t\t\tEnter Fee paid[New]: ");
                    f = scan.nextInt();
                    scan.nextLine();
                    f += s.getFeepaid();
                    b = c.getFees() - f;
                    s.setFeepaid(f);
                    s.setFeebalance(b);
                    System.out.println("\n\t\t\tStudent Fee Details Updated!!!");

                    System.out.println("\t\t\tStudent Name : " +

                            s.getName());

                    System.out.println("\t\t\tStudent Reg No: " +

                            s.getRegNo());

                    System.out.println("\t\t\tFee Paid : " +

                            s.getFeepaid());

                    System.out.println("\t\t\tFee Due : " +

                            s.getFeebalance());

                    s.f_check = true;
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("\n\t\t\tSorry, The registration numberdoes not exist!!!");
            }
        } else {
            System.out.println("\n\t\t\tTotal Fee not yet updated!!!");
        }
        System.out.print("\t\t\tPress Enter to continue...");
        scan.nextLine();
    }

    private void update_studentMarks() {
        display_menu();
        int i, j;
        int[] marks;
        String reg_no;
        Student s;
        boolean found = false;
        if (c.s_check == true) {
            System.out.print("\n\t\t\tEnter student registration number: ");
            reg_no = scan.nextLine();
            System.out.println();
            for (i = 0; i < c.students.size(); i++) {
                s = c.students.get(i);
                if (reg_no.equals(s.getRegNo())) {
                    found = true;
                    marks = new int[c.subjects.size()];
                    for (j = 0; j < marks.length; j++) {
                        System.out.println("\n\t\t\t[ Subject: " +

                                c.subjects.get(j) + " ]");

                        System.out.print("\t\t\tEnter Marks scored in Subject:");

                        marks[i] = scan.nextInt();
                    }
                    scan.nextLine();
                    s.setMarks(marks);
                    System.out.println("\n\t\t\tStudent Marks updated!!!");
                    s.m_check = true;
                }
            }
            if (!found) {
                System.out.println("\n\t\t\tSorry, The registration number does not exist!!!");
            }
        } else {
            System.out.println("\n\t\t\tSemester Subjects not yet updated!!!");
        }
        System.out.print("\t\t\tPress Enter to continue...");
        scan.nextLine();
    }

    private void update_classes() {
        display_menu();
        int classes;
        if (c.c_check == true) {

            System.out.println("\t\t\tCompleted Classes : " +

                    c.getTotalclasses());
        }
        System.out.print("\n\t\t\tEnter Number of classes held: ");
        classes = scan.nextInt();
        scan.nextLine();
        classes += c.getTotalclasses();
        c.setTotalclasses(classes);
        c.c_check = true;
        System.out.println("\n\t\t\tClasses Updated!!!");
        System.out.println("\t\t\tTotal Classes Held : " +
                c.getTotalclasses());
        System.out.print("\n\t\t\tPress Enter to Continue...");
        scan.nextLine();
    }

    private void update_studentAttendanceDetails() {
        display_menu();
        int i, at, ab;
        double ap;
        String reg_no;
        Student s;
        boolean found = false;
        if (c.c_check == true) {
            System.out.print("\n\t\t\tEnter student registration number: ");
            reg_no = scan.nextLine();
            for (i = 0; i < c.students.size(); i++) {
                s = c.students.get(i);
                if (reg_no.equals(s.getRegNo())) {
                    System.out.println("\n\t\t\tTotal Classes Completed: " +

                            c.getTotalclasses());

                    if (s.a_check == true) {
                        System.out.println("\n\t\t\tClasses Attended : "

                                + s.getAttendedClasses());

                        System.out.println("\t\t\tClasses Absent : " +

                                s.getAbsentClasses());
                    }
                    System.out.print("\n\t\t\tEnter classes Attended [New]:");

                    at = scan.nextInt();
                    scan.nextLine();
                    at += s.getAttendedClasses();
                    ab = c.getTotalclasses() - at;
                    ap = ((double) at / c.getTotalclasses()) * 100;
                    s.setAttendedClasses(at);
                    s.setAbsentClasses(ab);
                    s.setAttendancepercetange(ap);

                    System.out.println("\n\t\t\tStudent Attended Details Updated!!!");

                    System.out.println("\t\t\tStudent Name : " + s.getName());

                    System.out.println("\t\t\tStudent Reg No : " + s.getRegNo());

                    System.out.println("\t\t\tClasses Attended : " + s.getAttendedClasses());

                    System.out.println("\t\t\tClasses Absent : " + s.getAbsentClasses());

                    System.out.printf("\t\t\tAttendance Percentage : %.2f\n", s.getAttendancepercentage());
                    s.a_check = true;
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("\n\t\t\tSorry, The registration number does not exist!!!");
            }
        } else {
            System.out.println("\n\t\t\tClassses not yet updated!!!");
        }
        System.out.print("\n\t\t\tPress Enter to continue...");
        scan.nextLine();
    }

    private void delete_student() {
        display_menu();
        int i, index = 0;
        String reg_no;
        Student s = null;
        boolean found = false;
        if (c.f_check == true) {
            System.out.print("\n\t\t\tEnter student registration number: ");
            reg_no = scan.nextLine();
            for (i = 0; i < c.students.size(); i++) {
                s = c.students.get(i);
                if (reg_no.equals(s.getRegNo())) {
                    index = i;
                    found = true;
                    break;
                }
            }
            if (found) {
                c.students.remove(index);

                System.out.println("\t\t\tStudent " + s.getName() + " details Deleted!!!");
            }
            if (!found) {
                System.out.println("\n\t\t\tSorry, The registration number does not exist!!!");
            }
        }
        System.out.print("\t\t\tPress Enter to continue...");
        scan.nextLine();
    }

    private void view_totalStudents() {
        System.out.println("\n\t\t\t Number of Students in College: " +
                c.getTotalStudents());
        System.out.print("\n\t\t\tPress Enter to Continue...");
        scan.nextLine();
    }

    private void view_totalStudentDetails() {
        display_menu();
        Student s;
        int i;
        System.out.println("\n\t\t\tStudents Details...");
        for (i = 0; i < c.students.size(); i++) {
            s = c.students.get(i);
            System.out.print("\t\t\t[Student " + (i + 1) + "] ");
            System.out.println(s);
        }
        System.out.print("\n\t\t\tPress Enter to continue...");
        scan.nextLine();
    }

    private void update_subjects() {
        display_menu();
        System.out.println("\n\t\t\t============ UPDATE SEMESTERSUBJECTS ===============");
        int i, n;
        String subject;
        System.out.print("\n\t\t\tEnter number of subjects: ");
        n = scan.nextInt();
        scan.nextLine();
        System.out.println("\n");
        for (i = 0; i < n; i++) {
            System.out.print("\t\t\tEnter Subject " + (i + 1) + " name: ");
            subject = scan.nextLine();
            c.addSubject(subject);

        }
        c.s_check = true;
        System.out.print("\n\t\t\tPress Enter to Continue...");
        scan.nextLine();
    }
}

class AdminMenu implements Menu {
    private College c;
    Scanner scan;
    String name = "Sairam", password = "Sairam4589";

    public AdminMenu(College c) {
        this.c = c;
        scan = new Scanner(System.in);
    }

    public void display_menu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        head_message();
        System.out.println("\t\t\t==========================================================");
        System.out.println("\t\t\t=============== ADMIN LOGINPAGE ===============");
        System.out.println("\t\t\t==========================================================");
    }

    public void display_choices() {
        System.out.println("\n\t\t\t 1.View Teacher Details");
        System.out.println("\t\t\t 2.Add a Teacher");
        System.out.println("\t\t\t 3.Remove a Teacher");
        System.out.println("\t\t\t 4.Set Annual Fees");
        System.out.println("\t\t\t 5.Set Attendance Criteria");
        System.out.println("\t\t\t 0.Exit");
    }

    public void enter_menu() throws InterruptedException {
        display_menu();
        String n, p;
        int chances = 0;
        System.out.print("\n\t\t\tEnter Admin Name : ");
        n = scan.nextLine();
        if (name.equals(n)) {
            do {
                System.out.print("\t\t\tEnter Admin Password : ");
                p = scan.nextLine();

                if (p.equals(password)) {
                    System.out.println("\n\t\t\tLogin Verified...");
                    Thread.sleep(1);
                    get_userchoices();
                    chances = 0;
                } else {
                    System.out.println("\n\t\t\t[Password Unmatch] - Please ReEnter the correct Password!!");
                    chances++;
                }
            } while (chances != 0 && chances < 3);
        } else {
            System.out.println("\n[Error] - Invalid Admin Name!!");
            Thread.sleep(1000);
        }
    }

    public void get_userchoices() throws InterruptedException {
        while (true) {
            display_menu();
            display_choices();
            int choice;
            System.out.print("\n\t\t\tEnter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                view_teacher();
            } else if (choice == 2) {
                add_teacher();
            } else if (choice == 3) {
                remove_teacher();
            } else if (choice == 4) {
                update_fees();
            } else if (choice == 5) {
                update_attendanceCriteria();
            } else if (choice == 0) {
                System.out.println("\n\t\t\tExiting....");
                break;
            }
        }
        System.out.print("\n\t\t\tPress Enter to continue...");
        scan.nextLine();
    }

    private void view_teacher() {
        display_menu();

        String id;
        Teacher t;
        boolean found = false;
        if (c.teachers.size() != 0) {
            System.out.print("\n\t\t\tEnter Teacher Id: ");
            id = scan.nextLine();
            for (int i = 0; i < c.teachers.size(); i++) {
                t = c.teachers.get(i);
                if (id.equals(t.getId())) {
                    System.out.println("\n\t\t\tTeacher Details...");
                    t.displayDetails();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("\t\t\tSorry, Teacher Id does not exist!!!");
            }
        } else {
            System.out.println("\n\t\t\tTeacher not added yet!!!");
        }
        System.out.print("\n\t\t\tPress Enter to Continue...");
        scan.nextLine();
    }

    private void add_teacher() {
        display_menu();
        String name, id, password;
        Teacher t;
        System.out.println("\n\t\t\tEnter Teacher Details...");
        System.out.print("\t\t\tEnter Teacher Name: ");
        name = scan.nextLine();
        id = "AP" + Integer.toString(Teacher.teacher_id) + "SEAS";
        System.out.println("\t\t\tTeacher Id [AI generated] : " + id);
        password = Character.toString(name.charAt(0)) + "@" +
                Integer.toString(Teacher.teacher_id / 5) + "-SEAS-"

                + Character.toString(name.charAt(name.length() - 1)) + "/AP";
        System.out.println("\t\t\tLogin password [AI generated] : " +
                password + "\n");
        t = new Teacher(name, id, password);
        c.addTeacher(t);
        Teacher.teacher_id++;
        System.out.println("\t\t\tTeacher Added successfully!!!");
        System.out.print("\t\t\tPress Enter to Continue...");
        scan.nextLine();
    }

    private void remove_teacher() {
        display_menu();
        int i, index = 0;
        String id;
        Teacher t = null;
        boolean found = false;
        System.out.print("\n\t\t\tEnter Teacher Id: ");
        id = scan.nextLine();
        for (i = 0; i < c.teachers.size(); i++) {
            t = c.teachers.get(i);
            if (id.equals(t.getId())) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            c.teachers.remove(index);
            System.out.println("\n\t\t\tTeacher " + t.getName() + " detailsremoved successfully!!!");
        } else {
            System.out.println("\n\t\t\tSorry, Can't find Teacher with entered Id!!!");
        }
        System.out.print("\t\t\tPress Enter to Continue...");
        scan.nextLine();
    }

    private void update_fees() {
        display_menu();
        System.out.println("\n\t\t\t============ SET ANNUALFEES ===============");
        int new_fees;
        if (c.f_check == true) {
            System.out.print("\n\t\t\tPrevious Annual Fee : " + c.getFees() + "\n");

            System.out.print("\t\t\tEnter new Annual Fee : ");
            new_fees = scan.nextInt();
            scan.nextLine();
            c.setFees(new_fees);
        } else {
            System.out.print("\t\t\tEnter Annual Fee: ");
            new_fees = scan.nextInt();
            scan.nextLine();
            c.setFees(new_fees);
        }
        System.out.println("\n\t\t\tAnnual Fee Successfully Updated!!!");

        System.out.print("\t\t\tPress Enter to Continue...");
        scan.nextLine();
    }

    private void update_attendanceCriteria() {
        float attendance;
        if (c.a_check == true) {
            System.out.println("\t\t\tMinimum Attendance(%) [Previous] : " +

                    c.getAttendancepercentage());

            System.out.print("\t\t\tEnter Minimum Attendance (%) [New]: ");
            attendance = scan.nextFloat();
            scan.nextLine();
        } else {
            System.out.print("\t\t\tEnter Minimum Attendance (%) [New]: ");
            attendance = scan.nextFloat();
            scan.nextLine();
        }
        c.setAttendancepercetange(attendance);
        System.out.print("\t\t\tPress Enter to Continue...");
        scan.nextLine();
    }
}

class MainMenu implements Menu {
    private College c;
    Scanner scan;

    public MainMenu() {
        c = new College();
        scan = new Scanner(System.in);
    }

    public void display_menu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        head_message();
        System.out.println("\t\t\t==========================================================");
        System.out.println("\t\t\t=============== MAINMENU ===============");
        System.out.println("\t\t\t==========================================================");
    }

    public void display_choices() {
        System.out.println("\n\t\t\t 1.ADMIN LOGIN");
        System.out.println("\t\t\t 2.STAFF LOGIN");
        System.out.println("\t\t\t 3.STUDENT LOGIN");

        System.out.println("\t\t\t 0.Exit");
    }

    public void get_userchoices() throws InterruptedException {
        int choice;
        String x;
        while (true) {
            display_menu();
            display_choices();
            System.out.print("\n\t\t\tEnter your choice: ");
            choice = scan.nextInt();
            x = scan.nextLine();
            if (choice == 1) {
                System.out.print("\t\t\tRedirecting to Admin Page");
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(1000);
                }
                AdminMenu a = new AdminMenu(c);
                a.enter_menu();
            } else if (choice == 2) {
                System.out.print("\t\t\tRedirecting to Staff Page");
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(1000);
                }
                StaffMenu st = new StaffMenu(c);
                st.enter_menu();
            } else if (choice == 3) {
                System.out.print("\t\t\tRedirecting to Student Page");
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(1000);
                }
                StudentMenu su = new StudentMenu(c);
                su.get_userchoices();
            } else if (choice == 0) {
                System.out.print("\t\t\tExiting from System");
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(1000);
                }
                System.out.print("\n\t\t\tPress Enter to Continue...");
                scan.nextLine();
                break;
            }
        }
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MainMenu m = new MainMenu();
        m.get_userchoices();
    }
}
