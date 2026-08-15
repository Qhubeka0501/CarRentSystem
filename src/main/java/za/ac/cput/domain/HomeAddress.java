package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HomeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long addressId;
    private String streetNumber;
    private String houseNumber;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public HomeAddress(){

    }

    public HomeAddress(Builder builder){
        this.streetNumber = builder.streetNumber;
        this.houseNumber = builder.houseNumber;
        this.city = builder.city;
        this.province= builder.province;
        this.postalCode = builder.postalCode;
        this.country = builder.country;

    }

    public Long getAddressId() {
        return addressId;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }


    @Override
    public String toString() {
        return "HomeAddress{" +
                "addressId=" + addressId +
                ", streetNumber='" + streetNumber + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public  static  class Builder{


        private String streetNumber;
        private String houseNumber;
        private String city;
        private String province;
        private String postalCode;
        private String country;

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return  this;
        }


        public Builder setCity(String city) {
            this.city = city;
            return  this;
        }

        public Builder setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;

            return  this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return  this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return  this ;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return  this;
        }


        public Builder copy(HomeAddress homeAddress) {
            this.country = homeAddress.getCountry();
            this.city = homeAddress.getCity();
            this.postalCode = homeAddress.getPostalCode();
            this.province = homeAddress.getProvince();
            this.houseNumber = homeAddress.getHouseNumber();
            this.streetNumber = homeAddress.getStreetNumber();
            return  this;
        }

        public  HomeAddress build(){
            return  new HomeAddress(this);
        }}}

