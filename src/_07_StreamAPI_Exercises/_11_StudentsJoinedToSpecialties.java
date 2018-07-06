package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _11_StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSp> students = new ArrayList<>();
        List<StudentSpeciality11> specialities = new ArrayList<>();

        while (true){
            String[] input = reader.readLine().split("\\s+");
            if("Students:".equals(input[0])){
                break;
            }
            String specialityName = input[0] +" " + input[1];
            Integer facNum = Integer.valueOf(input[2]);
            StudentSpeciality11 speciality = new StudentSpeciality11(specialityName, facNum);
            specialities.add(speciality);
        }

        while (true){
            String[] input = reader.readLine().split("\\s+");
            if("END".equals(input[0])){
                break;
            }
            StudentSp student = new StudentSp(input[1] + " " + input[2], Integer.valueOf(input[0]));
            students.add(student);
        }

        students.stream().sorted(Comparator.comparing(StudentSp::get_name))
                .forEach(student -> specialities.stream().filter((spec) -> spec.get_facultyNumber() == student.get_facultyNumber())
                        .forEach(speciality ->
                                System.out.printf("%s %s %s\n", student.get_name().trim(), student.get_facultyNumber(), speciality.get_name())));
    }
}
class StudentSpeciality11{

    private String _name;
    private int _facultyNumber;

    StudentSpeciality11(String name, int facultyNumber){
        this._facultyNumber = facultyNumber;
        this._name = name;
    }

    int get_facultyNumber() {
        return _facultyNumber;
    }

    String get_name() {
        return _name;
    }
}

class StudentSp{

    private String _name;
    private int _facultyNumber;

    StudentSp(String name, int facultyNumber){
        this._facultyNumber = facultyNumber;
        this._name = name;
    }

    int get_facultyNumber() {
        return _facultyNumber;
    }

    String get_name() {
        return _name;
    }
}

