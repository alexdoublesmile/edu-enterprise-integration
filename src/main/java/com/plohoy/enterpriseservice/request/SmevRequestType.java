package com.plohoy.enterpriseservice.request;

/**
 * Smev request types enumeration.
 */
public enum SmevRequestType {
    BANK_ACC_ENTREP("bankAccEntrep"),
    BANK_ACC_ORG("bankAccOrg"),
    BANK_ACC_PERS("bankAccPers"),
    DISKVLIC("diskvlic"),
    FAKTUPNAL("factupnal"),
    NDFL3("ndfl3"),
    NDIPSR("ndipsr"),
    VIPIP("vipip"),
    VIPUL("vipul"),
    ZADORG("zadorg"),
    ZPVIPEGR("zpvipegr"),
    ZVIPUL("zvipul");

    private String name;

    SmevRequestType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SmevRequestType findByName(String name) {
        for (SmevRequestType value : SmevRequestType.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }
}
