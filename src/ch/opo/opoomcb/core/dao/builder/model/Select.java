/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;

/**
 * @author Paweł Łabuda
 */
public class Select implements Renderable
{
   private boolean distinct = false;

   private List<Column> columnList;

   private List<From> fromList;

   private Where where;

   public Select()
   {
      columnList = new ArrayList<Column>();
      fromList = new ArrayList<From>();
   }

   public void setDistinct(boolean distinct)
   {
      this.distinct = distinct;
   }

   public boolean isDistinct()
   {
      return distinct;
   }

   public void addColumn(Column column)
   {
      columnList.add(column);
   }

   public void addFrom(From from)
   {
      fromList.add(from);
   }

   public List<Column> getColumnList()
   {
      return columnList;
   }

   public List<From> getFromList()
   {
      return fromList;
   }

   public From getLastFrom()
   {
      if (fromList.size() > 0)
      {
         return fromList.get(fromList.size() - 1);
      }
      return null;
   }

   public Where getWhere()
   {
      return where;
   }

   public void setWhere(Where where)
   {
      this.where = where;
   }

   @Override
   public void render(StringBuilder builder)
   {
      builder.append(SELECT).append(SPACE);

      renderColumns(builder);

      builder.append(SPACE).append(FROM);

      Iterator<From> fromIterator = fromList.iterator();
      while (fromIterator.hasNext())
      {
         builder.append(KEY_PARAM_PREFIX);
         fromIterator.next().render(builder);
         builder.append(KEY_PARAM_SUFFIX);
         if (fromIterator.hasNext())
         {
            builder.append(RESULTS_SEPARATOR);
         }
      }
   }

   private void renderColumns(StringBuilder builder)
   {
      Iterator<Column> columnIterator = columnList.iterator();
      while (columnIterator.hasNext())
      {
         columnIterator.next().render(builder);
         if (columnIterator.hasNext())
         {
            builder.append(RESULTS_SEPARATOR);
         }
      }
   }
}
