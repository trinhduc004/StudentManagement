package org.example.share;

public enum AcademicPerformanceEnum {
    KEM("KÉM"),
    YEU("YẾU"),
    TRUNG_BINH("TRUNG BÌNH"),
    KHA("KHÁ"),
    GIOI("GIỎI"),
    XUAT_SAC("XUẤT SẮC");
    private final String giaTri;

    AcademicPerformanceEnum(String giaTri) {
        this.giaTri = giaTri;
    }
    public String getvalue(){
        return giaTri;
    }
}
