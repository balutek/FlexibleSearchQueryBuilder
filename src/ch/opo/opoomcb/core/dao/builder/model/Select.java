/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paweł Łabuda
 */
public class Select
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

   public Where getWhere()
   {
      return where;
   }

   public void setWhere(Where where)
   {
      this.where = where;
   }
}
