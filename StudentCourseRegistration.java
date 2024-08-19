
import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String courseName;
    private int credits;

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }
}

class Student {
    private String studentId;
    private String studentName;
    private ArrayList<Course> registeredCourses;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println("Course registered successfully!");
    }

    public void viewRegisteredCourses() {
        System.out.println("Registered Courses:");
        for (Course course : registeredCourses) {
            System.out.println(
                    course.getCourseCode() + " - " + course.getCourseName() + " (" + course.getCredits() + " credits)");
        }
    }
}

public class StudentCourseRegistration {
    private static ArrayList<Course> courses;
    private static ArrayList<Student> students;

    public static void main(String[] args) {
        courses = new ArrayList<>();
        students = new ArrayList<>();

        // Add some sample courses
        courses.add(new Course("CS101", "Introduction to Computer Science", 3));
        courses.add(new Course("MATH102", "Calculus II", 4));
        courses.add(new Course("ENGL103", "English Composition", 3));

        // Add some sample students
        students.add(new Student("S051", "Neha Jha"));
        students.add(new Student("S040", "Priyanka late"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Course Registration System");
            System.out.println("-------------------------------");
            System.out.println("1. Register for a course");
            System.out.println("2. View registered courses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerCourse(scanner);
                    break;
                case 2:
                    viewRegisteredCourses(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerCourse(Scanner scanner) {
        System.out.print("Enter your student ID: ");
        String studentId = scanner.next();

        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found. Please try again.");
            return;
        }

        System.out.println("Available courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseCode() + " - " + courses.get(i).getCourseName()
                    + " (" + courses.get(i).getCredits() + " credits)");
        }

        System.out.print("Enter the course number you want to register for: ");
        int courseNumber = scanner.nextInt();

        Course course = courses.get(courseNumber - 1);
        student.registerCourse(course);
    }

    private static void viewRegisteredCourses(Scanner scanner) {
        System.out.print("Enter your student ID: ");
        String studentId = scanner.next();

        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found. Please try again.");
            return;
        }

        student.viewRegisteredCourses();
    }

    private static Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
