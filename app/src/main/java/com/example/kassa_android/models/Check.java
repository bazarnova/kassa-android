package com.example.kassa_android.models;

public class Check {
    private Long id;
    private Double sumAmount;
    private Long date;
    private String shopName;
    private String comment;

    public Check(Builder builder) {
        this.id = builder.id;
        this.sumAmount = builder.sumAmount;
        this.date = builder.date;
        this.shopName = builder.shopName;
        this.comment = builder.comment;
    }

    public Check() {
    }

    public Check(Long id, Double sumAmount, Long date, String shopName, String comment) {
        this.id = id;
        this.sumAmount = sumAmount;
        this.date = date;
        this.shopName = shopName;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSumAmount() {
        return sumAmount;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getDate() {
        return date;
    }

    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static class Builder {
        Long id;
        Double sumAmount;
        Long date;
        String shopName;
        String comment;

        public Builder setId(Long idd) {
            this.id = idd;
            return this;
        }

        public Builder setSumAmount(Double sumAmount) {
            this.sumAmount = sumAmount;
            return this;
        }

        public Builder setDate(Long date) {
            this.date = date;
            return this;
        }

        public Builder setShopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Check build() {
            return new Check(this);
        }
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", sumAmount=" + sumAmount +
                ", date=" + date +
                ", shopName='" + shopName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
