/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.render;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.From;
import ch.opo.opoomcb.core.dao.builder.model.Join;
import ch.opo.opoomcb.core.dao.builder.model.QueryModel;
import ch.opo.opoomcb.core.dao.builder.model.Select;
import ch.opo.opoomcb.core.dao.builder.model.Table;
import javafx.scene.control.Tab;
import org.apache.commons.lang.StringUtils;

import java.util.Iterator;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;

/**
 * @author Paweł Łabuda
 */
public class QueryRenderer
{
   private QueryModel model;

   private StringBuilder resultQuery;

   private QueryRenderer(QueryModel model)
   {
      this.model = model;
   }

   public static String render(QueryModel model)
   {
      return new QueryRenderer(model).build();
   }

   private String build()
   {
      resultQuery = new StringBuilder();
      renderSelect(model.getSelect());
      return resultQuery.toString();
   }

   private void renderSelect(Select select)
   {
      resultQuery.append(SELECT).append(SPACE);

      renderSelectedColumns(select);

      for (From from : select.getFromList())
      {
         renderFrom(from);
      }
   }

   private void renderSelectedColumns(Select select)
   {
      Iterator<Column> columnIterator = select.getColumnList().iterator();
      while (columnIterator.hasNext())
      {
         renderColumn(columnIterator.next());
         if (columnIterator.hasNext())
         {
            resultQuery.append(RESULTS_SEPARATOR);
         }
      }
   }

   private void renderColumn(Column column)
   {
      String columnAlias = column.getAlias();
      resultQuery.append(KEY_PARAM_PREFIX);
      if (StringUtils.isNotBlank(columnAlias))
      {
         resultQuery.append(columnAlias).append(ALIAS_SEPARATOR);
      }
      resultQuery.append(column.getName()).append(KEY_PARAM_SUFFIX);
   }

   private void renderFrom(From from)
   {
      Table fromTable = from.getTable();
      resultQuery.append(KEY_PARAM_PREFIX);
      resultQuery.append(fromTable.getName());

      String fromTableAlias = fromTable.getAlias();
      if (StringUtils.isNotBlank(fromTableAlias))
      {
         resultQuery.append(SPACE).append(AS).append(SPACE).append(fromTableAlias);
      }
      for (Join join : from.getJoinList())
      {
         renderJoin(join);
      }
      resultQuery.append(KEY_PARAM_SUFFIX);
   }

   private void renderJoin(Join join)
   {
   }

}
