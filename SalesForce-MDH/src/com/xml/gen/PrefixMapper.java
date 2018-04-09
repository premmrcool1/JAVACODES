package com.xml.gen;

import com.sun.xml.bind.marshaller.*;

public class PrefixMapper extends NamespacePrefixMapper {

    @Override
    public String getPreferredPrefix(String arg0, String arg1, boolean arg2) {
        return null;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris2() {
        return new String[] {"xs", "http://www.w3.org/2001/XMLSchema", "fn", "http://dlineage.com","mmxml","http://xdtl.org/mmxml"};
    }


}