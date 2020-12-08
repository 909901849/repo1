package com.wkq.controller.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeptEmpVO {
    private int deptno;
    private BigDecimal min;
    private BigDecimal max;

    public DeptEmpVO() {
    }

    public DeptEmpVO(int deptno, BigDecimal min, BigDecimal max) {
        this.deptno = deptno;
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "DeptEmpVO{" +
                "deptno=" + deptno +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
