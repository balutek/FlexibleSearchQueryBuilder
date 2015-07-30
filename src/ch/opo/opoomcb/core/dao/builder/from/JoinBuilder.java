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
   private QueryModel queryModel;

   public JoinBuilder(QueryModel queryModel)
   {
      this.queryModel = queryModel;
   }

   public ParamJoinBuilder on()
   {
      return new ParamJoinBuilder(queryModel);
   }
}
