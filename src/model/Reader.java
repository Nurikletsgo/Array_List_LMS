package model;

import exception.MyException;
import model.enums.Gender;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    private Long Id;
    private String fullName;
    private String email;
    private Long phoneNumber;
    private Gender gender;

    public Reader() {
    }

    public Reader(long id, String fullName, String email, Long phoneNumber, Gender gender) {
        Id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        boolean choose = true;
        System.out.println("write reader fullName");
        while (choose) {
            try {
                String name =  new Scanner(System.in).nextLine();

                if (name.matches(".*\\d.*")) {
                    throw new MyException("адамдын аты тамгалар менен жазылат");
                }
                this.fullName = name;
                choose = false;
            }catch(MyException e ){
                System.err.println(e.getMessage());
            }
            catch (Exception e) {
                System.err.println("write letter");
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        boolean word = true;
        System.out.println("write reader email address ");
        while (word) {
            try {
                String email = new Scanner(System.in).nextLine();
                if (email.contains("@gmail.com") && (!email.equals(getEmail())) && !email.equals("@gmail.com")) {
                    this.email = email;
                    word = false;
                } else {
                    if (email.equals(getEmail())) {
                        System.err.println(" This email already exits");
                    } else if (email.equals("@gmail.com")) {
                        System.err.println("this email can't exist ");
                    } else {
                        System.err.println(" email address must contain characters '@gmail.com' !" + "\n Write again");
                    }
                }
            } catch (Exception e) {
                System.err.println(" write again");
            }
        }

    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        boolean num = true;
        System.out.println("write phone number ");
        while (num) {
            try {
                this.phoneNumber = new Scanner(System.in).nextLong();
                num = false;
            } catch (Exception e) {
                System.err.println("write number");
            }
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender() {
        boolean choose = true;
        System.out.println("Write gender \n"+ Arrays.toString(Gender.values()));
        while (choose) {
            try {
                this.gender = Gender.valueOf(new Scanner(System.in).nextLine());
                choose = false;
            } catch (Exception e) {
                System.err.println("write gender");
            }
        }
    }

    @Override
    public String toString() {
        return " \n" +
                "Reader ID = " + Id +
                ", fullName = " + fullName +
                ", email = " + email +
                ", phone number = " + phoneNumber +
                ", gender = " + gender;
    }
}
