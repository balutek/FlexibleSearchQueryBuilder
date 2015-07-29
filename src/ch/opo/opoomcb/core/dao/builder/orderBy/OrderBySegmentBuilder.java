/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.orderBy;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;

/**
 * @author Paweł Łabuda
 */
public class OrderBySegmentBuilder
{
   private StringBuilder query;

   public OrderBySegmentBuilder(StringBuilder query, String order)
   {
      this.query = query;

      insertOrderBy(order);
   }

   public String build()
   {
      return query.toString();
   }

   private void insertOrderBy(String order)
   {
      query.append(QueryElements.ORDER_BY)
         .append(QueryElements.KEY_PARAM_PREFIX)
         .append(order)
         .append(QueryElements.KEY_PARAM_SUFFIX);
   }
}
