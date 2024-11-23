package chapter13;

public enum SlotStatus {
    EMPTY,      // 이 슬롯에는 데이터가 저장된 바 없다
    DELETED,    // 이 슬롯에는 데이터가 저장된바 있으나 현재는 비워진 상태이다.
    INUSE       // 이 슬롯에는 현재 유효한 데이터가 저장되어 있다.
}
