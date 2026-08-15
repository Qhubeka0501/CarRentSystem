package za.ac.cput.domain;

import jakarta.persistence.Embeddable;

import java.util.Objects;

/*
 * Class Name: NextOfKin
 * Description: NextOfKin CarRentSystem class
 * Author: Qhubekani Shandu (231316267)
 * Date: 20 June 2026
 */

@Embeddable
public class NextOfKin {

    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String relationship;

    private NextOfKin(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.relationship = builder.relationship;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NextOfKin)) return false;
        NextOfKin that = (NextOfKin) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(relationship, that.relationship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, relationship);
    }

    @Override
    public String toString() {
        return "NextOfKin{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", relationship='" + relationship + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String relationship;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setRelationship(String relationship) {
            this.relationship = relationship;
            return this;
        }

        public Builder copy(NextOfKin nextOfKin) {
            this.firstName = nextOfKin.firstName;
            this.lastName = nextOfKin.lastName;
            this.phoneNumber = nextOfKin.phoneNumber;
            this.relationship = nextOfKin.relationship;
            return this;
        }

        public NextOfKin build() {
            return new NextOfKin(this);
        }
    }
}
