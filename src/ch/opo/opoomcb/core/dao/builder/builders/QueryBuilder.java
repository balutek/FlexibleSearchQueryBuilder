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
   private String SELECT_ITEM = "pk";

   private QueryModel queryModel;

   private QueryBuilder(String param, String alias, boolean distinct)
   {
      if (StringUtils.isNotBlank(param))
      {
         SELECT_ITEM = param; //todo to chyba nie powinno tu pyc
      }

      queryModel = new QueryModel();

      Select select = new Select();
      select.setDistinct(distinct);
      select.addColumn(new Column(param, alias));
      queryModel.setSelect(select);
   }

   public static QueryBuilder select()
   {
      return new QueryBuilder(null, null, false);
   }

   public static QueryBuilder select(String param)
   {
      return new QueryBuilder(param, null, false);
   }

   public static QueryBuilder select(String alias, String param)
   {
      return new QueryBuilder(param, alias, true);
   }

   public static QueryBuilder selectDistinct()
   {
      return new QueryBuilder(null, null, true);
   }

   public static QueryBuilder selectDistinct(String param)
   {
      return new QueryBuilder(param, null, true);
   }

   public static QueryBuilder selectDistinct(String alias, String param)
   {
      return new QueryBuilder(param, alias, true);
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
