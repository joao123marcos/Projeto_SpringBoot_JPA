package com.CursoJava_JPA_Hibernate.Curso.enums;

public enum OrderStatus {
    
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;
    
    //Construtor em enums é private
    private OrderStatus(int code){
        this.code = code;
    }

    public int getCodeEnum(){
        return this.code;
    }

    //Método estático para converter um orderStatus em um int
    public static OrderStatus convertOrderStatusInt(int code){
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCodeEnum() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
