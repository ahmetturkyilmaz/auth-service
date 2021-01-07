package com.fitness.authservice.exception;

public class ExceptionMessages {

    public final static String INVALID_USERNAME_PASSWORD = "You have entered an invalid username or password";



    /* EMAIL VALIDATION MESSAGES */
    public final static String EMAIL_ADDRESS_MANDATORY = "EMAIL ADDRESS IS MANDATORY";
    public final static int EMAIL_ADDRESS_MANDATORY_CODE = 1020;

    public final static String EMAIL_ADDRESS_NOT_VALID = "The given email address is not valid.";
    public final static int EMAIL_ADDRESS_NOT_VALID_CODE = 1021;

    public final static String EMAIL_ALREADY_EXIST = "The given email address is already exist in the system.";
    public final static int EMAIL_ALREADY_EXIST_CODE = 1022;


    /* USERNAME VALIDATION MESSAGES */
    public final static String USERNAME_MANDATORY = "USERNAME IS MANDATORY";
    public final static int USERNAME_MANDATORY_CODE = 1010;

    public final static String USERNAME_CONTAINS_SPECIAL_CHARACTERS = "The given username contains special characters";
    public final static int USERNAME_CONTAINS_SPECIAL_CHARACTERS_CODE = 1011;

    public final static String USERNAME_ALREADY_EXIST = "The given username is already exist in the system";
    public final static int USERNAME_ALREADY_EXIST_CODE = 1012;

    public final static String USERNAME_OR_EMAIL_NOT_FOUND = "Username or email not found";
    public final static int USERNAME_OR_EMAIL_NOT_FOUND_CODE = 1013;

    public final static String USERNAME_NOT_FOUND = "Username not found";
    public final static int USERNAME_NOT_FOUND_CODE = 1014;

    public final static String USER_HAS_BEEN_BLOCKED = "User has been blocked";
    public final static int USER_HAS_BEEN_BLOCKED_CODE = 1045;

    /* PASSWORD VALIDATION MESSAGES */
    public final static String PASSWORD_IS_WRONG = "The given password is wrong";
    public final static int PASSWORD_IS_WRONG_CODE = 1030;

    public final static String PASSWORD_IS_NOT_MATCHED = "The password must contain at least a lowercase, an upper case, 2 number, a special character and it must be minimum 8 characters.";
    public final static int PASSWORD_IS_NOT_MATCHED_CODE = 1031;

    public final static String PASSWORD_IS_MANDATORY = "Password is mandatory";
    public final static int PASSWORD_IS_MANDATORY_CODE = 1032;



}