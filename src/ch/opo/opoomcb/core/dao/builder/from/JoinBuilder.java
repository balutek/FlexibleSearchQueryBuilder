/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.model.QueryModel;

/**
 * @author Paweł Łabuda
 */
public class JoinBuilder
{
//    private StringBuilder query;

   private QueryModel queryModel;

   private String alias;

   private String typecode;

   public JoinBuilder(QueryModel queryModel)
   {
//        query.append(" JOIN ")
//                .append(typecode)
//                .append(QueryElements.AS)
//                .append(alias);
      this.queryModel = queryModel;
   }

   public ParamJoinBuilder on()
   {
      return new ParamJoinBuilder(queryModel);
   }
}
