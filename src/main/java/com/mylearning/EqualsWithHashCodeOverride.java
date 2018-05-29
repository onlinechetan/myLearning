package com.mylearning;

import java.util.HashMap;
import java.util.Map;

/**
 * Hashocde override is required if equals is true.
 */
public class EqualsWithHashCodeOverride {

    private long crmID;
    private int nameSpace;

    public EqualsWithHashCodeOverride(long crmID, int nameSpace) {
        super();
        this.crmID = crmID;
        this.nameSpace = nameSpace;
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        m.put(new EqualsWithHashCodeOverride(2345891234L, 0), "Jeff Smith");
        System.out.println(m.get(new EqualsWithHashCodeOverride(2345891234L, 0)));
    }

    public boolean equals(Object obj) {
        //null instanceof Object will always return false
        if (!(obj instanceof EqualsWithHashCodeOverride))
            return false;
        if (obj == this)
            return true;
        return this.crmID == ((EqualsWithHashCodeOverride) obj).crmID &&
                this.nameSpace == ((EqualsWithHashCodeOverride) obj).nameSpace;
    }

    public int hashCode() {
        int result = 0;
        result = (int) (crmID / 12) + nameSpace;
        return result;
    }
}
