/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.from.FromSegmentBuilder;
import ch.opo.opoomcb.core.dao.builder.model.Select;

/**
 * @author Paweł Łabuda
 */
public class QueryBuilder
{
   private String SELECT_ITEM = "pk";

   private boolean distinct;

   private Select SELECT;

   private QueryBuilder(String param, boolean distinct)
   {
      this.distinct = distinct;

//      if (StringUtils.isNotBlank(param))//todo
      if (param != null)
      {
         SELECT_ITEM = param;
      }
      SELECT = new Select();
      SELECT.setDistinct(distinct);
   }

   public static QueryBuilder select()
   {
      return new QueryBuilder(null, false);
   }

   public static QueryBuilder select(String param)
   {
      return new QueryBuilder(param, false);
   }

   public static QueryBuilder selectDistinct()
   {
      return new QueryBuilder(null, true);
   }

   public static QueryBuilder selectDistinct(String param)
   {
      return new QueryBuilder(param, true);
   }

   public FromSegmentBuilder from(String from)
   {
      return new FromSegmentBuilder(buildQuery(null), from);
   }

   public FromSegmentBuilder from(String alias, String from)
   {
      return new FromSegmentBuilder(buildQuery(alias), alias, from);
   }

   private StringBuilder buildQuery(String alias)
   {
      StringBuilder query = new StringBuilder()
         .append(QueryElements.SELECT);

      if (distinct)
      {
         query.append(QueryElements.DISTINCT);
      }
      query.append(QueryElements.KEY_PARAM_PREFIX);

      if (alias != null)
      {
         query.append(alias)
            .append(".");
      }
      query.append(SELECT_ITEM)
         .append(QueryElements.KEY_PARAM_SUFFIX)
         .append(QueryElements.FROM)
         .append(QueryElements.KEY_PARAM_PREFIX);

      return query;
   }
}
