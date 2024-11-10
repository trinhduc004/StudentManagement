package org.example.share;

import java.util.Calendar;

public class Constant {
    //gioi han id
    public static final int MIN_ID = 1;
    //gioi han ten
    public static final int MAX_NAME_LENGTH = 100;
    //gioi han ngay sinh
    public static final int MIN_BIRTHDAY_YEAR = 1900;
    public static final int MAX_BIRTHDAY_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    //gioi han dia chi
    public static final int MAX_ADDRESS_LENGTH = 300;
    //gioi han chieu cao
    public static final float MIN_HEIGHT_CM = 50.0f;
    public static final float MAX_HEIGHT_CM = 300.0f;
    //gioi han can nang
    public static final float MIN_WEIGHT_KG = 5.0f;
    public static final float MAX_WEIGHT_KG = 1000.0f;
    //gioi han ma sinh vien
    public static final int MAX_STUDENT_ID_LENGTH = 10;
    //gioi han truong hoc
    public static final int MAX_SCHOOL_NAME_LENGTH = 200;
    //gioi han nam hoc
    public static final int MIN_YEAR = 1900;
    public static final int MAX_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    //gioi han diem
    public static final double MIN_GPA = 0.0f;
    public static final double MAX_GPA = 10.0f;
}
