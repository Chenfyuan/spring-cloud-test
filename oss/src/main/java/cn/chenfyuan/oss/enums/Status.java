package cn.chenfyuan.oss.enums;


public enum Status{
    START(1, "启用"), OFF(0, "停用");

    private Integer value;
    private String name;

    Status(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
