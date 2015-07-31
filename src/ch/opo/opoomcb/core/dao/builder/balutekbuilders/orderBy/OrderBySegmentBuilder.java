/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.balutekbuilders.orderBy;

import ch.opo.opoomcb.core.dao.builder.model.QueryModel;

/**
 * @author Paweł Łabuda
 */
public class OrderBySegmentBuilder // todo hire should be DESC and ASC
{
   private QueryModel queryModel;

   public OrderBySegmentBuilder(QueryModel queryModel)
   {
      this.queryModel = queryModel;
   }

   public QueryModel getQuery()
   {
      return queryModel;
   }
}
