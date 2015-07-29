/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;

/**
 * @author Paweł Łabuda
 */
public class JoinBuilder
{
    private StringBuilder query;

    private String alias;

    private String typecode;

    public JoinBuilder(StringBuilder query, String alias, String typecode)
    {
        query.append(" JOIN ")
                .append(typecode)
                .append(QueryElements.AS)
                .append(alias);
        this.query = query;
        this.alias = alias;
        this.typecode = typecode;
    }

    public ParamJoinBuilder on()
    {
        return new ParamJoinBuilder(query);
    }
}
