/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.whereSegment;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.model.QueryModel;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.And;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.Or;
import ch.opo.opoomcb.core.dao.builder.orderBy.OrderBySegmentBuilder;

/**
 * @author Paweł Łabuda
 */
public class OperatorBuilder
{
   private WhereSegmentBuilder builder;

   public OperatorBuilder(WhereSegmentBuilder builder)
   {
      this.builder = builder;
   }

   public QueryModel getQuery()
   {
      return builder.getQuery();
   }

   public OrderBySegmentBuilder orderBy(String alias, String column)
   {
      return builder.getOrderByBuilder(alias, column);
   }

   public ParamBuilder and()
   {
      builder.insertOperation(new And());
      return builder.getParamBuilder();
   }

   public ParamBuilder or()
   {
      builder.insertOperation(new Or());
      return builder.getParamBuilder();
   }

   public OperatorBuilder closeBracket()
   {
      builder.closeBracket();
      return builder.getOperatorBuilder();
   }
}
