/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.model.*;
import ch.opo.opoomcb.core.dao.builder.whereSegment.ParamBuilder;

/**
 * @author Paweł Łabuda
 */
public class FromSegmentBuilder
{
//   private StringBuilder query;

   private QueryModel queryModel;

   public FromSegmentBuilder(QueryModel queryModel)
   {
      this.queryModel = queryModel;
//      this.query = query;
//      insertSimpleFrom(from);
   }

//   public FromSegmentBuilder(StringBuilder query, String alias, String from)
//   {
//      this.query = query;
//      insertSimpleFrom(alias, from);
//   }

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

   public ParamBuilder where()
   {
      return new ParamBuilder(queryModel);
   }

//   public String build()
//   {
//      return query.toString();
//   }
//
//   private void insertSimpleFrom(String alias, String from)
//   {
//      query.append(from)
//         .append(QueryElements.AS)
//         .append(alias)
//         .append(QueryElements.KEY_PARAM_SUFFIX);
//   }
//
//   private void insertSimpleFrom(String from)
//   {
//      query.append(from)
//         .append(QueryElements.KEY_PARAM_SUFFIX);
//   }
}
