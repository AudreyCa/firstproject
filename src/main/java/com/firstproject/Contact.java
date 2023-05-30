package com.firstproject;

public class Contact {

    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String phoneNumber;

    // Notre constructeur : (pour instancier le nouvel objet Contact (newContact)
    // dans PhoneBook)
    public Contact(String lastName, String firstName, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    // Les Getter et Setter des attributs ci-dessus :
    /*
     * public String getLastName() {
     * return this.lastName;
     * }
     * public void setLastName(String lastName) {
     * this.lastName = lastName;
     * }
     * public String getFirstName() {
     * return this.firstName;
     * }
     * public void setFirstName(String firstName) {
     * this.firstName = firstName;
     * }
     * public String getPhoneNumber() {
     * return this.phoneNumber;
     * }
     * public void setPhoneNumber(String phoneNumber) {
     * this.phoneNumber = phoneNumber;
     * }
     */

}
