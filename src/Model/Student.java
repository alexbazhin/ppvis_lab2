package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lion on 12.03.2016.
 */
public class Student {
    public static List<Student> students = new ArrayList<>();
    String fullName;
    String group;
    String omissionsDisease;
    String omissionsOtherCauses;
    String omissionsWithoutGoodReason;
    String omissions;

    public Student(String fullName, String group, String omissionsDisease, String omissionsOtherCauses,
                   String omissionsWithoutGoodReason, String omissions) {
        this.fullName=fullName;
        this.group=group;
        this.omissionsDisease=omissionsDisease;
        this.omissionsOtherCauses=omissionsOtherCauses;
        this.omissionsWithoutGoodReason=omissionsWithoutGoodReason;
        this.omissions=omissions;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGroup() {
        return group;
    }

    public String getOmissionsDisease() {
        return omissionsDisease;
    }

    public String getOmissionsOtherCauses() {
        return omissionsOtherCauses;
    }

    public String getOmissionsWithoutGoodReason() {
        return omissionsWithoutGoodReason;
    }

    public String getOmissions() {
        return omissions;
    }
}
