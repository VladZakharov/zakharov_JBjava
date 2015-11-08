package model.enums;

/**
 * Created by vlad on 27.10.15.
 */
public enum PeopleType {

    STUFF {
        public String toString() {
            return "Stuff";
        }
    },
    PATIENT {
        public String toString() {
            return "Patient";
        }
    }

}
