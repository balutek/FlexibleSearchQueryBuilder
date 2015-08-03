/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.builders;

import ch.opo.opoomcb.core.dao.builder.builders.from.FromSegmentBuilder;
import ch.opo.opoomcb.core.dao.builder.model.*;
import org.apache.commons.lang.StringUtils;

/**
 * @author Paweł Łabuda
 */
public class QueryBuilder
{
   private static final String defaultColumnName = "pk";

   private QueryModel queryModel;

   private QueryBuilder(String column, String alias, boolean distinct)
   {
      if (StringUtils.isBlank(column))
      {
         column = defaultColumnName;
      }

      queryModel = new QueryModel();

      Select select = new Select();
      select.setDistinct(distinct);
      select.addColumn(new Column(column, alias));
      queryModel.setSelect(select);
   }

   public static QueryBuilder selectPK()
   {
      return new QueryBuilder(null, null, false);
   }

   public static QueryBuilder selectPK(String alias)
   {
      return new QueryBuilder(null, alias, false);
   }

   public static QueryBuilder select(String column)
   {
      return new QueryBuilder(column, null, false);
   }

   public static QueryBuilder select(String alias, String column)
   {
      return new QueryBuilder(column, alias, true);
   }

   public static QueryBuilder selectDistinctPK()
   {
      return new QueryBuilder(null, null, true);
   }

   public static QueryBuilder selectDistinctPK(String alias)
   {
      return new QueryBuilder(null, alias, true);
   }

   public static QueryBuilder selectDistinct(String column)
   {
      return new QueryBuilder(column, null, true);
   }

   public static QueryBuilder selectDistinct(String alias, String column)
   {
      return new QueryBuilder(column, alias, true);
   }

   public FromSegmentBuilder from(String from)
   {
      queryModel.getLastSelect().addFrom(new From(new Table(from, null)));
      return new FromSegmentBuilder(queryModel);
   }

   public FromSegmentBuilder from(String alias, String from)
   {
      queryModel.getLastSelect().addFrom(new From(new Table(from, alias)));
      return new FromSegmentBuilder(queryModel);
   }
}
