package za.ac.cput.domain;



import java.util.Objects;

    public class NextOfKin {
        private final String nextOfKinId;
        private final String personId;
        private final String fullName;
        private final String phoneNumber;
        private final String relationship;

        private NextOfKin(Builder builder) {
            this.nextOfKinId = builder.nextOfKinId;
            this.personId = builder.personId;
            this.fullName = builder.fullName;
            this.phoneNumber = builder.phoneNumber;
            this.relationship = builder.relationship;
        }

        public String getNextOfKinId() { return nextOfKinId; }
        public String getPersonId() { return personId; }
        public String getFullName() { return fullName; }
        public String getPhoneNumber() { return phoneNumber; }
        public String getRelationship() { return relationship; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NextOfKin that = (NextOfKin) o;
            return Objects.equals(nextOfKinId, that.nextOfKinId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nextOfKinId);
        }

        @Override
        public String toString() {
            return "NextOfKin{" +
                    "nextOfKinId='" + nextOfKinId + '\'' +
                    ", personId='" + personId + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", relationship='" + relationship + '\'' +
                    '}';
        }

        public static class Builder {
            private String nextOfKinId;
            private String personId;
            private String fullName;
            private String phoneNumber;
            private String relationship;

            public Builder setNextOfKinId(String nextOfKinId) {
                this.nextOfKinId = nextOfKinId;
                return this;
            }

            public Builder setPersonId(String personId) {
                this.personId = personId;
                return this;
            }

            public Builder setFullName(String fullName) {
                this.fullName = fullName;
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
                this.nextOfKinId = nextOfKin.nextOfKinId;
                this.personId = nextOfKin.personId;
                this.fullName = nextOfKin.fullName;
                this.phoneNumber = nextOfKin.phoneNumber;
                this.relationship = nextOfKin.relationship;
                return this;
            }

            public NextOfKin build() {
                return new NextOfKin(this);
            }
        }
    }

