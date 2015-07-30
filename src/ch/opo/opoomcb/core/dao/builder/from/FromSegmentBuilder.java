/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.model.*;
import ch.opo.opoomcb.core.dao.builder.whereSegment.CompareWhereBuilder;

/**
 * @author Paweł Łabuda
 */
public class FromSegmentBuilder
{
   private QueryModel queryModel;

   public FromSegmentBuilder(QueryModel queryModel)
   {
      this.queryModel = queryModel;
   }

   public JoinBuilder join(String alias, String typecode)
   {
      queryModel.getLastFrom().addJoin(new Join(new Table(typecode, alias)));
      return new JoinBuilder(queryModel);
   }

   public JoinBuilder leftJoin(String alias, String typecode)
   {
      queryModel.getLastFrom().addJoin(new LeftJoin(new Table(typecode, alias)));
      return new JoinBuilder(queryModel);
   }

   public JoinBuilder rightJoin(String alias, String typecode)
   {
      queryModel.getLastFrom().addJoin(new RightJoin(new Table(typecode, alias)));
      return new JoinBuilder(queryModel);
   }

   public CompareWhereBuilder where()
   {
      return new CompareWhereBuilder(queryModel);
   }
}
