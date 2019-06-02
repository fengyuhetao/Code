package strategy;

public enum CashStrategy {
    NORMAL(1, "正常收费"),
    RETURN(2, "返利模式"),
    REBATE(3, "打折模式");

    private Integer code;
    private String description;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    CashStrategy(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
