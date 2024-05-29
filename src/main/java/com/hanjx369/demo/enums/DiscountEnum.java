package com.hanjx369.demo.enums;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * 折扣枚举
 *
 * @author 寒江雪
 * @createDate 2024-05-29 23:16
 */
@Getter
public enum DiscountEnum {

    NORMAL(0, "普通用户", BigDecimal.valueOf(1.00)),
    VIP(1, "普通VIP", BigDecimal.valueOf(0.95)),
    PVIP(2, "高级VIP", BigDecimal.valueOf(0.90)),
    EVIP(4, "至尊VIP", BigDecimal.valueOf(0.85)),
    SVIP(3, "超级VIP", BigDecimal.valueOf(0.80));

    /**
     * 用户类型code
     */
    private final int code;
    /**
     * 用户类型文字
     */
    private final String type;
    /**
     * 折扣
     */
    private final BigDecimal discount;

    DiscountEnum(int code, String type, BigDecimal discount) {
        this.code = code;
        this.type = type;
        this.discount = discount;
    }

    /**
     * 根据code获取枚举
     *
     * @param code code
     * @return DiscountEnum
     */
    public static DiscountEnum valueOf(int code) {
        for (DiscountEnum value : DiscountEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

}
