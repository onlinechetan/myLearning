package com.mylearning;

import java.util.HashMap;
import java.util.Map;

/**
 * Hashocde override is required if equals is true.
 */
public class EqualsNoHashCodeOverride {

    private long crmID;
    private int nameSpace;

    public EqualsNoHashCodeOverride(long crmID, int nameSpace) {
        super();
        this.crmID = crmID;
        this.nameSpace = nameSpace;
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        m.put(new EqualsNoHashCodeOverride(2345891234L, 0), "Jeff Smith");
        System.out.println(m.get(new EqualsNoHashCodeOverride(2345891234L, 0)));
    }
//no hash code override

    public boolean equals(Object obj) {
        //null instanceof Object will always return false
        if (!(obj instanceof EqualsNoHashCodeOverride))
            return false;
        if (obj == this)
            return true;
        return this.crmID == ((EqualsNoHashCodeOverride) obj).crmID &&
                this.nameSpace == ((EqualsNoHashCodeOverride) obj).nameSpace;
    }
}
